package com.tvd.cmri.threePhase_LT;

import com.tvd.cmri.other.FunctionCall;
import com.tvd.cmri.other.GetSetValues;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;

public class Ver4SB1F20 {

   private Element d3,B30, B31, B32, B33, B34, B35, B36, B37, B40, B41, B42, B43, B44, B45, B46, B47, B48, B49, B50, B51, B52, B53, B54, B55, B56, B57, B58, B59, B60, B61, B62, B63,
            d302, B100, B101, B102, B103, B104, B105, B106, B107, B108,
            B109, B110, B111, B112, B113, B114, B115, B116, B117, B118, B119, B120, B121, B122, B123, B124, B125, B126, B127, B128, B129, B130, B131, B132, B133, B134, B135, B136, B137, B138, B139, d301, pId;

   private Attr B30attr1, B30attr2, B30attr3, B31attr1, B31attr2, B31attr3, B32attr1, B32attr2, B32attr3, B33attr1, B33attr2, B33attr3, B34attr1, B34attr2, B34attr3, B35attr1, B35attr2, B35attr3,
            B36attr1, B36attr2, B36attr3, B37attr1, B37attr2, B37attr3, B40attr1, B40attr2, B40attr3, B40attr4, B41attr1, B41attr2, B41attr3, B41attr4, B42attr1, B42attr2, B42attr3, B42attr4,
            B43attr1, B43attr2, B43attr3, B43attr4, B44attr1, B44attr2, B44attr3, B44attr4, B45attr1, B45attr2, B45attr3, B45attr4, B46attr1, B46attr2, B46attr3, B46attr4, B47attr1, B47attr2,
            B47attr3, B47attr4, B48attr1, B48attr2, B48attr3, B48attr4, B49attr1, B49attr2, B49attr3, B49attr4, B50attr1, B50attr2, B50attr3, B50attr4, B51attr1, B51attr2, B51attr3, B51attr4,
            B52attr1, B52attr2, B52attr3, B52attr4, B53attr1, B53attr2, B53attr3, B53attr4, B54attr1, B54attr2, B54attr3, B54attr4, B55attr1, B55attr2, B55attr3, B55attr4, B56attr1, B56attr2, B56attr3, B56attr4,
            B57attr1, B57attr2, B57attr3, B57attr4, B58attr1, B58attr2, B58attr3, B58attr4, B59attr1, B59attr2, B59attr3, B59attr4, B60attr1, B60attr2, B60attr3, B60attr4, B61attr1, B61attr2, B61attr3, B61attr4,
            B62attr1, B62attr2, B62attr3, B62attr4, B63attr1, B63attr2, B63attr3, B63attr4, B64attr1, B64attr2, B64attr3, B64attr4, B65attr1, B65attr2, B65attr3, B65attr4, B66attr1, B66attr2, B66attr3, B66attr4,
            B100attr1, B100attr2, B100attr3, B101attr1, B101attr2, B101attr3, B102attr1, B102attr2, B102attr3, B103attr2, B103attr3, B104attr1, B104attr2, B104attr3, B105attr1, B105attr2, B105attr3, B106attr1,
            B106attr2, B106attr3, B103attr1, B107attr1, B107attr2, B107attr3, B108attr1, B108attr2, B108attr3, B108attr4, B109attr1, B109attr2, B109attr3, B109attr4, B110attr1, B110attr2, B110attr3, B110attr4,
            B111attr1, B111attr2, B111attr3, B111attr4, B112attr1, B112attr2, B112attr3, B112attr4, B113attr1, B113attr2, B113attr3, B113attr4, B114attr1, B114attr2, B114attr3, B114attr4, B115attr1, B115attr2, B115attr3, B115attr4,
            B116attr1, B116attr2, B116attr3, B116attr4, B117attr1, B117attr2, B117attr3, B117attr4, B118attr1, B118attr2, B118attr3, B118attr4, B119attr1, B119attr2, B119attr3, B119attr4, B120attr1, B120attr2, B120attr3,
            B120attr4, B121attr1, B121attr2, B121attr3, B121attr4, B122attr1, B122attr2, B122attr3, B122attr4, B123attr1, B123attr2, B123attr3, B123attr4, B124attr1, B124attr2, B124attr3, B124attr4, B125attr1, B125attr2, B125attr3, B125attr4,
            B126attr1, B126attr2, B126attr3, B126attr4, B127attr1, B127attr2, B127attr3, B127attr4, B128attr1, B128attr2, B128attr3, B128attr4, B129attr1, B129attr2, B129attr3, B129attr4, B130attr1, B130attr2, B130attr3, B130attr4,
            B131attr1, B131attr2, B131attr3, B131attr4;


    private FunctionCall functionCall = new FunctionCall();
    public void ver4SB1F_20(ArrayList<GetSetValues> getSetValueslist,Document document,Element d301,Element d3){

        B30 = document.createElement("B3");
        d301.appendChild(B30);

        B30attr1 = document.createAttribute("PARAMCODE");
        B30attr1.setValue("P7-3-5-2-0");
        B30.setAttributeNode(B30attr1);

        B30attr2 = document.createAttribute("VALUE");
        B30attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValueslist.get(0).getLine_first()) + Double.parseDouble(getSetValueslist.get(0).getLine_second()) + Double.parseDouble(getSetValueslist.get(0).getLine_third()))));
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
        B31attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValueslist.get(1).getLine_first()) + Double.parseDouble(getSetValueslist.get(1).getLine_second()) + Double.parseDouble(getSetValueslist.get(1).getLine_third()))));
        B31.setAttributeNode(B31attr2);

        B31attr3 = document.createAttribute("UNIT");
        B31attr3.setValue("k");
        B31.setAttributeNode(B31attr3);
