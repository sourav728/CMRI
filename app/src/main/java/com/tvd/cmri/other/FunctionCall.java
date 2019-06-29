package com.tvd.cmri.other;

import java.io.File;
import java.math.BigDecimal;

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

    public int findInStr(String s1, char c){
        return s1.indexOf(c);
    }
}
