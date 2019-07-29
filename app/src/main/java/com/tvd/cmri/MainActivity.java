package com.tvd.cmri;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.tvd.cmri.other.FileAdapter;
import com.tvd.cmri.other.FunctionCall;
import com.tvd.cmri.other.GetSetValues;
import com.tvd.cmri.service.UsbService;
import com.tvd.cmri.singlePhase_LT.Single;
import com.tvd.cmri.threePhase_LT.ThreePhase;
import com.tvd.cmri.threePhase_LT.Ver4SB1F20;
import com.tvd.cmri.threePhase_LT.VerEAJ8_02;
import com.tvd.cmri.threePhase_LT.Version_NED26;
import com.tvd.cmri.threePhase_LT.version_DTDDN;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button singlephase, threephase, xmlconvert;
    private MyHandler mHandler2;
    private static final String PREFERENCE = "CMRI";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private FunctionCall fcall;
    String path = "";
    String filename = "", mtr_version = "";
    GetSetValues getSetValues;
    FunctionCall functionCall;
    VerEAJ8_02 verEAJ8_02;
    ArrayList<GetSetValues> getSetValueslist;
    Document document;
    version_DTDDN version_dtddn;
    Ver4SB1F20 ver4SB1F20;
    Version_NED26 version_ned26;
    String line_first, line_second, line_third, line_fourth, line_fifth, line_sixth;
    Element d3, d301, pId, utilitytype, di;
    String[] names ;
    ArrayList<GetSetValues> arrayList;

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
        getSetValueslist = new ArrayList<>();
        fcall = new FunctionCall();
        version_ned26 = new Version_NED26();
        verEAJ8_02 = new VerEAJ8_02();
        ver4SB1F20 = new Ver4SB1F20();
        version_dtddn = new version_DTDDN();
        sharedPreferences = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        arrayList = new ArrayList<>();
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
            readfile1();
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
                        line6 = line6.substring(3, line6.indexOf("B"));
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

                                break;

                            case "ver4SB1F.20":
                                getSetValueslist.clear();
                                for (int i = 15, j = 0; i <= 30; i++, j++) {
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

                                break;
                        }

                        xml_creation(filename);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(),"Xml generation failed!!",Toast.LENGTH_LONG).show();
                    }
                }
            }
        }
    }

    public void readfile1() {

        File sdcard = new File(fcall.filepath(""));

        File[] files = sdcard.listFiles();
        names = new String[files.length];
        arrayList.clear();

        for (File file : files) {
            if (file.isFile()) {
                GetSetValues getSetValues = new GetSetValues();
               // getSetValues.setFile(file.getName());
                arrayList.add(getSetValues);
            }

        }
        showDialog(MainActivity.this);
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
            Toast.makeText(getApplicationContext(),"Xml generation failed!!",Toast.LENGTH_LONG).show();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
            Toast.makeText(getApplicationContext(),"Xml generation failed!!",Toast.LENGTH_LONG).show();
        }

        // Appending String to textfile

        File file = new File(path + File.separator + filename.substring(0,filename.length()-4)+".xml"); // File name with path
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
            Toast.makeText(getApplicationContext(),"Xml generation failed!!",Toast.LENGTH_LONG).show();
        }
    }

    public void showDialog(Activity activity) {

        final Dialog dialog = new Dialog(activity);
        // dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_dialog);

        Button btndialog = dialog.findViewById(R.id.btndialog);
        btndialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        ListView listView = dialog.findViewById(R.id.listview);
        FileAdapter fileAdapter = new FileAdapter(arrayList,MainActivity.this);
        listView.setAdapter(fileAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                readfile(arrayList.get(position).getFile());
                dialog.dismiss();
            }
        });

        dialog.show();

    }
}

