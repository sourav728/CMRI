package com.tvd.cmri;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tvd.cmri.other.FunctionCall;
import com.tvd.cmri.other.GetSetValues;
import com.tvd.cmri.service.UsbService;
import com.tvd.cmri.singlePhase_LT.Single;
import com.tvd.cmri.threePhase_LT.ThreePhase;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button singlephase, threephase, xmlconvert;
    private MyHandler mHandler2;
    private static final String PREFERENCE = "CMRI";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private FunctionCall fcall;
    BufferedReader in;
    StreamResult out;
    TransformerHandler th;
    String path = "";
    String filename = "";
    GetSetValues getSetValues;
    FunctionCall functionCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        path = fcall.filepath("Xml_file");
        filename = "Optical.xml";
    }

    @SuppressLint("CommitPrefEdits")
    private void initialize() {
        functionCall = new FunctionCall();
        getSetValues = new GetSetValues();
        singlephase = findViewById(R.id.btn_single_phase);
        threephase = findViewById(R.id.btn_three_phase);
        xmlconvert = findViewById(R.id.btn_xml);

        singlephase.setOnClickListener(this);
        threephase.setOnClickListener(this);
        xmlconvert.setOnClickListener(this);
        mHandler2 = new MyHandler(this);

        fcall = new FunctionCall();
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
            case R.id.btn_xml:
                check_optical_text_file();

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

    private void check_optical_text_file() {
        String path2 = fcall.filepath("Optical.txt");
        File file = new File(path2);
        if (file.exists()) {
            readfile();
        } else
            Toast.makeText(this, "Optical textfile does not exists!!", Toast.LENGTH_SHORT).show();

    }

    public void readfile() {
        String line2, line3, line4, line5, line6, line10, line12, line13, line14, line15, line16, line17, line18, line19, line21, line22, line23,
                line24, line25, line26, line27, line28, line29;
        File sdcard = new File(fcall.filepath(""));

        for (File f : sdcard.listFiles()) {
            if (f.isFile()) {
                String name = f.getName();
                if (name.equals("Optical.txt")) {
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
                        StringBuilder sb = new StringBuilder(line3.substring(0,2));
                        sb.append("-");
                        sb.append(line3.substring(2,4));
                        sb.append("-");
                        sb.append(line3.substring(4,6));
                        sb.append(" ");
                        sb.append(line3.substring(8,10));
                        sb.append(":");
                        sb.append(line3.substring(10,12));
                        sb.append(":");
                        sb.append(line3.substring(12,14));

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
                        getSetValues.setG17(g17);

                        //H(01000B )
                        line6 = FileUtils.readLines(file).get(6).trim();
                        line6 = line6.substring(3, line6.indexOf("B"));
                        getSetValues.setG1195(line6);

                        //A2000
                        line10 = FileUtils.readLines(file).get(10).trim();
                        line10 = line10.substring(2, line10.indexOf(" "));
                        getSetValues.setG1199(line10);

                        //line13
                        //KI(003073.34005205.36001365.68000191.87)
                        line12 = FileUtils.readLines(file).get(12).trim();
                        String line12ki_first = line12.substring(5, 12);
                        String line12ki_second = line12.substring(14, 21);
                        String line12ki_third = line12.substring(23, 30);
                        String line12ki_fourth = line12.substring(32, 39);

                        getSetValues.setLine12ki_first(line12ki_first);
                        getSetValues.setLine12ki_second(line12ki_second);
                        getSetValues.setLine12ki_third(line12ki_third);
                        getSetValues.setLine12ki_fourth(line12ki_fourth);

                        //line14
                        //KI(002762.36004791.54001233.93000184.84)
                        line13 = FileUtils.readLines(file).get(13).trim();
                        String line13ki_first = line13.substring(5, 12);
                        String line13ki_second = line13.substring(14, 21);
                        String line13ki_third = line13.substring(23, 30);
                        String line13ki_fourth = line13.substring(32, 39);

                        getSetValues.setLine13ki_first(line13ki_first);
                        getSetValues.setLine13ki_second(line13ki_second);
                        getSetValues.setLine13ki_third(line13ki_third);
                        getSetValues.setLine13ki_fourth(line13ki_fourth);

                        //line15
                        //KI(001255.00001931.67000547.07000049.32)
                        line14 = FileUtils.readLines(file).get(14).trim();

                        String line14ki_first = line14.substring(5, 12);
                        String line14ki_second = line14.substring(14, 21);
                        String line14ki_third = line14.substring(23, 30);
                        String line14ki_fourth = line14.substring(32, 39);

                        getSetValues.setLine14ki_first(line14ki_first);
                        getSetValues.setLine14ki_second(line14ki_second);
                        getSetValues.setLine14ki_third(line14ki_third);
                        getSetValues.setLine14ki_fourth(line14ki_fourth);

                        //line16
                        //KI(000278.95000370.94000138.85000000.26)
                        line15 = FileUtils.readLines(file).get(15).trim();
                        String line15ki_first = line15.substring(5, 12);
                        String line15ki_second = line15.substring(14, 21);
                        String line15ki_third = line15.substring(23, 30);
                        String line15ki_fourth = line15.substring(32, 39);

                        getSetValues.setLine15ki_first(line15ki_first);
                        getSetValues.setLine15ki_second(line15ki_second);
                        getSetValues.setLine15ki_third(line15ki_third);
                        getSetValues.setLine15ki_fourth(line15ki_fourth);

                        //line17
                        //KE(000000.00000000.11000000.00000000.00)
                        line16 = FileUtils.readLines(file).get(16).trim();
                        String line16ki_second = line16.substring(14, 21);
                        getSetValues.setLine16ki_second(line16ki_second);

                        //line18
                        //KE(000000.00000000.10000000.00000000.00)
                        line17 = FileUtils.readLines(file).get(17).trim();
                        String line17ki_second = line17.substring(14, 21);
                        getSetValues.setLine17ki_second(line17ki_second);

                        //line19
                        //KE(000000.00000000.02000000.00000000.00)
                        line18 = FileUtils.readLines(file).get(18).trim();
                        String line18ki_second = line18.substring(14, 21);
                        getSetValues.setLine18ki_second(line18ki_second);

                        //line20
                        //KE(000000.00000000.03000000.00000000.00)
                        line19 = FileUtils.readLines(file).get(19).trim();
                        String line19ki_second = line19.substring(14, 21);
                        getSetValues.setLine19ki_second(line19ki_second);

                        //line21
                        //KI(003073.34005205.36001365.68000191.87)
                        line21 = FileUtils.readLines(file).get(20).trim();
                        String line21ki_first = line21.substring(5, 12);
                        String line21ki_second = line21.substring(14, 21);
                        String line21ki_third = line21.substring(23, 30);
                        String line21ki_fourth = line21.substring(32, 39);

                        getSetValues.setLine21ki_first(line21ki_first);
                        getSetValues.setLine21ki_second(line21ki_second);
                        getSetValues.setLine21ki_third(line21ki_third);
                        getSetValues.setLine21ki_fourth(line21ki_fourth);

                        //line22
                        //KI(003073.34005205.36001365.68000191.87)
                        line22 = FileUtils.readLines(file).get(21).trim();
                        String line22ki_first = line22.substring(5, 12);
                        String line22ki_second = line22.substring(14, 21);
                        String line22ki_third = line22.substring(23, 30);
                        String line22ki_fourth = line22.substring(32, 39);

                        getSetValues.setLine22ki_first(line22ki_first);
                        getSetValues.setLine22ki_second(line22ki_second);
                        getSetValues.setLine22ki_third(line22ki_third);
                        getSetValues.setLine22ki_fourth(line22ki_fourth);

                        //line23
                        //KI(002762.36004791.54001233.93000184.84)
                        line23 = FileUtils.readLines(file).get(22).trim();
                        String line23ki_first = line23.substring(5, 12);
                        String line23ki_second = line23.substring(14, 21);
                        String line23ki_third = line23.substring(23, 30);
                        String line23ki_fourth = line23.substring(32, 39);

                        getSetValues.setLine23ki_first(line23ki_first);
                        getSetValues.setLine23ki_second(line23ki_second);
                        getSetValues.setLine23ki_third(line23ki_third);
                        getSetValues.setLine23ki_fourth(line23ki_fourth);

                        //line24
                        //KI(002762.36004791.54001233.93000184.84)
                        line24 = FileUtils.readLines(file).get(23).trim();
                        String line24ki_first = line24.substring(5, 12);
                        String line24ki_second = line24.substring(14, 21);
                        String line24ki_third = line24.substring(23, 30);
                        String line24ki_fourth = line24.substring(32, 39);

                        getSetValues.setLine24ki_first(line24ki_first);
                        getSetValues.setLine24ki_second(line24ki_second);
                        getSetValues.setLine24ki_third(line24ki_third);
                        getSetValues.setLine24ki_fourth(line24ki_fourth);

                        //line26
                        //KE(000000.00000000.11000000.00000000.00)
                        line25 = FileUtils.readLines(file).get(24).trim();
                        String line25ki_second = line25.substring(14, 21);
                        getSetValues.setLine25ki_second(line25ki_second);

                        //line27
                        //KE(000000.00000000.11000000.00000000.00)
                        line26 = FileUtils.readLines(file).get(25).trim();
                        String line26ki_second = line26.substring(14, 21);
                        getSetValues.setLine26ki_second(line26ki_second);

                        //line28
                        //KE(000000.00000000.02000000.00000000.00)
                        line27 = FileUtils.readLines(file).get(26).trim();
                        String line27ki_second = line27.substring(14, 21);
                        getSetValues.setLine27ki_second(line27ki_second);

                        //line29
                        //KE(000000.00000000.03000000.00000000.00)
                        line28 = FileUtils.readLines(file).get(27).trim();
                        String line28ki_second = line28.substring(14, 21);
                        getSetValues.setLine28ki_second(line28ki_second);


                        xml_creation();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void xml_creation() {
        String xmlBioData = null;
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            //root element CDF
            Element pId = document.createElement("CDF");
            document.appendChild(pId);

            //For UTILITYTYPE tag
            Element utilitytype = document.createElement("UTILITYTYPE");
            pId.appendChild(utilitytype);

            Attr langAttr = document.createAttribute("CODE");
            langAttr.setValue("1");
            utilitytype.setAttributeNode(langAttr);

            //For D1 tag
            Element di = document.createElement("D1");
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

            //For G25 tag
            Element g25 = document.createElement("G25");
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
            Element d3 = document.createElement("D3");
            utilitytype.appendChild(d3);

            Element d301 = document.createElement("D3-01");
            d3.appendChild(d301);

            Attr g301attr = document.createAttribute("DATETIME");
            g301attr.setValue("");
            d301.setAttributeNode(g301attr);

            Attr g301attr2 = document.createAttribute("MECHANISM");
            g301attr2.setValue("");
            d301.setAttributeNode(g301attr2);

            //For first B3 tag
            Element B30 = document.createElement("B3");
            d301.appendChild(B30);

            Attr B30attr1 = document.createAttribute("PARAMCODE");
            B30attr1.setValue("P7-3-5-2-0");
            B30.setAttributeNode(B30attr1);

            Attr B30attr2 = document.createAttribute("VALUE");
            B30attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValues.getLine12ki_first()) + Double.parseDouble(getSetValues.getLine12ki_second()) + Double.parseDouble(getSetValues.getLine12ki_third()) + Double.parseDouble(getSetValues.getLine12ki_fourth()))));
            B30.setAttributeNode(B30attr2);

            Attr B30attr3 = document.createAttribute("UNIT");
            B30attr3.setValue("k");
            B30.setAttributeNode(B30attr3);
            //End

            //For second B3 tag
            Element B31 = document.createElement("B3");
            d301.appendChild(B31);

            Attr B31attr1 = document.createAttribute("PARAMCODE");
            B31attr1.setValue("P7-1-5-2-0");
            B31.setAttributeNode(B31attr1);

            Attr B31attr2 = document.createAttribute("VALUE");
            B31attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValues.getLine13ki_first()) + Double.parseDouble(getSetValues.getLine13ki_second()) + Double.parseDouble(getSetValues.getLine13ki_third()) + Double.parseDouble(getSetValues.getLine13ki_fourth()))));
            B31.setAttributeNode(B31attr2);

            Attr B31attr3 = document.createAttribute("UNIT");
            B31attr3.setValue("k");
            B31.setAttributeNode(B31attr3);
            //End

            //For third B3 tag
            Element B32 = document.createElement("B3");
            d301.appendChild(B32);

            Attr B32attr1 = document.createAttribute("PARAMCODE");
            B32attr1.setValue("P7-2-1-2-0");
            B32.setAttributeNode(B32attr1);

            Attr B32attr2 = document.createAttribute("VALUE");

            B32attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValues.getLine14ki_first()) + Double.parseDouble(getSetValues.getLine14ki_second()) + Double.parseDouble(getSetValues.getLine14ki_third()) + Double.parseDouble(getSetValues.getLine14ki_fourth()))));
            B32.setAttributeNode(B32attr2);

            Attr B32attr3 = document.createAttribute("UNIT");
            B32attr3.setValue("k");
            B32.setAttributeNode(B32attr3);
            //End


            //For fourth B3 tag
            Element B33 = document.createElement("B3");
            d301.appendChild(B33);

            Attr B33attr1 = document.createAttribute("PARAMCODE");
            B33attr1.setValue("P7-2-4-2-0");
            B33.setAttributeNode(B33attr1);

            Attr B33attr2 = document.createAttribute("VALUE");
            B33attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValues.getLine15ki_first()) + Double.parseDouble(getSetValues.getLine15ki_second()) + Double.parseDouble(getSetValues.getLine15ki_third()) + Double.parseDouble(getSetValues.getLine15ki_fourth()))));
            B33.setAttributeNode(B33attr2);

            Attr B33attr3 = document.createAttribute("UNIT");
            B33attr3.setValue("k");
            B33.setAttributeNode(B33attr3);
            //End

            //For fifth B3 tag
            Element B34 = document.createElement("B3");
            d301.appendChild(B34);

            Attr B34attr1 = document.createAttribute("PARAMCODE");
            B34attr1.setValue("P7-3-6-2-0");
            B34.setAttributeNode(B34attr1);

            Attr B34attr2 = document.createAttribute("VALUE");
            B34attr2.setValue(getSetValues.getLine16ki_second());
            B34.setAttributeNode(B34attr2);

            Attr B34attr3 = document.createAttribute("UNIT");
            B34attr3.setValue("k");
            B34.setAttributeNode(B34attr3);
            //End

            //For sixth B3 tag
            Element B35 = document.createElement("B3");
            d301.appendChild(B35);

            Attr B35attr1 = document.createAttribute("PARAMCODE");
            B35attr1.setValue("P7-1-6-2-0");
            B35.setAttributeNode(B35attr1);

            Attr B35attr2 = document.createAttribute("VALUE");
            B35attr2.setValue(getSetValues.getLine17ki_second());
            B35.setAttributeNode(B35attr2);

            Attr B35attr3 = document.createAttribute("UNIT");
            B35attr3.setValue("k");
            B35.setAttributeNode(B35attr3);
            //End

            //For seventh B3 tag
            Element B36 = document.createElement("B3");
            d301.appendChild(B36);

            Attr B36attr1 = document.createAttribute("PARAMCODE");
            B36attr1.setValue("P7-2-2-2-0");
            B36.setAttributeNode(B36attr1);

            Attr B36attr2 = document.createAttribute("VALUE");
            B36attr2.setValue(getSetValues.getLine18ki_second());
            B36.setAttributeNode(B36attr2);

            Attr B36attr3 = document.createAttribute("UNIT");
            B36attr3.setValue("k");
            B36.setAttributeNode(B36attr3);
            //End

            //For eight B3 tag
            Element B37 = document.createElement("B3");
            d301.appendChild(B37);

            Attr B37attr1 = document.createAttribute("PARAMCODE");
            B37attr1.setValue("P7-2-3-2-0");
            B37.setAttributeNode(B37attr1);

            Attr B37attr2 = document.createAttribute("VALUE");
            B37attr2.setValue(getSetValues.getLine19ki_second());
            B37.setAttributeNode(B37attr2);

            Attr B37attr3 = document.createAttribute("UNIT");
            B37attr3.setValue("k");
            B37.setAttributeNode(B37attr3);
            //End

            //first B4 tag
            Element B40 = document.createElement("B4");
            d301.appendChild(B40);

            Attr B40attr1 = document.createAttribute("TOD");
            B40attr1.setValue("0");
            B40.setAttributeNode(B40attr1);

            Attr B40attr2 = document.createAttribute("PARAMCODE");
            B40attr2.setValue("P7-3-5-2-0");
            B40.setAttributeNode(B40attr2);

            Attr B40attr3 = document.createAttribute("VALUE");
            B40attr3.setValue(getSetValues.getLine12ki_first());
            B40.setAttributeNode(B40attr3);

            Attr B40attr4 = document.createAttribute("UNIT");
            B40attr4.setValue("k");
            B40.setAttributeNode(B40attr4);
            //End

            //second B4 tag
            Element B41 = document.createElement("B4");
            d301.appendChild(B41);

            Attr B41attr1 = document.createAttribute("TOD");
            B41attr1.setValue("0");
            B41.setAttributeNode(B41attr1);

            Attr B41attr2 = document.createAttribute("PARAMCODE");
            B41attr2.setValue("P7-1-5-2-0");
            B41.setAttributeNode(B41attr2);

            Attr B41attr3 = document.createAttribute("VALUE");
            B41attr3.setValue(getSetValues.getLine13ki_first());
            B41.setAttributeNode(B41attr3);

            Attr B41attr4 = document.createAttribute("UNIT");
            B41attr4.setValue("k");
            B41.setAttributeNode(B41attr4);
            //End

            //third B4 tag
            Element B42 = document.createElement("B4");
            d301.appendChild(B42);

            Attr B42attr1 = document.createAttribute("TOD");
            B42attr1.setValue("0");
            B42.setAttributeNode(B42attr1);

            Attr B42attr2 = document.createAttribute("PARAMCODE");
            B42attr2.setValue("P7-2-1-2-0");
            B42.setAttributeNode(B42attr2);

            Attr B42attr3 = document.createAttribute("VALUE");
            B42attr3.setValue(getSetValues.getLine14ki_first());
            B42.setAttributeNode(B42attr3);

            Attr B42attr4 = document.createAttribute("UNIT");
            B42attr4.setValue("k");
            B42.setAttributeNode(B42attr4);
            //End

            //fourth B4 tag
            Element B43 = document.createElement("B4");
            d301.appendChild(B43);

            Attr B43attr1 = document.createAttribute("TOD");
            B43attr1.setValue("0");
            B43.setAttributeNode(B43attr1);

            Attr B43attr2 = document.createAttribute("PARAMCODE");
            B43attr2.setValue("P7-2-4-2-0");
            B43.setAttributeNode(B43attr2);

            Attr B43attr3 = document.createAttribute("VALUE");
            B43attr3.setValue(getSetValues.getLine15ki_first());
            B43.setAttributeNode(B43attr3);

            Attr B43attr4 = document.createAttribute("UNIT");
            B43attr4.setValue("k");
            B43.setAttributeNode(B43attr4);
            //End


            //fifth B4 tag
            Element B44 = document.createElement("B4");
            d301.appendChild(B44);

            Attr B44attr1 = document.createAttribute("TOD");
            B44attr1.setValue("0");
            B44.setAttributeNode(B44attr1);

            Attr B44attr2 = document.createAttribute("PARAMCODE");
            B44attr2.setValue("P7-3-6-2-0");
            B44.setAttributeNode(B44attr2);

            Attr B44attr3 = document.createAttribute("VALUE");
            B44attr3.setValue("0");
            B44.setAttributeNode(B44attr3);

            Attr B44attr4 = document.createAttribute("UNIT");
            B44attr4.setValue("k");
            B44.setAttributeNode(B44attr4);
            //End

            //sixth B4 tag
            Element B45 = document.createElement("B4");
            d301.appendChild(B45);

            Attr B45attr1 = document.createAttribute("TOD");
            B45attr1.setValue("0");
            B45.setAttributeNode(B45attr1);

            Attr B45attr2 = document.createAttribute("PARAMCODE");
            B45attr2.setValue("P7-1-6-2-0");
            B45.setAttributeNode(B45attr2);

            Attr B45attr3 = document.createAttribute("VALUE");
            B45attr3.setValue("0");
            B45.setAttributeNode(B45attr3);

            Attr B45attr4 = document.createAttribute("UNIT");
            B45attr4.setValue("k");
            B45.setAttributeNode(B45attr4);
            //End

            //seventh B4 tag
            Element B46 = document.createElement("B4");
            d301.appendChild(B46);

            Attr B46attr1 = document.createAttribute("TOD");
            B46attr1.setValue("0");
            B46.setAttributeNode(B46attr1);

            Attr B46attr2 = document.createAttribute("PARAMCODE");
            B46attr2.setValue("P7-1-6-2-0");
            B46.setAttributeNode(B46attr2);

            Attr B46attr3 = document.createAttribute("VALUE");
            B46attr3.setValue("0");
            B46.setAttributeNode(B46attr3);

            Attr B46attr4 = document.createAttribute("UNIT");
            B46attr4.setValue("k");
            B46.setAttributeNode(B46attr4);
            //End

            //eight B4 tag
            Element B47 = document.createElement("B4");
            d301.appendChild(B47);

            Attr B47attr1 = document.createAttribute("TOD");
            B47attr1.setValue("0");
            B47.setAttributeNode(B47attr1);

            Attr B47attr2 = document.createAttribute("PARAMCODE");
            B47attr2.setValue("P7-2-3-2-0");
            B47.setAttributeNode(B47attr2);

            Attr B47attr3 = document.createAttribute("VALUE");
            B47attr3.setValue("0");
            B47.setAttributeNode(B47attr3);

            Attr B47attr4 = document.createAttribute("UNIT");
            B47attr4.setValue("k");
            B47.setAttributeNode(B47attr4);
            //End

            //nine B4 with tod 1tag
            Element B48 = document.createElement("B4");
            d301.appendChild(B48);

            Attr B48attr1 = document.createAttribute("TOD");
            B48attr1.setValue("1");
            B48.setAttributeNode(B48attr1);

            Attr B48attr2 = document.createAttribute("PARAMCODE");
            B48attr2.setValue("P7-3-5-2-0");
            B48.setAttributeNode(B48attr2);

            Attr B48attr3 = document.createAttribute("VALUE");
            B48attr3.setValue(getSetValues.getLine21ki_second());
            B48.setAttributeNode(B48attr3);

            Attr B48attr4 = document.createAttribute("UNIT");
            B48attr4.setValue("k");
            B48.setAttributeNode(B48attr4);
            //End

            //tenth B4 tag
            Element B49 = document.createElement("B4");
            d301.appendChild(B49);

            Attr B49attr1 = document.createAttribute("TOD");
            B49attr1.setValue("1");
            B49.setAttributeNode(B49attr1);

            Attr B49attr2 = document.createAttribute("PARAMCODE");
            B49attr2.setValue("P7-1-5-2-0");
            B49.setAttributeNode(B49attr2);

            Attr B49attr3 = document.createAttribute("VALUE");
            B49attr3.setValue(getSetValues.getLine22ki_second());
            B49.setAttributeNode(B49attr3);

            Attr B49attr4 = document.createAttribute("UNIT");
            B49attr4.setValue("k");
            B49.setAttributeNode(B49attr4);
            //End

            //11th B4 tag
            Element B50 = document.createElement("B4");
            d301.appendChild(B50);

            Attr B50attr1 = document.createAttribute("TOD");
            B50attr1.setValue("1");
            B50.setAttributeNode(B50attr1);

            Attr B50attr2 = document.createAttribute("PARAMCODE");
            B50attr2.setValue("P7-1-5-2-0");
            B50.setAttributeNode(B50attr2);

            Attr B50attr3 = document.createAttribute("VALUE");
            B50attr3.setValue(getSetValues.getLine23ki_second());
            B50.setAttributeNode(B50attr3);

            Attr B50attr4 = document.createAttribute("UNIT");
            B50attr4.setValue("k");
            B50.setAttributeNode(B50attr4);
            //End

            //12th B4 tag
            Element B51 = document.createElement("B4");
            d301.appendChild(B51);

            Attr B51attr1 = document.createAttribute("TOD");
            B51attr1.setValue("1");
            B51.setAttributeNode(B51attr1);

            Attr B51attr2 = document.createAttribute("PARAMCODE");
            B51attr2.setValue("P7-1-5-2-0");
            B51.setAttributeNode(B51attr2);

            Attr B51attr3 = document.createAttribute("VALUE");
            B51attr3.setValue(getSetValues.getLine24ki_second());
            B51.setAttributeNode(B51attr3);

            Attr B51attr4 = document.createAttribute("UNIT");
            B51attr4.setValue("k");
            B51.setAttributeNode(B51attr4);
            //End

            //13th B4 tag
            Element B52 = document.createElement("B4");
            d301.appendChild(B52);

            Attr B52attr1 = document.createAttribute("TOD");
            B52attr1.setValue("1");
            B52.setAttributeNode(B52attr1);

            Attr B52attr2 = document.createAttribute("PARAMCODE");
            B52attr2.setValue("P7-3-6-2-0");
            B52.setAttributeNode(B52attr2);

            Attr B52attr3 = document.createAttribute("VALUE");
            B52attr3.setValue(getSetValues.getLine25ki_second());
            B52.setAttributeNode(B52attr3);

            Attr B52attr4 = document.createAttribute("UNIT");
            B52attr4.setValue("k");
            B52.setAttributeNode(B52attr4);
            //End

            //14th B4 tag
            Element B53 = document.createElement("B4");
            d301.appendChild(B53);

            Attr B53attr1 = document.createAttribute("TOD");
            B53attr1.setValue("1");
            B53.setAttributeNode(B53attr1);

            Attr B53attr2 = document.createAttribute("PARAMCODE");
            B53attr2.setValue("P7-1-6-2-0");
            B53.setAttributeNode(B53attr2);

            Attr B53attr3 = document.createAttribute("VALUE");
            B53attr3.setValue(getSetValues.getLine26ki_second());
            B53.setAttributeNode(B53attr3);

            Attr B53attr4 = document.createAttribute("UNIT");
            B53attr4.setValue("k");
            B53.setAttributeNode(B53attr4);
            //End

            //15th B4 tag
            Element B54 = document.createElement("B4");
            d301.appendChild(B54);

            Attr B54attr1 = document.createAttribute("TOD");
            B54attr1.setValue("1");
            B54.setAttributeNode(B54attr1);

            Attr B54attr2 = document.createAttribute("PARAMCODE");
            B54attr2.setValue("P7-2-2-2-0");
            B54.setAttributeNode(B54attr2);

            Attr B54attr3 = document.createAttribute("VALUE");
            B54attr3.setValue(getSetValues.getLine27ki_second());
            B54.setAttributeNode(B54attr3);

            Attr B54attr4 = document.createAttribute("UNIT");
            B54attr4.setValue("k");
            B54.setAttributeNode(B54attr4);
            //End


            //16th B4 tag
            Element B55 = document.createElement("B4");
            d301.appendChild(B55);

            Attr B55attr1 = document.createAttribute("TOD");
            B55attr1.setValue("1");
            B55.setAttributeNode(B55attr1);

            Attr B55attr2 = document.createAttribute("PARAMCODE");
            B55attr2.setValue("P7-2-3-2-0");
            B55.setAttributeNode(B55attr2);

            Attr B55attr3 = document.createAttribute("VALUE");
            B55attr3.setValue(getSetValues.getLine28ki_second());
            B55.setAttributeNode(B55attr3);

            Attr B55attr4 = document.createAttribute("UNIT");
            B55attr4.setValue("k");
            B55.setAttributeNode(B55attr4);
            //End

            //1st B4 with tod 2
            /***********/
            Element B56 = document.createElement("B4");
            d301.appendChild(B56);

            Attr B56attr1 = document.createAttribute("TOD");
            B56attr1.setValue("2");
            B56.setAttributeNode(B56attr1);

            Attr B56attr2 = document.createAttribute("PARAMCODE");
            B56attr2.setValue("P7-3-5-2-0");
            B56.setAttributeNode(B56attr2);

            Attr B56attr3 = document.createAttribute("VALUE");
            B56attr3.setValue(getSetValues.getLine21ki_third());
            B56.setAttributeNode(B56attr3);

            Attr B56attr4 = document.createAttribute("UNIT");
            B56attr4.setValue("k");
            B56.setAttributeNode(B56attr4);


            //2nd B4 with tod 2
            /***********/
            Element B57 = document.createElement("B4");
            d301.appendChild(B57);

            Attr B57attr1 = document.createAttribute("TOD");
            B57attr1.setValue("2");
            B57.setAttributeNode(B57attr1);

            Attr B57attr2 = document.createAttribute("PARAMCODE");
            B57attr2.setValue("P7-1-5-2-0");
            B57.setAttributeNode(B57attr2);

            Attr B57attr3 = document.createAttribute("VALUE");
            B57attr3.setValue(getSetValues.getLine22ki_third());
            B57.setAttributeNode(B57attr3);

            Attr B57attr4 = document.createAttribute("UNIT");
            B57attr4.setValue("k");
            B57.setAttributeNode(B57attr4);

            //3rd B4 with tod 2
            /***********/
            Element B58 = document.createElement("B4");
            d301.appendChild(B58);

            Attr B58attr1 = document.createAttribute("TOD");
            B58attr1.setValue("2");
            B58.setAttributeNode(B58attr1);

            Attr B58attr2 = document.createAttribute("PARAMCODE");
            B58attr2.setValue("P7-2-1-2-0");
            B58.setAttributeNode(B58attr2);

            Attr B58attr3 = document.createAttribute("VALUE");
            B58attr3.setValue(getSetValues.getLine23ki_third());
            B58.setAttributeNode(B58attr3);

            Attr B58attr4 = document.createAttribute("UNIT");
            B58attr4.setValue("k");
            B58.setAttributeNode(B58attr4);


            //4th B4 with tod 2
            /***********/
            Element B59 = document.createElement("B4");
            d301.appendChild(B59);

            Attr B59attr1 = document.createAttribute("TOD");
            B59attr1.setValue("2");
            B59.setAttributeNode(B59attr1);

            Attr B59attr2 = document.createAttribute("PARAMCODE");
            B59attr2.setValue("P7-2-4-2-0");
            B59.setAttributeNode(B59attr2);

            Attr B59attr3 = document.createAttribute("VALUE");
            B59attr3.setValue(getSetValues.getLine24ki_third());
            B59.setAttributeNode(B59attr3);

            Attr B59attr4 = document.createAttribute("UNIT");
            B59attr4.setValue("k");
            B59.setAttributeNode(B59attr4);

            //5th B4 with tod 2
            /***********/
            Element B60 = document.createElement("B4");
            d301.appendChild(B60);

            Attr B60attr1 = document.createAttribute("TOD");
            B60attr1.setValue("2");
            B60.setAttributeNode(B60attr1);

            Attr B60attr2 = document.createAttribute("PARAMCODE");
            B60attr2.setValue("P7-3-6-2-0");
            B60.setAttributeNode(B60attr2);

            Attr B60attr3 = document.createAttribute("VALUE");
            B60attr3.setValue("0");
            B60.setAttributeNode(B60attr3);

            Attr B60attr4 = document.createAttribute("UNIT");
            B60attr4.setValue("k");
            B60.setAttributeNode(B60attr4);

            //6th B4 with tod 2
            /***********/
            Element B61 = document.createElement("B4");
            d301.appendChild(B61);

            Attr B61attr1 = document.createAttribute("TOD");
            B61attr1.setValue("2");
            B61.setAttributeNode(B61attr1);

            Attr B61attr2 = document.createAttribute("PARAMCODE");
            B61attr2.setValue("P7-1-6-2-0");
            B61.setAttributeNode(B61attr2);

            Attr B61attr3 = document.createAttribute("VALUE");
            B61attr3.setValue("0");
            B61.setAttributeNode(B61attr3);

            Attr B61attr4 = document.createAttribute("UNIT");
            B61attr4.setValue("k");
            B61.setAttributeNode(B61attr4);


            //7th B4 with tod 2
            /***********/
            Element B62 = document.createElement("B4");
            d301.appendChild(B62);

            Attr B62attr1 = document.createAttribute("TOD");
            B62attr1.setValue("2");
            B62.setAttributeNode(B62attr1);

            Attr B62attr2 = document.createAttribute("PARAMCODE");
            B62attr2.setValue("P7-2-2-2-0");
            B62.setAttributeNode(B62attr2);

            Attr B62attr3 = document.createAttribute("VALUE");
            B62attr3.setValue("0");
            B62.setAttributeNode(B62attr3);

            Attr B62attr4 = document.createAttribute("UNIT");
            B62attr4.setValue("k");
            B62.setAttributeNode(B62attr4);


            //8th B4 with tod 2
            /***********/
            Element B63 = document.createElement("B4");
            d301.appendChild(B63);

            Attr B63attr1 = document.createAttribute("TOD");
            B63attr1.setValue("2");
            B63.setAttributeNode(B63attr1);

            Attr B63attr2 = document.createAttribute("PARAMCODE");
            B63attr2.setValue("P7-2-2-2-0");
            B63.setAttributeNode(B63attr2);

            Attr B63attr3 = document.createAttribute("VALUE");
            B63attr3.setValue("0");
            B63.setAttributeNode(B63attr3);

            Attr B63attr4 = document.createAttribute("UNIT");
            B63attr4.setValue("k");
            B63.setAttributeNode(B63attr4);

            /*****tod3****/

            //1st B4 with tod 3
            /***********/
            Element B64 = document.createElement("B4");
            d301.appendChild(B64);

            Attr B64attr1 = document.createAttribute("TOD");
            B64attr1.setValue("3");
            B64.setAttributeNode(B64attr1);

            Attr B64attr2 = document.createAttribute("PARAMCODE");
            B64attr2.setValue("P7-3-5-2-0");
            B64.setAttributeNode(B64attr2);

            Attr B64attr3 = document.createAttribute("VALUE");
            B64attr3.setValue(getSetValues.getLine21ki_fourth());
            B64.setAttributeNode(B64attr3);

            Attr B64attr4 = document.createAttribute("UNIT");
            B64attr4.setValue("k");
            B64.setAttributeNode(B64attr4);


            //2nd B4 with tod 3
            /***********/
            Element B65 = document.createElement("B4");
            d301.appendChild(B65);

            Attr B65attr1 = document.createAttribute("TOD");
            B65attr1.setValue("3");
            B65.setAttributeNode(B65attr1);

            Attr B65attr2 = document.createAttribute("PARAMCODE");
            B65attr2.setValue("P7-1-5-2-0");
            B65.setAttributeNode(B65attr2);

            Attr B65attr3 = document.createAttribute("VALUE");
            B65attr3.setValue(getSetValues.getLine22ki_fourth());
            B65.setAttributeNode(B65attr3);

            Attr B65attr4 = document.createAttribute("UNIT");
            B65attr4.setValue("k");
            B65.setAttributeNode(B65attr4);

            //3rd B4 with tod 3
            /***********/
            Element B66 = document.createElement("B4");
            d301.appendChild(B66);

            Attr B66attr1 = document.createAttribute("TOD");
            B66attr1.setValue("3");
            B66.setAttributeNode(B66attr1);

            Attr B66attr2 = document.createAttribute("PARAMCODE");
            B66attr2.setValue("P7-2-1-2-0");
            B66.setAttributeNode(B66attr2);

            Attr B66attr3 = document.createAttribute("VALUE");
            B66attr3.setValue(getSetValues.getLine23ki_fourth());
            B66.setAttributeNode(B66attr3);

            Attr B66attr4 = document.createAttribute("UNIT");
            B66attr4.setValue("k");
            B66.setAttributeNode(B66attr4);


            //4th B4 with tod 3
            /***********/
            Element B67 = document.createElement("B4");
            d301.appendChild(B67);

            Attr B67attr1 = document.createAttribute("TOD");
            B67attr1.setValue("3");
            B67.setAttributeNode(B67attr1);

            Attr B67attr2 = document.createAttribute("PARAMCODE");
            B67attr2.setValue("P7-2-4-2-0");
            B67.setAttributeNode(B67attr2);

            Attr B67attr3 = document.createAttribute("VALUE");
            B67attr3.setValue(getSetValues.getLine24ki_fourth());
            B67.setAttributeNode(B67attr3);

            Attr B67attr4 = document.createAttribute("UNIT");
            B67attr4.setValue("k");
            B67.setAttributeNode(B67attr4);

            //5th B4 with tod 3
            /***********/
            Element B68 = document.createElement("B4");
            d301.appendChild(B68);

            Attr B68attr1 = document.createAttribute("TOD");
            B68attr1.setValue("3");
            B68.setAttributeNode(B68attr1);

            Attr B68attr2 = document.createAttribute("PARAMCODE");
            B68attr2.setValue("P7-3-6-2-0");
            B68.setAttributeNode(B68attr2);

            Attr B68attr3 = document.createAttribute("VALUE");
            B68attr3.setValue("0");
            B68.setAttributeNode(B68attr3);

            Attr B68attr4 = document.createAttribute("UNIT");
            B68attr4.setValue("k");
            B68.setAttributeNode(B68attr4);

            //6th B4 with tod 3
            /***********/
            Element B69 = document.createElement("B4");
            d301.appendChild(B69);

            Attr B69attr1 = document.createAttribute("TOD");
            B69attr1.setValue("3");
            B69.setAttributeNode(B69attr1);

            Attr B69attr2 = document.createAttribute("PARAMCODE");
            B69attr2.setValue("P7-1-6-2-0");
            B69.setAttributeNode(B69attr2);

            Attr B69attr3 = document.createAttribute("VALUE");
            B69attr3.setValue("0");
            B69.setAttributeNode(B69attr3);

            Attr B69attr4 = document.createAttribute("UNIT");
            B69attr4.setValue("k");
            B69.setAttributeNode(B69attr4);


            //7th B4 with tod 3
            /***********/
            Element B70 = document.createElement("B4");
            d301.appendChild(B70);

            Attr B70attr1 = document.createAttribute("TOD");
            B70attr1.setValue("3");
            B70.setAttributeNode(B70attr1);

            Attr B70attr2 = document.createAttribute("PARAMCODE");
            B70attr2.setValue("P7-2-2-2-0");
            B70.setAttributeNode(B70attr2);

            Attr B70attr3 = document.createAttribute("VALUE");
            B70attr3.setValue("0");
            B70.setAttributeNode(B70attr3);

            Attr B70attr4 = document.createAttribute("UNIT");
            B70attr4.setValue("k");
            B70.setAttributeNode(B70attr4);


            //8th B4 with tod 2
            /***********/
            Element B71 = document.createElement("B4");
            d301.appendChild(B71);

            Attr B71attr1 = document.createAttribute("TOD");
            B71attr1.setValue("3");
            B71.setAttributeNode(B71attr1);

            Attr B71attr2 = document.createAttribute("PARAMCODE");
            B71attr2.setValue("P7-2-3-2-0");
            B71.setAttributeNode(B71attr2);

            Attr B71attr3 = document.createAttribute("VALUE");
            B71attr3.setValue("0");
            B71.setAttributeNode(B71attr3);

            Attr B71attr4 = document.createAttribute("UNIT");
            B71attr4.setValue("k");
            B71.setAttributeNode(B71attr4);

            /****B5*****/
            //1st B5
            Element B72 = document.createElement("B5");
            d301.appendChild(B72);

            Attr B72attr2 = document.createAttribute("PARAMCODE");
            B72attr2.setValue("P7-6-5-2-0");
            B72.setAttributeNode(B72attr2);

            Attr B72attr3 = document.createAttribute("VALUE");
            B72attr3.setValue("0");
            B72.setAttributeNode(B72attr3);

            Attr B72attr4 = document.createAttribute("UNIT");
            B72attr4.setValue("k");
            B72.setAttributeNode(B72attr4);

            //2nd B5
            Element B73 = document.createElement("B5");
            d301.appendChild(B73);

            Attr B73attr2 = document.createAttribute("PARAMCODE");
            B73attr2.setValue("P7-4-5-2-0");
            B73.setAttributeNode(B73attr2);

            Attr B73attr3 = document.createAttribute("VALUE");
            B73attr3.setValue("0");
            B73.setAttributeNode(B73attr3);

            Attr B73attr4 = document.createAttribute("UNIT");
            B73attr4.setValue("k");
            B73.setAttributeNode(B73attr4);

            //3rd B5
            Element B74 = document.createElement("B5");
            d301.appendChild(B74);

            Attr B74attr2 = document.createAttribute("PARAMCODE");
            B74attr2.setValue("P7-5-1-2-0");
            B74.setAttributeNode(B74attr2);

            Attr B74attr3 = document.createAttribute("VALUE");
            B74attr3.setValue("0");
            B74.setAttributeNode(B74attr3);

            Attr B74attr4 = document.createAttribute("UNIT");
            B74attr4.setValue("k");
            B74.setAttributeNode(B74attr4);

            /****B6****/
            //1st B6 tod 0
            Element B75 = document.createElement("B6");
            d301.appendChild(B75);

            Attr B75attr1 = document.createAttribute("TOD");
            B75attr1.setValue("0");
            B75.setAttributeNode(B75attr1);

            Attr B75attr2 = document.createAttribute("PARAMCODE");
            B75attr2.setValue("P7-6-5-2-0");
            B75.setAttributeNode(B75attr2);

            Attr B75attr3 = document.createAttribute("VALUE");
            B75attr3.setValue("0");
            B75.setAttributeNode(B75attr3);

            Attr B75attr4 = document.createAttribute("UNIT");
            B75attr4.setValue("k");
            B75.setAttributeNode(B75attr4);

            Attr B75attr5 = document.createAttribute("OCCDATE");
            B75attr5.setValue("");
            B75.setAttributeNode(B75attr5);


            //2nd B6 tod 0
            Element B76 = document.createElement("B6");
            d301.appendChild(B76);

            Attr B76attr1 = document.createAttribute("TOD");
            B76attr1.setValue("0");
            B76.setAttributeNode(B76attr1);

            Attr B76attr2 = document.createAttribute("PARAMCODE");
            B76attr2.setValue("P7-4-5-2-0");
            B76.setAttributeNode(B76attr2);

            Attr B76attr3 = document.createAttribute("VALUE");
            B76attr3.setValue("0");
            B76.setAttributeNode(B76attr3);

            Attr B76attr4 = document.createAttribute("UNIT");
            B76attr4.setValue("k");
            B76.setAttributeNode(B76attr4);

            Attr B76attr5 = document.createAttribute("OCCDATE");
            B76attr5.setValue("");
            B76.setAttributeNode(B76attr5);

            //3rd B6 tod 0
            Element B77 = document.createElement("B6");
            d301.appendChild(B77);

            Attr B77attr1 = document.createAttribute("TOD");
            B77attr1.setValue("0");
            B77.setAttributeNode(B77attr1);

            Attr B77attr2 = document.createAttribute("PARAMCODE");
            B77attr2.setValue("P7-5-1-2-0");
            B77.setAttributeNode(B77attr2);

            Attr B77attr3 = document.createAttribute("VALUE");
            B77attr3.setValue("0");
            B77.setAttributeNode(B77attr3);

            Attr B77attr4 = document.createAttribute("UNIT");
            B77attr4.setValue("k");
            B77.setAttributeNode(B77attr4);

            Attr B77attr5 = document.createAttribute("OCCDATE");
            B77attr5.setValue("");
            B77.setAttributeNode(B77attr5);

            //1st B6 tod 1
            Element B78 = document.createElement("B6");
            d301.appendChild(B78);

            Attr B78attr1 = document.createAttribute("TOD");
            B78attr1.setValue("1");
            B78.setAttributeNode(B78attr1);

            Attr B78attr2 = document.createAttribute("PARAMCODE");
            B78attr2.setValue("P7-6-5-2-0");
            B78.setAttributeNode(B78attr2);

            Attr B78attr3 = document.createAttribute("VALUE");
            B78attr3.setValue("0");
            B78.setAttributeNode(B78attr3);

            Attr B78attr4 = document.createAttribute("UNIT");
            B78attr4.setValue("k");
            B78.setAttributeNode(B78attr4);

            Attr B78attr5 = document.createAttribute("OCCDATE");
            B78attr5.setValue("");
            B75.setAttributeNode(B78attr5);


            //2nd B6 tod 1
            Element B79 = document.createElement("B6");
            d301.appendChild(B79);

            Attr B79attr1 = document.createAttribute("TOD");
            B79attr1.setValue("1");
            B79.setAttributeNode(B79attr1);

            Attr B79attr2 = document.createAttribute("PARAMCODE");
            B79attr2.setValue("P7-4-5-2-0");
            B79.setAttributeNode(B79attr2);

            Attr B79attr3 = document.createAttribute("VALUE");
            B79attr3.setValue("0");
            B79.setAttributeNode(B79attr3);

            Attr B79attr4 = document.createAttribute("UNIT");
            B79attr4.setValue("k");
            B79.setAttributeNode(B79attr4);

            Attr B79attr5 = document.createAttribute("OCCDATE");
            B79attr5.setValue("");
            B79.setAttributeNode(B79attr5);

            //3rd B6 tod 1
            Element B80 = document.createElement("B6");
            d301.appendChild(B80);

            Attr B80attr1 = document.createAttribute("TOD");
            B80attr1.setValue("1");
            B80.setAttributeNode(B80attr1);

            Attr B80attr2 = document.createAttribute("PARAMCODE");
            B80attr2.setValue("P7-5-1-2-0");
            B80.setAttributeNode(B80attr2);

            Attr B80attr3 = document.createAttribute("VALUE");
            B80attr3.setValue("0");
            B80.setAttributeNode(B80attr3);

            Attr B80attr4 = document.createAttribute("UNIT");
            B80attr4.setValue("k");
            B80.setAttributeNode(B80attr4);

            Attr B80attr5 = document.createAttribute("OCCDATE");
            B80attr5.setValue("");
            B80.setAttributeNode(B80attr5);

            //1st B6 tod 2
            Element B81 = document.createElement("B6");
            d301.appendChild(B81);

            Attr B81attr1 = document.createAttribute("TOD");
            B81attr1.setValue("2");
            B81.setAttributeNode(B81attr1);

            Attr B81attr2 = document.createAttribute("PARAMCODE");
            B81attr2.setValue("P7-6-5-2-0");
            B81.setAttributeNode(B81attr2);

            Attr B81attr3 = document.createAttribute("VALUE");
            B81attr3.setValue("0");
            B81.setAttributeNode(B81attr3);

            Attr B81attr4 = document.createAttribute("UNIT");
            B81attr4.setValue("k");
            B81.setAttributeNode(B81attr4);

            Attr B81attr5 = document.createAttribute("OCCDATE");
            B81attr5.setValue("");
            B81.setAttributeNode(B81attr5);


            //2nd B6 tod 2
            Element B82 = document.createElement("B6");
            d301.appendChild(B82);

            Attr B82attr1 = document.createAttribute("TOD");
            B82attr1.setValue("2");
            B82.setAttributeNode(B82attr1);

            Attr B82attr2 = document.createAttribute("PARAMCODE");
            B82attr2.setValue("P7-4-5-2-0");
            B82.setAttributeNode(B82attr2);

            Attr B82attr3 = document.createAttribute("VALUE");
            B82attr3.setValue("0");
            B82.setAttributeNode(B82attr3);

            Attr B82attr4 = document.createAttribute("UNIT");
            B82attr4.setValue("k");
            B82.setAttributeNode(B82attr4);

            Attr B82attr5 = document.createAttribute("OCCDATE");
            B82attr5.setValue("");
            B82.setAttributeNode(B82attr5);

            //3rd B6 tod 2
            Element B83 = document.createElement("B6");
            d301.appendChild(B83);

            Attr B83attr1 = document.createAttribute("TOD");
            B83attr1.setValue("2");
            B83.setAttributeNode(B83attr1);

            Attr B83attr2 = document.createAttribute("PARAMCODE");
            B83attr2.setValue("P7-5-1-2-0");
            B83.setAttributeNode(B83attr2);

            Attr B83attr3 = document.createAttribute("VALUE");
            B83attr3.setValue("0");
            B83.setAttributeNode(B83attr3);

            Attr B83attr4 = document.createAttribute("UNIT");
            B83attr4.setValue("k");
            B83.setAttributeNode(B83attr4);

            Attr B83attr5 = document.createAttribute("OCCDATE");
            B83attr5.setValue("");
            B83.setAttributeNode(B83attr5);

            //1st B6 tod 3
            Element B84 = document.createElement("B6");
            d301.appendChild(B84);

            Attr B84attr1 = document.createAttribute("TOD");
            B84attr1.setValue("3");
            B84.setAttributeNode(B84attr1);

            Attr B84attr2 = document.createAttribute("PARAMCODE");
            B84attr2.setValue("P7-6-5-2-0");
            B84.setAttributeNode(B84attr2);

            Attr B84attr3 = document.createAttribute("VALUE");
            B84attr3.setValue("0");
            B84.setAttributeNode(B84attr3);

            Attr B84attr4 = document.createAttribute("UNIT");
            B84attr4.setValue("k");
            B84.setAttributeNode(B84attr4);

            Attr B84attr5 = document.createAttribute("OCCDATE");
            B84attr5.setValue("");
            B84.setAttributeNode(B84attr5);


            //2nd B6 tod 3
            Element B85 = document.createElement("B6");
            d301.appendChild(B85);

            Attr B85attr1 = document.createAttribute("TOD");
            B85attr1.setValue("3");
            B85.setAttributeNode(B85attr1);

            Attr B85attr2 = document.createAttribute("PARAMCODE");
            B85attr2.setValue("P7-4-5-2-0");
            B85.setAttributeNode(B85attr2);

            Attr B85attr3 = document.createAttribute("VALUE");
            B85attr3.setValue("0");
            B85.setAttributeNode(B85attr3);

            Attr B85attr4 = document.createAttribute("UNIT");
            B85attr4.setValue("k");
            B85.setAttributeNode(B85attr4);

            Attr B85attr5 = document.createAttribute("OCCDATE");
            B85attr5.setValue("");
            B85.setAttributeNode(B85attr5);

            //3rd B6 tod 3
            Element B86 = document.createElement("B6");
            d301.appendChild(B86);

            Attr B86attr1 = document.createAttribute("TOD");
            B86attr1.setValue("3");
            B86.setAttributeNode(B86attr1);

            Attr B86attr2 = document.createAttribute("PARAMCODE");
            B86attr2.setValue("P7-5-1-2-0");
            B86.setAttributeNode(B86attr2);

            Attr B86attr3 = document.createAttribute("VALUE");
            B86attr3.setValue("0");
            B86.setAttributeNode(B86attr3);

            Attr B86attr4 = document.createAttribute("UNIT");
            B86attr4.setValue("k");
            B86.setAttributeNode(B86attr4);

            Attr B86attr5 = document.createAttribute("OCCDATE");
            B86attr5.setValue("");
            B86.setAttributeNode(B86attr5);




            //1st B9
            Element B90 = document.createElement("B9");
            d301.appendChild(B90);

            Attr B90attr2 = document.createAttribute("PARAMCODE");
            B90attr2.setValue("P4-4-4-1-0");
            B90.setAttributeNode(B90attr2);

            Attr B90attr3 = document.createAttribute("VALUE");
            B90attr3.setValue("0");
            B90.setAttributeNode(B90attr3);

            //2nd B9
            Element B91 = document.createElement("B9");
            d301.appendChild(B91);

            Attr B91attr2 = document.createAttribute("PARAMCODE");
            B91attr2.setValue("P4-4-4-2-0");
            B91.setAttributeNode(B91attr2);

            Attr B91attr3 = document.createAttribute("VALUE");
            B91attr3.setValue("0");
            B91.setAttributeNode(B91attr3);


            //1st B10 tod 0
            Element B92 = document.createElement("B10");
            d301.appendChild(B92);

            Attr B92attr1 = document.createAttribute("TOD");
            B92attr1.setValue("0");
            B92.setAttributeNode(B92attr1);

            Attr B92attr2 = document.createAttribute("PARAMCODE");
            B92attr2.setValue("P4-4-4-1-0");
            B92.setAttributeNode(B92attr2);

            Attr B92attr3 = document.createAttribute("VALUE");
            B92attr3.setValue("0");
            B92.setAttributeNode(B92attr3);


            //2nd B10 tod 3
            Element B93 = document.createElement("B10");
            d301.appendChild(B93);

            Attr B93attr1 = document.createAttribute("TOD");
            B93attr1.setValue("0");
            B93.setAttributeNode(B93attr1);

            Attr B93attr2 = document.createAttribute("PARAMCODE");
            B93attr2.setValue("P4-4-4-2-0");
            B93.setAttributeNode(B93attr2);

            Attr B93attr3 = document.createAttribute("VALUE");
            B93attr3.setValue("0");
            B93.setAttributeNode(B93attr3);


            //3rd B10 tod 1
            Element B94 = document.createElement("B10");
            d301.appendChild(B94);

            Attr B94attr1 = document.createAttribute("TOD");
            B94attr1.setValue("1");
            B94.setAttributeNode(B94attr1);

            Attr B94attr2 = document.createAttribute("PARAMCODE");
            B94attr2.setValue("P4-4-4-1-0");
            B94.setAttributeNode(B94attr2);

            Attr B94attr3 = document.createAttribute("VALUE");
            B94attr3.setValue("0");
            B94.setAttributeNode(B94attr3);

            //4th B10 tod 1
            Element B95 = document.createElement("B10");
            d301.appendChild(B95);

            Attr B95attr1 = document.createAttribute("TOD");
            B95attr1.setValue("1");
            B95.setAttributeNode(B95attr1);

            Attr B95attr2 = document.createAttribute("PARAMCODE");
            B95attr2.setValue("P4-4-4-2-0");
            B95.setAttributeNode(B95attr2);

            Attr B95attr3 = document.createAttribute("VALUE");
            B95attr3.setValue("0");
            B95.setAttributeNode(B95attr3);

            //5th B10 tod 3
            Element B96 = document.createElement("B10");
            d301.appendChild(B96);

            Attr B96attr1 = document.createAttribute("TOD");
            B96attr1.setValue("3");
            B96.setAttributeNode(B96attr1);

            Attr B96attr2 = document.createAttribute("PARAMCODE");
            B96attr2.setValue("P4-4-4-1-0");
            B96.setAttributeNode(B96attr2);

            Attr B96attr3 = document.createAttribute("VALUE");
            B96attr3.setValue("0");
            B96.setAttributeNode(B96attr3);

            //6th B10 tod 3
            Element B97 = document.createElement("B10");
            d301.appendChild(B97);

            Attr B97attr1 = document.createAttribute("TOD");
            B97attr1.setValue("3");
            B97.setAttributeNode(B97attr1);

            Attr B97attr2 = document.createAttribute("PARAMCODE");
            B97attr2.setValue("P4-4-4-2-0");
            B97.setAttributeNode(B97attr2);

            Attr B97attr3 = document.createAttribute("VALUE");
            B97attr3.setValue("0");
            B97.setAttributeNode(B97attr3);
            /*************/
            /******START*****/
            //7th B10 tod 3
            Element B98 = document.createElement("B10");
            d301.appendChild(B98);

            Attr B98attr1 = document.createAttribute("TOD");
            B98attr1.setValue("3");
            B98.setAttributeNode(B98attr1);

            Attr B98attr2 = document.createAttribute("PARAMCODE");
            B98attr2.setValue("P4-4-4-1-0");
            B98.setAttributeNode(B98attr2);

            Attr B98attr3 = document.createAttribute("VALUE");
            B98attr3.setValue("0");
            B98.setAttributeNode(B98attr3);

            //8th B10 tod 3
            Element B99 = document.createElement("B10");
            d301.appendChild(B99);

            Attr B99attr1 = document.createAttribute("TOD");
            B99attr1.setValue("3");
            B99.setAttributeNode(B99attr1);

            Attr B99attr2 = document.createAttribute("PARAMCODE");
            B99attr2.setValue("P4-4-4-1-0");
            B99.setAttributeNode(B99attr2);

            Attr B99attr3 = document.createAttribute("VALUE");
            B99attr3.setValue("0");
            B99.setAttributeNode(B99attr3);

            /////////////// D3-02 TAG Starting//////////////

            Element d302 = document.createElement("D3-02");
            d3.appendChild(d302);

            Attr g302attr = document.createAttribute("DATETIME");
            g302attr.setValue("");
            d302.setAttributeNode(g302attr);

            Attr g302attr2 = document.createAttribute("MECHANISM");
            g302attr2.setValue("");
            d302.setAttributeNode(g302attr2);


            //For first B3 tag
            Element B100 = document.createElement("B3");
            d302.appendChild(B100);

            Attr B100attr1 = document.createAttribute("PARAMCODE");
            B100attr1.setValue("P7-3-5-2-0");
            B100.setAttributeNode(B100attr1);

            Attr B100attr2 = document.createAttribute("VALUE");
            B100attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValues.getLine12ki_first()) + Double.parseDouble(getSetValues.getLine12ki_second()) + Double.parseDouble(getSetValues.getLine12ki_third()) + Double.parseDouble(getSetValues.getLine12ki_fourth()))));
            B100.setAttributeNode(B100attr2);

            Attr B100attr3 = document.createAttribute("UNIT");
            B100attr3.setValue("k");
            B100.setAttributeNode(B100attr3);
            //End

            //For second B3 tag
            Element B101 = document.createElement("B3");
            d302.appendChild(B101);

            Attr B101attr1 = document.createAttribute("PARAMCODE");
            B101attr1.setValue("P7-1-5-2-0");
            B101.setAttributeNode(B101attr1);

            Attr B101attr2 = document.createAttribute("VALUE");
            B101attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValues.getLine13ki_first()) + Double.parseDouble(getSetValues.getLine13ki_second()) + Double.parseDouble(getSetValues.getLine13ki_third()) + Double.parseDouble(getSetValues.getLine13ki_fourth()))));
            B101.setAttributeNode(B101attr2);

            Attr B101attr3 = document.createAttribute("UNIT");
            B101attr3.setValue("k");
            B101.setAttributeNode(B101attr3);
            //End

            //For third B3 tag
            Element B102 = document.createElement("B3");
            d302.appendChild(B102);

            Attr B102attr1 = document.createAttribute("PARAMCODE");
            B102attr1.setValue("P7-2-1-2-0");
            B102.setAttributeNode(B102attr1);

            Attr B102attr2 = document.createAttribute("VALUE");

            B102attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValues.getLine14ki_first()) + Double.parseDouble(getSetValues.getLine14ki_second()) + Double.parseDouble(getSetValues.getLine14ki_third()) + Double.parseDouble(getSetValues.getLine14ki_fourth()))));
            B102.setAttributeNode(B102attr2);

            Attr B102attr3 = document.createAttribute("UNIT");
            B102attr3.setValue("k");
            B102.setAttributeNode(B102attr3);
            //End


            //For fourth B3 tag
            Element B103 = document.createElement("B3");
            d302.appendChild(B103);

            Attr B103attr1 = document.createAttribute("PARAMCODE");
            B103attr1.setValue("P7-2-4-2-0");
            B103.setAttributeNode(B103attr1);

            Attr B103attr2 = document.createAttribute("VALUE");
            B103attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValues.getLine15ki_first()) + Double.parseDouble(getSetValues.getLine15ki_second()) + Double.parseDouble(getSetValues.getLine15ki_third()) + Double.parseDouble(getSetValues.getLine15ki_fourth()))));
            B103.setAttributeNode(B103attr2);

            Attr B103attr3 = document.createAttribute("UNIT");
            B103attr3.setValue("k");
            B103.setAttributeNode(B103attr3);
            //End

            //For fifth B3 tag
            Element B104 = document.createElement("B3");
            d302.appendChild(B104);

            Attr B104attr1 = document.createAttribute("PARAMCODE");
            B104attr1.setValue("P7-3-6-2-0");
            B104.setAttributeNode(B104attr1);

            Attr B104attr2 = document.createAttribute("VALUE");
            B104attr2.setValue(getSetValues.getLine16ki_second());
            B104.setAttributeNode(B104attr2);

            Attr B104attr3 = document.createAttribute("UNIT");
            B104attr3.setValue("k");
            B104.setAttributeNode(B104attr3);
            //End

            //For sixth B3 tag
            Element B105 = document.createElement("B3");
            d302.appendChild(B105);

            Attr B105attr1 = document.createAttribute("PARAMCODE");
            B105attr1.setValue("P7-1-6-2-0");
            B105.setAttributeNode(B105attr1);

            Attr B105attr2 = document.createAttribute("VALUE");
            B105attr2.setValue(getSetValues.getLine17ki_second());
            B105.setAttributeNode(B105attr2);

            Attr B105attr3 = document.createAttribute("UNIT");
            B105attr3.setValue("k");
            B105.setAttributeNode(B105attr3);
            //End

            //For seventh B3 tag
            Element B106 = document.createElement("B3");
            d302.appendChild(B106);

            Attr B106attr1 = document.createAttribute("PARAMCODE");
            B106attr1.setValue("P7-2-2-2-0");
            B106.setAttributeNode(B106attr1);

            Attr B106attr2 = document.createAttribute("VALUE");
            B106attr2.setValue(getSetValues.getLine18ki_second());
            B106.setAttributeNode(B106attr2);

            Attr B106attr3 = document.createAttribute("UNIT");
            B106attr3.setValue("k");
            B106.setAttributeNode(B106attr3);
            //End

            //For eight B3 tag
            Element B107 = document.createElement("B3");
            d302.appendChild(B107);

            Attr B107attr1 = document.createAttribute("PARAMCODE");
            B107attr1.setValue("P7-2-3-2-0");
            B107.setAttributeNode(B107attr1);

            Attr B107attr2 = document.createAttribute("VALUE");
            B107attr2.setValue(getSetValues.getLine19ki_second());
            B107.setAttributeNode(B107attr2);

            Attr B107attr3 = document.createAttribute("UNIT");
            B107attr3.setValue("k");
            B107.setAttributeNode(B107attr3);
            //End

            /*******D3-02 part******/
            /*****B4 Series Repetation******/
            //first B4 tag
            Element B108 = document.createElement("B4");
            d302.appendChild(B108);

            Attr B108attr1 = document.createAttribute("TOD");
            B108attr1.setValue("0");
            B108.setAttributeNode(B108attr1);

            Attr B108attr2 = document.createAttribute("PARAMCODE");
            B108attr2.setValue("P7-3-5-2-0");
            B108.setAttributeNode(B108attr2);

            Attr B108attr3 = document.createAttribute("VALUE");
            B108attr3.setValue(getSetValues.getLine12ki_first());
            B108.setAttributeNode(B108attr3);

            Attr B108attr4 = document.createAttribute("UNIT");
            B108attr4.setValue("k");
            B108.setAttributeNode(B108attr4);
            //End

            //second B4 tag
            Element B109 = document.createElement("B4");
            d302.appendChild(B109);

            Attr B109attr1 = document.createAttribute("TOD");
            B109attr1.setValue("0");
            B109.setAttributeNode(B109attr1);

            Attr B109attr2 = document.createAttribute("PARAMCODE");
            B109attr2.setValue("P7-1-5-2-0");
            B109.setAttributeNode(B109attr2);

            Attr B109attr3 = document.createAttribute("VALUE");
            B109attr3.setValue(getSetValues.getLine13ki_first());
            B109.setAttributeNode(B109attr3);

            Attr B109attr4 = document.createAttribute("UNIT");
            B109attr4.setValue("k");
            B109.setAttributeNode(B109attr4);
            //End

            //third B4 tag
            Element B110 = document.createElement("B4");
            d302.appendChild(B110);

            Attr B110attr1 = document.createAttribute("TOD");
            B110attr1.setValue("0");
            B110.setAttributeNode(B110attr1);

            Attr B110attr2 = document.createAttribute("PARAMCODE");
            B110attr2.setValue("P7-2-1-2-0");
            B110.setAttributeNode(B110attr2);

            Attr B110attr3 = document.createAttribute("VALUE");
            B110attr3.setValue(getSetValues.getLine14ki_first());
            B110.setAttributeNode(B110attr3);

            Attr B110attr4 = document.createAttribute("UNIT");
            B110attr4.setValue("k");
            B110.setAttributeNode(B110attr4);
            //End

            //fourth B4 tag
            Element B111 = document.createElement("B4");
            d302.appendChild(B111);

            Attr B111attr1 = document.createAttribute("TOD");
            B111attr1.setValue("0");
            B111.setAttributeNode(B111attr1);

            Attr B111attr2 = document.createAttribute("PARAMCODE");
            B111attr2.setValue("P7-2-4-2-0");
            B111.setAttributeNode(B111attr2);

            Attr B111attr3 = document.createAttribute("VALUE");
            B111attr3.setValue(getSetValues.getLine15ki_first());
            B111.setAttributeNode(B111attr3);

            Attr B111attr4 = document.createAttribute("UNIT");
            B111attr4.setValue("k");
            B111.setAttributeNode(B111attr4);
            //End


            //fifth B4 tag
            Element B112 = document.createElement("B4");
            d302.appendChild(B112);

            Attr B112attr1 = document.createAttribute("TOD");
            B112attr1.setValue("0");
            B112.setAttributeNode(B112attr1);

            Attr B112attr2 = document.createAttribute("PARAMCODE");
            B112attr2.setValue("P7-3-6-2-0");
            B112.setAttributeNode(B112attr2);

            Attr B112attr3 = document.createAttribute("VALUE");
            B112attr3.setValue("0");
            B112.setAttributeNode(B112attr3);

            Attr B112attr4 = document.createAttribute("UNIT");
            B112attr4.setValue("k");
            B112.setAttributeNode(B112attr4);
            //End

            //sixth B4 tag
            Element B113 = document.createElement("B4");
            d302.appendChild(B113);

            Attr B113attr1 = document.createAttribute("TOD");
            B113attr1.setValue("0");
            B113.setAttributeNode(B113attr1);

            Attr B113attr2 = document.createAttribute("PARAMCODE");
            B113attr2.setValue("P7-1-6-2-0");
            B113.setAttributeNode(B113attr2);

            Attr B113attr3 = document.createAttribute("VALUE");
            B113attr3.setValue("0");
            B113.setAttributeNode(B113attr3);

            Attr B113attr4 = document.createAttribute("UNIT");
            B113attr4.setValue("k");
            B113.setAttributeNode(B113attr4);
            //End

            //seventh B4 tag
            Element B114 = document.createElement("B4");
            d302.appendChild(B114);

            Attr B114attr1 = document.createAttribute("TOD");
            B114attr1.setValue("0");
            B114.setAttributeNode(B114attr1);

            Attr B114attr2 = document.createAttribute("PARAMCODE");
            B114attr2.setValue("P7-1-6-2-0");
            B114.setAttributeNode(B114attr2);

            Attr B114attr3 = document.createAttribute("VALUE");
            B114attr3.setValue("0");
            B114.setAttributeNode(B114attr3);

            Attr B114attr4 = document.createAttribute("UNIT");
            B114attr4.setValue("k");
            B114.setAttributeNode(B114attr4);
            //End

            //eight B4 tag
            Element B115 = document.createElement("B4");
            d302.appendChild(B115);

            Attr B115attr1 = document.createAttribute("TOD");
            B115attr1.setValue("0");
            B115.setAttributeNode(B115attr1);

            Attr B115attr2 = document.createAttribute("PARAMCODE");
            B115attr2.setValue("P7-2-3-2-0");
            B115.setAttributeNode(B115attr2);

            Attr B115attr3 = document.createAttribute("VALUE");
            B115attr3.setValue("0");
            B115.setAttributeNode(B115attr3);

            Attr B115attr4 = document.createAttribute("UNIT");
            B115attr4.setValue("k");
            B115.setAttributeNode(B115attr4);
            //End

            //nine B4 with tod 1tag
            Element B116 = document.createElement("B4");
            d302.appendChild(B116);

            Attr B116attr1 = document.createAttribute("TOD");
            B116attr1.setValue("1");
            B116.setAttributeNode(B116attr1);

            Attr B116attr2 = document.createAttribute("PARAMCODE");
            B116attr2.setValue("P7-3-5-2-0");
            B116.setAttributeNode(B116attr2);

            Attr B116attr3 = document.createAttribute("VALUE");
            B116attr3.setValue(getSetValues.getLine21ki_second());
            B116.setAttributeNode(B116attr3);

            Attr B116attr4 = document.createAttribute("UNIT");
            B116attr4.setValue("k");
            B116.setAttributeNode(B116attr4);
            //End

            //tenth B4 tag
            Element B117 = document.createElement("B4");
            d302.appendChild(B117);

            Attr B117attr1 = document.createAttribute("TOD");
            B117attr1.setValue("1");
            B117.setAttributeNode(B117attr1);

            Attr B117attr2 = document.createAttribute("PARAMCODE");
            B117attr2.setValue("P7-1-5-2-0");
            B117.setAttributeNode(B117attr2);

            Attr B117attr3 = document.createAttribute("VALUE");
            B117attr3.setValue(getSetValues.getLine22ki_second());
            B117.setAttributeNode(B117attr3);

            Attr B117attr4 = document.createAttribute("UNIT");
            B117attr4.setValue("k");
            B117.setAttributeNode(B117attr4);
            //End

            //11th B4 tag
            Element B118 = document.createElement("B4");
            d302.appendChild(B118);

            Attr B118attr1 = document.createAttribute("TOD");
            B118attr1.setValue("1");
            B118.setAttributeNode(B118attr1);

            Attr B118attr2 = document.createAttribute("PARAMCODE");
            B118attr2.setValue("P7-1-5-2-0");
            B118.setAttributeNode(B118attr2);

            Attr B118attr3 = document.createAttribute("VALUE");
            B118attr3.setValue(getSetValues.getLine23ki_second());
            B118.setAttributeNode(B118attr3);

            Attr B118attr4 = document.createAttribute("UNIT");
            B118attr4.setValue("k");
            B118.setAttributeNode(B118attr4);
            //End

            //12th B4 tag
            Element B119 = document.createElement("B4");
            d302.appendChild(B119);

            Attr B119attr1 = document.createAttribute("TOD");
            B119attr1.setValue("1");
            B119.setAttributeNode(B119attr1);

            Attr B119attr2 = document.createAttribute("PARAMCODE");
            B119attr2.setValue("P7-1-5-2-0");
            B119.setAttributeNode(B119attr2);

            Attr B119attr3 = document.createAttribute("VALUE");
            B119attr3.setValue(getSetValues.getLine24ki_second());
            B119.setAttributeNode(B119attr3);

            Attr B119attr4 = document.createAttribute("UNIT");
            B119attr4.setValue("k");
            B119.setAttributeNode(B119attr4);
            //End

            //13th B4 tag
            Element B120 = document.createElement("B4");
            d302.appendChild(B120);

            Attr B120attr1 = document.createAttribute("TOD");
            B120attr1.setValue("1");
            B120.setAttributeNode(B120attr1);

            Attr B120attr2 = document.createAttribute("PARAMCODE");
            B120attr2.setValue("P7-3-6-2-0");
            B120.setAttributeNode(B120attr2);

            Attr B120attr3 = document.createAttribute("VALUE");
            B120attr3.setValue(getSetValues.getLine25ki_second());
            B120.setAttributeNode(B120attr3);

            Attr B120attr4 = document.createAttribute("UNIT");
            B120attr4.setValue("k");
            B120.setAttributeNode(B120attr4);
            //End

            //14th B4 tag
            Element B121 = document.createElement("B4");
            d302.appendChild(B121);

            Attr B121attr1 = document.createAttribute("TOD");
            B121attr1.setValue("1");
            B121.setAttributeNode(B121attr1);

            Attr B121attr2 = document.createAttribute("PARAMCODE");
            B121attr2.setValue("P7-1-6-2-0");
            B121.setAttributeNode(B121attr2);

            Attr B121attr3 = document.createAttribute("VALUE");
            B121attr3.setValue(getSetValues.getLine26ki_second());
            B121.setAttributeNode(B121attr3);

            Attr B121attr4 = document.createAttribute("UNIT");
            B121attr4.setValue("k");
            B121.setAttributeNode(B121attr4);
            //End

            //15th B4 tag
            Element B122 = document.createElement("B4");
            d302.appendChild(B122);

            Attr B122attr1 = document.createAttribute("TOD");
            B122attr1.setValue("1");
            B122.setAttributeNode(B122attr1);

            Attr B122attr2 = document.createAttribute("PARAMCODE");
            B122attr2.setValue("P7-2-2-2-0");
            B122.setAttributeNode(B122attr2);

            Attr B122attr3 = document.createAttribute("VALUE");
            B122attr3.setValue(getSetValues.getLine27ki_second());
            B122.setAttributeNode(B122attr3);

            Attr B122attr4 = document.createAttribute("UNIT");
            B122attr4.setValue("k");
            B122.setAttributeNode(B122attr4);
            //End


            //16th B4 tag
            Element B123 = document.createElement("B4");
            d302.appendChild(B123);

            Attr B123attr1 = document.createAttribute("TOD");
            B123attr1.setValue("1");
            B123.setAttributeNode(B123attr1);

            Attr B123attr2 = document.createAttribute("PARAMCODE");
            B123attr2.setValue("P7-2-3-2-0");
            B123.setAttributeNode(B123attr2);

            Attr B123attr3 = document.createAttribute("VALUE");
            B123attr3.setValue(getSetValues.getLine28ki_second());
            B123.setAttributeNode(B123attr3);

            Attr B123attr4 = document.createAttribute("UNIT");
            B123attr4.setValue("k");
            B123.setAttributeNode(B123attr4);
            //End

            //1st B4 with tod 2
            /***********/
            Element B124 = document.createElement("B4");
            d302.appendChild(B124);

            Attr B124attr1 = document.createAttribute("TOD");
            B124attr1.setValue("2");
            B124.setAttributeNode(B124attr1);

            Attr B124attr2 = document.createAttribute("PARAMCODE");
            B124attr2.setValue("P7-3-5-2-0");
            B124.setAttributeNode(B124attr2);

            Attr B124attr3 = document.createAttribute("VALUE");
            B124attr3.setValue(getSetValues.getLine21ki_third());
            B124.setAttributeNode(B124attr3);

            Attr B124attr4 = document.createAttribute("UNIT");
            B124attr4.setValue("k");
            B124.setAttributeNode(B124attr4);


            //2nd B4 with tod 2
            /***********/
            Element B125 = document.createElement("B4");
            d302.appendChild(B125);

            Attr B125attr1 = document.createAttribute("TOD");
            B125attr1.setValue("2");
            B125.setAttributeNode(B125attr1);

            Attr B125attr2 = document.createAttribute("PARAMCODE");
            B125attr2.setValue("P7-1-5-2-0");
            B125.setAttributeNode(B125attr2);

            Attr B125attr3 = document.createAttribute("VALUE");
            B125attr3.setValue(getSetValues.getLine22ki_third());
            B125.setAttributeNode(B125attr3);

            Attr B125attr4 = document.createAttribute("UNIT");
            B125attr4.setValue("k");
            B125.setAttributeNode(B125attr4);

            //3rd B4 with tod 2
            /***********/
            Element B126 = document.createElement("B4");
            d302.appendChild(B126);

            Attr B126attr1 = document.createAttribute("TOD");
            B126attr1.setValue("2");
            B126.setAttributeNode(B126attr1);

            Attr B126attr2 = document.createAttribute("PARAMCODE");
            B126attr2.setValue("P7-2-1-2-0");
            B126.setAttributeNode(B126attr2);

            Attr B126attr3 = document.createAttribute("VALUE");
            B126attr3.setValue(getSetValues.getLine23ki_third());
            B126.setAttributeNode(B126attr3);

            Attr B126attr4 = document.createAttribute("UNIT");
            B126attr4.setValue("k");
            B126.setAttributeNode(B126attr4);


            //4th B4 with tod 2
            /***********/
            Element B127 = document.createElement("B4");
            d302.appendChild(B127);

            Attr B127attr1 = document.createAttribute("TOD");
            B127attr1.setValue("2");
            B127.setAttributeNode(B127attr1);

            Attr B127attr2 = document.createAttribute("PARAMCODE");
            B127attr2.setValue("P7-2-4-2-0");
            B127.setAttributeNode(B127attr2);

            Attr B127attr3 = document.createAttribute("VALUE");
            B127attr3.setValue(getSetValues.getLine24ki_third());
            B127.setAttributeNode(B127attr3);

            Attr B127attr4 = document.createAttribute("UNIT");
            B127attr4.setValue("k");
            B127.setAttributeNode(B127attr4);

            //5th B4 with tod 2
            /***********/
            Element B128 = document.createElement("B4");
            d302.appendChild(B128);

            Attr B128attr1 = document.createAttribute("TOD");
            B128attr1.setValue("2");
            B128.setAttributeNode(B128attr1);

            Attr B128attr2 = document.createAttribute("PARAMCODE");
            B128attr2.setValue("P7-3-6-2-0");
            B128.setAttributeNode(B128attr2);

            Attr B128attr3 = document.createAttribute("VALUE");
            B128attr3.setValue("0");
            B128.setAttributeNode(B128attr3);

            Attr B128attr4 = document.createAttribute("UNIT");
            B128attr4.setValue("k");
            B128.setAttributeNode(B128attr4);

            //6th B4 with tod 2
            /***********/
            Element B129 = document.createElement("B4");
            d302.appendChild(B129);

            Attr B129attr1 = document.createAttribute("TOD");
            B129attr1.setValue("2");
            B129.setAttributeNode(B129attr1);

            Attr B129attr2 = document.createAttribute("PARAMCODE");
            B129attr2.setValue("P7-1-6-2-0");
            B129.setAttributeNode(B129attr2);

            Attr B129attr3 = document.createAttribute("VALUE");
            B129attr3.setValue("0");
            B129.setAttributeNode(B129attr3);

            Attr B129attr4 = document.createAttribute("UNIT");
            B129attr4.setValue("k");
            B129.setAttributeNode(B129attr4);


            //7th B4 with tod 2
            /***********/
            Element B130 = document.createElement("B4");
            d302.appendChild(B130);

            Attr B130attr1 = document.createAttribute("TOD");
            B130attr1.setValue("2");
            B130.setAttributeNode(B130attr1);

            Attr B130attr2 = document.createAttribute("PARAMCODE");
            B130attr2.setValue("P7-2-2-2-0");
            B130.setAttributeNode(B130attr2);

            Attr B130attr3 = document.createAttribute("VALUE");
            B130attr3.setValue("0");
            B130.setAttributeNode(B130attr3);

            Attr B130attr4 = document.createAttribute("UNIT");
            B130attr4.setValue("k");
            B130.setAttributeNode(B130attr4);


            //8th B4 with tod 2
            /***********/
            Element B131 = document.createElement("B4");
            d302.appendChild(B131);

            Attr B131attr1 = document.createAttribute("TOD");
            B131attr1.setValue("2");
            B131.setAttributeNode(B131attr1);

            Attr B131attr2 = document.createAttribute("PARAMCODE");
            B131attr2.setValue("P7-2-2-2-0");
            B131.setAttributeNode(B131attr2);

            Attr B131attr3 = document.createAttribute("VALUE");
            B131attr3.setValue("0");
            B131.setAttributeNode(B131attr3);

            Attr B131attr4 = document.createAttribute("UNIT");
            B131attr4.setValue("k");
            B131.setAttributeNode(B131attr4);

            /*****tod3****/

            //1st B4 with tod 3
            /***********/
            Element B132 = document.createElement("B4");
            d302.appendChild(B132);

            Attr B132attr1 = document.createAttribute("TOD");
            B132attr1.setValue("3");
            B132.setAttributeNode(B132attr1);

            Attr B132attr2 = document.createAttribute("PARAMCODE");
            B132attr2.setValue("P7-3-5-2-0");
            B132.setAttributeNode(B132attr2);

            Attr B132attr3 = document.createAttribute("VALUE");
            B132attr3.setValue(getSetValues.getLine21ki_fourth());
            B132.setAttributeNode(B132attr3);

            Attr B132attr4 = document.createAttribute("UNIT");
            B132attr4.setValue("k");
            B132.setAttributeNode(B132attr4);


            //2nd B4 with tod 3
            /***********/
            Element B133 = document.createElement("B4");
            d302.appendChild(B133);

            Attr B133attr1 = document.createAttribute("TOD");
            B133attr1.setValue("3");
            B133.setAttributeNode(B133attr1);

            Attr B133attr2 = document.createAttribute("PARAMCODE");
            B133attr2.setValue("P7-1-5-2-0");
            B133.setAttributeNode(B133attr2);

            Attr B133attr3 = document.createAttribute("VALUE");
            B133attr3.setValue(getSetValues.getLine22ki_fourth());
            B133.setAttributeNode(B133attr3);

            Attr B133attr4 = document.createAttribute("UNIT");
            B133attr4.setValue("k");
            B133.setAttributeNode(B133attr4);

            //3rd B4 with tod 3
            /***********/
            Element B134 = document.createElement("B4");
            d302.appendChild(B134);

            Attr B134attr1 = document.createAttribute("TOD");
            B134attr1.setValue("3");
            B134.setAttributeNode(B134attr1);

            Attr B134attr2 = document.createAttribute("PARAMCODE");
            B134attr2.setValue("P7-2-1-2-0");
            B134.setAttributeNode(B134attr2);

            Attr B134attr3 = document.createAttribute("VALUE");
            B134attr3.setValue(getSetValues.getLine23ki_fourth());
            B134.setAttributeNode(B134attr3);

            Attr B134attr4 = document.createAttribute("UNIT");
            B134attr4.setValue("k");
            B134.setAttributeNode(B134attr4);


            //4th B4 with tod 3
            /***********/
            Element B135 = document.createElement("B4");
            d302.appendChild(B135);

            Attr B135attr1 = document.createAttribute("TOD");
            B135attr1.setValue("3");
            B135.setAttributeNode(B135attr1);

            Attr B135attr2 = document.createAttribute("PARAMCODE");
            B135attr2.setValue("P7-2-4-2-0");
            B135.setAttributeNode(B135attr2);

            Attr B135attr3 = document.createAttribute("VALUE");
            B135attr3.setValue(getSetValues.getLine24ki_fourth());
            B135.setAttributeNode(B135attr3);

            Attr B135attr4 = document.createAttribute("UNIT");
            B135attr4.setValue("k");
            B135.setAttributeNode(B135attr4);

            //5th B4 with tod 3
            /***********/
            Element B136 = document.createElement("B4");
            d302.appendChild(B136);

            Attr B136attr1 = document.createAttribute("TOD");
            B136attr1.setValue("3");
            B136.setAttributeNode(B136attr1);

            Attr B136attr2 = document.createAttribute("PARAMCODE");
            B136attr2.setValue("P7-3-6-2-0");
            B136.setAttributeNode(B136attr2);

            Attr B136attr3 = document.createAttribute("VALUE");
            B136attr3.setValue("0");
            B136.setAttributeNode(B136attr3);

            Attr B136attr4 = document.createAttribute("UNIT");
            B136attr4.setValue("k");
            B136.setAttributeNode(B136attr4);

            //6th B4 with tod 3
            /***********/
            Element B137 = document.createElement("B4");
            d302.appendChild(B137);

            Attr B137attr1 = document.createAttribute("TOD");
            B137attr1.setValue("3");
            B137.setAttributeNode(B137attr1);

            Attr B137attr2 = document.createAttribute("PARAMCODE");
            B137attr2.setValue("P7-1-6-2-0");
            B137.setAttributeNode(B137attr2);

            Attr B137attr3 = document.createAttribute("VALUE");
            B137attr3.setValue("0");
            B137.setAttributeNode(B137attr3);

            Attr B137attr4 = document.createAttribute("UNIT");
            B137attr4.setValue("k");
            B137.setAttributeNode(B137attr4);


            //7th B4 with tod 3
            /***********/
            Element B138 = document.createElement("B4");
            d302.appendChild(B138);

            Attr B138attr1 = document.createAttribute("TOD");
            B138attr1.setValue("3");
            B138.setAttributeNode(B138attr1);

            Attr B138attr2 = document.createAttribute("PARAMCODE");
            B138attr2.setValue("P7-2-2-2-0");
            B138.setAttributeNode(B138attr2);

            Attr B138attr3 = document.createAttribute("VALUE");
            B138attr3.setValue("0");
            B138.setAttributeNode(B138attr3);

            Attr B138attr4 = document.createAttribute("UNIT");
            B138attr4.setValue("k");
            B138.setAttributeNode(B138attr4);


            //8th B4 with tod 2
            /***********/
            Element B139 = document.createElement("B4");
            d302.appendChild(B139);

            Attr B139attr1 = document.createAttribute("TOD");
            B139attr1.setValue("3");
            B139.setAttributeNode(B139attr1);

            Attr B139attr2 = document.createAttribute("PARAMCODE");
            B139attr2.setValue("P7-2-3-2-0");
            B139.setAttributeNode(B139attr2);

            Attr B139attr3 = document.createAttribute("VALUE");
            B139attr3.setValue("0");
            B139.setAttributeNode(B139attr3);

            Attr B139attr4 = document.createAttribute("UNIT");
            B139attr4.setValue("k");
            B139.setAttributeNode(B139attr4);

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
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }

        // Appending String to textfile

        File file = new File(path + File.separator + filename); // File name with path
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
        }
    }

}

