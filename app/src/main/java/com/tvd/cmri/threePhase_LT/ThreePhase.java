package com.tvd.cmri.threePhase_LT;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tvd.cmri.R;
import com.tvd.cmri.service.UsbService;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class ThreePhase extends AppCompatActivity {

    /*
     * Notifications from UsbService will be received here.

     */
    private final BroadcastReceiver mUsbReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            switch (Objects.requireNonNull(intent.getAction())) {

                case UsbService.ACTION_USB_PERMISSION_GRANTED: // USB PERMISSION GRANTED
                    Toast.makeText(context, "USB Ready", Toast.LENGTH_SHORT).show();
                    break;
                case UsbService.ACTION_USB_PERMISSION_NOT_GRANTED: // USB PERMISSION NOT GRANTED
                    Toast.makeText(context, "USB Permission not granted", Toast.LENGTH_SHORT).show();
                    break;
                case UsbService.ACTION_NO_USB: // NO USB CONNECTED
                    Toast.makeText(context, "No USB connected", Toast.LENGTH_SHORT).show();
                    break;
                case UsbService.ACTION_USB_DISCONNECTED: // USB DISCONNECTED
                    Toast.makeText(context, "USB disconnected", Toast.LENGTH_SHORT).show();
                    break;
                case UsbService.ACTION_USB_NOT_SUPPORTED: // USB NOT SUPPORTED
                    Toast.makeText(context, "USB device not supported", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    private android.support.v7.widget.Toolbar toolbar;
    private UsbService usbService;
    private TextView display;
    //private EditText editText;
    private MyHandler mHandler;
    private Button btn_full_data, btn_previous_read, btn_pres_read;
    int i = 0;
    private static ProgressDialog progressDialog;
    private ImageView disconnect_connect;
    private TextView connect_status;
    private static final String PREFERENCE = "CMRI";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    boolean pres_read = false, previous_read = false, full_reading = false;
    private String filename = "", line2 = "";

    private final ServiceConnection usbConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName arg0, IBinder arg1) {
            usbService = ((UsbService.UsbBinder) arg1).getService();
            usbService.setHandler(mHandler);
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            usbService = null;
        }
    };


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_phase);
        initialize();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //For getting Present Reading
        btn_pres_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usbService != null) { // if UsbService was correctly binded, Send data
                    char[] data = new char[12];

                    data[0] = 0x3A;//3A
                    data[1] = 0x3F;//?
                    data[2] = 0x21;//!
                    data[3] = 0x0D;//CTRL+M
                    data[4] = 0x0A;//CTRL+J

                    data[5] = 0x06;//CTRL+F
                    data[6] = 0x30;//0
                    data[7] = 0x34;//4
                    data[8] = 0x33;//3
                    data[9] = 0x0D;//CTRL+M
                    data[10] = 0x0A;//CTRL+J
                    data[11] = 0x10;///CTRL+P
                    for (int i = 0; i <= 11; i++) {

                        switch (i) {
                            case 0:
                                for (int j = 0; j < 2; j++) {

                                    // display.append(Character.toString(data[0]));
                                    usbService.write(Character.toString(data[0]).getBytes(StandardCharsets.US_ASCII));
                                }
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 1:
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 5:
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                break;
                        }
                        //display.append(Character.toString(data[i]));
                        usbService.write(Character.toString(data[i]).getBytes(StandardCharsets.US_ASCII));
                        pres_read = true;
                        previous_read = false;
                        full_reading = false;
                    }
                } else
                    Toast.makeText(ThreePhase.this, "Please Connect with Serial Port!!", Toast.LENGTH_SHORT).show();
            }
        });


        //For getting Full data
        btn_full_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usbService != null) { // if UsbService was correctly binded, Send data
                    char[] data = new char[11];

                    data[0] = 0x3A;//3A
                    data[1] = 0x3F;//?
                    data[2] = 0x21;//!
                    data[3] = 0x0D;//CTRL+M
                    data[4] = 0x0A;//CTRL+J

                    data[5] = 0x06;//CTRL+F
                    data[6] = 0x30;//0
                    data[7] = 0x34;//4
                    data[8] = 0x30;//0
                    data[9] = 0x0D;//CTRL+M
                    data[10] = 0x0A;//CTRL+J

                    for (int i = 0; i <= 10; i++) {

                        switch (i) {
                            case 0:
                                for (int j = 0; j < 2; j++) {

                                    // display.append(Character.toString(data[0]));
                                    usbService.write(Character.toString(data[0]).getBytes(StandardCharsets.US_ASCII));
                                }
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 1:
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 5:
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                break;
                        }
                        //display.append(Character.toString(data[i]));
                        usbService.write(Character.toString(data[i]).getBytes(StandardCharsets.US_ASCII));
                        full_reading = true;
                        previous_read = false;
                        pres_read = false;
                    }
                } else
                    Toast.makeText(ThreePhase.this, "Please Connect with Serial Port!!", Toast.LENGTH_SHORT).show();
            }
        });

        //For getting previous data
        btn_previous_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usbService != null) { // if UsbService was correctly binded, Send data
                    char[] data = new char[12];

                    data[0] = 0x3A;//3A
                    data[1] = 0x3F;//?
                    data[2] = 0x21;//!
                    data[3] = 0x0D;//CTRL+M
                    data[4] = 0x0A;//CTRL+J

                    data[5] = 0x06;//CTRL+F
                    data[6] = 0x30;//0
                    data[7] = 0x34;//4
                    data[8] = 0x33;//3
                    data[9] = 0x0D;//CTRL+M
                    data[10] = 0x0A;//CTRL+J
                    data[11] = 0x02;///CTRL+B
                    for (int i = 0; i <= 11; i++) {

                        switch (i) {
                            case 0:
                                for (int j = 0; j < 2; j++) {

                                    // display.append(Character.toString(data[0]));
                                    usbService.write(Character.toString(data[0]).getBytes(StandardCharsets.US_ASCII));
                                }
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 1:
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 5:
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                break;
                        }
                        //display.append(Character.toString(data[i]));
                        usbService.write(Character.toString(data[i]).getBytes(StandardCharsets.US_ASCII));
                        previous_read = true;
                        pres_read = false;
                        full_reading = false;
                    }
                } else
                    Toast.makeText(ThreePhase.this, "Please Connect with Serial Port!!", Toast.LENGTH_SHORT).show();
            }
        });

        //clear button
        Button clrButton = findViewById(R.id.buttonClear);
        clrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText("");
            }
        });
    }

    @SuppressLint("CommitPrefEdits")
    private void initialize() {
        toolbar = findViewById(R.id.my_toolbar);
        toolbar.setNavigationIcon(R.drawable.action_back);
        disconnect_connect = toolbar.findViewById(R.id.img_disconnect_connect);
        connect_status = toolbar.findViewById(R.id.txt_connection_status);

        mHandler = new MyHandler(this);
        display = findViewById(R.id.textView1);
        display.setMovementMethod(new ScrollingMovementMethod());
        progressDialog = new ProgressDialog(ThreePhase.this);

        //Initialization
        btn_full_data = findViewById(R.id.buttonFullData);
        btn_previous_read = findViewById(R.id.buttonPreviousRead);
        btn_pres_read = findViewById(R.id.buttonSend);

        sharedPreferences = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    @Override
    public void onResume() {
        super.onResume();
        setFilters();  // Start listening notifications from UsbService
        startService(usbConnection); // Start UsbService(if it was not started before) and Bind it
        String device_connection_status = sharedPreferences.getString("CONNECTED", "");
        if (Objects.requireNonNull(device_connection_status).equals("Yes")) {
            disconnect_connect.setBackgroundResource(R.drawable.reconnect);
            connect_status.setText(R.string.connected);
        } else {
            disconnect_connect.setBackgroundResource(R.drawable.disconnect);
            connect_status.setText(R.string.disconnect);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        unregisterReceiver(mUsbReceiver);
        unbindService(usbConnection);
    }

    private void startService(ServiceConnection serviceConnection) {
        if (!UsbService.SERVICE_CONNECTED) {
            Intent startService = new Intent(this, UsbService.class);
            startService(startService);
        }
        Intent bindingIntent = new Intent(this, UsbService.class);
        bindService(bindingIntent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    private void setFilters() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(UsbService.ACTION_USB_PERMISSION_GRANTED);
        filter.addAction(UsbService.ACTION_NO_USB);
        filter.addAction(UsbService.ACTION_USB_DISCONNECTED);
        filter.addAction(UsbService.ACTION_USB_NOT_SUPPORTED);
        filter.addAction(UsbService.ACTION_USB_PERMISSION_NOT_GRANTED);
        registerReceiver(mUsbReceiver, filter);
    }

    /*
     * This handler will be passed to UsbService. Data received from serial port is displayed through this handler
     */
    @SuppressLint("HandlerLeak")
    public class MyHandler extends Handler {
        private final WeakReference<ThreePhase> mActivity;

        MyHandler(ThreePhase activity) {
            mActivity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UsbService.MESSAGE_FROM_SERIAL_PORT:
                    String data = (String) msg.obj;
                    mActivity.get().display.append(data);
                    storevalue();
                    break;
                case UsbService.DEVICE_CONNECTED:
                    Toast.makeText(ThreePhase.this, "Device Connected..", Toast.LENGTH_SHORT).show();
                    disconnect_connect.setBackgroundResource(R.drawable.reconnect);
                    connect_status.setText(R.string.connected);
                    editor.putString("CONNECTED", "Yes");
                    editor.commit();
                    break;
                case UsbService.DEVICE_DISCONNECTED:
                    Toast.makeText(ThreePhase.this, "Device Disconnected.." + "\n" + "Please attach the USB and try again..", Toast.LENGTH_SHORT).show();
                    disconnect_connect.setBackgroundResource(R.drawable.disconnect);
                    connect_status.setText(R.string.disconnect);
                    editor.putString("CONNECTED", "No");
                    editor.commit();
                    //stopService(new Intent(ThreePhase.this, UsbService.class));
                    if (progressDialog.isShowing())
                        progressDialog.dismiss();
                    break;
                case UsbService.DATA_RECEIVING_STARTED:
                    Toast.makeText(ThreePhase.this, "Data Reading Started.." + "\n" + "Please Wait..", Toast.LENGTH_SHORT).show();
                    break;
                case UsbService.DATA_RECEIVING_STOPPED:
                    Toast.makeText(ThreePhase.this, "Data Reading Stopped..", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    public void storevalue() {
        String display_text;
        i++;
        display_text = display.getText().toString();
        writeToFile(display_text);
    }

    //Below code is for writing the Opticals port output in text file
    private void writeToFile(String currentStacktrace) {
        try {
            //Gets the Android external storage directory & Create new folder Crash_Reports
            File dir = new File(Environment.getExternalStorageDirectory(),
                    "Opticals_3Phase");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            if (pres_read) {
                filename = "Optical_Presreading" + ".txt";
            } else if (previous_read) {
                filename = "Optical_Prevreading" + ".txt";
            } else if (full_reading) {
                filename = "Optical_Fullreading" + ".txt";
            }
            File reportFile = new File(dir, filename);
            FileWriter fileWriter = new FileWriter(reportFile);
            fileWriter.append(currentStacktrace);
            fileWriter.flush();
            fileWriter.close();
            readfile();
        } catch (Exception e) {
            Log.e("ExceptionHandler", e.getMessage());
        }
    }

    public void readfile() {
        FileInputStream is;
        BufferedReader reader;
        File dir = new File(Environment.getExternalStorageDirectory(),
                "Opticals_3Phase");

        if (pres_read) {
            filename = "Optical_Presreading" + ".txt";
        } else if (previous_read) {
            filename = "Optical_Prevreading" + ".txt";
        } else if (full_reading) {
            filename = "Optical_Fullreading" + ".txt";
        }
        File reportFile = new File(dir, filename);
        try {
            if (reportFile.exists()) {
                is = new FileInputStream(reportFile);
                reader = new BufferedReader(new InputStreamReader(is));
                String line = reader.readLine();
                while (line != null) {
                    line = reader.readLine();
                    if (line.equals("H")) {
                        line2 = FileUtils.readLines(reportFile).get(2).trim();
                        line2 = line2.substring(2, line2.indexOf(" "));
                        progressDialog.setCancelable(false);
                        progressDialog.setMessage("Fetching Data.." + "\n" + "Please Wait..");
                        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                        progressDialog.setProgress(0);
                        progressDialog.show();
                    }
                    if (line.equals("!")) {
                        Toast.makeText(this, "Reading completed.." + "\n" + "Please find the text file..", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        rename_textfile();
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void rename_textfile() {
        File dir = new File(Environment.getExternalStorageDirectory(),
                "Opticals_3Phase");
        if (pres_read) {
            filename = "Optical_Presreading" + ".txt";
        } else if (previous_read) {
            filename = "Optical_Prevreading" + ".txt";
        } else if (full_reading) {
            filename = "Optical_Fullreading" + ".txt";
        }

        File reportFile = new File(dir, filename);
        try {
            if (reportFile.exists()) {
                File from = new File(dir, filename);
                File to = new File(dir, line2 + "_" + (new SimpleDateFormat("ddMMyyyy_HHmmss", Locale
                        .getDefault())).format(new Date())+"_" + filename);
                if (from.exists())
                    from.renameTo(to);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
