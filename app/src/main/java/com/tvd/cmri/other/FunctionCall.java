package com.tvd.cmri.other;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.tvd.cmri.R;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

import static com.tvd.cmri.other.Constant.FILE_ENCODED_ERROR;
import static com.tvd.cmri.other.Constant.FILE_ENCODED_SUCCESS;

public class FunctionCall {

    public String filepath(String value) {
        File dir = new File(android.os.Environment.getExternalStorageDirectory(), Appfoldername()
                + File.separator + value);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir.toString();
    }

    public File filestorepath(String value, String file) {
        File dir = new File(android.os.Environment.getExternalStorageDirectory(), Appfoldername()
                + File.separator + value);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return new File(dir, File.separator + file);
    }

    public String Appfoldername() {
        return "Opticals_3Phase";
    }

    public String decimalroundoff(double value) {
        BigDecimal a = new BigDecimal(value);
        BigDecimal roundOff = a.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        return "" + roundOff;
    }

    public void setSnackBar(Context context, View root, String snackTitle) {
        Snackbar snackbar = Snackbar.make(root, snackTitle, Snackbar.LENGTH_SHORT);
        snackbar.show();
        View view = snackbar.getView();
        view.setBackgroundColor(context.getResources().getColor(R.color.red));
        TextView txtv = view.findViewById(android.support.design.R.id.snackbar_text);
        txtv.setTextColor(context.getResources().getColor(R.color.textColorPrimary));
        txtv.setGravity(Gravity.CENTER_HORIZONTAL);
    }

    public final boolean isInternetOn(Activity activity) {
        ConnectivityManager connect = (ConnectivityManager) activity.getSystemService(activity.getBaseContext().CONNECTIVITY_SERVICE);
        if (connect.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED ||
                connect.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTING ||
                connect.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING ||
                connect.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) {
            return true;
        } else if (connect.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED ||
                connect.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED) {
            return false;
        }
        return false;
    }
    public void setProgressDialog(ProgressDialog progressDialog, String title, String message){
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage(message);
        progressDialog.setTitle(title);
        progressDialog.show();
        progressDialog.setCancelable(false);
    }

    public void logStatus(String message) {
        Log.d("debug", message);
    }
    private String encoded(String filepath) {
        File originalFile = new File(filepath);
        String encodedBase64;
        try {
            byte[] bytes = FileUtils.readFileToByteArray(originalFile);
            encodedBase64 = Base64.encodeToString(bytes, Base64.DEFAULT);
        } catch (IOException | OutOfMemoryError e) {
            e.printStackTrace();
            byte[] bytes = new byte[0];
            try {
                bytes = FileUtils.readFileToByteArray(originalFile);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            encodedBase64 = Base64.encodeToString(bytes, Base64.DEFAULT);
        }
        return encodedBase64;
    }

    public void encode(String filename, GetSetValues getSetValues, Handler handler, String format) {
        new EncodeFile(filename, getSetValues, handler, format).execute();
    }

    @SuppressLint("StaticFieldLeak")
    private class EncodeFile extends AsyncTask<String, String, String> {
        private String filename;
        private GetSetValues getSetValues;
        private Handler handler;
        private String format;
        EncodeFile(String filename, GetSetValues getSetValues, Handler handler, String format) {
            this.filename = filename;
            this.getSetValues = getSetValues;
            this.handler = handler;
            this.format = format;
        }

        @Override
        protected String doInBackground(String... strings) {
            return encoded(filename);
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            getSetValues.setFilename(filename);
            if (!TextUtils.isEmpty(result)) {
                if (format.equals("xml"))
                getSetValues.setResult(result);
                else getSetValues.setResult2(result);
                handler.sendEmptyMessage(FILE_ENCODED_SUCCESS);
            } else handler.sendEmptyMessage(FILE_ENCODED_ERROR);
        }
    }

    public void move_files(String source_path, String source_file, String destination_path, String destination_file) {
        File fromfile = new File(source_path + File.separator + source_file);
        File tofile = new File(destination_path + File.separator + destination_file);
        if (fromfile.exists())
            //noinspection ResultOfMethodCallIgnored
            fromfile.renameTo(tofile);
    }
}
