package com.paiique.flatcat.util;

import java.util.Calendar;

public class CheckFestiveDate {
    static Calendar cal = Calendar.getInstance();

    public static boolean isChristmas() {
        if (cal.get(Calendar.DATE) > 23 && cal.get(Calendar.DATE) < 26) return cal.get(Calendar.MONTH) == Calendar.DECEMBER;
        return false;
    }

    public static boolean isHalloween() {
        if (cal.get(Calendar.DATE) == 31) return cal.get(Calendar.MONTH) == Calendar.OCTOBER;
        return false;
    }

    public static boolean isValentines() {
        if (cal.get(Calendar.DATE) == 14) return cal.get(Calendar.MONTH) == Calendar.FEBRUARY;
        return false;
    }

    public static boolean isEaster() {
        if (cal.get(Calendar.DATE) > 1 && cal.get(Calendar.DATE) < 5) return cal.get(Calendar.MONTH) == Calendar.APRIL;
        return false;
    }

    public static boolean isAprilFools() {
        if (cal.get(Calendar.DATE) == 1) return cal.get(Calendar.MONTH) == Calendar.APRIL;
        return false;
    }

    public static boolean isNewYear() {
        if (cal.get(Calendar.DATE) > 29 && cal.get(Calendar.DATE) < 2) return cal.get(Calendar.MONTH) == Calendar.DECEMBER || cal.get(Calendar.MONTH) == Calendar.JANUARY;
        return false;
    }
}
