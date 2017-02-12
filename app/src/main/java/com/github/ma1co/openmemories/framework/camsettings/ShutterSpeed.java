package com.github.ma1co.openmemories.framework.camsettings;

public class ShutterSpeed {

    public static final ShutterSpeed s1 = ShutterSpeed.fromSeconds(1);

    /*
       public static final int[][] SHUTTER_SPEEDS = new int[][] {
            new int[]{1, 4000},
            new int[]{1, 3200},
            new int[]{1, 2500},
            new int[]{1, 2000},
            new int[]{1, 1600},
            new int[]{1, 1250},
            new int[]{1, 1000},
            new int[]{1, 800},
            new int[]{1, 640},
            new int[]{1, 500},
            new int[]{1, 400},
            new int[]{1, 320},
            new int[]{1, 250},
            new int[]{1, 200},
            new int[]{1, 160},
            new int[]{1, 125},
            new int[]{1, 100},
            new int[]{1, 80},
            new int[]{1, 60},
            new int[]{1, 50},
            new int[]{1, 40},
            new int[]{1, 30},
            new int[]{1, 25},
            new int[]{1, 20},
            new int[]{1, 15},
            new int[]{1, 13},
            new int[]{1, 10},
            new int[]{1, 8},
            new int[]{1, 6},
            new int[]{1, 5},
            new int[]{1, 4},
            new int[]{1, 3},
            new int[]{10, 25},
            new int[]{1, 2},
            new int[]{10, 16},
            new int[]{4, 5},
            new int[]{1, 1},
            new int[]{13, 10},
            new int[]{16, 10},
            new int[]{2, 1},
            new int[]{25, 10},
            new int[]{16, 5},
            new int[]{4, 1},
            new int[]{5, 1},
            new int[]{6, 1},
            new int[]{8, 1},
            new int[]{10, 1},
            new int[]{13, 1},
            new int[]{15, 1},
            new int[]{20, 1},
            new int[]{25, 1},
            new int[]{30, 1},
    };
     */

    private final int nominator, denominator;

    private ShutterSpeed(int nominator, int denominator) {
        this.nominator = nominator;
        this.denominator = denominator;
    }

    public static ShutterSpeed fromSeconds(int sec) {
        return new ShutterSpeed(sec, 1);
    }

    public static ShutterSpeed fromFraction(int nominator, int denominator) {
        return new ShutterSpeed(nominator, denominator);
    }

    public int nominator() {
        return nominator;
    }

    public int denominator() {
        return denominator;
    }

    public String toString() {

        if (denominator == 1) {
            return nominator + "sec";
        }
        else {
            return nominator + "/" + denominator + " sec";
        }
    }
}
