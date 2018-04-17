package com.example.mirol.androidprojekat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static String convertDateToString(Date date){
        return dateFormat.format(date);
    }
}
