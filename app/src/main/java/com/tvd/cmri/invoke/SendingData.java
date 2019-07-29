package com.tvd.cmri.invoke;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import com.tvd.cmri.other.GetSetValues;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class SendingData {

    ReceivingData receivingData = new ReceivingData();
    private String UrlPostConnection(String Post_Url, HashMap<String, String> datamap) throws IOException {
        try {
            StringBuilder response = new StringBuilder();
            URL url = new URL(Post_Url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(60000);
            conn.setConnectTimeout(60000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(getPostDataString(datamap));
            writer.flush();
            writer.close();
            os.close();
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpsURLConnection.HTTP_OK) {
                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line = br.readLine()) != null) {
                    response.append(line);
                }
            } else {
                response = new StringBuilder();
            }
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("Debug", "SERVER TIME OUT");

        }
        return null;
    }

    private String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }

        return result.toString();
    }

    @SuppressLint("StaticFieldLeak")
    public class Login extends AsyncTask<String, String, String> {
        String response = "";
        Handler handler;
        GetSetValues getSetValues;
        public Login(Handler handler, GetSetValues getSetValues) {
            this.handler = handler;
            this.getSetValues = getSetValues;
        }

        @Override
        protected String doInBackground(String... params) {
            HashMap<String, String> datamap = new HashMap<>();
            datamap.put("username", params[0]);
            datamap.put("password", params[1]);
            try {
                response = UrlPostConnection("http://test_bc_service.hescomtrm.com/TicketingService.asmx/loginDetails", datamap);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            receivingData.get_Details(result, handler, getSetValues);
        }
    }

    //For posting text and xml files
    @SuppressLint("StaticFieldLeak")
    public class XMLPosting extends AsyncTask<String, String, String> {
        String requestUrl = "";
        Handler handler;
        public XMLPosting(Handler handler) {
            this.handler = handler;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            HashMap<String, String> datamap = new HashMap<>();
            datamap.put("User_Name", params[0]);
            datamap.put("Meter_Make", params[1]);
            datamap.put("Meter_Version", params[2]);
            datamap.put("Text_File", params[3]);
            datamap.put("XML_File", params[4]);
            datamap.put("IMEI_Number", params[5]);
            datamap.put("Text_FileName", params[6]);
            datamap.put("XML_FileName", params[7]);
            try {
               // requestUrl = UrlPostConnection("http://bc_service2.hescomtrm.com/TicketingService.asmx/Spot_Attendance_Details", datamap);
                requestUrl = UrlPostConnection("http://test_bc_service.hescomtrm.com/TicketingService.asmx/OpticalDataInsert",datamap);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return requestUrl;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            receivingData.get_xml_response(result, handler);
        }
    }

}
