package com.tvd.cmri.invoke;

import android.os.Handler;

import com.tvd.cmri.other.FunctionCall;
import com.tvd.cmri.other.GetSetValues;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static com.tvd.cmri.other.Constant.LOGIN_FAILURE;
import static com.tvd.cmri.other.Constant.LOGIN_SUCCESS;
import static com.tvd.cmri.other.Constant.XML_POSTING_FAILURE;
import static com.tvd.cmri.other.Constant.XML_POSTING_SUCCESS;


public class ReceivingData {
    private FunctionCall functionsCall = new FunctionCall();
    public String parseServerXML(String result) {
        String value = "";
        XmlPullParserFactory pullParserFactory;
        InputStream res;
        try {
            res = new ByteArrayInputStream(result.getBytes());
            pullParserFactory = XmlPullParserFactory.newInstance();
            pullParserFactory.setNamespaceAware(true);
            XmlPullParser parser = pullParserFactory.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(res, null);
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String name = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
                        switch (name) {
                            case "string":
                                value = parser.nextText();
                                break;
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                }
                eventType = parser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public void get_Details(String result, android.os.Handler handler, GetSetValues getSetValues) {
        result = parseServerXML(result);
        JSONArray jsonArray;
        try {
            jsonArray = new JSONArray(result);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String message = jsonObject.getString("message");
            if (message.equals("Success")) {
                String username = jsonObject.getString("USERNAME");
                getSetValues.setUsername(username);
                handler.sendEmptyMessage(LOGIN_SUCCESS);
            } else handler.sendEmptyMessage(LOGIN_FAILURE);
        } catch (JSONException e) {
            e.printStackTrace();
            handler.sendEmptyMessage(LOGIN_FAILURE);
        }
    }

    //For getting xml_posting response
    void get_xml_response(String result, Handler handler) {
        result = parseServerXML(result);
        functionsCall.logStatus("XML And Text file posting status: " + result);
        JSONArray jsonArray;
        try {
            jsonArray = new JSONArray(result);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            //JSONObject jsonObject = new JSONObject(result);
            String message = jsonObject.getString("message");
            if (message.equals("Success"))
                handler.sendEmptyMessage(XML_POSTING_SUCCESS);
            else handler.sendEmptyMessage(XML_POSTING_FAILURE);
        } catch (JSONException e) {
            e.printStackTrace();
            handler.sendEmptyMessage(XML_POSTING_FAILURE);
        }
    }
}
