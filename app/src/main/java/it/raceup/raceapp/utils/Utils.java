package it.raceup.raceapp.utils;

import android.content.Context;
import android.content.Intent;

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

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

    public static ArrayList<Integer> getDigits(Long number) {
        ArrayList<Integer> digits = new ArrayList<>();
        while (number > 0) {
            int digit = (int) (number % 10);
            digits.add(digit);
            number = number / 10;
        }
        return digits;
    }

    public static int[] convertIntegers(List<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i);
        }
        return ret;
    }

    public static int[] reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }

    public static String getBuildVersion(Long timestamp) {
        ArrayList<Integer> listDigits = getDigits(timestamp);
        int[] digits = reverseArray(convertIntegers(listDigits));
        for (int i = 0; i < digits.length; i++) {
            System.out.println(digits[i]);
        }  // reverse
        String buildVersion = Integer.toString(digits[0]) + Integer.toString(digits[1]) + ".";
        int points = 1;
        for (int i = 2; i < digits.length; i++) {
            buildVersion += digits[i];
            if (i % 3 == 1 && points < 3) {
                buildVersion += ".";
                points += 1;
            }
        }
        return buildVersion;
    }
}