//        End

        //For third B3 tag
        B32 = document.createElement("B3");
        d301.appendChild(B32);

        B32attr1 = document.createAttribute("PARAMCODE");
        B32attr1.setValue("P7-2-1-2-0");
        B32.setAttributeNode(B32attr1);

        B32attr2 = document.createAttribute("VALUE");

        B32attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValueslist.get(2).getLine_first()) + Double.parseDouble(getSetValueslist.get(2).getLine_second()) + Double.parseDouble(getSetValueslist.get(2).getLine_third()))));
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
        B33attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValueslist.get(3).getLine_first()) + Double.parseDouble(getSetValueslist.get(3).getLine_second()) + Double.parseDouble(getSetValueslist.get(3).getLine_third()))));
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

        //TOD 2
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
        //end

        //-----------D3-02-----------------------
        d302 = document.createElement("D3-02");
        d3.appendChild(d302);

        Attr g302attr = document.createAttribute("DATETIME");
        g302attr.setValue("");
        d302.setAttributeNode(g302attr);

        Attr g302attr2 = document.createAttribute("MECHANISM");
        g302attr2.setValue("");
        d302.setAttributeNode(g302attr2);

        B100 = document.createElement("B3");
        d302.appendChild(B100);

        B100attr1 = document.createAttribute("PARAMCODE");
        B100attr1.setValue("P7-3-5-2-0");
        B100.setAttributeNode(B100attr1);

        B100attr2 = document.createAttribute("VALUE");
        B100attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValueslist.get(8).getLine_first()) + Double.parseDouble(getSetValueslist.get(8).getLine_second()) + Double.parseDouble(getSetValueslist.get(8).getLine_third()))));
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
        B101attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValueslist.get(9).getLine_first()) + Double.parseDouble(getSetValueslist.get(9).getLine_second()) + Double.parseDouble(getSetValueslist.get(9).getLine_third()))));
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

        B102attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValueslist.get(10).getLine_first()) + Double.parseDouble(getSetValueslist.get(10).getLine_second()) + Double.parseDouble(getSetValueslist.get(10).getLine_third()))));
        B102.setAttributeNode(B102attr2);

        B102attr3 = document.createAttribute("UNIT");
        B102attr3.setValue("k");
        B102.setAttributeNode(B102attr3);

        //For fourth B3 tag
        B103 = document.createElement("B3");
        d302.appendChild(B103);

        B103attr1 = document.createAttribute("PARAMCODE");
        B103attr1.setValue("P7-2-4-2-0");
        B103.setAttributeNode(B103attr1);

        B103attr2 = document.createAttribute("VALUE");
        B103attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValueslist.get(11).getLine_first()) + Double.parseDouble(getSetValueslist.get(11).getLine_second()) + Double.parseDouble(getSetValueslist.get(11).getLine_third()))));
        B103.setAttributeNode(B103attr2);

        B103attr3 = document.createAttribute("UNIT");
        B103attr3.setValue("k");
        B103.setAttributeNode(B103attr3);

        //For fifth B3 tag
        B104 = document.createElement("B3");
        d302.appendChild(B104);

        B104attr1 = document.createAttribute("PARAMCODE");
        B104attr1.setValue("P7-3-6-2-0");
        B104.setAttributeNode(B104attr1);

        B104attr2 = document.createAttribute("VALUE");
        B104attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValueslist.get(12).getLine_first()) + Double.parseDouble(getSetValueslist.get(12).getLine_second()) + Double.parseDouble(getSetValueslist.get(12).getLine_third()))));
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
        B105attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValueslist.get(13).getLine_first()) + Double.parseDouble(getSetValueslist.get(13).getLine_second()) + Double.parseDouble(getSetValueslist.get(13).getLine_third()))));
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
        B106attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValueslist.get(14).getLine_first()) + Double.parseDouble(getSetValueslist.get(14).getLine_second()) + Double.parseDouble(getSetValueslist.get(14).getLine_third()))));
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
        B107attr2.setValue(String.valueOf(functionCall.decimalroundoff(Double.parseDouble(getSetValueslist.get(15).getLine_first()) + Double.parseDouble(getSetValueslist.get(15).getLine_second()) + Double.parseDouble(getSetValueslist.get(15).getLine_third()))));
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
        B112attr3.setValue(getSetValueslist.get(12).getLine_first());
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
        B113attr3.setValue(getSetValueslist.get(13).getLine_first());
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
        B114attr3.setValue(getSetValueslist.get(14).getLine_first());
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
        B115attr3.setValue(getSetValueslist.get(15).getLine_first());
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
        B120attr3.setValue(getSetValueslist.get(12).getLine_second());
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
        B121attr3.setValue(getSetValueslist.get(13).getLine_second());
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
        B122attr3.setValue(getSetValueslist.get(14).getLine_second());
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
        B123attr3.setValue(getSetValueslist.get(15).getLine_second());
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
        B124attr3.setValue(getSetValueslist.get(8).getLine_third());
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
        B128attr3.setValue(getSetValueslist.get(12).getLine_third());
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
        B129attr3.setValue(getSetValueslist.get(13).getLine_third());
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
        B130attr3.setValue(getSetValueslist.get(14).getLine_third());
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
        B131attr3.setValue(getSetValueslist.get(15).getLine_third());
        B131.setAttributeNode(B131attr3);

        B131attr4 = document.createAttribute("UNIT");
        B131attr4.setValue("k");
        B131.setAttributeNode(B131attr4);

    }
}
