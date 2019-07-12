package com.tvd.cmri.threePhase_LT;

import com.tvd.cmri.other.FunctionCall;
import com.tvd.cmri.other.GetSetValues;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;

public class version_DTDDN {

    FunctionCall functionCall = new FunctionCall();

    Element B30, B31, B32, B33, B34, B35, B36, B37, B40, B41, B42, B43, B44, B45, B46, B47, B48, B49, B50, B51, B52, B53, B54, B55, B56, B57, B58, B59, B60, B61, B62, B63, B64, B65, B66, B67, B68,
            B69, B70, B71, B72, B73, B74, B75, B76, B77, B78, B79, B80, B81, B82, B83, B84, B85, B86, B90, B91, B92, B93, B94, B95, B96, B97, B98, B99, d302, B100, B101, B102, B103, B104, B105, B106, B107, B108,
            B109, B110, B111, B112, B113, B114, B115, B116, B117, B118, B119, B120, B121, B122, B123, B124, B125, B126, B127, B128, B129, B130, B131, B132, B133, B134, B135, B136, B137, B138, B139, d301, pId,
            B140, B141, B142, B143, B144, B145, B146, B147, B148,B149,B150,B151,B152,B153,B154,B155,B156,B157,B158,B159,B160,B161,B162,B163,B164,B165,B166,B167,B168,B169,B170,B171,B172,B173,
            B174,B175,B176,B177,B178,B179,B180,B181,B182,B183,B184,B185,B186,B187,B188,B189;

    Attr B30attr1, B30attr2, B30attr3, B31attr1, B31attr2, B31attr3, B32attr1, B32attr2, B32attr3, B33attr1, B33attr2, B33attr3, B34attr1, B34attr2, B34attr3, B35attr1, B35attr2, B35attr3,
            B36attr1, B36attr2, B36attr3, B37attr1, B37attr2, B37attr3, B40attr1, B40attr2, B40attr3, B40attr4, B41attr1, B41attr2, B41attr3, B41attr4, B42attr1, B42attr2, B42attr3, B42attr4,
            B43attr1, B43attr2, B43attr3, B43attr4, B44attr1, B44attr2, B44attr3, B44attr4, B45attr1, B45attr2, B45attr3, B45attr4, B46attr1, B46attr2, B46attr3, B46attr4, B47attr1, B47attr2,
            B47attr3, B47attr4, B48attr1, B48attr2, B48attr3, B48attr4, B49attr1, B49attr2, B49attr3, B49attr4, B50attr1, B50attr2, B50attr3, B50attr4, B51attr1, B51attr2, B51attr3, B51attr4,
            B52attr1, B52attr2, B52attr3, B52attr4, B53attr1, B53attr2, B53attr3, B53attr4, B54attr1, B54attr2, B54attr3, B54attr4, B55attr1, B55attr2, B55attr3, B55attr4, B56attr1, B56attr2, B56attr3, B56attr4,
            B57attr1, B57attr2, B57attr3, B57attr4, B58attr1, B58attr2, B58attr3, B58attr4, B59attr1, B59attr2, B59attr3, B59attr4, B60attr1, B60attr2, B60attr3, B60attr4, B61attr1, B61attr2, B61attr3, B61attr4,
            B62attr1, B62attr2, B62attr3, B62attr4, B63attr1, B63attr2, B63attr3, B63attr4, B64attr1, B64attr2, B64attr3, B64attr4, B65attr1, B65attr2, B65attr3, B65attr4, B66attr1, B66attr2, B66attr3, B66attr4,
            B67attr1, B67attr2, B67attr3, B67attr4, B68attr1, B68attr2, B68attr3, B68attr4, B69attr1, B69attr2, B69attr3, B69attr4, B70attr1, B70attr2, B70attr3, B70attr4, B71attr1, B71attr2, B71attr3, B71attr4,
            B72attr2, B72attr3, B72attr4, B72attr5, B73attr2, B73attr3, B73attr4, B73attr5, B74attr2, B74attr3, B74attr4, B74attr5, B75attr1, B75attr2, B75attr3, B75attr4, B75attr5, B76attr1, B76attr2, B76attr3,
            B76attr4, B76attr5, B77attr1, B77attr2, B77attr3, B77attr4, B77attr5, B78attr1, B78attr2, B78attr3, B78attr4, B78attr5, B79attr1, B79attr2, B79attr3, B79attr4, B79attr5, B80attr1, B80attr2, B80attr3,
            B80attr4, B80attr5, B81attr1, B81attr2, B81attr3, B81attr4, B81attr5, B82attr1, B82attr2, B82attr3, B82attr4, B82attr5, B83attr1, B83attr2, B83attr3, B83attr4, B83attr5, B84attr1, B84attr2, B84attr3, B84attr4,
            B84attr5, B85attr1, B85attr2, B85attr3, B85attr4, B85attr5, B86attr1, B86attr2, B86attr3, B86attr4, B86attr5, B90attr2, B90attr3, B91attr2, B91attr3, B92attr1, B92attr2, B92attr3, B93attr1, B93attr2, B93attr3,
            B94attr1, B94attr2, B94attr3, B95attr1, B95attr2, B95attr3, B96attr1, B96attr2, B96attr3, B97attr1, B97attr2, B97attr3, B98attr1, B98attr2, B98attr3, B99attr1, B99attr2, B99attr3, g302attr, g302attr2,
            B100attr1, B100attr2, B100attr3, B101attr1, B101attr2, B101attr3, B102attr1, B102attr2, B102attr3, B103attr2, B103attr3, B104attr1, B104attr2, B104attr3, B105attr1, B105attr2, B105attr3, B106attr1,
            B106attr2, B106attr3, B103attr1, B107attr1, B107attr2, B107attr3, B108attr1, B108attr2, B108attr3, B108attr4, B109attr1, B109attr2, B109attr3, B109attr4, B110attr1, B110attr2, B110attr3, B110attr4,
            B111attr1, B111attr2, B111attr3, B111attr4, B112attr1, B112attr2, B112attr3, B112attr4, B113attr1, B113attr2, B113attr3, B113attr4, B114attr1, B114attr2, B114attr3, B114attr4, B115attr1, B115attr2, B115attr3, B115attr4,
            B116attr1, B116attr2, B116attr3, B116attr4, B117attr1, B117attr2, B117attr3, B117attr4, B118attr1, B118attr2, B118attr3, B118attr4, B119attr1, B119attr2, B119attr3, B119attr4, B120attr1, B120attr2, B120attr3,
            B120attr4, B121attr1, B121attr2, B121attr3, B121attr4, B122attr1, B122attr2, B122attr3, B122attr4, B123attr1, B123attr2, B123attr3, B123attr4, B124attr1, B124attr2, B124attr3, B124attr4, B125attr1, B125attr2, B125attr3, B125attr4,
            B126attr1, B126attr2, B126attr3, B126attr4, B127attr1, B127attr2, B127attr3, B127attr4, B128attr1, B128attr2, B128attr3, B128attr4, B129attr1, B129attr2, B129attr3, B129attr4, B130attr1, B130attr2, B130attr3, B130attr4,
            B131attr1, B131attr2, B131attr3, B131attr4, B132attr1, B132attr2, B132attr3, B132attr4, B133attr1, B133attr2, B133attr3, B133attr4, B134attr1, B134attr2, B134attr3, B134attr4, B135attr1, B135attr2, B135attr3, B135attr4,
            B136attr1, B136attr2, B136attr3, B136attr4, B137attr1, B137attr2, B137attr3, B137attr4, B138attr1, B138attr2, B138attr3, B138attr4, B139attr1, B139attr2, B139attr3, B139attr4, B140attr1, B140attr2, B140attr3, B140attr4,
            B141attr1, B141attr2, B141attr3, B141attr4, B142attr1, B142attr2, B142attr3, B142attr4, B143attr1, B143attr2, B143attr3, B143attr4, B144attr1, B144attr2, B144attr3, B144attr4, B145attr1, B145attr2, B145attr3, B145attr4, B146attr1, B146attr2,
            B146attr3, B146attr4, B147attr1, B147attr2, B147attr3, B147attr4, B148attr1, B148attr2, B148attr3, B148attr4,B148attr5, B149attr1,B149attr2,B149attr3,B149attr4,B149attr5,B150attr1,B150attr2,B150attr3,B150attr4,B150attr5,
            B151attr1,B151attr2,B151attr3,B152attr1,B152attr2,B152attr3,B153attr1,B153attr2,B153attr3,B153attr4,B154attr1,B154attr2,B154attr3,B154attr4,B155attr1,B155attr2,B155attr3,B155attr4,B156attr1,B156attr2,B156attr3,B156attr4,
            B157attr1,B157attr2,B157attr3,B157attr4,B158attr1,B158attr2,B158attr3,B158attr4,B159attr1,B159attr2,B159attr3,B159attr4,B160attr1,B160attr2,B160attr3,B160attr4,B161attr1,B161attr2,B161attr3,B162attr1,B162attr2,B162attr3,
            B163attr1,B163attr2,B163attr3,B163attr4,B164attr1,B164attr2,B164attr3,B164attr4,B165attr1,B165attr2,B165attr3,B165attr4,B166attr1,B166attr2,B166attr3,B166attr4,B167attr1,B167attr2,B167attr3,B167attr4,B168attr1,B168attr2,B168attr3,
            B168attr4,B169attr1,B169attr2,B169attr3,B169attr4,B170attr1,B170attr2,B170attr3,B170attr4,B171attr1,B171attr2,B171attr3,B171attr4,B171attr5,B172attr1,B172attr2,B172attr3,B172attr4,B172attr5,B173attr1,B173attr2,B173attr3,B173attr4,B173attr5,
            B174attr1,B174attr2,B174attr3,B174attr4,B175attr1,B175attr2,B175attr3,B175attr4,B176attr1,B176attr2,B176attr3,B176attr4,B177attr1,B177attr2,B177attr3,B177attr4,B178attr1,B178attr2,B178attr3,B178attr4,B179attr1,B179attr2,B179attr3,B179attr4,
            B180attr1,B180attr2,B180attr3,B180attr4,B181attr1,B181attr2,B181attr3,B181attr4,B182attr1,B182attr2,B182attr3,B182attr4,B183attr1,B183attr2,B183attr3,B183attr4,B184attr1,B184attr2,B184attr3,B184attr4,B185attr1,B185attr2,B185attr3,B185attr4,
            B186attr1,B186attr2,B186attr3,B186attr4,B187attr1,B187attr2,B187attr3,B187attr4,B188attr1,B188attr2,B188attr3,B188attr4,B189attr1,B189attr2,B189attr3,B189attr4;

