package com.tvd.cmri;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tvd.cmri.service.UsbService;
import com.tvd.cmri.singlePhase_LT.Single;
import com.tvd.cmri.threePhase_LT.ThreePhase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button singlephase, threephase;
    private MyHandler mHandler2;
    private static final String PREFERENCE = "CMRI";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    @SuppressLint("CommitPrefEdits")
    private void initialize() {
        singlephase = findViewById(R.id.btn_single_phase);
        threephase = findViewById(R.id.btn_three_phase);
        singlephase.setOnClickListener(this);
        threephase.setOnClickListener(this);
        mHandler2 = new MyHandler(this);

        sharedPreferences = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_single_phase:
                startActivity(new Intent(MainActivity.this, Single.class));
                break;
            case R.id.btn_three_phase:
                startActivity(new Intent(MainActivity.this, ThreePhase.class));
                break;
        }
    }

    /*
     * This handler will be passed to UsbService. Data received from serial port is displayed through this handler
     */
    @SuppressLint("HandlerLeak")
    public class MyHandler extends Handler {

        MyHandler(MainActivity activity) {

        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {

                case UsbService.DEVICE_CONNECTED:
                    Toast.makeText(MainActivity.this, "Device Connected..", Toast.LENGTH_SHORT).show();
                    editor.putString("CONNECTED", "Yes");
                    editor.commit();
                    break;
                case UsbService.DEVICE_DISCONNECTED:
                    Toast.makeText(MainActivity.this, "Device Disconnected.." + "\n" + "Please attach the USB and try again..", Toast.LENGTH_SHORT).show();
                    editor.putString("CONNECTED", "No");
                    editor.commit();
                    break;

            }
        }
    }
}
