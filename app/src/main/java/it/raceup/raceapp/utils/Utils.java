package it.raceup.raceapp.utils;

import android.content.Context;
import android.content.Intent;

import java.lang.reflect.Field;
import java.text.DecimalFormat;

public class Utils {
    public static final DecimalFormat TWO_DECIMALS = new DecimalFormat(".##");

    public static double randomInRange(double min, double max) {
        return min + Math.random() * (max - min);
    }

    public static double[] randomsInRange(double min, double max, int length) {
        double[] randoms = new double[length];
        for (int i = 0; i < randoms.length; i++) {
            randoms[i] = randomInRange(min, max);
        }
        return randoms;
    }

    public static String formatDecimals(double value) {
        return TWO_DECIMALS.format(value);
    }

    public static int getResId(String resName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void openActivityByClass(Context context, Class activityClass) {
        Intent openActivity = new Intent(context, activityClass);
        context.startActivity(openActivity);
    }
}
