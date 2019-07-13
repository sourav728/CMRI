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
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tvd.cmri.LoginActivity;
import com.tvd.cmri.MainActivity;
import com.tvd.cmri.R;
import com.tvd.cmri.invoke.SendingData;
import com.tvd.cmri.other.FunctionCall;
import com.tvd.cmri.other.GetSetValues;
import com.tvd.cmri.service.UsbService;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import static com.tvd.cmri.other.Constant.DESTINATION_UPLOAD_XML_PATH;
import static com.tvd.cmri.other.Constant.DIR_UPLOAD;
import static com.tvd.cmri.other.Constant.FILE_ENCODED_ERROR;
import static com.tvd.cmri.other.Constant.FILE_ENCODED_SUCCESS;
import static com.tvd.cmri.other.Constant.TEXT_GENERATION_FAILURE;
import static com.tvd.cmri.other.Constant.TEXT_GENERATION_SUCCESS;
import static com.tvd.cmri.other.Constant.XML_POSTING_FAILURE;
import static com.tvd.cmri.other.Constant.XML_POSTING_SUCCESS;

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
    private String filename = "", line2 = "", path = "", mobileUploadPath = "", destinationPath = "";
    private FunctionCall fcall;
    private GetSetValues getSetValues;
    private SendingData sendingData;

    String line_first, line_second, line_third, line_fourth, line_fifth, line_sixth, mtr_version;
    Element d3, d301, pId, utilitytype, di;
    ArrayList<GetSetValues> getSetValueslist;

    VerEAJ8_02 verEAJ8_02;
    version_DTDDN version_dtddn;
    Ver4SB1F20 ver4SB1F20;
    Version_NED26 version_ned26;

    private FunctionCall functionCall;
    Document document;
    boolean alreadyExecuted = false;
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case TEXT_GENERATION_SUCCESS:
                    Toast.makeText(ThreePhase.this, "TextFile Generation Completed..", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                    if (!alreadyExecuted) {
                        rename_textfile();
                        alreadyExecuted = true;
                    }
                    break;
                case TEXT_GENERATION_FAILURE:
                    Toast.makeText(ThreePhase.this, "TextFile Generation Failure!!", Toast.LENGTH_SHORT).show();
                    break;
                case FILE_ENCODED_SUCCESS:
                    Toast.makeText(ThreePhase.this, "File Encoading Success" + "\n" + "uploading Files in server", Toast.LENGTH_SHORT).show();
                    call_file_upload_api();
                    break;
                case FILE_ENCODED_ERROR:
                    break;
                case XML_POSTING_SUCCESS:
                    progressDialog.dismiss();
                    Toast.makeText(ThreePhase.this, "Xml Posting Success..", Toast.LENGTH_SHORT).show();
                    move_xml_file();
                    break;

                case XML_POSTING_FAILURE:
                    progressDialog.dismiss();
                    Toast.makeText(ThreePhase.this, "Xml POsting Failure!!", Toast.LENGTH_SHORT).show();
                    break;
            }
            return false;
        }
    });

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
                call_encode();
            }
        });
    }

    @SuppressLint("CommitPrefEdits")
    private void initialize() {
        sendingData = new SendingData();
        functionCall = new FunctionCall();
        getSetValueslist = new ArrayList<>();
        getSetValues = new GetSetValues();
        fcall = new FunctionCall();
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

        ver4SB1F20 = new Ver4SB1F20();
        version_dtddn = new version_DTDDN();
        version_ned26 = new Version_NED26();
        verEAJ8_02 = new VerEAJ8_02();
        path = fcall.filepath("Xml_file");

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
                    if (TextUtils.equals(line, "!")) {
                        handler.sendEmptyMessage(TEXT_GENERATION_SUCCESS);
                        // Toast.makeText(this, "Reading completed.." + "\n" + "Please find the text file..", Toast.LENGTH_SHORT).show();
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
        File to = null;
        String generated_textfile_name = line2 + "_" + (new SimpleDateFormat("ddMMyyyy_HHmmss", Locale
                .getDefault())).format(new Date()) + "_" + filename;
        try {
            if (reportFile.exists()) {
                File from = new File(dir, filename);

                to = new File(dir, generated_textfile_name);
                if (from.exists())
                    from.renameTo(to);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Toast.makeText(ThreePhase.this, "File Name " + generated_textfile_name, Toast.LENGTH_SHORT).show();
        check_optical_text_file(generated_textfile_name);
    }


    private void check_optical_text_file(String filename) {
        String path2 = fcall.filepath("Optical.txt");
        File file = new File(path2);
        if (file.exists()) {
            readfile(filename);
        } else
            Toast.makeText(this, "Optical textfile does not exists!!", Toast.LENGTH_SHORT).show();

    }

    public void readfile(String filename) {

        String line2, line3, line4, line5, line6, line10, line12, line15;
        File sdcard = new File(fcall.filepath(""));

        for (File f : sdcard.listFiles()) {
            if (f.isFile()) {
                String name = f.getName();
                if (name.equals(filename)) {
                    File file = fcall.filestorepath("", name);
                    try {
                        //For fetching particular line from text file
                        //H(09166245     )
                        line2 = FileUtils.readLines(file).get(2).trim();
                        line2 = line2.substring(2, line2.indexOf(" "));
                        getSetValues.setG1(line2);

                        //H(27061905170058 )
                        line3 = FileUtils.readLines(file).get(3).trim();
                        line3 = line3.substring(2, line3.indexOf(" "));
                        StringBuilder sb = new StringBuilder(line3.substring(0, 2));
                        sb.append("-");
                        sb.append(line3.substring(2, 4));
                        sb.append("-");
                        sb.append(line3.substring(4, 6));
                        sb.append(" ");
                        sb.append(line3.substring(8, 10));
                        sb.append(":");
                        sb.append(line3.substring(10, 12));
                        sb.append(":");
                        sb.append(line3.substring(12, 14));

                        getSetValues.setG2(sb.toString());

                        //For H(3 1.00 1.00 5 0 0E K A )
                        line4 = FileUtils.readLines(file).get(4).trim();
                        String[] parts1 = line4.split(" ");
                        String g7 = parts1[1];
                        String g8 = parts1[2];
                        String g13 = parts1[3];
                        getSetValues.setG7(g7);
                        getSetValues.setG8(g8);
                        getSetValues.setG13(g13);

                        //H(verEAJ8.02 pc49. )
                        line5 = FileUtils.readLines(file).get(5).trim();
                        String[] parts2 = line5.split(" ");
                        String g17 = parts2[0];
                        mtr_version = g17.substring(2, g17.length());
                        getSetValues.setG17(g17);

                        //H(01000B )
                        line6 = FileUtils.readLines(file).get(6).trim();
                        if (previous_read)
                            line6 = line6.substring(2, line6.indexOf("B"));
                        else line6 = line6.substring(2, line6.indexOf("P"));
                        getSetValues.setG1195(line6);

                        //A2000
                        line10 = FileUtils.readLines(file).get(10).trim();
                        line10 = line10.substring(2, line10.indexOf(" "));
                        getSetValues.setG1199(line10);


                        switch (mtr_version) {
                            case "verEAJ8.02":

                                getSetValueslist.clear();
                                for (int i = 12; i <= 27; i++) {
                                    GetSetValues getSetValues = new GetSetValues();

                                    line_first = "";
                                    line_second = "";
                                    line_third = "";
                                    line_fourth = "";

                                    line12 = FileUtils.readLines(file).get(i).trim();
                                    line_first = line12.substring(5, 12);
                                    line_second = line12.substring(14, 21);
                                    line_third = line12.substring(23, 30);
                                    line_fourth = line12.substring(32, 39);

                                    getSetValues.setLine_first(line_first);
                                    getSetValues.setLine_second(line_first);
                                    getSetValues.setLine_third(line_first);
                                    getSetValues.setLine_fourth(line_first);

                                    getSetValueslist.add(getSetValues);
                                }
                                xml_creation(filename);
                                break;

                            case "verNED26.00":
                                getSetValueslist.clear();
                                for (int i = 14; i <= 29; i++) {
                                    GetSetValues getSetValues = new GetSetValues();
                                    line12 = FileUtils.readLines(file).get(i).trim();
                                    line_first = "";
                                    line_second = "";
                                    line_third = "";
                                    line_fourth = "";
                                    line_fifth = "";

                                    line_first = line12.substring(5, 12);
                                    line_second = line12.substring(14, 21);
                                    line_third = line12.substring(23, 30);
                                    line_fourth = line12.substring(32, 39);
                                    line_fifth = line12.substring(41, 48);

                                    getSetValues.setLine_first(line_first);
                                    getSetValues.setLine_second(line_second);
                                    getSetValues.setLine_third(line_third);
                                    getSetValues.setLine_fourth(line_fourth);
                                    getSetValues.setLine_fifth(line_fifth);
                                    getSetValueslist.add(getSetValues);
                                }
                                xml_creation(filename);
                                break;

                            case "verDTDDN.B0":

                                getSetValueslist.clear();
                                for (int i = 14; i <= 29; i++) {
                                    GetSetValues getSetValues = new GetSetValues();
                                    line12 = FileUtils.readLines(file).get(i).trim();
                                    line_first = "";
                                    line_second = "";
                                    line_third = "";
                                    line_fourth = "";
                                    line_fifth = "";
                                    line_sixth = "";

                                    line_first = line12.substring(5, 12);
                                    line_second = line12.substring(14, 21);
                                    line_third = line12.substring(23, 30);
                                    line_fourth = line12.substring(32, 39);
                                    line_fifth = line12.substring(41, 48);
                                    line_sixth = line12.substring(50, 57);

                                    getSetValues.setLine_first(line_first);
                                    getSetValues.setLine_second(line_second);
                                    getSetValues.setLine_third(line_third);
                                    getSetValues.setLine_fourth(line_fourth);
                                    getSetValues.setLine_fifth(line_fifth);
                                    getSetValues.setLine_sixth(line_sixth);

                                    getSetValueslist.add(getSetValues);
                                }
                                xml_creation(filename);

                                break;

                            case "ver4SB1F.20":
                                int a = 0, b = 0;
                                getSetValueslist.clear();
                                if (previous_read) {
                                    a = 15;
                                    b = 30;
                                } else {
                                    a = 14;
                                    b = 29;
                                }
                                for (int i = a; i <= b; i++) {
                                    GetSetValues getSetValues = new GetSetValues();
                                    line_first = "";
                                    line_second = "";
                                    line_third = "";
                                    line15 = FileUtils.readLines(file).get(i).trim();
                                    line_first = line15.substring(5, 12);
                                    line_second = line15.substring(14, 21);
                                    line_third = line15.substring(23, 30);

                                    getSetValues.setLine_first(line_first);
                                    getSetValues.setLine_second(line_second);
                                    getSetValues.setLine_third(line_third);
                                    getSetValueslist.add(getSetValues);
                                }
                                xml_creation(filename);

                                break;
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(), "Xml generation failed!!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }
    }

    private void xml_creation(String filename) {
        String xmlBioData = null;
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            document = documentBuilder.newDocument();

            //root element CDF
            pId = document.createElement("CDF");
            document.appendChild(pId);

            //For UTILITYTYPE tag
            utilitytype = document.createElement("UTILITYTYPE");
            pId.appendChild(utilitytype);

            Attr langAttr = document.createAttribute("CODE");
            langAttr.setValue("1");
            utilitytype.setAttributeNode(langAttr);

            //For D1 tag
            di = document.createElement("D1");
            utilitytype.appendChild(di);
            //For G1 tag
            Element g1 = document.createElement("G1");
            g1.appendChild(document.createTextNode(getSetValues.getG1()));
            di.appendChild(g1);

            //For G2 tag
            Element g2 = document.createElement("G2");
            g2.appendChild(document.createTextNode(getSetValues.getG2()));
            di.appendChild(g2);

            //For G7 tag
            Element g7 = document.createElement("G7");
            g7.appendChild(document.createTextNode(getSetValues.getG7()));
            di.appendChild(g7);

            //For G8 tag
            Element g8 = document.createElement("G8");
            g8.appendChild(document.createTextNode(getSetValues.getG8()));
            di.appendChild(g8);

            //For G13 tag
            Element g13 = document.createElement("G13");
            g13.appendChild(document.createTextNode(getSetValues.getG13()));
            di.appendChild(g13);

            //For G14 tag
            Element g14 = document.createElement("G14");
            g14.appendChild(document.createTextNode("5-10"));
            di.appendChild(g14);

            //For G15 tag
            Element g15 = document.createElement("G15");
            g15.appendChild(document.createTextNode("HT(3ph-3W)"));
            di.appendChild(g15);

            //For G17 tag
            Element g17 = document.createElement("G17");
            g17.appendChild(document.createTextNode(getSetValues.getG17().substring(2)));
            di.appendChild(g17);

            //For G22 tag
            Element g22 = document.createElement("G22");
            di.appendChild(g22);

            Attr g22attr = document.createAttribute("CODE");
            g22attr.setValue("1");
            g22.setAttributeNode(g22attr);

            Attr g22attr2 = document.createAttribute("NAME");
            g22attr2.setValue("L&amp;T");
            g22.setAttributeNode(g22attr2);

            //For G24 tag
            Element g24 = document.createElement("G24");
            g24.appendChild(document.createTextNode("Mains"));
            di.appendChild(g24);

            //For G27 tag
            Element g25 = document.createElement("G27");
            g25.appendChild(document.createTextNode("VALID"));
            di.appendChild(g25);

            //For G30 tag
            Element g30 = document.createElement("G30");
            g30.appendChild(document.createTextNode("3.0"));
            di.appendChild(g30);

            //For G31 tag
            Element g31 = document.createElement("G31");
            g31.appendChild(document.createTextNode("2.00.12.00"));
            di.appendChild(g31);

            //For G33 tag
            Element g33 = document.createElement("G33");
            g33.appendChild(document.createTextNode("MM002"));
            di.appendChild(g33);

            //For G1193 tag
            Element g1193 = document.createElement("G1193");
            g1193.appendChild(document.createTextNode("CTOperated"));
            di.appendChild(g1193);

            //For G1194 tag
            Element g1194 = document.createElement("G1194");
            g1194.appendChild(document.createTextNode("Previous Billing Data"));
            di.appendChild(g1194);

            //For G1195 tag
            Element g1195 = document.createElement("G1195");
            g1195.appendChild(document.createTextNode(getSetValues.getG1195()));
            di.appendChild(g1195);

            //For G1197 tag
            Element g1197 = document.createElement("G1197");
            g1197.appendChild(document.createTextNode(getSetValues.getG2()));
            di.appendChild(g1197);

            //For G1198 tag
            Element g1198 = document.createElement("G1198");
            g1198.appendChild(document.createTextNode(getSetValues.getG13()));
            di.appendChild(g1198);

            //For G1199 tag
            Element g1199 = document.createElement("G1199");
            g1199.appendChild(document.createTextNode(getSetValues.getG1199()));
            di.appendChild(g1199);

            /////////////// D3 TAG Starting//////////////
            //For D3 tag
            d3 = document.createElement("D3");
            utilitytype.appendChild(d3);

            d301 = document.createElement("D3-01");
            d3.appendChild(d301);

            Attr g301attr = document.createAttribute("DATETIME");
            g301attr.setValue("");
            d301.setAttributeNode(g301attr);

            Attr g301attr2 = document.createAttribute("MECHANISM");
            g301attr2.setValue("");
            d301.setAttributeNode(g301attr2);

            switch (mtr_version) {
                case "verEAJ8.02":
                    verEAJ8_02.version_EAJ8_02(getSetValueslist, document, d301, d3);
                    break;
                case "verNED26.00":
                    version_ned26.version_ned26(getSetValueslist, document, d301, d3);
                    break;
                case "verDTDDN.B0":
                    version_dtddn.version_DTDDN1(getSetValueslist, document, d301, d3);
                    break;
                case "ver4SB1F.20":
                    ver4SB1F20.ver4SB1F_20(getSetValueslist, document, d301, d3);
                    break;
                default:
                    Toast.makeText(this, mtr_version + "This Meter Version Code is not Integrated yet!!", Toast.LENGTH_SHORT).show();
                    break;
            }
            //string conversion
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(document), new StreamResult(writer));
            xmlBioData = writer.getBuffer().toString();
            Toast.makeText(this, "Xml file created successfully..", Toast.LENGTH_SHORT).show();

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
            Toast.makeText(getApplicationContext(), "Xml generation failed!!", Toast.LENGTH_LONG).show();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
            Toast.makeText(getApplicationContext(), "Xml generation failed!!", Toast.LENGTH_LONG).show();
        }

        // Appending String to textfile

        File file = new File(path + File.separator + filename.substring(0, filename.length() - 4) + ".xml"); // File name with path
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(new FileWriter(file, true));
            out.append(xmlBioData);
            out.append("\r\n");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Xml generation failed!!", Toast.LENGTH_LONG).show();
        }
    }

    private void call_encode() {
        mobileUploadPath = functionCall.filepath(DIR_UPLOAD + File.separator);
        functionCall.encode(mobileUploadPath + File.separator + "14416062_12072019_180522_Optical_Prevreading.xml", getSetValues, handler);
    }


    //For uploading Text and XML files
    private void call_file_upload_api() {
        functionCall.setProgressDialog(progressDialog, "Posting Data", "Please Wait");
        //For Calling Xml posting Service and text files too
        SendingData.XMLPosting xmlposting = sendingData.new XMLPosting(handler);
        xmlposting.execute("1234567890", "123", "14416062_12072019_180522_Optical_Prevreading.xml", "123.34", "257.54", "dummy", "Bangalore", getSetValues.getResult());
    }

    private void move_xml_file() {
        destinationPath = functionCall.filepath(DESTINATION_UPLOAD_XML_PATH + File.separator);
        functionCall.move_files(mobileUploadPath, "14416062_12072019_180522_Optical_Prevreading.xml", destinationPath, "14416062_12072019_180522_Optical_Prevreading.xml");
    }
}