    public void version_DTDDN1(ArrayList<GetSetValues> getSetValueslist,Document document,Element d301,Element d3){
        //For first B3 tag
        B30 = document.createElement("B3");
        d301.appendChild(B30);

        B30attr1 = document.createAttribute("PARAMCODE");
        B30attr1.setValue("P7-3-5-2-0");
        B30.setAttributeNode(B30attr1);

        B30attr2 = document.createAttribute("VALUE");
        B30attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValueslist.get(0).getLine_first()) + Double.parseDouble(getSetValueslist.get(0).getLine_second()) + Double.parseDouble(getSetValueslist.get(0).getLine_third()) + Double.parseDouble(getSetValueslist.get(0).getLine_fourth()) + Double.parseDouble(getSetValueslist.get(0).getLine_fifth()) + Double.parseDouble(getSetValueslist.get(0).getLine_sixth()))));
        B30.setAttributeNode(B30attr2);

        B30attr3 = document.createAttribute("UNIT");
        B30attr3.setValue("k");
        B30.setAttributeNode(B30attr3);
        //End

        //For second B3 tag
        B31 = document.createElement("B3");
        d301.appendChild(B31);

        B31attr1 = document.createAttribute("PARAMCODE");
        B31attr1.setValue("P7-1-5-2-0");
        B31.setAttributeNode(B31attr1);

        B31attr2 = document.createAttribute("VALUE");
        B31attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValueslist.get(1).getLine_first()) + Double.parseDouble(getSetValueslist.get(1).getLine_second()) + Double.parseDouble(getSetValueslist.get(1).getLine_third()) + Double.parseDouble(getSetValueslist.get(1).getLine_fourth()) + Double.parseDouble(getSetValueslist.get(1).getLine_fifth()) + Double.parseDouble(getSetValueslist.get(1).getLine_sixth()))));
        B31.setAttributeNode(B31attr2);

        B31attr3 = document.createAttribute("UNIT");
        B31attr3.setValue("k");
        B31.setAttributeNode(B31attr3);
        //End

        //For third B3 tag
        B32 = document.createElement("B3");
        d301.appendChild(B32);

        B32attr1 = document.createAttribute("PARAMCODE");
        B32attr1.setValue("P7-2-1-2-0");
        B32.setAttributeNode(B32attr1);

        B32attr2 = document.createAttribute("VALUE");

        B32attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValueslist.get(2).getLine_first()) + Double.parseDouble(getSetValueslist.get(2).getLine_second()) + Double.parseDouble(getSetValueslist.get(2).getLine_third()) + Double.parseDouble(getSetValueslist.get(2).getLine_fourth()) + Double.parseDouble(getSetValueslist.get(2).getLine_fifth()) + Double.parseDouble(getSetValueslist.get(2).getLine_sixth()))));
        B32.setAttributeNode(B32attr2);

        B32attr3 = document.createAttribute("UNIT");
        B32attr3.setValue("k");
        B32.setAttributeNode(B32attr3);
        //End


        //For fourth B3 tag
        B33 = document.createElement("B3");
        d301.appendChild(B33);

        B33attr1 = document.createAttribute("PARAMCODE");
        B33attr1.setValue("P7-2-4-2-0");
        B33.setAttributeNode(B33attr1);

        B33attr2 = document.createAttribute("VALUE");
        B33attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValueslist.get(3).getLine_first()) + Double.parseDouble(getSetValueslist.get(3).getLine_second()) + Double.parseDouble(getSetValueslist.get(3).getLine_third()) + Double.parseDouble(getSetValueslist.get(3).getLine_fourth()) + Double.parseDouble(getSetValueslist.get(3).getLine_fifth()) + Double.parseDouble(getSetValueslist.get(3).getLine_sixth()))));
        B33.setAttributeNode(B33attr2);

        B33attr3 = document.createAttribute("UNIT");
        B33attr3.setValue("k");
        B33.setAttributeNode(B33attr3);
        //End

        //For fifth B3 tag
        B34 = document.createElement("B3");
        d301.appendChild(B34);

        B34attr1 = document.createAttribute("PARAMCODE");
        B34attr1.setValue("P7-3-6-2-0");
        B34.setAttributeNode(B34attr1);

        B34attr2 = document.createAttribute("VALUE");
        B34attr2.setValue(getSetValueslist.get(4).getLine_second());
        B34.setAttributeNode(B34attr2);

        B34attr3 = document.createAttribute("UNIT");
        B34attr3.setValue("k");
        B34.setAttributeNode(B34attr3);
        //End

        //For sixth B3 tag
        B35 = document.createElement("B3");
        d301.appendChild(B35);

        B35attr1 = document.createAttribute("PARAMCODE");
        B35attr1.setValue("P7-1-6-2-0");
        B35.setAttributeNode(B35attr1);

        B35attr2 = document.createAttribute("VALUE");
        B35attr2.setValue(getSetValueslist.get(5).getLine_second());
        B35.setAttributeNode(B35attr2);

        B35attr3 = document.createAttribute("UNIT");
        B35attr3.setValue("k");
        B35.setAttributeNode(B35attr3);
        //End

        //For seventh B3 tag
        B36 = document.createElement("B3");
        d301.appendChild(B36);

        B36attr1 = document.createAttribute("PARAMCODE");
        B36attr1.setValue("P7-2-2-2-0");
        B36.setAttributeNode(B36attr1);

        B36attr2 = document.createAttribute("VALUE");
        B36attr2.setValue(getSetValueslist.get(6).getLine_second());
        B36.setAttributeNode(B36attr2);

        B36attr3 = document.createAttribute("UNIT");
        B36attr3.setValue("k");
        B36.setAttributeNode(B36attr3);
        //End

        //For eight B3 tag
        B37 = document.createElement("B3");
        d301.appendChild(B37);

        B37attr1 = document.createAttribute("PARAMCODE");
        B37attr1.setValue("P7-2-3-2-0");
        B37.setAttributeNode(B37attr1);

        B37attr2 = document.createAttribute("VALUE");
        B37attr2.setValue(getSetValueslist.get(7).getLine_second());
        B37.setAttributeNode(B37attr2);

        B37attr3 = document.createAttribute("UNIT");
        B37attr3.setValue("k");
        B37.setAttributeNode(B37attr3);
        //End

        //first B4 tag
        B40 = document.createElement("B4");
        d301.appendChild(B40);

        B40attr1 = document.createAttribute("TOD");
        B40attr1.setValue("0");
        B40.setAttributeNode(B40attr1);

        B40attr2 = document.createAttribute("PARAMCODE");
        B40attr2.setValue("P7-3-5-2-0");
        B40.setAttributeNode(B40attr2);

        B40attr3 = document.createAttribute("VALUE");
        B40attr3.setValue(getSetValueslist.get(0).getLine_first());
        B40.setAttributeNode(B40attr3);

        B40attr4 = document.createAttribute("UNIT");
        B40attr4.setValue("k");
        B40.setAttributeNode(B40attr4);
        //End

        //second B4 tag
        B41 = document.createElement("B4");
        d301.appendChild(B41);

        B41attr1 = document.createAttribute("TOD");
        B41attr1.setValue("0");
        B41.setAttributeNode(B41attr1);

        B41attr2 = document.createAttribute("PARAMCODE");
        B41attr2.setValue("P7-1-5-2-0");
        B41.setAttributeNode(B41attr2);

        B41attr3 = document.createAttribute("VALUE");
        B41attr3.setValue(getSetValueslist.get(1).getLine_first());
        B41.setAttributeNode(B41attr3);

        B41attr4 = document.createAttribute("UNIT");
        B41attr4.setValue("k");
        B41.setAttributeNode(B41attr4);
        //End

        //third B4 tag
        B42 = document.createElement("B4");
        d301.appendChild(B42);

        B42attr1 = document.createAttribute("TOD");
        B42attr1.setValue("0");
        B42.setAttributeNode(B42attr1);

        B42attr2 = document.createAttribute("PARAMCODE");
        B42attr2.setValue("P7-2-1-2-0");
        B42.setAttributeNode(B42attr2);

        B42attr3 = document.createAttribute("VALUE");
        B42attr3.setValue(getSetValueslist.get(2).getLine_first());
        B42.setAttributeNode(B42attr3);

        B42attr4 = document.createAttribute("UNIT");
        B42attr4.setValue("k");
        B42.setAttributeNode(B42attr4);
        //End

        //fourth B4 tag
        B43 = document.createElement("B4");
        d301.appendChild(B43);

        B43attr1 = document.createAttribute("TOD");
        B43attr1.setValue("0");
        B43.setAttributeNode(B43attr1);

        B43attr2 = document.createAttribute("PARAMCODE");
        B43attr2.setValue("P7-2-4-2-0");
        B43.setAttributeNode(B43attr2);

        B43attr3 = document.createAttribute("VALUE");
        B43attr3.setValue(getSetValueslist.get(3).getLine_first());
        B43.setAttributeNode(B43attr3);

        B43attr4 = document.createAttribute("UNIT");
        B43attr4.setValue("k");
        B43.setAttributeNode(B43attr4);
        //End


        //fifth B4 tag
        B44 = document.createElement("B4");
        d301.appendChild(B44);

        B44attr1 = document.createAttribute("TOD");
        B44attr1.setValue("0");
        B44.setAttributeNode(B44attr1);

        B44attr2 = document.createAttribute("PARAMCODE");
        B44attr2.setValue("P7-3-6-2-0");
        B44.setAttributeNode(B44attr2);

        B44attr3 = document.createAttribute("VALUE");
        B44attr3.setValue(getSetValueslist.get(4).getLine_first());
        B44.setAttributeNode(B44attr3);

        B44attr4 = document.createAttribute("UNIT");
        B44attr4.setValue("k");
        B44.setAttributeNode(B44attr4);
        //End

        //sixth B4 tag
        B45 = document.createElement("B4");
        d301.appendChild(B45);

        Attr B45attr1 = document.createAttribute("TOD");
        B45attr1.setValue("0");
        B45.setAttributeNode(B45attr1);

        Attr B45attr2 = document.createAttribute("PARAMCODE");
        B45attr2.setValue("P7-1-6-2-0");
        B45.setAttributeNode(B45attr2);

        Attr B45attr3 = document.createAttribute("VALUE");
        B45attr3.setValue(getSetValueslist.get(5).getLine_first());
        B45.setAttributeNode(B45attr3);

        Attr B45attr4 = document.createAttribute("UNIT");
        B45attr4.setValue("k");
        B45.setAttributeNode(B45attr4);
        //End

        //seventh B4 tag
        B46 = document.createElement("B4");
        d301.appendChild(B46);

        B46attr1 = document.createAttribute("TOD");
        B46attr1.setValue("0");
        B46.setAttributeNode(B46attr1);

        B46attr2 = document.createAttribute("PARAMCODE");
        B46attr2.setValue("P7-2-2-2-0");
        B46.setAttributeNode(B46attr2);

        B46attr3 = document.createAttribute("VALUE");
        B46attr3.setValue(getSetValueslist.get(6).getLine_first());
        B46.setAttributeNode(B46attr3);

        B46attr4 = document.createAttribute("UNIT");
        B46attr4.setValue("k");
        B46.setAttributeNode(B46attr4);
        //End

        //eight B4 tag
        B47 = document.createElement("B4");
        d301.appendChild(B47);

        B47attr1 = document.createAttribute("TOD");
        B47attr1.setValue("0");
        B47.setAttributeNode(B47attr1);

        B47attr2 = document.createAttribute("PARAMCODE");
        B47attr2.setValue("P7-2-3-2-0");
        B47.setAttributeNode(B47attr2);

        B47attr3 = document.createAttribute("VALUE");
        B47attr3.setValue(getSetValueslist.get(7).getLine_first());
        B47.setAttributeNode(B47attr3);

        B47attr4 = document.createAttribute("UNIT");
        B47attr4.setValue("k");
        B47.setAttributeNode(B47attr4);
        //End

        //nine B4 with tod 1tag
        B48 = document.createElement("B4");
        d301.appendChild(B48);

        B48attr1 = document.createAttribute("TOD");
        B48attr1.setValue("1");
        B48.setAttributeNode(B48attr1);

        B48attr2 = document.createAttribute("PARAMCODE");
        B48attr2.setValue("P7-3-5-2-0");
        B48.setAttributeNode(B48attr2);

        B48attr3 = document.createAttribute("VALUE");
        B48attr3.setValue(getSetValueslist.get(0).getLine_second());
        B48.setAttributeNode(B48attr3);

        B48attr4 = document.createAttribute("UNIT");
        B48attr4.setValue("k");
        B48.setAttributeNode(B48attr4);
        //End

        //tenth B4 tag
        B49 = document.createElement("B4");
        d301.appendChild(B49);
        B49attr1 = document.createAttribute("TOD");
        B49attr1.setValue("1");
        B49.setAttributeNode(B49attr1);

        B49attr2 = document.createAttribute("PARAMCODE");
        B49attr2.setValue("P7-1-5-2-0");
        B49.setAttributeNode(B49attr2);

        B49attr3 = document.createAttribute("VALUE");
        B49attr3.setValue(getSetValueslist.get(1).getLine_second());
        B49.setAttributeNode(B49attr3);

        B49attr4 = document.createAttribute("UNIT");
        B49attr4.setValue("k");
        B49.setAttributeNode(B49attr4);
        //End

        //11th B4 tag
        B50 = document.createElement("B4");
        d301.appendChild(B50);

        B50attr1 = document.createAttribute("TOD");
        B50attr1.setValue("1");
        B50.setAttributeNode(B50attr1);

        B50attr2 = document.createAttribute("PARAMCODE");
        B50attr2.setValue("P7-2-1-2-0");
        B50.setAttributeNode(B50attr2);

        B50attr3 = document.createAttribute("VALUE");
        B50attr3.setValue(getSetValueslist.get(2).getLine_second());
        B50.setAttributeNode(B50attr3);

        B50attr4 = document.createAttribute("UNIT");
        B50attr4.setValue("k");
        B50.setAttributeNode(B50attr4);
        //End

        //12th B4 tag
        B51 = document.createElement("B4");
        d301.appendChild(B51);

        B51attr1 = document.createAttribute("TOD");
        B51attr1.setValue("1");
        B51.setAttributeNode(B51attr1);

        B51attr2 = document.createAttribute("PARAMCODE");
        B51attr2.setValue("P7-2-4-2-0");
        B51.setAttributeNode(B51attr2);

        B51attr3 = document.createAttribute("VALUE");
        B51attr3.setValue(getSetValueslist.get(3).getLine_second());
        B51.setAttributeNode(B51attr3);

        B51attr4 = document.createAttribute("UNIT");
        B51attr4.setValue("k");
        B51.setAttributeNode(B51attr4);
        //End

        //13th B4 tag
        B52 = document.createElement("B4");
        d301.appendChild(B52);

        B52attr1 = document.createAttribute("TOD");
        B52attr1.setValue("1");
        B52.setAttributeNode(B52attr1);

        B52attr2 = document.createAttribute("PARAMCODE");
        B52attr2.setValue("P7-3-6-2-0");
        B52.setAttributeNode(B52attr2);

        B52attr3 = document.createAttribute("VALUE");
        B52attr3.setValue(getSetValueslist.get(4).getLine_second());
        B52.setAttributeNode(B52attr3);

        B52attr4 = document.createAttribute("UNIT");
        B52attr4.setValue("k");
        B52.setAttributeNode(B52attr4);
        //End

        //14th B4 tag
        B53 = document.createElement("B4");
        d301.appendChild(B53);

        B53attr1 = document.createAttribute("TOD");
        B53attr1.setValue("1");
        B53.setAttributeNode(B53attr1);

        B53attr2 = document.createAttribute("PARAMCODE");
        B53attr2.setValue("P7-1-6-2-0");
        B53.setAttributeNode(B53attr2);

        B53attr3 = document.createAttribute("VALUE");
        B53attr3.setValue(getSetValueslist.get(5).getLine_second());
        B53.setAttributeNode(B53attr3);

        B53attr4 = document.createAttribute("UNIT");
        B53attr4.setValue("k");
        B53.setAttributeNode(B53attr4);
        //End

        //15th B4 tag
        B54 = document.createElement("B4");
        d301.appendChild(B54);

        B54attr1 = document.createAttribute("TOD");
        B54attr1.setValue("1");
        B54.setAttributeNode(B54attr1);

        B54attr2 = document.createAttribute("PARAMCODE");
        B54attr2.setValue("P7-2-2-2-0");
        B54.setAttributeNode(B54attr2);

        B54attr3 = document.createAttribute("VALUE");
        B54attr3.setValue(getSetValueslist.get(6).getLine_second());
        B54.setAttributeNode(B54attr3);

        B54attr4 = document.createAttribute("UNIT");
        B54attr4.setValue("k");
        B54.setAttributeNode(B54attr4);
        //End


        //16th B4 tag
        B55 = document.createElement("B4");
        d301.appendChild(B55);

        B55attr1 = document.createAttribute("TOD");
        B55attr1.setValue("1");
        B55.setAttributeNode(B55attr1);

        B55attr2 = document.createAttribute("PARAMCODE");
        B55attr2.setValue("P7-2-3-2-0");
        B55.setAttributeNode(B55attr2);

        B55attr3 = document.createAttribute("VALUE");
        B55attr3.setValue(getSetValueslist.get(7).getLine_second());
        B55.setAttributeNode(B55attr3);

        B55attr4 = document.createAttribute("UNIT");
        B55attr4.setValue("k");
        B55.setAttributeNode(B55attr4);
        //End

        //1st B4 with tod 2
        /***********/
        B56 = document.createElement("B4");
        d301.appendChild(B56);

        B56attr1 = document.createAttribute("TOD");
        B56attr1.setValue("2");
        B56.setAttributeNode(B56attr1);

        B56attr2 = document.createAttribute("PARAMCODE");
        B56attr2.setValue("P7-3-5-2-0");
        B56.setAttributeNode(B56attr2);

        B56attr3 = document.createAttribute("VALUE");
        B56attr3.setValue(getSetValueslist.get(0).getLine_third());
        B56.setAttributeNode(B56attr3);

        B56attr4 = document.createAttribute("UNIT");
        B56attr4.setValue("k");
        B56.setAttributeNode(B56attr4);


        //2nd B4 with tod 2
        /***********/
        B57 = document.createElement("B4");
        d301.appendChild(B57);

        B57attr1 = document.createAttribute("TOD");
        B57attr1.setValue("2");
        B57.setAttributeNode(B57attr1);

        B57attr2 = document.createAttribute("PARAMCODE");
        B57attr2.setValue("P7-1-5-2-0");
        B57.setAttributeNode(B57attr2);

        B57attr3 = document.createAttribute("VALUE");
        B57attr3.setValue(getSetValueslist.get(1).getLine_third());
        B57.setAttributeNode(B57attr3);

        B57attr4 = document.createAttribute("UNIT");
        B57attr4.setValue("k");
        B57.setAttributeNode(B57attr4);

        //3rd B4 with tod 2
        /***********/
        B58 = document.createElement("B4");
        d301.appendChild(B58);

        B58attr1 = document.createAttribute("TOD");
        B58attr1.setValue("2");
        B58.setAttributeNode(B58attr1);

        B58attr2 = document.createAttribute("PARAMCODE");
        B58attr2.setValue("P7-2-1-2-0");
        B58.setAttributeNode(B58attr2);

        B58attr3 = document.createAttribute("VALUE");
        B58attr3.setValue(getSetValueslist.get(2).getLine_third());
        B58.setAttributeNode(B58attr3);

        B58attr4 = document.createAttribute("UNIT");
        B58attr4.setValue("k");
        B58.setAttributeNode(B58attr4);


        //4th B4 with tod 2
        /***********/
        B59 = document.createElement("B4");
        d301.appendChild(B59);

        B59attr1 = document.createAttribute("TOD");
        B59attr1.setValue("2");
        B59.setAttributeNode(B59attr1);

        B59attr2 = document.createAttribute("PARAMCODE");
        B59attr2.setValue("P7-2-4-2-0");
        B59.setAttributeNode(B59attr2);

        B59attr3 = document.createAttribute("VALUE");
        B59attr3.setValue(getSetValueslist.get(3).getLine_third());
        B59.setAttributeNode(B59attr3);

        B59attr4 = document.createAttribute("UNIT");
        B59attr4.setValue("k");
        B59.setAttributeNode(B59attr4);

        //5th B4 with tod 2
        /***********/
        B60 = document.createElement("B4");
        d301.appendChild(B60);

        B60attr1 = document.createAttribute("TOD");
        B60attr1.setValue("2");
        B60.setAttributeNode(B60attr1);

        B60attr2 = document.createAttribute("PARAMCODE");
        B60attr2.setValue("P7-3-6-2-0");
        B60.setAttributeNode(B60attr2);

        B60attr3 = document.createAttribute("VALUE");
        B60attr3.setValue(getSetValueslist.get(4).getLine_third());
        B60.setAttributeNode(B60attr3);

        B60attr4 = document.createAttribute("UNIT");
        B60attr4.setValue("k");
        B60.setAttributeNode(B60attr4);

        //6th B4 with tod 2
        /***********/
        B61 = document.createElement("B4");
        d301.appendChild(B61);

        B61attr1 = document.createAttribute("TOD");
        B61attr1.setValue("2");
        B61.setAttributeNode(B61attr1);

        B61attr2 = document.createAttribute("PARAMCODE");
        B61attr2.setValue("P7-1-6-2-0");
        B61.setAttributeNode(B61attr2);

        B61attr3 = document.createAttribute("VALUE");
        B61attr3.setValue(getSetValueslist.get(5).getLine_third());
        B61.setAttributeNode(B61attr3);

        B61attr4 = document.createAttribute("UNIT");
        B61attr4.setValue("k");
        B61.setAttributeNode(B61attr4);


        //7th B4 with tod 2
        /***********/
        B62 = document.createElement("B4");
        d301.appendChild(B62);

        B62attr1 = document.createAttribute("TOD");
        B62attr1.setValue("2");
        B62.setAttributeNode(B62attr1);

        B62attr2 = document.createAttribute("PARAMCODE");
        B62attr2.setValue("P7-2-2-2-0");
        B62.setAttributeNode(B62attr2);

        B62attr3 = document.createAttribute("VALUE");
        B62attr3.setValue(getSetValueslist.get(6).getLine_third());
        B62.setAttributeNode(B62attr3);

        B62attr4 = document.createAttribute("UNIT");
        B62attr4.setValue("k");
        B62.setAttributeNode(B62attr4);


        //8th B4 with tod 2
        /***********/
        B63 = document.createElement("B4");
        d301.appendChild(B63);

        B63attr1 = document.createAttribute("TOD");
        B63attr1.setValue("2");
        B63.setAttributeNode(B63attr1);

        B63attr2 = document.createAttribute("PARAMCODE");
        B63attr2.setValue("P7-2-3-2-0");
        B63.setAttributeNode(B63attr2);

        B63attr3 = document.createAttribute("VALUE");
        B63attr3.setValue(getSetValueslist.get(7).getLine_third());
        B63.setAttributeNode(B63attr3);

        B63attr4 = document.createAttribute("UNIT");
        B63attr4.setValue("k");
        B63.setAttributeNode(B63attr4);

        /*****tod3****/

        //1st B4 with tod 3
        /***********/
        B64 = document.createElement("B4");
        d301.appendChild(B64);

        B64attr1 = document.createAttribute("TOD");
        B64attr1.setValue("3");
        B64.setAttributeNode(B64attr1);

        B64attr2 = document.createAttribute("PARAMCODE");
        B64attr2.setValue("P7-3-5-2-0");
        B64.setAttributeNode(B64attr2);

        B64attr3 = document.createAttribute("VALUE");
        B64attr3.setValue(getSetValueslist.get(0).getLine_fourth());
        B64.setAttributeNode(B64attr3);

        B64attr4 = document.createAttribute("UNIT");
        B64attr4.setValue("k");
        B64.setAttributeNode(B64attr4);


        //2nd B4 with tod 3
        /***********/
        B65 = document.createElement("B4");
        d301.appendChild(B65);

        B65attr1 = document.createAttribute("TOD");
        B65attr1.setValue("3");
        B65.setAttributeNode(B65attr1);

        B65attr2 = document.createAttribute("PARAMCODE");
        B65attr2.setValue("P7-1-5-2-0");
        B65.setAttributeNode(B65attr2);

        B65attr3 = document.createAttribute("VALUE");
        B65attr3.setValue(getSetValueslist.get(1).getLine_fourth());
        B65.setAttributeNode(B65attr3);

        B65attr4 = document.createAttribute("UNIT");
        B65attr4.setValue("k");
        B65.setAttributeNode(B65attr4);

        //3rd B4 with tod 3
        /***********/
        B66 = document.createElement("B4");
        d301.appendChild(B66);

        B66attr1 = document.createAttribute("TOD");
        B66attr1.setValue("3");
        B66.setAttributeNode(B66attr1);

        B66attr2 = document.createAttribute("PARAMCODE");
        B66attr2.setValue("P7-2-1-2-0");
        B66.setAttributeNode(B66attr2);

        B66attr3 = document.createAttribute("VALUE");
        B66attr3.setValue(getSetValueslist.get(2).getLine_fourth());
        B66.setAttributeNode(B66attr3);

        B66attr4 = document.createAttribute("UNIT");
        B66attr4.setValue("k");
        B66.setAttributeNode(B66attr4);


        //4th B4 with tod 3
        /***********/
        B67 = document.createElement("B4");
        d301.appendChild(B67);

        B67attr1 = document.createAttribute("TOD");
        B67attr1.setValue("3");
        B67.setAttributeNode(B67attr1);

        B67attr2 = document.createAttribute("PARAMCODE");
        B67attr2.setValue("P7-2-4-2-0");
        B67.setAttributeNode(B67attr2);

        B67attr3 = document.createAttribute("VALUE");
        B67attr3.setValue(getSetValueslist.get(3).getLine_fourth());
        B67.setAttributeNode(B67attr3);

        B67attr4 = document.createAttribute("UNIT");
        B67attr4.setValue("k");
        B67.setAttributeNode(B67attr4);

        //5th B4 with tod 3
        /***********/
        B68 = document.createElement("B4");
        d301.appendChild(B68);

        B68attr1 = document.createAttribute("TOD");
        B68attr1.setValue("3");
        B68.setAttributeNode(B68attr1);

        B68attr2 = document.createAttribute("PARAMCODE");
        B68attr2.setValue("P7-3-6-2-0");
        B68.setAttributeNode(B68attr2);

        B68attr3 = document.createAttribute("VALUE");
        B68attr3.setValue(getSetValueslist.get(4).getLine_fourth());//setLine16ki_fourth
        B68.setAttributeNode(B68attr3);

        B68attr4 = document.createAttribute("UNIT");
        B68attr4.setValue("k");
        B68.setAttributeNode(B68attr4);

        //6th B4 with tod 3
        /***********/
        B69 = document.createElement("B4");
        d301.appendChild(B69);

        B69attr1 = document.createAttribute("TOD");
        B69attr1.setValue("3");
        B69.setAttributeNode(B69attr1);

        B69attr2 = document.createAttribute("PARAMCODE");
        B69attr2.setValue("P7-1-6-2-0");
        B69.setAttributeNode(B69attr2);

        B69attr3 = document.createAttribute("VALUE");
        B69attr3.setValue(getSetValueslist.get(5).getLine_fourth());
        B69.setAttributeNode(B69attr3);

        B69attr4 = document.createAttribute("UNIT");
        B69attr4.setValue("k");
        B69.setAttributeNode(B69attr4);


        //7th B4 with tod 3
        /***********/
        B70 = document.createElement("B4");
        d301.appendChild(B70);

        B70attr1 = document.createAttribute("TOD");
        B70attr1.setValue("3");
        B70.setAttributeNode(B70attr1);

        B70attr2 = document.createAttribute("PARAMCODE");
        B70attr2.setValue("P7-2-2-2-0");
        B70.setAttributeNode(B70attr2);

        B70attr3 = document.createAttribute("VALUE");
        B70attr3.setValue(getSetValueslist.get(6).getLine_fourth());
        B70.setAttributeNode(B70attr3);

        B70attr4 = document.createAttribute("UNIT");
        B70attr4.setValue("k");
        B70.setAttributeNode(B70attr4);


        //8th B4 with tod 3
        /***********/
        B71 = document.createElement("B4");
        d301.appendChild(B71);

        B71attr1 = document.createAttribute("TOD");
        B71attr1.setValue("3");
        B71.setAttributeNode(B71attr1);

        B71attr2 = document.createAttribute("PARAMCODE");
        B71attr2.setValue("P7-2-3-2-0");
        B71.setAttributeNode(B71attr2);

        B71attr3 = document.createAttribute("VALUE");
        B71attr3.setValue(getSetValueslist.get(7).getLine_fourth());
        B71.setAttributeNode(B71attr3);

        B71attr4 = document.createAttribute("UNIT");
        B71attr4.setValue("k");
        B71.setAttributeNode(B71attr4);


        //1st B4 with tod 4
        /***********/
        B140 = document.createElement("B4");
        d301.appendChild(B140);

        B140attr1 = document.createAttribute("TOD");
        B140attr1.setValue("4");
        B140.setAttributeNode(B140attr1);

        B140attr2 = document.createAttribute("PARAMCODE");
        B140attr2.setValue("P7-3-5-2-0");
        B140.setAttributeNode(B140attr2);

        B140attr3 = document.createAttribute("VALUE");
        B140attr3.setValue(getSetValueslist.get(0).getLine_fifth());
        B140.setAttributeNode(B140attr3);

        B140attr4 = document.createAttribute("UNIT");
        B140attr4.setValue("k");
        B140.setAttributeNode(B140attr4);


        //2nd B4 with tod 4
        /***********/
        B141 = document.createElement("B4");
        d301.appendChild(B141);

        B141attr1 = document.createAttribute("TOD");
        B141attr1.setValue("4");
        B141.setAttributeNode(B141attr1);

        B141attr2 = document.createAttribute("PARAMCODE");
        B141attr2.setValue("P7-1-5-2-0");
        B141.setAttributeNode(B141attr2);

        B141attr3 = document.createAttribute("VALUE");
        B141attr3.setValue(getSetValueslist.get(1).getLine_fifth());
        B141.setAttributeNode(B141attr3);

        B141attr4 = document.createAttribute("UNIT");
        B141attr4.setValue("k");
        B141.setAttributeNode(B141attr4);

        //3rd B4 with tod 4
        /***********/
        B142 = document.createElement("B4");
        d301.appendChild(B142);

        B142attr1 = document.createAttribute("TOD");
        B142attr1.setValue("4");
        B142.setAttributeNode(B142attr1);

        B142attr2 = document.createAttribute("PARAMCODE");
        B142attr2.setValue("P7-2-1-2-0");
        B142.setAttributeNode(B142attr2);

        B142attr3 = document.createAttribute("VALUE");
        B142attr3.setValue(getSetValueslist.get(2).getLine_fifth());
        B142.setAttributeNode(B142attr3);

        B142attr4 = document.createAttribute("UNIT");
        B142attr4.setValue("k");
        B142.setAttributeNode(B142attr4);


        //4th B4 with tod 4
        /***********/
        B143 = document.createElement("B4");
        d301.appendChild(B143);

        B143attr1 = document.createAttribute("TOD");
        B143attr1.setValue("4");
        B143.setAttributeNode(B143attr1);

        B143attr2 = document.createAttribute("PARAMCODE");
        B143attr2.setValue("P7-2-4-2-0");
        B143.setAttributeNode(B143attr2);

        B143attr3 = document.createAttribute("VALUE");
        B143attr3.setValue(getSetValueslist.get(3).getLine_fifth());
        B143.setAttributeNode(B143attr3);

        B143attr4 = document.createAttribute("UNIT");
        B143attr4.setValue("k");
        B143.setAttributeNode(B143attr4);

        //5th B4 with tod 4
        /***********/
        B144 = document.createElement("B4");
        d301.appendChild(B144);

        B144attr1 = document.createAttribute("TOD");
        B144attr1.setValue("4");
        B144.setAttributeNode(B144attr1);

        B144attr2 = document.createAttribute("PARAMCODE");
        B144attr2.setValue("P7-3-6-2-0");
        B144.setAttributeNode(B144attr2);

        B144attr3 = document.createAttribute("VALUE");
        B144attr3.setValue(getSetValueslist.get(4).getLine_fifth());
        B144.setAttributeNode(B144attr3);

        B144attr4 = document.createAttribute("UNIT");
        B144attr4.setValue("k");
        B144.setAttributeNode(B144attr4);

        //6th B4 with tod 4
        /***********/
        B145 = document.createElement("B4");
        d301.appendChild(B145);

        B145attr1 = document.createAttribute("TOD");
        B145attr1.setValue("4");
        B145.setAttributeNode(B145attr1);

        B145attr2 = document.createAttribute("PARAMCODE");
        B145attr2.setValue("P7-1-6-2-0");
        B145.setAttributeNode(B145attr2);

        B145attr3 = document.createAttribute("VALUE");
        B145attr3.setValue(getSetValueslist.get(5).getLine_fifth());
        B145.setAttributeNode(B145attr3);

        B145attr4 = document.createAttribute("UNIT");
        B145attr4.setValue("k");
        B145.setAttributeNode(B145attr4);


        //7th B4 with tod 4
        /***********/
        B146 = document.createElement("B4");
        d301.appendChild(B146);

        B146attr1 = document.createAttribute("TOD");
        B146attr1.setValue("4");
        B146.setAttributeNode(B146attr1);

        B146attr2 = document.createAttribute("PARAMCODE");
        B146attr2.setValue("P7-2-2-2-0");
        B146.setAttributeNode(B146attr2);

        B146attr3 = document.createAttribute("VALUE");
        B146attr3.setValue(getSetValueslist.get(6).getLine_fifth());
        B146.setAttributeNode(B146attr3);

        B146attr4 = document.createAttribute("UNIT");
        B146attr4.setValue("k");
        B146.setAttributeNode(B146attr4);

        //8th B4 with tod 4
        /***********/
        B147 = document.createElement("B4");
        d301.appendChild(B147);

        B147attr1 = document.createAttribute("TOD");
        B147attr1.setValue("4");
        B147.setAttributeNode(B147attr1);

        B147attr2 = document.createAttribute("PARAMCODE");
        B147attr2.setValue("P7-2-3-2-0");
        B147.setAttributeNode(B147attr2);

        B147attr3 = document.createAttribute("VALUE");
        B147attr3.setValue(getSetValueslist.get(7).getLine_fifth());
        B147.setAttributeNode(B147attr3);

        B147attr4 = document.createAttribute("UNIT");
        B147attr4.setValue("k");
        B147.setAttributeNode(B147attr4);

        //1st B4 with tod 5
        /***********/
        B163 = document.createElement("B4");
        d301.appendChild(B163);

        B163attr1 = document.createAttribute("TOD");
        B163attr1.setValue("5");
        B163.setAttributeNode(B163attr1);

        B163attr2 = document.createAttribute("PARAMCODE");
        B163attr2.setValue("P7-3-5-2-0");
        B163.setAttributeNode(B163attr2);

        B163attr3 = document.createAttribute("VALUE");
        B163attr3.setValue(getSetValueslist.get(0).getLine_sixth());//setLine12ki_sixth
        B163.setAttributeNode(B163attr3);

        B163attr4 = document.createAttribute("UNIT");
        B163attr4.setValue("k");
        B163.setAttributeNode(B163attr4);


        //2nd B4 with tod 5
        /***********/
        B164 = document.createElement("B4");
        d301.appendChild(B164);

        B164attr1 = document.createAttribute("TOD");
        B164attr1.setValue("5");
        B164.setAttributeNode(B164attr1);

        B164attr2 = document.createAttribute("PARAMCODE");
        B164attr2.setValue("P7-1-5-2-0");
        B164.setAttributeNode(B164attr2);

        B164attr3 = document.createAttribute("VALUE");
        B164attr3.setValue(getSetValueslist.get(1).getLine_sixth());
        B164.setAttributeNode(B164attr3);

        B164attr4 = document.createAttribute("UNIT");
        B164attr4.setValue("k");
        B164.setAttributeNode(B164attr4);

        //3rd B4 with tod 5
        /***********/
        B165 = document.createElement("B4");
        d301.appendChild(B165);

        B165attr1 = document.createAttribute("TOD");
        B165attr1.setValue("5");
        B165.setAttributeNode(B165attr1);

        B165attr2 = document.createAttribute("PARAMCODE");
        B165attr2.setValue("P7-2-1-2-0");
        B165.setAttributeNode(B165attr2);

        B165attr3 = document.createAttribute("VALUE");
        B165attr3.setValue(getSetValueslist.get(2).getLine_sixth());
        B165.setAttributeNode(B165attr3);

        B165attr4 = document.createAttribute("UNIT");
        B165attr4.setValue("k");
        B165.setAttributeNode(B165attr4);


        //4th B4 with tod 5
        /***********/
        B166 = document.createElement("B4");
        d301.appendChild(B166);

        B166attr1 = document.createAttribute("TOD");
        B166attr1.setValue("5");
        B166.setAttributeNode(B166attr1);

        B166attr2 = document.createAttribute("PARAMCODE");
        B166attr2.setValue("P7-2-4-2-0");
        B166.setAttributeNode(B166attr2);

        B166attr3 = document.createAttribute("VALUE");
        B166attr3.setValue(getSetValueslist.get(3).getLine_sixth());
        B166.setAttributeNode(B166attr3);

        B166attr4 = document.createAttribute("UNIT");
        B166attr4.setValue("k");
        B166.setAttributeNode(B166attr4);

        //5th B4 with tod 5
        /***********/
        B167 = document.createElement("B4");
        d301.appendChild(B167);

        B167attr1 = document.createAttribute("TOD");
        B167attr1.setValue("5");
        B167.setAttributeNode(B167attr1);

        B167attr2 = document.createAttribute("PARAMCODE");
        B167attr2.setValue("P7-3-6-2-0");
        B167.setAttributeNode(B167attr2);

        B167attr3 = document.createAttribute("VALUE");
        B167attr3.setValue(getSetValueslist.get(4).getLine_sixth());
        B167.setAttributeNode(B167attr3);

        B167attr4 = document.createAttribute("UNIT");
        B167attr4.setValue("k");
        B167.setAttributeNode(B167attr4);

        //6th B4 with tod 5
        /***********/
        B168 = document.createElement("B4");
        d301.appendChild(B168);

        B168attr1 = document.createAttribute("TOD");
        B168attr1.setValue("5");
        B168.setAttributeNode(B168attr1);

        B168attr2 = document.createAttribute("PARAMCODE");
        B168attr2.setValue("P7-1-6-2-0");
        B168.setAttributeNode(B168attr2);

        B168attr3 = document.createAttribute("VALUE");
        B168attr3.setValue(getSetValueslist.get(5).getLine_sixth());
        B168.setAttributeNode(B168attr3);

        B168attr4 = document.createAttribute("UNIT");
        B168attr4.setValue("k");
        B168.setAttributeNode(B168attr4);


        //7th B4 with tod 5
        /***********/
        B169 = document.createElement("B4");
        d301.appendChild(B169);

        B169attr1 = document.createAttribute("TOD");
        B169attr1.setValue("5");
        B169.setAttributeNode(B169attr1);

        B169attr2 = document.createAttribute("PARAMCODE");
        B169attr2.setValue("P7-2-2-2-0");
        B169.setAttributeNode(B169attr2);

        B169attr3 = document.createAttribute("VALUE");
        B169attr3.setValue(getSetValueslist.get(6).getLine_sixth());
        B169.setAttributeNode(B169attr3);

        B169attr4 = document.createAttribute("UNIT");
        B169attr4.setValue("k");
        B169.setAttributeNode(B169attr4);

        //8th B4 with tod 5
        /***********/
        B170 = document.createElement("B4");
        d301.appendChild(B170);

        B170attr1 = document.createAttribute("TOD");
        B170attr1.setValue("5");
        B170.setAttributeNode(B170attr1);

        B170attr2 = document.createAttribute("PARAMCODE");
        B170attr2.setValue("P7-2-3-2-0");
        B170.setAttributeNode(B170attr2);

        B170attr3 = document.createAttribute("VALUE");
        B170attr3.setValue(getSetValueslist.get(7).getLine_sixth());
        B170.setAttributeNode(B170attr3);

        B170attr4 = document.createAttribute("UNIT");
        B170attr4.setValue("k");
        B170.setAttributeNode(B170attr4);


        /****B5*****/
        //1st B5
        B72 = document.createElement("B5");
        d301.appendChild(B72);

        B72attr2 = document.createAttribute("PARAMCODE");
        B72attr2.setValue("P7-6-5-2-0");
        B72.setAttributeNode(B72attr2);

        B72attr3 = document.createAttribute("VALUE");
        B72attr3.setValue("0");
        B72.setAttributeNode(B72attr3);

        B72attr4 = document.createAttribute("UNIT");
        B72attr4.setValue("k");
        B72.setAttributeNode(B72attr4);

        B72attr5 = document.createAttribute("OCCDATE");
        B72attr5.setValue("");
        B72.setAttributeNode(B72attr5);

        //2nd B5
        B73 = document.createElement("B5");
        d301.appendChild(B73);

        B73attr2 = document.createAttribute("PARAMCODE");
        B73attr2.setValue("P7-4-5-2-0");
        B73.setAttributeNode(B73attr2);

        B73attr3 = document.createAttribute("VALUE");
        B73attr3.setValue("0");
        B73.setAttributeNode(B73attr3);

        B73attr4 = document.createAttribute("UNIT");
        B73attr4.setValue("k");
        B73.setAttributeNode(B73attr4);

        B73attr5 = document.createAttribute("OCCDATE");
        B73attr5.setValue("");
        B73.setAttributeNode(B73attr5);

        //3rd B5
        B74 = document.createElement("B5");
        d301.appendChild(B74);

        B74attr2 = document.createAttribute("PARAMCODE");
        B74attr2.setValue("P7-5-1-2-0");
        B74.setAttributeNode(B74attr2);

        B74attr3 = document.createAttribute("VALUE");
        B74attr3.setValue("0");
        B74.setAttributeNode(B74attr3);

        B74attr4 = document.createAttribute("UNIT");
        B74attr4.setValue("k");
        B74.setAttributeNode(B74attr4);

        B74attr5 = document.createAttribute("OCCDATE");
        B74attr5.setValue("");
        B74.setAttributeNode(B74attr5);

        /****B6****/
        //1st B6 tod 0
        B75 = document.createElement("B6");
        d301.appendChild(B75);

        B75attr1 = document.createAttribute("TOD");
        B75attr1.setValue("0");
        B75.setAttributeNode(B75attr1);

        B75attr2 = document.createAttribute("PARAMCODE");
        B75attr2.setValue("P7-6-5-2-0");
        B75.setAttributeNode(B75attr2);

        B75attr3 = document.createAttribute("VALUE");
        B75attr3.setValue("0");
        B75.setAttributeNode(B75attr3);

        B75attr4 = document.createAttribute("UNIT");
        B75attr4.setValue("k");
        B75.setAttributeNode(B75attr4);

        B75attr5 = document.createAttribute("OCCDATE");
        B75attr5.setValue("");
        B75.setAttributeNode(B75attr5);


        //2nd B6 tod 0B76 = document.createElement("B6");
        B76 = document.createElement("B6");
        d301.appendChild(B76);

        B76attr1 = document.createAttribute("TOD");
        B76attr1.setValue("0");
        B76.setAttributeNode(B76attr1);

        B76attr2 = document.createAttribute("PARAMCODE");
        B76attr2.setValue("P7-4-5-2-0");
        B76.setAttributeNode(B76attr2);

        B76attr3 = document.createAttribute("VALUE");
        B76attr3.setValue("0");
        B76.setAttributeNode(B76attr3);

        B76attr4 = document.createAttribute("UNIT");
        B76attr4.setValue("k");
        B76.setAttributeNode(B76attr4);

        B76attr5 = document.createAttribute("OCCDATE");
        B76attr5.setValue("");
        B76.setAttributeNode(B76attr5);

        //3rd B6 tod 0
        B77 = document.createElement("B6");
        d301.appendChild(B77);

        B77attr1 = document.createAttribute("TOD");
        B77attr1.setValue("0");
        B77.setAttributeNode(B77attr1);

        B77attr2 = document.createAttribute("PARAMCODE");
        B77attr2.setValue("P7-5-1-2-0");
        B77.setAttributeNode(B77attr2);

        B77attr3 = document.createAttribute("VALUE");
        B77attr3.setValue("0");
        B77.setAttributeNode(B77attr3);

        B77attr4 = document.createAttribute("UNIT");
        B77attr4.setValue("k");
        B77.setAttributeNode(B77attr4);

        B77attr5 = document.createAttribute("OCCDATE");
        B77attr5.setValue("");
        B77.setAttributeNode(B77attr5);

        //1st B6 tod 1
        B78 = document.createElement("B6");
        d301.appendChild(B78);

        B78attr1 = document.createAttribute("TOD");
        B78attr1.setValue("1");
        B78.setAttributeNode(B78attr1);

        B78attr2 = document.createAttribute("PARAMCODE");
        B78attr2.setValue("P7-6-5-2-0");
        B78.setAttributeNode(B78attr2);

        B78attr3 = document.createAttribute("VALUE");
        B78attr3.setValue("0");
        B78.setAttributeNode(B78attr3);

        B78attr4 = document.createAttribute("UNIT");
        B78attr4.setValue("k");
        B78.setAttributeNode(B78attr4);

        B78attr5 = document.createAttribute("OCCDATE");
        B78attr5.setValue("");
        B78.setAttributeNode(B78attr5);


        //2nd B6 tod 1
        B79 = document.createElement("B6");
        d301.appendChild(B79);

        B79attr1 = document.createAttribute("TOD");
        B79attr1.setValue("1");
        B79.setAttributeNode(B79attr1);

        B79attr2 = document.createAttribute("PARAMCODE");
        B79attr2.setValue("P7-4-5-2-0");
        B79.setAttributeNode(B79attr2);

        B79attr3 = document.createAttribute("VALUE");
        B79attr3.setValue("0");
        B79.setAttributeNode(B79attr3);

        B79attr4 = document.createAttribute("UNIT");
        B79attr4.setValue("k");
        B79.setAttributeNode(B79attr4);

        B79attr5 = document.createAttribute("OCCDATE");
        B79attr5.setValue("");
        B79.setAttributeNode(B79attr5);

        //3rd B6 tod 1
        B80 = document.createElement("B6");
        d301.appendChild(B80);

        B80attr1 = document.createAttribute("TOD");
        B80attr1.setValue("1");
        B80.setAttributeNode(B80attr1);

        B80attr2 = document.createAttribute("PARAMCODE");
        B80attr2.setValue("P7-5-1-2-0");
        B80.setAttributeNode(B80attr2);

        B80attr3 = document.createAttribute("VALUE");
        B80attr3.setValue("0");
        B80.setAttributeNode(B80attr3);

        B80attr4 = document.createAttribute("UNIT");
        B80attr4.setValue("k");
        B80.setAttributeNode(B80attr4);

        B80attr5 = document.createAttribute("OCCDATE");
        B80attr5.setValue("");
        B80.setAttributeNode(B80attr5);

        //1st B6 tod 2
        B81 = document.createElement("B6");
        d301.appendChild(B81);

        B81attr1 = document.createAttribute("TOD");
        B81attr1.setValue("2");
        B81.setAttributeNode(B81attr1);

        B81attr2 = document.createAttribute("PARAMCODE");
        B81attr2.setValue("P7-6-5-2-0");
        B81.setAttributeNode(B81attr2);

        B81attr3 = document.createAttribute("VALUE");
        B81attr3.setValue("0");
        B81.setAttributeNode(B81attr3);

        B81attr4 = document.createAttribute("UNIT");
        B81attr4.setValue("k");
        B81.setAttributeNode(B81attr4);

        B81attr5 = document.createAttribute("OCCDATE");
        B81attr5.setValue("");
        B81.setAttributeNode(B81attr5);


        //2nd B6 tod 2
        B82 = document.createElement("B6");
        d301.appendChild(B82);

        B82attr1 = document.createAttribute("TOD");
        B82attr1.setValue("2");
        B82.setAttributeNode(B82attr1);

        B82attr2 = document.createAttribute("PARAMCODE");
        B82attr2.setValue("P7-4-5-2-0");
        B82.setAttributeNode(B82attr2);

        B82attr3 = document.createAttribute("VALUE");
        B82attr3.setValue("0");
        B82.setAttributeNode(B82attr3);

        B82attr4 = document.createAttribute("UNIT");
        B82attr4.setValue("k");
        B82.setAttributeNode(B82attr4);

        B82attr5 = document.createAttribute("OCCDATE");
        B82attr5.setValue("");
        B82.setAttributeNode(B82attr5);

        //3rd B6 tod 2
        B83 = document.createElement("B6");
        d301.appendChild(B83);

        B83attr1 = document.createAttribute("TOD");
        B83attr1.setValue("2");
        B83.setAttributeNode(B83attr1);

        B83attr2 = document.createAttribute("PARAMCODE");
        B83attr2.setValue("P7-5-1-2-0");
        B83.setAttributeNode(B83attr2);

        B83attr3 = document.createAttribute("VALUE");
        B83attr3.setValue("0");
        B83.setAttributeNode(B83attr3);

        B83attr4 = document.createAttribute("UNIT");
        B83attr4.setValue("k");
        B83.setAttributeNode(B83attr4);

        B83attr5 = document.createAttribute("OCCDATE");
        B83attr5.setValue("");
        B83.setAttributeNode(B83attr5);

        //1st B6 tod 3
        B84 = document.createElement("B6");
        d301.appendChild(B84);

        B84attr1 = document.createAttribute("TOD");
        B84attr1.setValue("3");
        B84.setAttributeNode(B84attr1);

        B84attr2 = document.createAttribute("PARAMCODE");
        B84attr2.setValue("P7-6-5-2-0");
        B84.setAttributeNode(B84attr2);

        B84attr3 = document.createAttribute("VALUE");
        B84attr3.setValue("0");
        B84.setAttributeNode(B84attr3);

        B84attr4 = document.createAttribute("UNIT");
        B84attr4.setValue("k");
        B84.setAttributeNode(B84attr4);

        B84attr5 = document.createAttribute("OCCDATE");
        B84attr5.setValue("");
        B84.setAttributeNode(B84attr5);


        //2nd B6 tod 3
        B85 = document.createElement("B6");
        d301.appendChild(B85);

        B85attr1 = document.createAttribute("TOD");
        B85attr1.setValue("3");
        B85.setAttributeNode(B85attr1);

        B85attr2 = document.createAttribute("PARAMCODE");
        B85attr2.setValue("P7-4-5-2-0");
        B85.setAttributeNode(B85attr2);

        B85attr3 = document.createAttribute("VALUE");
        B85attr3.setValue("0");
        B85.setAttributeNode(B85attr3);

        B85attr4 = document.createAttribute("UNIT");
        B85attr4.setValue("k");
        B85.setAttributeNode(B85attr4);

        B85attr5 = document.createAttribute("OCCDATE");
        B85attr5.setValue("");
        B85.setAttributeNode(B85attr5);

        //3rd B6 tod 3
        B86 = document.createElement("B6");
        d301.appendChild(B86);

        B86attr1 = document.createAttribute("TOD");
        B86attr1.setValue("3");
        B86.setAttributeNode(B86attr1);

        B86attr2 = document.createAttribute("PARAMCODE");
        B86attr2.setValue("P7-5-1-2-0");
        B86.setAttributeNode(B86attr2);

        B86attr3 = document.createAttribute("VALUE");
        B86attr3.setValue("0");
        B86.setAttributeNode(B86attr3);

        B86attr4 = document.createAttribute("UNIT");
        B86attr4.setValue("k");
        B86.setAttributeNode(B86attr4);

        B86attr5 = document.createAttribute("OCCDATE");
        B86attr5.setValue("");
        B86.setAttributeNode(B86attr5);

        //1st B6 tod 4
        B148 = document.createElement("B6");
        d301.appendChild(B148);

        B148attr1 = document.createAttribute("TOD");
        B148attr1.setValue("4");
        B148.setAttributeNode(B148attr1);

        B148attr2 = document.createAttribute("PARAMCODE");
        B148attr2.setValue("P7-6-5-2-0");
        B148.setAttributeNode(B148attr2);

        B148attr3 = document.createAttribute("VALUE");
        B148attr3.setValue("0");
        B148.setAttributeNode(B148attr3);

        B148attr4 = document.createAttribute("UNIT");
        B148attr4.setValue("k");
        B148.setAttributeNode(B148attr4);

        B148attr5 = document.createAttribute("OCCDATE");
        B148attr5.setValue("");
        B148.setAttributeNode(B148attr5);

        //2nd B6 tod 4
        B149 = document.createElement("B6");
        d301.appendChild(B149);

        B149attr1 = document.createAttribute("TOD");
        B149attr1.setValue("4");
        B149.setAttributeNode(B149attr1);

        B149attr2 = document.createAttribute("PARAMCODE");
        B149attr2.setValue("P7-4-5-2-0");
        B149.setAttributeNode(B149attr2);

        B149attr3 = document.createAttribute("VALUE");
        B149attr3.setValue("0");
        B149.setAttributeNode(B149attr3);

        B149attr4 = document.createAttribute("UNIT");
        B149attr4.setValue("k");
        B149.setAttributeNode(B149attr4);

        B149attr5 = document.createAttribute("OCCDATE");
        B149attr5.setValue("");
        B149.setAttributeNode(B149attr5);

        //3rd B6 tod 4
        B150 = document.createElement("B6");
        d301.appendChild(B150);

        B150attr1 = document.createAttribute("TOD");
        B150attr1.setValue("4");
        B150.setAttributeNode(B150attr1);

        B150attr2 = document.createAttribute("PARAMCODE");
        B150attr2.setValue("P7-5-1-2-0");
        B150.setAttributeNode(B150attr2);

        B150attr3 = document.createAttribute("VALUE");
        B150attr3.setValue("0");
        B150.setAttributeNode(B150attr3);

        B150attr4 = document.createAttribute("UNIT");
        B150attr4.setValue("k");
        B150.setAttributeNode(B150attr4);

        B150attr5 = document.createAttribute("OCCDATE");
        B150attr5.setValue("");
        B150.setAttributeNode(B150attr5);

        //1st B6 tod 5
        B171 = document.createElement("B6");
        d301.appendChild(B171);

        B171attr1 = document.createAttribute("TOD");
        B171attr1.setValue("5");
        B171.setAttributeNode(B171attr1);

        B171attr2 = document.createAttribute("PARAMCODE");
        B171attr2.setValue("P7-6-5-2-0");
        B171.setAttributeNode(B171attr2);

        B171attr3 = document.createAttribute("VALUE");
        B171attr3.setValue("0");
        B171.setAttributeNode(B171attr3);

        B171attr4 = document.createAttribute("UNIT");
        B171attr4.setValue("k");
        B171.setAttributeNode(B171attr4);

        B171attr5 = document.createAttribute("OCCDATE");
        B171attr5.setValue("");
        B171.setAttributeNode(B171attr5);

        //2nd B6 tod 5
        B172 = document.createElement("B6");
        d301.appendChild(B172);

        B172attr1 = document.createAttribute("TOD");
        B172attr1.setValue("5");
        B172.setAttributeNode(B172attr1);

        B172attr2 = document.createAttribute("PARAMCODE");
        B172attr2.setValue("P7-4-5-2-0");
        B172.setAttributeNode(B172attr2);

        B172attr3 = document.createAttribute("VALUE");
        B172attr3.setValue("0");
        B172.setAttributeNode(B172attr3);

        B172attr4 = document.createAttribute("UNIT");
        B172attr4.setValue("k");
        B172.setAttributeNode(B172attr4);

        B172attr5 = document.createAttribute("OCCDATE");
        B172attr5.setValue("");
        B172.setAttributeNode(B172attr5);

        //3rd B6 tod 5
        B173 = document.createElement("B6");
        d301.appendChild(B173);

        B173attr1 = document.createAttribute("TOD");
        B173attr1.setValue("5");
        B173.setAttributeNode(B173attr1);

        B173attr2 = document.createAttribute("PARAMCODE");
        B173attr2.setValue("P7-5-1-2-0");
        B173.setAttributeNode(B173attr2);

        B173attr3 = document.createAttribute("VALUE");
        B173attr3.setValue("0");
        B173.setAttributeNode(B173attr3);

        B173attr4 = document.createAttribute("UNIT");
        B173attr4.setValue("k");
        B173.setAttributeNode(B173attr4);

        B173attr5 = document.createAttribute("OCCDATE");
        B173attr5.setValue("");
        B173.setAttributeNode(B173attr5);

        //1st B9
        B90 = document.createElement("B9");
        d301.appendChild(B90);

        B90attr2 = document.createAttribute("PARAMCODE");
        B90attr2.setValue("P4-4-4-1-0");
        B90.setAttributeNode(B90attr2);

        B90attr3 = document.createAttribute("VALUE");
        B90attr3.setValue("0");
        B90.setAttributeNode(B90attr3);

        //2nd B9
        B91 = document.createElement("B9");
        d301.appendChild(B91);

        B91attr2 = document.createAttribute("PARAMCODE");
        B91attr2.setValue("P4-4-4-2-0");
        B91.setAttributeNode(B91attr2);

        B91attr3 = document.createAttribute("VALUE");
        B91attr3.setValue("0");
        B91.setAttributeNode(B91attr3);


        //1st B10 tod 0
        B92 = document.createElement("B10");
        d301.appendChild(B92);

        B92attr1 = document.createAttribute("TOD");
        B92attr1.setValue("0");
        B92.setAttributeNode(B92attr1);

        B92attr2 = document.createAttribute("PARAMCODE");
        B92attr2.setValue("P4-4-4-1-0");
        B92.setAttributeNode(B92attr2);

        B92attr3 = document.createAttribute("VALUE");
        B92attr3.setValue("0");
        B92.setAttributeNode(B92attr3);


        //2nd B10 tod 0
        B93 = document.createElement("B10");
        d301.appendChild(B93);

        B93attr1 = document.createAttribute("TOD");
        B93attr1.setValue("0");
        B93.setAttributeNode(B93attr1);

        B93attr2 = document.createAttribute("PARAMCODE");
        B93attr2.setValue("P4-4-4-2-0");
        B93.setAttributeNode(B93attr2);

        B93attr3 = document.createAttribute("VALUE");
        B93attr3.setValue("0");
        B93.setAttributeNode(B93attr3);


        //3rd B10 tod 1
        B94 = document.createElement("B10");
        d301.appendChild(B94);

        B94attr1 = document.createAttribute("TOD");
        B94attr1.setValue("1");
        B94.setAttributeNode(B94attr1);

        B94attr2 = document.createAttribute("PARAMCODE");
        B94attr2.setValue("P4-4-4-1-0");
        B94.setAttributeNode(B94attr2);

        B94attr3 = document.createAttribute("VALUE");
        B94attr3.setValue("0");
        B94.setAttributeNode(B94attr3);

        //4th B10 tod 1
        B95 = document.createElement("B10");
        d301.appendChild(B95);

        B95attr1 = document.createAttribute("TOD");
        B95attr1.setValue("1");
        B95.setAttributeNode(B95attr1);

        B95attr2 = document.createAttribute("PARAMCODE");
        B95attr2.setValue("P4-4-4-2-0");
        B95.setAttributeNode(B95attr2);

        B95attr3 = document.createAttribute("VALUE");
        B95attr3.setValue("0");
        B95.setAttributeNode(B95attr3);

        //5th B10 tod 3
        B96 = document.createElement("B10");
        d301.appendChild(B96);

        B96attr1 = document.createAttribute("TOD");
        B96attr1.setValue("2");
        B96.setAttributeNode(B96attr1);

        B96attr2 = document.createAttribute("PARAMCODE");
        B96attr2.setValue("P4-4-4-1-0");
        B96.setAttributeNode(B96attr2);

        B96attr3 = document.createAttribute("VALUE");
        B96attr3.setValue("0");
        B96.setAttributeNode(B96attr3);

        //6th B10 tod 3
        B97 = document.createElement("B10");
        d301.appendChild(B97);

        B97attr1 = document.createAttribute("TOD");
        B97attr1.setValue("2");
        B97.setAttributeNode(B97attr1);

        B97attr2 = document.createAttribute("PARAMCODE");
        B97attr2.setValue("P4-4-4-2-0");
        B97.setAttributeNode(B97attr2);

        B97attr3 = document.createAttribute("VALUE");
        B97attr3.setValue("0");
        B97.setAttributeNode(B97attr3);

        //7th B10 tod 3
        B98 = document.createElement("B10");
        d301.appendChild(B98);

        B98attr1 = document.createAttribute("TOD");
        B98attr1.setValue("3");
        B98.setAttributeNode(B98attr1);

        B98attr2 = document.createAttribute("PARAMCODE");
        B98attr2.setValue("P4-4-4-1-0");
        B98.setAttributeNode(B98attr2);

        B98attr3 = document.createAttribute("VALUE");
        B98attr3.setValue("0");
        B98.setAttributeNode(B98attr3);

        //8th B10 tod 3
        B99 = document.createElement("B10");
        d301.appendChild(B99);

        B99attr1 = document.createAttribute("TOD");
        B99attr1.setValue("3");
        B99.setAttributeNode(B99attr1);

        B99attr2 = document.createAttribute("PARAMCODE");
        B99attr2.setValue("P4-4-4-2-0");
        B99.setAttributeNode(B99attr2);

        B99attr3 = document.createAttribute("VALUE");
        B99attr3.setValue("0");
        B99.setAttributeNode(B99attr3);

        //8th B10 tod 4
        B151 = document.createElement("B10");
        d301.appendChild(B151);

        B151attr1 = document.createAttribute("TOD");
        B151attr1.setValue("4");
        B151.setAttributeNode(B151attr1);

        B151attr2 = document.createAttribute("PARAMCODE");
        B151attr2.setValue("P4-4-4-1-0");
        B151.setAttributeNode(B151attr2);

        B151attr3 = document.createAttribute("VALUE");
        B151attr3.setValue("0");
        B151.setAttributeNode(B151attr3);

        //9th B10 tod 4
        B152 = document.createElement("B10");
        d301.appendChild(B152);

        B152attr1 = document.createAttribute("TOD");
        B152attr1.setValue("4");
        B152.setAttributeNode(B152attr1);

        B152attr2 = document.createAttribute("PARAMCODE");
        B152attr2.setValue("P4-4-4-2-0");
        B152.setAttributeNode(B152attr2);

        B152attr3 = document.createAttribute("VALUE");
        B152attr3.setValue("0");
        B152.setAttributeNode(B152attr3);

        //8th B10 tod 5
        B161 = document.createElement("B10");
        d301.appendChild(B161);

        B161attr1 = document.createAttribute("TOD");
        B161attr1.setValue("5");
        B161.setAttributeNode(B161attr1);

        B161attr2 = document.createAttribute("PARAMCODE");
        B161attr2.setValue("P4-4-4-1-0");
        B161.setAttributeNode(B161attr2);

        B161attr3 = document.createAttribute("VALUE");
        B161attr3.setValue("0");
        B161.setAttributeNode(B161attr3);

        //9th B10 tod 5
        B162 = document.createElement("B10");
        d301.appendChild(B162);

        B162attr1 = document.createAttribute("TOD");
        B162attr1.setValue("5");
        B162.setAttributeNode(B162attr1);

        B162attr2 = document.createAttribute("PARAMCODE");
        B162attr2.setValue("P4-4-4-2-0");
        B162.setAttributeNode(B162attr2);

        B162attr3 = document.createAttribute("VALUE");
        B162attr3.setValue("0");
        B162.setAttributeNode(B162attr3);

        /////////////// D3-02 TAG Starting//////////////

        Element d302 = document.createElement("D3-02");
        d3.appendChild(d302);

        g302attr = document.createAttribute("DATETIME");
        g302attr.setValue("");
        d302.setAttributeNode(g302attr);

        g302attr2 = document.createAttribute("MECHANISM");
        g302attr2.setValue("");
        d302.setAttributeNode(g302attr2);


        //For first B3 tag
        B100 = document.createElement("B3");
        d302.appendChild(B100);

        B100attr1 = document.createAttribute("PARAMCODE");
        B100attr1.setValue("P7-3-5-2-0");
        B100.setAttributeNode(B100attr1);

        B100attr2 = document.createAttribute("VALUE");
        B100attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValueslist.get(8).getLine_first()) + Double.parseDouble(getSetValueslist.get(8).getLine_second()) + Double.parseDouble(getSetValueslist.get(8).getLine_third()) + Double.parseDouble(getSetValueslist.get(8).getLine_fourth()) + Double.parseDouble(getSetValueslist.get(8).getLine_fifth()) + Double.parseDouble(getSetValueslist.get(8).getLine_sixth()))));
        B100.setAttributeNode(B100attr2);

        B100attr3 = document.createAttribute("UNIT");
        B100attr3.setValue("k");
        B100.setAttributeNode(B100attr3);
        //End

        //For second B3 tag
        B101 = document.createElement("B3");
        d302.appendChild(B101);

        B101attr1 = document.createAttribute("PARAMCODE");
        B101attr1.setValue("P7-1-5-2-0");
        B101.setAttributeNode(B101attr1);

        B101attr2 = document.createAttribute("VALUE");
        B101attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValueslist.get(9).getLine_first()) + Double.parseDouble(getSetValueslist.get(9).getLine_second()) + Double.parseDouble(getSetValueslist.get(9).getLine_third()) + Double.parseDouble(getSetValueslist.get(9).getLine_fourth()) + Double.parseDouble(getSetValueslist.get(9).getLine_fifth()) + Double.parseDouble(getSetValueslist.get(9).getLine_sixth()))));
        B101.setAttributeNode(B101attr2);

        B101attr3 = document.createAttribute("UNIT");
        B101attr3.setValue("k");
        B101.setAttributeNode(B101attr3);
        //End

        //For third B3 tag
        B102 = document.createElement("B3");
        d302.appendChild(B102);

        B102attr1 = document.createAttribute("PARAMCODE");
        B102attr1.setValue("P7-2-1-2-0");
        B102.setAttributeNode(B102attr1);

        B102attr2 = document.createAttribute("VALUE");

        B102attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValueslist.get(10).getLine_first()) + Double.parseDouble(getSetValueslist.get(10).getLine_second()) + Double.parseDouble(getSetValueslist.get(10).getLine_third()) + Double.parseDouble(getSetValueslist.get(10).getLine_fourth()) + Double.parseDouble(getSetValueslist.get(10).getLine_fifth()) + Double.parseDouble(getSetValueslist.get(10).getLine_sixth()))));
        B102.setAttributeNode(B102attr2);

        B102attr3 = document.createAttribute("UNIT");
        B102attr3.setValue("k");
        B102.setAttributeNode(B102attr3);
        //End


        //For fourth B3 tag
        B103 = document.createElement("B3");
        d302.appendChild(B103);

        B103attr1 = document.createAttribute("PARAMCODE");
        B103attr1.setValue("P7-2-4-2-0");
        B103.setAttributeNode(B103attr1);

        B103attr2 = document.createAttribute("VALUE");
        B103attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValueslist.get(11).getLine_first()) + Double.parseDouble(getSetValueslist.get(11).getLine_second()) + Double.parseDouble(getSetValueslist.get(11).getLine_third()) + Double.parseDouble(getSetValueslist.get(11).getLine_fourth()) + Double.parseDouble(getSetValueslist.get(11).getLine_fifth()) + Double.parseDouble(getSetValueslist.get(11).getLine_sixth()))));
        B103.setAttributeNode(B103attr2);

        B103attr3 = document.createAttribute("UNIT");
        B103attr3.setValue("k");
        B103.setAttributeNode(B103attr3);
        //End

        //For fifth B3 tag
        B104 = document.createElement("B3");
        d302.appendChild(B104);

        B104attr1 = document.createAttribute("PARAMCODE");
        B104attr1.setValue("P7-3-6-2-0");
        B104.setAttributeNode(B104attr1);

        B104attr2 = document.createAttribute("VALUE");
        B104attr2.setValue("0");
        B104.setAttributeNode(B104attr2);

        B104attr3 = document.createAttribute("UNIT");
        B104attr3.setValue("k");
        B104.setAttributeNode(B104attr3);
        //End

        //For sixth B3 tag
        B105 = document.createElement("B3");
        d302.appendChild(B105);

        B105attr1 = document.createAttribute("PARAMCODE");
        B105attr1.setValue("P7-1-6-2-0");
        B105.setAttributeNode(B105attr1);

        B105attr2 = document.createAttribute("VALUE");
        B105attr2.setValue("0");
        B105.setAttributeNode(B105attr2);

        B105attr3 = document.createAttribute("UNIT");
        B105attr3.setValue("k");
        B105.setAttributeNode(B105attr3);
        //End

        //For seventh B3 tag
        B106 = document.createElement("B3");
        d302.appendChild(B106);

        B106attr1 = document.createAttribute("PARAMCODE");
        B106attr1.setValue("P7-2-2-2-0");
        B106.setAttributeNode(B106attr1);

        B106attr2 = document.createAttribute("VALUE");
        B106attr2.setValue("0");
        B106.setAttributeNode(B106attr2);

        B106attr3 = document.createAttribute("UNIT");
        B106attr3.setValue("k");
        B106.setAttributeNode(B106attr3);
        //End

        //For eight B3 tag
        B107 = document.createElement("B3");
        d302.appendChild(B107);

        B107attr1 = document.createAttribute("PARAMCODE");
        B107attr1.setValue("P7-2-3-2-0");
        B107.setAttributeNode(B107attr1);

        B107attr2 = document.createAttribute("VALUE");
        B107attr2.setValue("0");
        B107.setAttributeNode(B107attr2);

        B107attr3 = document.createAttribute("UNIT");
        B107attr3.setValue("k");
        B107.setAttributeNode(B107attr3);
        //End

        //first B4 tag
        B108 = document.createElement("B4");
        d302.appendChild(B108);

        B108attr1 = document.createAttribute("TOD");
        B108attr1.setValue("0");
        B108.setAttributeNode(B108attr1);

        B108attr2 = document.createAttribute("PARAMCODE");
        B108attr2.setValue("P7-3-5-2-0");
        B108.setAttributeNode(B108attr2);

        B108attr3 = document.createAttribute("VALUE");
        B108attr3.setValue(getSetValueslist.get(8).getLine_first());
        B108.setAttributeNode(B108attr3);

        B108attr4 = document.createAttribute("UNIT");
        B108attr4.setValue("k");
        B108.setAttributeNode(B108attr4);
        //End

        //second B4 tag
        B109 = document.createElement("B4");
        d302.appendChild(B109);

        B109attr1 = document.createAttribute("TOD");
        B109attr1.setValue("0");
        B109.setAttributeNode(B109attr1);

        B109attr2 = document.createAttribute("PARAMCODE");
        B109attr2.setValue("P7-1-5-2-0");
        B109.setAttributeNode(B109attr2);

        B109attr3 = document.createAttribute("VALUE");
        B109attr3.setValue(getSetValueslist.get(9).getLine_first());
        B109.setAttributeNode(B109attr3);

        B109attr4 = document.createAttribute("UNIT");
        B109attr4.setValue("k");
        B109.setAttributeNode(B109attr4);
        //End

        //third B4 tag
        B110 = document.createElement("B4");
        d302.appendChild(B110);

        B110attr1 = document.createAttribute("TOD");
        B110attr1.setValue("0");
        B110.setAttributeNode(B110attr1);

        B110attr2 = document.createAttribute("PARAMCODE");
        B110attr2.setValue("P7-2-1-2-0");
        B110.setAttributeNode(B110attr2);

        B110attr3 = document.createAttribute("VALUE");
        B110attr3.setValue(getSetValueslist.get(10).getLine_first());
        B110.setAttributeNode(B110attr3);

        B110attr4 = document.createAttribute("UNIT");
        B110attr4.setValue("k");
        B110.setAttributeNode(B110attr4);
        //End

        //fourth B4 tag
        B111 = document.createElement("B4");
        d302.appendChild(B111);

        B111attr1 = document.createAttribute("TOD");
        B111attr1.setValue("0");
        B111.setAttributeNode(B111attr1);

        B111attr2 = document.createAttribute("PARAMCODE");
        B111attr2.setValue("P7-2-4-2-0");
        B111.setAttributeNode(B111attr2);

        B111attr3 = document.createAttribute("VALUE");
        B111attr3.setValue(getSetValueslist.get(11).getLine_first());
        B111.setAttributeNode(B111attr3);

        B111attr4 = document.createAttribute("UNIT");
        B111attr4.setValue("k");
        B111.setAttributeNode(B111attr4);
        //End


        //fifth B4 tag tod 0
        B112 = document.createElement("B4");
        d302.appendChild(B112);

        B112attr1 = document.createAttribute("TOD");
        B112attr1.setValue("0");
        B112.setAttributeNode(B112attr1);

        B112attr2 = document.createAttribute("PARAMCODE");
        B112attr2.setValue("P7-3-6-2-0");
        B112.setAttributeNode(B112attr2);

        B112attr3 = document.createAttribute("VALUE");
        B112attr3.setValue("0");
        B112.setAttributeNode(B112attr3);

        B112attr4 = document.createAttribute("UNIT");
        B112attr4.setValue("k");
        B112.setAttributeNode(B112attr4);
        //End

        //sixth B4 tag
        B113 = document.createElement("B4");
        d302.appendChild(B113);

        B113attr1 = document.createAttribute("TOD");
        B113attr1.setValue("0");
        B113.setAttributeNode(B113attr1);

        B113attr2 = document.createAttribute("PARAMCODE");
        B113attr2.setValue("P7-1-6-2-0");
        B113.setAttributeNode(B113attr2);

        B113attr3 = document.createAttribute("VALUE");
        B113attr3.setValue("0");
        B113.setAttributeNode(B113attr3);

        B113attr4 = document.createAttribute("UNIT");
        B113attr4.setValue("k");
        B113.setAttributeNode(B113attr4);
        //End

        //seventh B4 tag
        B114 = document.createElement("B4");
        d302.appendChild(B114);

        B114attr1 = document.createAttribute("TOD");
        B114attr1.setValue("0");
        B114.setAttributeNode(B114attr1);

        B114attr2 = document.createAttribute("PARAMCODE");
        B114attr2.setValue("P7-2-2-2-0");
        B114.setAttributeNode(B114attr2);

        B114attr3 = document.createAttribute("VALUE");
        B114attr3.setValue("0");
        B114.setAttributeNode(B114attr3);

        B114attr4 = document.createAttribute("UNIT");
        B114attr4.setValue("k");
        B114.setAttributeNode(B114attr4);
        //End

        //eight B4 tag
        B115 = document.createElement("B4");
        d302.appendChild(B115);

        B115attr1 = document.createAttribute("TOD");
        B115attr1.setValue("0");
        B115.setAttributeNode(B115attr1);

        B115attr2 = document.createAttribute("PARAMCODE");
        B115attr2.setValue("P7-2-3-2-0");
        B115.setAttributeNode(B115attr2);

        B115attr3 = document.createAttribute("VALUE");
        B115attr3.setValue("0");
        B115.setAttributeNode(B115attr3);

        B115attr4 = document.createAttribute("UNIT");
        B115attr4.setValue("k");
        B115.setAttributeNode(B115attr4);
        //End

        //nine B4 with tod 1tag
        B116 = document.createElement("B4");
        d302.appendChild(B116);

        B116attr1 = document.createAttribute("TOD");
        B116attr1.setValue("1");
        B116.setAttributeNode(B116attr1);

        B116attr2 = document.createAttribute("PARAMCODE");
        B116attr2.setValue("P7-3-5-2-0");
        B116.setAttributeNode(B116attr2);

        B116attr3 = document.createAttribute("VALUE");
        B116attr3.setValue(getSetValueslist.get(8).getLine_second());
        B116.setAttributeNode(B116attr3);

        B116attr4 = document.createAttribute("UNIT");
        B116attr4.setValue("k");
        B116.setAttributeNode(B116attr4);
        //End

        //tenth B4 tag
        B117 = document.createElement("B4");
        d302.appendChild(B117);

        B117attr1 = document.createAttribute("TOD");
        B117attr1.setValue("1");
        B117.setAttributeNode(B117attr1);

        B117attr2 = document.createAttribute("PARAMCODE");
        B117attr2.setValue("P7-1-5-2-0");
        B117.setAttributeNode(B117attr2);

        B117attr3 = document.createAttribute("VALUE");
        B117attr3.setValue(getSetValueslist.get(9).getLine_second());
        B117.setAttributeNode(B117attr3);

        B117attr4 = document.createAttribute("UNIT");
        B117attr4.setValue("k");
        B117.setAttributeNode(B117attr4);
        //End

        //11th B4 tag
        B118 = document.createElement("B4");
        d302.appendChild(B118);

        B118attr1 = document.createAttribute("TOD");
        B118attr1.setValue("1");
        B118.setAttributeNode(B118attr1);

        B118attr2 = document.createAttribute("PARAMCODE");
        B118attr2.setValue("P7-2-1-2-0");
        B118.setAttributeNode(B118attr2);

        B118attr3 = document.createAttribute("VALUE");
        B118attr3.setValue(getSetValueslist.get(10).getLine_second());
        B118.setAttributeNode(B118attr3);

        B118attr4 = document.createAttribute("UNIT");
        B118attr4.setValue("k");
        B118.setAttributeNode(B118attr4);
        //End

        //12th B4 tag
        B119 = document.createElement("B4");
        d302.appendChild(B119);

        B119attr1 = document.createAttribute("TOD");
        B119attr1.setValue("1");
        B119.setAttributeNode(B119attr1);

        B119attr2 = document.createAttribute("PARAMCODE");
        B119attr2.setValue("P7-2-4-2-0");
        B119.setAttributeNode(B119attr2);

        B119attr3 = document.createAttribute("VALUE");
        B119attr3.setValue(getSetValueslist.get(11).getLine_second());
        B119.setAttributeNode(B119attr3);

        B119attr4 = document.createAttribute("UNIT");
        B119attr4.setValue("k");
        B119.setAttributeNode(B119attr4);
        //End

        //13th B4 tag
        B120 = document.createElement("B4");
        d302.appendChild(B120);

        B120attr1 = document.createAttribute("TOD");
        B120attr1.setValue("1");
        B120.setAttributeNode(B120attr1);

        B120attr2 = document.createAttribute("PARAMCODE");
        B120attr2.setValue("P7-3-6-2-0");
        B120.setAttributeNode(B120attr2);

        B120attr3 = document.createAttribute("VALUE");
        B120attr3.setValue("0");
        B120.setAttributeNode(B120attr3);

        B120attr4 = document.createAttribute("UNIT");
        B120attr4.setValue("k");
        B120.setAttributeNode(B120attr4);
        //End

        //14th B4 tag
        B121 = document.createElement("B4");
        d302.appendChild(B121);

        B121attr1 = document.createAttribute("TOD");
        B121attr1.setValue("1");
        B121.setAttributeNode(B121attr1);

        B121attr2 = document.createAttribute("PARAMCODE");
        B121attr2.setValue("P7-1-6-2-0");
        B121.setAttributeNode(B121attr2);

        B121attr3 = document.createAttribute("VALUE");
        B121attr3.setValue("0");
        B121.setAttributeNode(B121attr3);

        B121attr4 = document.createAttribute("UNIT");
        B121attr4.setValue("k");
        B121.setAttributeNode(B121attr4);
        //End

        //15th B4 tag
        B122 = document.createElement("B4");
        d302.appendChild(B122);

        B122attr1 = document.createAttribute("TOD");
        B122attr1.setValue("1");
        B122.setAttributeNode(B122attr1);

        B122attr2 = document.createAttribute("PARAMCODE");
        B122attr2.setValue("P7-2-2-2-0");
        B122.setAttributeNode(B122attr2);

        B122attr3 = document.createAttribute("VALUE");
        B122attr3.setValue("0");
        B122.setAttributeNode(B122attr3);

        B122attr4 = document.createAttribute("UNIT");
        B122attr4.setValue("k");
        B122.setAttributeNode(B122attr4);
        //End


        //16th B4 tag
        B123 = document.createElement("B4");
        d302.appendChild(B123);

        B123attr1 = document.createAttribute("TOD");
        B123attr1.setValue("1");
        B123.setAttributeNode(B123attr1);

        B123attr2 = document.createAttribute("PARAMCODE");
        B123attr2.setValue("P7-2-3-2-0");
        B123.setAttributeNode(B123attr2);

        B123attr3 = document.createAttribute("VALUE");
        B123attr3.setValue("0");
        B123.setAttributeNode(B123attr3);

        B123attr4 = document.createAttribute("UNIT");
        B123attr4.setValue("k");
        B123.setAttributeNode(B123attr4);
        //End

        //1st B4 with tod 2
        /***********/
        B124 = document.createElement("B4");
        d302.appendChild(B124);

        B124attr1 = document.createAttribute("TOD");
        B124attr1.setValue("2");
        B124.setAttributeNode(B124attr1);

        B124attr2 = document.createAttribute("PARAMCODE");
        B124attr2.setValue("P7-3-5-2-0");
        B124.setAttributeNode(B124attr2);

        B124attr3 = document.createAttribute("VALUE");
        B124attr3.setValue(getSetValueslist.get(8).getLine_third());//setLine21ki_third
        B124.setAttributeNode(B124attr3);

        B124attr4 = document.createAttribute("UNIT");
        B124attr4.setValue("k");
        B124.setAttributeNode(B124attr4);


        //2nd B4 with tod 2
        /***********/
        B125 = document.createElement("B4");
        d302.appendChild(B125);

        B125attr1 = document.createAttribute("TOD");
        B125attr1.setValue("2");
        B125.setAttributeNode(B125attr1);

        B125attr2 = document.createAttribute("PARAMCODE");
        B125attr2.setValue("P7-1-5-2-0");
        B125.setAttributeNode(B125attr2);

        B125attr3 = document.createAttribute("VALUE");
        B125attr3.setValue(getSetValueslist.get(9).getLine_third());
        B125.setAttributeNode(B125attr3);

        B125attr4 = document.createAttribute("UNIT");
        B125attr4.setValue("k");
        B125.setAttributeNode(B125attr4);

        //3rd B4 with tod 2
        /***********/
        B126 = document.createElement("B4");
        d302.appendChild(B126);

        B126attr1 = document.createAttribute("TOD");
        B126attr1.setValue("2");
        B126.setAttributeNode(B126attr1);

        B126attr2 = document.createAttribute("PARAMCODE");
        B126attr2.setValue("P7-2-1-2-0");
        B126.setAttributeNode(B126attr2);

        B126attr3 = document.createAttribute("VALUE");
        B126attr3.setValue(getSetValueslist.get(10).getLine_third());
        B126.setAttributeNode(B126attr3);

        B126attr4 = document.createAttribute("UNIT");
        B126attr4.setValue("k");
        B126.setAttributeNode(B126attr4);


        //4th B4 with tod 2
        /***********/
        B127 = document.createElement("B4");
        d302.appendChild(B127);

        B127attr1 = document.createAttribute("TOD");
        B127attr1.setValue("2");
        B127.setAttributeNode(B127attr1);

        B127attr2 = document.createAttribute("PARAMCODE");
        B127attr2.setValue("P7-2-4-2-0");
        B127.setAttributeNode(B127attr2);

        B127attr3 = document.createAttribute("VALUE");
        B127attr3.setValue(getSetValueslist.get(11).getLine_third());
        B127.setAttributeNode(B127attr3);

        B127attr4 = document.createAttribute("UNIT");
        B127attr4.setValue("k");
        B127.setAttributeNode(B127attr4);

        //5th B4 with tod 2
        /***********/
        B128 = document.createElement("B4");
        d302.appendChild(B128);

        B128attr1 = document.createAttribute("TOD");
        B128attr1.setValue("2");
        B128.setAttributeNode(B128attr1);

        B128attr2 = document.createAttribute("PARAMCODE");
        B128attr2.setValue("P7-3-6-2-0");
        B128.setAttributeNode(B128attr2);

        B128attr3 = document.createAttribute("VALUE");
        B128attr3.setValue("0");
        B128.setAttributeNode(B128attr3);

        B128attr4 = document.createAttribute("UNIT");
        B128attr4.setValue("k");
        B128.setAttributeNode(B128attr4);

        //6th B4 with tod 2
        /***********/
        B129 = document.createElement("B4");
        d302.appendChild(B129);

        B129attr1 = document.createAttribute("TOD");
        B129attr1.setValue("2");
        B129.setAttributeNode(B129attr1);

        B129attr2 = document.createAttribute("PARAMCODE");
        B129attr2.setValue("P7-1-6-2-0");
        B129.setAttributeNode(B129attr2);

        B129attr3 = document.createAttribute("VALUE");
        B129attr3.setValue("0");
        B129.setAttributeNode(B129attr3);

        B129attr4 = document.createAttribute("UNIT");
        B129attr4.setValue("k");
        B129.setAttributeNode(B129attr4);


        //7th B4 with tod 2
        /***********/
        B130 = document.createElement("B4");
        d302.appendChild(B130);

        B130attr1 = document.createAttribute("TOD");
        B130attr1.setValue("2");
        B130.setAttributeNode(B130attr1);

        B130attr2 = document.createAttribute("PARAMCODE");
        B130attr2.setValue("P7-2-2-2-0");
        B130.setAttributeNode(B130attr2);

        B130attr3 = document.createAttribute("VALUE");
        B130attr3.setValue("0");
        B130.setAttributeNode(B130attr3);

        B130attr4 = document.createAttribute("UNIT");
        B130attr4.setValue("k");
        B130.setAttributeNode(B130attr4);


        //8th B4 with tod 2
        /***********/
        B131 = document.createElement("B4");
        d302.appendChild(B131);

        B131attr1 = document.createAttribute("TOD");
        B131attr1.setValue("2");
        B131.setAttributeNode(B131attr1);

        B131attr2 = document.createAttribute("PARAMCODE");
        B131attr2.setValue("P7-2-3-2-0");
        B131.setAttributeNode(B131attr2);

        B131attr3 = document.createAttribute("VALUE");
        B131attr3.setValue("0");
        B131.setAttributeNode(B131attr3);

        B131attr4 = document.createAttribute("UNIT");
        B131attr4.setValue("k");
        B131.setAttributeNode(B131attr4);

        /*****tod3****/

        //1st B4 with tod 3
        /***********/
        B132 = document.createElement("B4");
        d302.appendChild(B132);

        B132attr1 = document.createAttribute("TOD");
        B132attr1.setValue("3");
        B132.setAttributeNode(B132attr1);

        B132attr2 = document.createAttribute("PARAMCODE");
        B132attr2.setValue("P7-3-5-2-0");
        B132.setAttributeNode(B132attr2);

        B132attr3 = document.createAttribute("VALUE");
        B132attr3.setValue(getSetValueslist.get(8).getLine_fourth());
        B132.setAttributeNode(B132attr3);

        B132attr4 = document.createAttribute("UNIT");
        B132attr4.setValue("k");
        B132.setAttributeNode(B132attr4);


        //2nd B4 with tod 3
        /***********/
        B133 = document.createElement("B4");
        d302.appendChild(B133);

        B133attr1 = document.createAttribute("TOD");
        B133attr1.setValue("3");
        B133.setAttributeNode(B133attr1);

        B133attr2 = document.createAttribute("PARAMCODE");
        B133attr2.setValue("P7-1-5-2-0");
        B133.setAttributeNode(B133attr2);

        B133attr3 = document.createAttribute("VALUE");
        B133attr3.setValue(getSetValueslist.get(9).getLine_fourth());
        B133.setAttributeNode(B133attr3);

        B133attr4 = document.createAttribute("UNIT");
        B133attr4.setValue("k");
        B133.setAttributeNode(B133attr4);

        //3rd B4 with tod 3
        /***********/
        B134 = document.createElement("B4");
        d302.appendChild(B134);

        B134attr1 = document.createAttribute("TOD");
        B134attr1.setValue("3");
        B134.setAttributeNode(B134attr1);

        B134attr2 = document.createAttribute("PARAMCODE");
        B134attr2.setValue("P7-2-1-2-0");
        B134.setAttributeNode(B134attr2);

        B134attr3 = document.createAttribute("VALUE");
        B134attr3.setValue(getSetValueslist.get(10).getLine_fourth());
        B134.setAttributeNode(B134attr3);

        B134attr4 = document.createAttribute("UNIT");
        B134attr4.setValue("k");
        B134.setAttributeNode(B134attr4);


        //4th B4 with tod 3
        /***********/
        B135 = document.createElement("B4");
        d302.appendChild(B135);

        B135attr1 = document.createAttribute("TOD");
        B135attr1.setValue("3");
        B135.setAttributeNode(B135attr1);

        B135attr2 = document.createAttribute("PARAMCODE");
        B135attr2.setValue("P7-2-4-2-0");
        B135.setAttributeNode(B135attr2);

        B135attr3 = document.createAttribute("VALUE");
        B135attr3.setValue(getSetValueslist.get(11).getLine_fourth());
        B135.setAttributeNode(B135attr3);

        B135attr4 = document.createAttribute("UNIT");
        B135attr4.setValue("k");
        B135.setAttributeNode(B135attr4);

        //5th B4 with tod 3
        /***********/
        B136 = document.createElement("B4");
        d302.appendChild(B136);

        B136attr1 = document.createAttribute("TOD");
        B136attr1.setValue("3");
        B136.setAttributeNode(B136attr1);

        B136attr2 = document.createAttribute("PARAMCODE");
        B136attr2.setValue("P7-3-6-2-0");
        B136.setAttributeNode(B136attr2);

        B136attr3 = document.createAttribute("VALUE");
        B136attr3.setValue(getSetValueslist.get(12).getLine_fourth());//setLine25ki_fourth
        B136.setAttributeNode(B136attr3);

        B136attr4 = document.createAttribute("UNIT");
        B136attr4.setValue("k");
        B136.setAttributeNode(B136attr4);

        //6th B4 with tod 3
        /***********/
        B137 = document.createElement("B4");
        d302.appendChild(B137);

        B137attr1 = document.createAttribute("TOD");
        B137attr1.setValue("3");
        B137.setAttributeNode(B137attr1);

        B137attr2 = document.createAttribute("PARAMCODE");
        B137attr2.setValue("P7-1-6-2-0");
        B137.setAttributeNode(B137attr2);

        B137attr3 = document.createAttribute("VALUE");
        B137attr3.setValue(getSetValueslist.get(13).getLine_fourth());
        B137.setAttributeNode(B137attr3);

        B137attr4 = document.createAttribute("UNIT");
        B137attr4.setValue("k");
        B137.setAttributeNode(B137attr4);


        //7th B4 with tod 3
        /***********/
        B138 = document.createElement("B4");
        d302.appendChild(B138);

        B138attr1 = document.createAttribute("TOD");
        B138attr1.setValue("3");
        B138.setAttributeNode(B138attr1);

        B138attr2 = document.createAttribute("PARAMCODE");
        B138attr2.setValue("P7-2-2-2-0");
        B138.setAttributeNode(B138attr2);

        B138attr3 = document.createAttribute("VALUE");
        B138attr3.setValue(getSetValueslist.get(14).getLine_fourth());
        B138.setAttributeNode(B138attr3);

        B138attr4 = document.createAttribute("UNIT");
        B138attr4.setValue("k");
        B138.setAttributeNode(B138attr4);


        //8th B4 with tod 2
        /***********/
        B139 = document.createElement("B4");
        d302.appendChild(B139);

        B139attr1 = document.createAttribute("TOD");
        B139attr1.setValue("3");
        B139.setAttributeNode(B139attr1);

        B139attr2 = document.createAttribute("PARAMCODE");
        B139attr2.setValue("P7-2-3-2-0");
        B139.setAttributeNode(B139attr2);

        B139attr3 = document.createAttribute("VALUE");
        B139attr3.setValue(getSetValueslist.get(15).getLine_fourth());
        B139.setAttributeNode(B139attr3);

        B139attr4 = document.createAttribute("UNIT");
        B139attr4.setValue("k");
        B139.setAttributeNode(B139attr4);

        //1st B4 with tod 4
        /***********/
        B174 = document.createElement("B4");
        d302.appendChild(B174);

        B174attr1 = document.createAttribute("TOD");
        B174attr1.setValue("4");
        B174.setAttributeNode(B174attr1);

        B174attr2 = document.createAttribute("PARAMCODE");
        B174attr2.setValue("P7-3-5-2-0");
        B174.setAttributeNode(B174attr2);

        B174attr3 = document.createAttribute("VALUE");
        B174attr3.setValue(getSetValueslist.get(8).getLine_fifth());
        B174.setAttributeNode(B174attr3);

        B174attr4 = document.createAttribute("UNIT");
        B174attr4.setValue("k");
        B174.setAttributeNode(B174attr4);


        //2nd B4 with tod 4
        /***********/
        B175 = document.createElement("B4");
        d302.appendChild(B175);

        B175attr1 = document.createAttribute("TOD");
        B175attr1.setValue("4");
        B175.setAttributeNode(B175attr1);

        B175attr2 = document.createAttribute("PARAMCODE");
        B175attr2.setValue("P7-1-5-2-0");
        B175.setAttributeNode(B175attr2);

        B175attr3 = document.createAttribute("VALUE");
        B175attr3.setValue(getSetValueslist.get(9).getLine_fifth());
        B175.setAttributeNode(B175attr3);

        B175attr4 = document.createAttribute("UNIT");
        B175attr4.setValue("k");
        B175.setAttributeNode(B175attr4);

        //3rd B4 with tod 4
        /***********/
        B176 = document.createElement("B4");
        d302.appendChild(B176);

        B176attr1 = document.createAttribute("TOD");
        B176attr1.setValue("4");
        B176.setAttributeNode(B176attr1);

        B176attr2 = document.createAttribute("PARAMCODE");
        B176attr2.setValue("P7-2-1-2-0");
        B176.setAttributeNode(B176attr2);

        B176attr3 = document.createAttribute("VALUE");
        B176attr3.setValue(getSetValueslist.get(10).getLine_fifth());
        B176.setAttributeNode(B176attr3);

        B176attr4 = document.createAttribute("UNIT");
        B176attr4.setValue("k");
        B176.setAttributeNode(B176attr4);


        //4th B4 with tod 4
        /***********/
        B177 = document.createElement("B4");
        d302.appendChild(B177);

        B177attr1 = document.createAttribute("TOD");
        B177attr1.setValue("4");
        B177.setAttributeNode(B177attr1);

        B177attr2 = document.createAttribute("PARAMCODE");
        B177attr2.setValue("P7-2-4-2-0");
        B177.setAttributeNode(B177attr2);

        B177attr3 = document.createAttribute("VALUE");
        B177attr3.setValue(getSetValueslist.get(11).getLine_fifth());
        B177.setAttributeNode(B177attr3);

        B177attr4 = document.createAttribute("UNIT");
        B177attr4.setValue("k");
        B177.setAttributeNode(B177attr4);

        //5th B4 with tod 4
        /***********/
        B178 = document.createElement("B4");
        d302.appendChild(B178);

        B178attr1 = document.createAttribute("TOD");
        B178attr1.setValue("4");
        B178.setAttributeNode(B178attr1);

        B178attr2 = document.createAttribute("PARAMCODE");
        B178attr2.setValue("P7-3-6-2-0");
        B178.setAttributeNode(B178attr2);

        B178attr3 = document.createAttribute("VALUE");
        B178attr3.setValue("0");//setLine25ki_fourth
        B178.setAttributeNode(B178attr3);

        B178attr4 = document.createAttribute("UNIT");
        B178attr4.setValue("k");
        B178.setAttributeNode(B178attr4);

        //6th B4 with tod 4
        /***********/
        B179 = document.createElement("B4");
        d302.appendChild(B179);

        B179attr1 = document.createAttribute("TOD");
        B179attr1.setValue("4");
        B179.setAttributeNode(B179attr1);

        B179attr2 = document.createAttribute("PARAMCODE");
        B179attr2.setValue("P7-1-6-2-0");
        B179.setAttributeNode(B179attr2);

        B179attr3 = document.createAttribute("VALUE");
        B179attr3.setValue("0");
        B179.setAttributeNode(B179attr3);

        B179attr4 = document.createAttribute("UNIT");
        B179attr4.setValue("k");
        B179.setAttributeNode(B179attr4);

        //7th B4 with tod 4
        /***********/
        B180 = document.createElement("B4");
        d302.appendChild(B180);

        B180attr1 = document.createAttribute("TOD");
        B180attr1.setValue("4");
        B180.setAttributeNode(B180attr1);

        B180attr2 = document.createAttribute("PARAMCODE");
        B180attr2.setValue("P7-2-2-2-0");
        B180.setAttributeNode(B180attr2);

        B180attr3 = document.createAttribute("VALUE");
        B180attr3.setValue("0");
        B180.setAttributeNode(B180attr3);

        B180attr4 = document.createAttribute("UNIT");
        B180attr4.setValue("k");
        B180.setAttributeNode(B180attr4);


        //8th B4 with tod 4
        /***********/
        B181 = document.createElement("B4");
        d302.appendChild(B181);

        B181attr1 = document.createAttribute("TOD");
        B181attr1.setValue("4");
        B181.setAttributeNode(B181attr1);

        B181attr2 = document.createAttribute("PARAMCODE");
        B181attr2.setValue("P7-2-3-2-0");
        B181.setAttributeNode(B181attr2);

        B181attr3 = document.createAttribute("VALUE");
        B181attr3.setValue("0");
        B181.setAttributeNode(B181attr3);

        B181attr4 = document.createAttribute("UNIT");
        B181attr4.setValue("k");
        B181.setAttributeNode(B181attr4);

        //1st B4 with tod 5
        /***********/
        B182 = document.createElement("B4");
        d302.appendChild(B182);

        B182attr1 = document.createAttribute("TOD");
        B182attr1.setValue("5");
        B182.setAttributeNode(B182attr1);

        B182attr2 = document.createAttribute("PARAMCODE");
        B182attr2.setValue("P7-3-5-2-0");
        B182.setAttributeNode(B182attr2);

        B182attr3 = document.createAttribute("VALUE");
        B182attr3.setValue(getSetValueslist.get(8).getLine_sixth());
        B182.setAttributeNode(B182attr3);

        B182attr4 = document.createAttribute("UNIT");
        B182attr4.setValue("k");
        B182.setAttributeNode(B182attr4);


        //2nd B4 with tod 5
        /***********/
        B183 = document.createElement("B4");
        d302.appendChild(B183);

        B183attr1 = document.createAttribute("TOD");
        B183attr1.setValue("5");
        B183.setAttributeNode(B183attr1);

        B183attr2 = document.createAttribute("PARAMCODE");
        B183attr2.setValue("P7-1-5-2-0");
        B183.setAttributeNode(B183attr2);

        B183attr3 = document.createAttribute("VALUE");
        B183attr3.setValue(getSetValueslist.get(9).getLine_sixth());
        B183.setAttributeNode(B183attr3);

        B183attr4 = document.createAttribute("UNIT");
        B183attr4.setValue("k");
        B183.setAttributeNode(B183attr4);

        //3rd B4 with tod 5
        /***********/
        B184 = document.createElement("B4");
        d302.appendChild(B184);

        B184attr1 = document.createAttribute("TOD");
        B184attr1.setValue("5");
        B184.setAttributeNode(B184attr1);

        B184attr2 = document.createAttribute("PARAMCODE");
        B184attr2.setValue("P7-2-1-2-0");
        B184.setAttributeNode(B184attr2);

        B184attr3 = document.createAttribute("VALUE");
        B184attr3.setValue(getSetValueslist.get(10).getLine_sixth());
        B184.setAttributeNode(B184attr3);

        B184attr4 = document.createAttribute("UNIT");
        B184attr4.setValue("k");
        B184.setAttributeNode(B184attr4);


        //4th B4 with tod 5
        /***********/
        B185 = document.createElement("B4");
        d302.appendChild(B185);

        B185attr1 = document.createAttribute("TOD");
        B185attr1.setValue("5");
        B185.setAttributeNode(B185attr1);

        B185attr2 = document.createAttribute("PARAMCODE");
        B185attr2.setValue("P7-2-4-2-0");
        B185.setAttributeNode(B185attr2);

        B185attr3 = document.createAttribute("VALUE");
        B185attr3.setValue(getSetValueslist.get(11).getLine_sixth());
        B185.setAttributeNode(B185attr3);

        B185attr4 = document.createAttribute("UNIT");
        B185attr4.setValue("k");
        B185.setAttributeNode(B185attr4);

        //5th B4 with tod 5
        /***********/
        B186 = document.createElement("B4");
        d302.appendChild(B186);

        B186attr1 = document.createAttribute("TOD");
        B186attr1.setValue("5");
        B186.setAttributeNode(B186attr1);

        B186attr2 = document.createAttribute("PARAMCODE");
        B186attr2.setValue("P7-3-6-2-0");
        B186.setAttributeNode(B186attr2);

        B186attr3 = document.createAttribute("VALUE");
        B186attr3.setValue("0");
        B186.setAttributeNode(B186attr3);

        B186attr4 = document.createAttribute("UNIT");
        B186attr4.setValue("k");
        B186.setAttributeNode(B186attr4);

        //6th B4 with tod 4
        /***********/
        B187 = document.createElement("B4");
        d302.appendChild(B187);

        B187attr1 = document.createAttribute("TOD");
        B187attr1.setValue("5");
        B187.setAttributeNode(B187attr1);

        B187attr2 = document.createAttribute("PARAMCODE");
        B187attr2.setValue("P7-1-6-2-0");
        B187.setAttributeNode(B187attr2);

        B187attr3 = document.createAttribute("VALUE");
        B187attr3.setValue("0");
        B187.setAttributeNode(B187attr3);

        B187attr4 = document.createAttribute("UNIT");
        B187attr4.setValue("k");
        B187.setAttributeNode(B187attr4);

        //7th B4 with tod 5
        /***********/
        B188 = document.createElement("B4");
        d302.appendChild(B188);

        B188attr1 = document.createAttribute("TOD");
        B188attr1.setValue("5");
        B188.setAttributeNode(B188attr1);

        B188attr2 = document.createAttribute("PARAMCODE");
        B188attr2.setValue("P7-2-2-2-0");
        B188.setAttributeNode(B188attr2);

        B188attr3 = document.createAttribute("VALUE");
        B188attr3.setValue("0");
        B188.setAttributeNode(B188attr3);

        B188attr4 = document.createAttribute("UNIT");
        B188attr4.setValue("k");
        B188.setAttributeNode(B188attr4);


        //8th B4 with tod 5
        /***********/
        B189 = document.createElement("B4");
        d302.appendChild(B189);

        B189attr1 = document.createAttribute("TOD");
        B189attr1.setValue("5");
        B189.setAttributeNode(B189attr1);

        B189attr2 = document.createAttribute("PARAMCODE");
        B189attr2.setValue("P7-2-3-2-0");
        B189.setAttributeNode(B189attr2);

        B189attr3 = document.createAttribute("VALUE");
        B189attr3.setValue("0");
        B189.setAttributeNode(B189attr3);

        B189attr4 = document.createAttribute("UNIT");
        B189attr4.setValue("k");
        B189.setAttributeNode(B189attr4);
    }
}
