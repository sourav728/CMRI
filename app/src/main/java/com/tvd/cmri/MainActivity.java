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
    String path="";
    String filename="";
    GetSetValues getSetValues;
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

    private void check_optical_text_file(){
        String path2 = fcall.filepath("Optical.txt");
        File file = new File(path2);
        if (file.exists()){
            readfile();
        }else Toast.makeText(this, "Optical textfile does not exists!!", Toast.LENGTH_SHORT).show();

    }
    public void readfile() {
        String line1,line2,line3,line4,line5,line6,line7,line8,line9,line10,line11,line12, line13,line14,line15,line16,line17,line18,line19,line20,line21,
               line22,line23,line24,line25,line26,line27,line28,line29,line30,line31,line32,line33,line34,line35,line36,line37,line38,line39,line40,line41,
                line42,line43,line44,line45,line46,line47,line48,line49,line50,line51,line52,line53,line54,line55,line56,line57,line58,line59,line60,line61,
                line62,line63,line64,line65,line66,line67,line68,line69,line70,line71,line72,line73,line74,line75,line76,line77,line78,line79,line80,line81,
                line82,line83,line84,line85,line86,line87,line88,line89,line90,line91,line92,line93,line94,line95,line96,line97,line98,line99,line100;
        File sdcard = new File(fcall.filepath(""));

        for (File f : sdcard.listFiles()) {
            if (f.isFile()) {
                String name = f.getName();
                if (name.equals("Optical.txt")){
                    File file = fcall.filestorepath("", name);
                    try {
                        //For fetching particular line from text file
                        line1 = FileUtils.readLines(file).get(1);
                        getSetValues.setRow1(line1);

                        line2 = FileUtils.readLines(file).get(2);
                        getSetValues.setRow2(line2);

                        line3 = FileUtils.readLines(file).get(3);
                        getSetValues.setRow3(line3);

                        line4 = FileUtils.readLines(file).get(4);
                        getSetValues.setRow4(line4);

                        line5 = FileUtils.readLines(file).get(5);
                        getSetValues.setRow5(line5);

                        line6 = FileUtils.readLines(file).get(6);
                        getSetValues.setRow5(line6);

                        line7 = FileUtils.readLines(file).get(7);
                        getSetValues.setRow7(line7);

                        line8 = FileUtils.readLines(file).get(8);
                        getSetValues.setRow8(line8);

                        line9 = FileUtils.readLines(file).get(9);
                        getSetValues.setRow9(line9);

                        line10 = FileUtils.readLines(file).get(10);
                        getSetValues.setRow10(line10);

                        line11 = FileUtils.readLines(file).get(11);
                        getSetValues.setRow11(line11);

                        line12 = FileUtils.readLines(file).get(12);
                        getSetValues.setRow12(line12);

                        line13 = FileUtils.readLines(file).get(13);
                        getSetValues.setRow13(line13);

                        line14 = FileUtils.readLines(file).get(14);
                        getSetValues.setRow14(line14);

                        line15 = FileUtils.readLines(file).get(15);
                        getSetValues.setRow15(line15);

                        line16 = FileUtils.readLines(file).get(16);
                        getSetValues.setRow16(line16);

                        line17 = FileUtils.readLines(file).get(17);
                        getSetValues.setRow17(line17);

                        line18 = FileUtils.readLines(file).get(18);
                        getSetValues.setRow18(line18);

                        line19 = FileUtils.readLines(file).get(19);
                        getSetValues.setRow19(line19);

                        line20 = FileUtils.readLines(file).get(20);
                        getSetValues.setRow20(line20);

                        line21 = FileUtils.readLines(file).get(21);
                        getSetValues.setRow21(line21);

                        line22 = FileUtils.readLines(file).get(22);
                        getSetValues.setRow22(line22);

                        line23 = FileUtils.readLines(file).get(23);
                        getSetValues.setRow23(line23);

                        line24 = FileUtils.readLines(file).get(24);
                        getSetValues.setRow24(line24);

                        line25 = FileUtils.readLines(file).get(25);
                        getSetValues.setRow25(line25);

                        line26 = FileUtils.readLines(file).get(26);
                        getSetValues.setRow26(line26);

                        line27 = FileUtils.readLines(file).get(27);
                        getSetValues.setRow27(line27);

                        line28 = FileUtils.readLines(file).get(28);
                        getSetValues.setRow28(line28);

                        line29 = FileUtils.readLines(file).get(29);
                        getSetValues.setRow29(line29);

                        line30 = FileUtils.readLines(file).get(30);
                        getSetValues.setRow30(line30);

                        line31 = FileUtils.readLines(file).get(31);
                        getSetValues.setRow31(line31);

                        line32 = FileUtils.readLines(file).get(32);
                        getSetValues.setRow32(line32);

                        line33 = FileUtils.readLines(file).get(33);
                        getSetValues.setRow33(line33);

                        line34 = FileUtils.readLines(file).get(34);
                        getSetValues.setRow34(line34);

                        line35 = FileUtils.readLines(file).get(35);
                        getSetValues.setRow35(line35);

                        line36 = FileUtils.readLines(file).get(36);
                        getSetValues.setRow36(line36);

                        line37 = FileUtils.readLines(file).get(37);
                        getSetValues.setRow37(line37);

                        line38 = FileUtils.readLines(file).get(38);
                        getSetValues.setRow38(line38);

                        line39 = FileUtils.readLines(file).get(39);
                        getSetValues.setRow39(line39);

                        ////////////////////////////////////////////////////
                        line40 = FileUtils.readLines(file).get(40);
                        getSetValues.setRow40(line40);

                        line41 = FileUtils.readLines(file).get(41);
                        getSetValues.setRow41(line41);

                        line42 = FileUtils.readLines(file).get(42);
                        getSetValues.setRow42(line42);

                        line43 = FileUtils.readLines(file).get(43);
                        getSetValues.setRow43(line43);

                        line44 = FileUtils.readLines(file).get(44);
                        getSetValues.setRow44(line44);

                        line45 = FileUtils.readLines(file).get(45);
                        getSetValues.setRow45(line45);

                        line46 = FileUtils.readLines(file).get(46);
                        getSetValues.setRow46(line46);

                        line47 = FileUtils.readLines(file).get(47);
                        getSetValues.setRow47(line47);

                        line48 = FileUtils.readLines(file).get(48);
                        getSetValues.setRow48(line48);

                        line49 = FileUtils.readLines(file).get(49);
                        getSetValues.setRow49(line49);

                        line50 = FileUtils.readLines(file).get(50);
                        getSetValues.setRow50(line50);

                        line51 = FileUtils.readLines(file).get(51);
                        getSetValues.setRow51(line51);

                        line52 = FileUtils.readLines(file).get(52);
                        getSetValues.setRow52(line52);

                        line53 = FileUtils.readLines(file).get(53);
                        getSetValues.setRow53(line53);

                        line54 = FileUtils.readLines(file).get(54);
                        getSetValues.setRow54(line54);

                        line55 = FileUtils.readLines(file).get(55);
                        getSetValues.setRow55(line55);

                        line56 = FileUtils.readLines(file).get(56);
                        getSetValues.setRow56(line56);

                        line57 = FileUtils.readLines(file).get(57);
                        getSetValues.setRow57(line57);

                        line58 = FileUtils.readLines(file).get(58);
                        getSetValues.setRow58(line58);

                        line59 = FileUtils.readLines(file).get(59);
                        getSetValues.setRow59(line59);

                        line60 = FileUtils.readLines(file).get(60);
                        getSetValues.setRow60(line60);

                        line61 = FileUtils.readLines(file).get(61);
                        getSetValues.setRow61(line61);

                        line62 = FileUtils.readLines(file).get(62);
                        getSetValues.setRow62(line62);

                        line63 = FileUtils.readLines(file).get(63);
                        getSetValues.setRow63(line63);

                        line64 = FileUtils.readLines(file).get(64);
                        getSetValues.setRow64(line64);

                        line65 = FileUtils.readLines(file).get(65);
                        getSetValues.setRow65(line65);

                        line66 = FileUtils.readLines(file).get(66);
                        getSetValues.setRow66(line66);

                        line67 = FileUtils.readLines(file).get(67);
                        getSetValues.setRow67(line67);

                        line68 = FileUtils.readLines(file).get(68);
                        getSetValues.setRow68(line68);

                        line69 = FileUtils.readLines(file).get(69);
                        getSetValues.setRow69(line69);

                        line70 = FileUtils.readLines(file).get(70);
                        getSetValues.setRow70(line70);

                        line71 = FileUtils.readLines(file).get(71);
                        getSetValues.setRow71(line71);

                        line72 = FileUtils.readLines(file).get(72);
                        getSetValues.setRow72(line72);

                        line73 = FileUtils.readLines(file).get(73);
                        getSetValues.setRow73(line73);

                        line74 = FileUtils.readLines(file).get(74);
                        getSetValues.setRow74(line74);

                        line75 = FileUtils.readLines(file).get(75);
                        getSetValues.setRow75(line75);

                        line76 = FileUtils.readLines(file).get(76);
                        getSetValues.setRow76(line76);

                        line77 = FileUtils.readLines(file).get(77);
                        getSetValues.setRow77(line77);

                        line78 = FileUtils.readLines(file).get(78);
                        getSetValues.setRow78(line78);

                        line79 = FileUtils.readLines(file).get(72);
                        getSetValues.setRow79(line79);

                        line80 = FileUtils.readLines(file).get(80);
                        getSetValues.setRow80(line80);

                        line81 = FileUtils.readLines(file).get(81);
                        getSetValues.setRow81(line81);

                        line82 = FileUtils.readLines(file).get(82);
                        getSetValues.setRow82(line82);

                        line83 = FileUtils.readLines(file).get(83);
                        getSetValues.setRow83(line83);

                        line84 = FileUtils.readLines(file).get(84);
                        getSetValues.setRow84(line84);

                        line85 = FileUtils.readLines(file).get(85);
                        getSetValues.setRow85(line85);

                        line86 = FileUtils.readLines(file).get(86);
                        getSetValues.setRow86(line86);

                        line87 = FileUtils.readLines(file).get(87);
                        getSetValues.setRow87(line87);

                        line88 = FileUtils.readLines(file).get(88);
                        getSetValues.setRow88(line88);

                        line89 = FileUtils.readLines(file).get(89);
                        getSetValues.setRow89(line89);

                        line90 = FileUtils.readLines(file).get(90);
                        getSetValues.setRow90(line90);

                        line91 = FileUtils.readLines(file).get(91);
                        getSetValues.setRow91(line91);

                        line92 = FileUtils.readLines(file).get(92);
                        getSetValues.setRow81(line92);

                        line93 = FileUtils.readLines(file).get(93);
                        getSetValues.setRow93(line93);

                        line94 = FileUtils.readLines(file).get(94);
                        getSetValues.setRow94(line94);

                        line95 = FileUtils.readLines(file).get(95);
                        getSetValues.setRow95(line95);

                        line96 = FileUtils.readLines(file).get(96);
                        getSetValues.setRow97(line96);

                        line97 = FileUtils.readLines(file).get(97);
                        getSetValues.setRow97(line97);

                        line98 = FileUtils.readLines(file).get(98);
                        getSetValues.setRow98(line98);

                        line99 = FileUtils.readLines(file).get(99);
                        getSetValues.setRow99(line99);

                        line100 = FileUtils.readLines(file).get(100);
                        getSetValues.setRow100(line100);


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
            pId.appendChild(di);
            //For G1 tag
            Element g1 = document.createElement("G1");
            g1.appendChild(document.createTextNode(getSetValues.getRow1()));
            di.appendChild(g1);

            //For G2 tag
            Element g2 = document.createElement("G2");
            g2.appendChild(document.createTextNode(getSetValues.getRow2()));
            di.appendChild(g2);

            //For G3 tag
            Element g3 = document.createElement("G3");
            g3.appendChild(document.createTextNode(getSetValues.getRow3()));
            di.appendChild(g3);

            //For G4 tag
            Element g4 = document.createElement("G4");
            g4.appendChild(document.createTextNode(getSetValues.getRow4()));
            di.appendChild(g4);

            //For G5 tag
            Element g5 = document.createElement("G5");
            g5.appendChild(document.createTextNode(getSetValues.getRow5()));
            di.appendChild(g5);

            //For G6 tag
            Element g6 = document.createElement("G6");
            g6.appendChild(document.createTextNode(getSetValues.getRow6()));
            di.appendChild(g6);

            //For G7 tag
            Element g7 = document.createElement("G7");
            g7.appendChild(document.createTextNode(getSetValues.getRow7()));
            di.appendChild(g7);

            //For G8 tag
            Element g8 = document.createElement("G8");
            g8.appendChild(document.createTextNode(getSetValues.getRow8()));
            di.appendChild(g8);

            //For G9 tag
            Element g9 = document.createElement("G9");
            g9.appendChild(document.createTextNode(getSetValues.getRow9()));
            di.appendChild(g9);

            //For G10 tag
            Element g10 = document.createElement("G10");
            g10.appendChild(document.createTextNode(getSetValues.getRow10()));
            di.appendChild(g10);

            //For G11 tag
            Element g11 = document.createElement("G11");
            g11.appendChild(document.createTextNode(getSetValues.getRow11()));
            di.appendChild(g11);

            //For G12 tag
            Element g12 = document.createElement("G12");
            g12.appendChild(document.createTextNode(getSetValues.getRow12()));
            di.appendChild(g12);

            //For G13 tag
            Element g13 = document.createElement("G13");
            g13.appendChild(document.createTextNode(getSetValues.getRow13()));
            di.appendChild(g13);

            //For G14 tag
            Element g14 = document.createElement("G14");
            g14.appendChild(document.createTextNode(getSetValues.getRow14()));
            di.appendChild(g14);

            //For G15 tag
            Element g15 = document.createElement("G15");
            g15.appendChild(document.createTextNode(getSetValues.getRow15()));
            di.appendChild(g15);


            //For G16 tag
            Element g16 = document.createElement("G16");
            g16.appendChild(document.createTextNode(getSetValues.getRow16()));
            di.appendChild(g16);

            //For G17 tag
            Element g17 = document.createElement("G17");
            g17.appendChild(document.createTextNode(getSetValues.getRow17()));
            di.appendChild(g17);

            //For G18 tag
            Element g18 = document.createElement("G18");
            g18.appendChild(document.createTextNode(getSetValues.getRow18()));
            di.appendChild(g18);

            //For G19 tag
            Element g19 = document.createElement("G19");
            g19.appendChild(document.createTextNode(getSetValues.getRow19()));
            di.appendChild(g19);

            //For G20 tag
            Element g20 = document.createElement("G20");
            g20.appendChild(document.createTextNode(getSetValues.getRow20()));
            di.appendChild(g20);

            //For G21 tag
            Element g21 = document.createElement("G21");
            g21.appendChild(document.createTextNode(getSetValues.getRow21()));
            di.appendChild(g21);

            //For G22 tag
            Element g22 = document.createElement("G22");
            g22.appendChild(document.createTextNode(getSetValues.getRow22()));
            di.appendChild(g22);

            //For G23 tag
            Element g23 = document.createElement("G23");
            g23.appendChild(document.createTextNode(getSetValues.getRow23()));
            di.appendChild(g23);

            //For G24 tag
            Element g24 = document.createElement("G24");
            g24.appendChild(document.createTextNode(getSetValues.getRow24()));
            di.appendChild(g24);

            //For G25 tag
            Element G25 = document.createElement("G25");
            g4.appendChild(document.createTextNode(getSetValues.getRow25()));
            di.appendChild(G25);

            //For G26 tag
            Element g26 = document.createElement("G26");
            g26.appendChild(document.createTextNode(getSetValues.getRow26()));
            di.appendChild(g26);

            //For G27 tag
            Element g27 = document.createElement("G27");
            g27.appendChild(document.createTextNode(getSetValues.getRow27()));
            di.appendChild(g27);

            //For G28 tag
            Element g28 = document.createElement("G28");
            g28.appendChild(document.createTextNode(getSetValues.getRow28()));
            di.appendChild(g28);

            //For G29 tag
            Element g29 = document.createElement("G29");
            g29.appendChild(document.createTextNode(getSetValues.getRow29()));
            di.appendChild(g29);

            //For G30 tag
            Element g30 = document.createElement("G30");
            g29.appendChild(document.createTextNode(getSetValues.getRow30()));
            di.appendChild(g30);

            //For G31 tag
            Element g31 = document.createElement("G31");
            g31.appendChild(document.createTextNode(getSetValues.getRow31()));
            di.appendChild(g31);

            //For G32 tag
            Element g32 = document.createElement("G32");
            g32.appendChild(document.createTextNode(getSetValues.getRow32()));
            di.appendChild(g32);

            //For G33 tag
            Element g33 = document.createElement("G33");
            g33.appendChild(document.createTextNode(getSetValues.getRow33()));
            di.appendChild(g33);

            //For G34 tag
            Element g34 = document.createElement("G34");
            g34.appendChild(document.createTextNode(getSetValues.getRow34()));
            di.appendChild(g34);

            //For G35 tag
            Element g35 = document.createElement("G35");
            g35.appendChild(document.createTextNode(getSetValues.getRow35()));
            di.appendChild(g35);

            //For G36 tag
            Element g36 = document.createElement("G36");
            g36.appendChild(document.createTextNode(getSetValues.getRow36()));
            di.appendChild(g36);

            //For G37 tag
            Element g37 = document.createElement("G37");
            g37.appendChild(document.createTextNode(getSetValues.getRow37()));
            di.appendChild(g37);

            //For G38 tag
            Element g38 = document.createElement("G38");
            g38.appendChild(document.createTextNode(getSetValues.getRow38()));
            di.appendChild(g38);

            //For G39 tag
            Element g39 = document.createElement("G39");
            g39.appendChild(document.createTextNode(getSetValues.getRow39()));
            di.appendChild(g39);

            //For G40 tag
            Element g40 = document.createElement("G40");
            g40.appendChild(document.createTextNode(getSetValues.getRow40()));
            di.appendChild(g40);

            //For G41 tag
            Element g41 = document.createElement("G41");
            g41.appendChild(document.createTextNode(getSetValues.getRow41()));
            di.appendChild(g41);

            //For G42 tag
            Element g42 = document.createElement("G42");
            g42.appendChild(document.createTextNode(getSetValues.getRow42()));
            di.appendChild(g42);

            //For G43 tag
            Element g43 = document.createElement("G43");
            g43.appendChild(document.createTextNode(getSetValues.getRow43()));
            di.appendChild(g43);

            //For G44 tag
            Element g44 = document.createElement("G44");
            g44.appendChild(document.createTextNode(getSetValues.getRow44()));
            di.appendChild(g44);

            //For G45 tag
            Element g45 = document.createElement("G45");
            g45.appendChild(document.createTextNode(getSetValues.getRow45()));
            di.appendChild(g45);

            //For G46 tag
            Element g46 = document.createElement("G46");
            g46.appendChild(document.createTextNode(getSetValues.getRow46()));
            di.appendChild(g46);

            //For G47 tag
            Element g47 = document.createElement("G47");
            g47.appendChild(document.createTextNode(getSetValues.getRow47()));
            di.appendChild(g47);

            //For G48 tag
            Element g48 = document.createElement("G48");
            g48.appendChild(document.createTextNode(getSetValues.getRow48()));
            di.appendChild(g48);

            //For G49 tag
            Element g49 = document.createElement("G49");
            g49.appendChild(document.createTextNode(getSetValues.getRow49()));
            di.appendChild(g49);

            //For G50 tag
            Element G50 = document.createElement("G50");
            G50.appendChild(document.createTextNode(getSetValues.getRow50()));
            di.appendChild(G50);

            //For G51 tag
            Element G51 = document.createElement("G51");
            G51.appendChild(document.createTextNode(getSetValues.getRow51()));
            di.appendChild(G51);

            //For G52 tag
            Element G52 = document.createElement("G52");
            G52.appendChild(document.createTextNode(getSetValues.getRow52()));
            di.appendChild(G52);

            //For G53 tag
            Element G53 = document.createElement("G53");
            G53.appendChild(document.createTextNode(getSetValues.getRow53()));
            di.appendChild(G53);

            //For G54 tag
            Element G54 = document.createElement("G54");
            G54.appendChild(document.createTextNode(getSetValues.getRow54()));
            di.appendChild(G54);

            //For G55 tag
            Element G55 = document.createElement("G55");
            G55.appendChild(document.createTextNode(getSetValues.getRow55()));
            di.appendChild(G55);

            //For G56 tag
            Element G56 = document.createElement("G56");
            G56.appendChild(document.createTextNode(getSetValues.getRow56()));
            di.appendChild(G56);

            //For G57 tag
            Element G57 = document.createElement("G57");
            G57.appendChild(document.createTextNode(getSetValues.getRow57()));
            di.appendChild(G57);

            //For G58 tag
            Element G58 = document.createElement("G58");
            G58.appendChild(document.createTextNode(getSetValues.getRow58()));
            di.appendChild(G58);

            //For G59 tag
            Element G59 = document.createElement("G59");
            G59.appendChild(document.createTextNode(getSetValues.getRow59()));
            di.appendChild(G59);

            //For G60 tag
            Element G60 = document.createElement("G60");
            G60.appendChild(document.createTextNode(getSetValues.getRow60()));
            di.appendChild(G60);

            //For G61 tag
            Element G61 = document.createElement("G61");
            G61.appendChild(document.createTextNode(getSetValues.getRow61()));
            di.appendChild(G61);

            //For G62 tag
            Element G62 = document.createElement("G62");
            G62.appendChild(document.createTextNode(getSetValues.getRow62()));
            di.appendChild(G62);

            //For G63 tag
            Element G63 = document.createElement("G63");
            G63.appendChild(document.createTextNode(getSetValues.getRow63()));
            di.appendChild(G63);


            //For G64 tag
            Element G64 = document.createElement("G64");
            G64.appendChild(document.createTextNode(getSetValues.getRow64()));
            di.appendChild(G64);

            //For G65 tag
            Element G65 = document.createElement("G65");
            G65.appendChild(document.createTextNode(getSetValues.getRow65()));
            di.appendChild(G65);

            //For G66 tag
            Element G66 = document.createElement("G66");
            G66.appendChild(document.createTextNode(getSetValues.getRow66()));
            di.appendChild(G66);

            //For G67 tag
            Element G67 = document.createElement("G67");
            G67.appendChild(document.createTextNode(getSetValues.getRow67()));
            di.appendChild(G67);


            //For G68 tag
            Element G68 = document.createElement("G68");
            G68.appendChild(document.createTextNode(getSetValues.getRow68()));
            di.appendChild(G68);

            //For G69 tag
            Element G69 = document.createElement("G69");
            G69.appendChild(document.createTextNode(getSetValues.getRow69()));
            di.appendChild(G69);

            //For G70 tag
            Element G70 = document.createElement("G70");
            G70.appendChild(document.createTextNode(getSetValues.getRow70()));
            di.appendChild(G70);

            //For G71 tag
            Element G71 = document.createElement("G71");
            G71.appendChild(document.createTextNode(getSetValues.getRow71()));
            di.appendChild(G71);

            //For G72 tag
            Element G72 = document.createElement("G72");
            G72.appendChild(document.createTextNode(getSetValues.getRow72()));
            di.appendChild(G72);

            //For G73 tag
            Element G73 = document.createElement("G73");
            G73.appendChild(document.createTextNode(getSetValues.getRow73()));
            di.appendChild(G73);

            //For G74 tag
            Element G74 = document.createElement("G74");
            G74.appendChild(document.createTextNode(getSetValues.getRow74()));
            di.appendChild(G74);

            //For G75 tag
            Element G75 = document.createElement("G75");
            G75.appendChild(document.createTextNode(getSetValues.getRow75()));
            di.appendChild(G75);

            /////////////////////////////////////////

            //For G76 tag
            Element G76 = document.createElement("G76");
            G76.appendChild(document.createTextNode(getSetValues.getRow76()));
            di.appendChild(G76);

            //For G77 tag
            Element G77 = document.createElement("G77");
            G77.appendChild(document.createTextNode(getSetValues.getRow77()));
            di.appendChild(G77);

            //For G78 tag
            Element G78 = document.createElement("G78");
            G78.appendChild(document.createTextNode(getSetValues.getRow78()));
            di.appendChild(G78);

            //For G79 tag
            Element G79 = document.createElement("G79");
            G79.appendChild(document.createTextNode(getSetValues.getRow79()));
            di.appendChild(G79);

            //For G80 tag
            Element G80 = document.createElement("G80");
            G80.appendChild(document.createTextNode(getSetValues.getRow80()));
            di.appendChild(G80);

            //For G81 tag
            Element G81 = document.createElement("G81");
            G81.appendChild(document.createTextNode(getSetValues.getRow81()));
            di.appendChild(G81);

            //For G82 tag
            Element G82 = document.createElement("G82");
            G82.appendChild(document.createTextNode(getSetValues.getRow82()));
            di.appendChild(G82);

            //For G83 tag
            Element G83 = document.createElement("G83");
            G83.appendChild(document.createTextNode(getSetValues.getRow83()));
            di.appendChild(G83);

            //For G84 tag
            Element G84 = document.createElement("G84");
            G84.appendChild(document.createTextNode(getSetValues.getRow84()));
            di.appendChild(G84);


            //For G85 tag
            Element G85 = document.createElement("G85");
            G85.appendChild(document.createTextNode(getSetValues.getRow85()));
            di.appendChild(G85);

            //For G86 tag
            Element G86 = document.createElement("G86");
            G86.appendChild(document.createTextNode(getSetValues.getRow86()));
            di.appendChild(G86);

            //For G87 tag
            Element G87 = document.createElement("G87");
            G87.appendChild(document.createTextNode(getSetValues.getRow87()));
            di.appendChild(G87);

            //For G88 tag
            Element G88 = document.createElement("G88");
            G88.appendChild(document.createTextNode(getSetValues.getRow88()));
            di.appendChild(G88);


            //For G89 tag
            Element G89 = document.createElement("G89");
            G89.appendChild(document.createTextNode(getSetValues.getRow89()));
            di.appendChild(G89);

            //For G90 tag
            Element G90 = document.createElement("G90");
            G90.appendChild(document.createTextNode(getSetValues.getRow90()));
            di.appendChild(G90);

            //For G91 tag
            Element G91 = document.createElement("G91");
            G91.appendChild(document.createTextNode(getSetValues.getRow91()));
            di.appendChild(G91);

            //For G92 tag
            Element G92 = document.createElement("G92");
            G92.appendChild(document.createTextNode(getSetValues.getRow92()));
            di.appendChild(G92);

            //For G93 tag
            Element G93 = document.createElement("G93");
            G93.appendChild(document.createTextNode(getSetValues.getRow93()));
            di.appendChild(G93);

            //For G94 tag
            Element G94 = document.createElement("G94");
            G94.appendChild(document.createTextNode(getSetValues.getRow94()));
            di.appendChild(G94);

            //For G95 tag
            Element G95 = document.createElement("G95");
            G95.appendChild(document.createTextNode(getSetValues.getRow95()));
            di.appendChild(G95);

            //For G96 tag
            Element G96 = document.createElement("G96");
            G96.appendChild(document.createTextNode(getSetValues.getRow96()));
            di.appendChild(G96);

            //For G97 tag
            Element G97 = document.createElement("G97");
            G97.appendChild(document.createTextNode(getSetValues.getRow97()));
            di.appendChild(G97);

            //For G98 tag
            Element G98 = document.createElement("G98");
            G98.appendChild(document.createTextNode(getSetValues.getRow98()));
            di.appendChild(G98);

            //For G99 tag
            Element G99 = document.createElement("G99");
            G99.appendChild(document.createTextNode(getSetValues.getRow99()));
            di.appendChild(G99);

            //For G100 tag
            Element G100 = document.createElement("G100");
            G100.appendChild(document.createTextNode(getSetValues.getRow100()));
            di.appendChild(G100);


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

