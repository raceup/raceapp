package it.raceup.raceapp.utils;

public class Utils {
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
}
