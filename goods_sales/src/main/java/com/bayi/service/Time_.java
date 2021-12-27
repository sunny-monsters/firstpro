package com.bayi.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Time_ {

    public static String getRandomTime() {
        String newTime = new SimpleDateFormat("yyyMMddHHmmss").format(Calendar.getInstance().getTime());
        return newTime;
    }

    public static String getTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        String time = sdf.format(date);
        return time;
    }

}
