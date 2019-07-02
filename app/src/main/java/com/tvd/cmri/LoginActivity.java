package com.tvd.cmri;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.tvd.cmri.invoke.SendingData;
import com.tvd.cmri.other.FunctionCall;
import com.tvd.cmri.other.GetSetValues;

import static com.tvd.cmri.other.Constant.LOGIN_FAILURE;
import static com.tvd.cmri.other.Constant.LOGIN_SUCCESS;

public class LoginActivity extends AppCompatActivity {
    Button button_login, button_cancel;
    SendingData sendingData;
    GetSetValues getSetValues;
    TextInputEditText username;
    EditText password;
    FunctionCall functionCall;
    RelativeLayout relativeLayout;
    ProgressDialog progressDialog;
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case LOGIN_SUCCESS:
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                    moveto_next();
                    break;
                case LOGIN_FAILURE:
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, "Login Failure!!", Toast.LENGTH_SHORT).show();
                    break;
            }
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        initialize();
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (functionCall.isInternetOn(LoginActivity.this)) {
                    if (!TextUtils.isEmpty(username.getText().toString())) {
                        if (!TextUtils.isEmpty(password.getText().toString())) {
                            functionCall.setProgressDialog(progressDialog, "Checking Credentials", "Please Wait..");
                            SendingData.Login login = sendingData.new Login(handler);
                            login.execute(username.getText().toString(), password.getText().toString());
                        } else
                            functionCall.setSnackBar(LoginActivity.this, relativeLayout, "Enter Password!!");
                    } else
                        functionCall.setSnackBar(LoginActivity.this, relativeLayout, "Enter Username!!");
                } else
                    functionCall.setSnackBar(LoginActivity.this, relativeLayout, "Please Turn On Internet!!");
            }
        });
    }

    private void moveto_next(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    private void initialize() {
        progressDialog = new ProgressDialog(this);
        getSetValues = new GetSetValues();
        sendingData = new SendingData();
        button_login = findViewById(R.id.btn_login);
        button_cancel = findViewById(R.id.btn_cancel);
        username = findViewById(R.id.txtinput_username);
        password = findViewById(R.id.edit_password);
        functionCall = new FunctionCall();
        relativeLayout = findViewById(R.id.relative_layout);
    }
}
