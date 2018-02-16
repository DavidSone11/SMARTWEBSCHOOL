package com.mathologic.project.SMARTSCHOOL.helpers;


import java.io.Serializable;
import java.text.DecimalFormat;



/**
 * @author Administrator
 *
 */
public class FileHandlingHelper implements Serializable {

    private static final long serialVersionUID = 1L;

    public FileHandlingHelper() {

    }

    public static String getExtension(String filename) {
        String extension = "";

        int i = filename.lastIndexOf('.');
        int p = Math.max(filename.lastIndexOf('/'), filename.lastIndexOf('\\'));

        if (i > p) {
            return extension = filename.substring(i + 1);
        }
        return "";
    }

    public static String getStringSizeLengthFile(long size) {
        DecimalFormat df = new DecimalFormat("0.00");
        float sizeKb = 1024.0f;
        float sizeMo = sizeKb * sizeKb;
        float sizeGo = sizeMo * sizeKb;
        float sizeTerra = sizeGo * sizeKb;
        if (size < sizeMo)
            return df.format(size / sizeKb) + " KB";
        else if (size < sizeGo)
            return df.format(size / sizeMo) + " MB";
        else if (size < sizeTerra)
            return df.format(size / sizeGo) + " GB";

        return "";
    }

}

