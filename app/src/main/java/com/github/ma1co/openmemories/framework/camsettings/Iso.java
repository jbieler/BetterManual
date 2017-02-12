package com.github.ma1co.openmemories.framework.camsettings;

import java.util.HashMap;
import java.util.Map;

public class Iso {

    public static final Iso iso100 = Iso.of(100);
    public static final Iso iso200 = Iso.of(200);
    public static final Iso iso400 = Iso.of(400);

    private static final Map<Integer, Integer> sonyIsoValues = new HashMap<Integer, Integer>();

    // Unused ATM
    static {
        sonyIsoValues.put(1, 100);
        sonyIsoValues.put(2, 125);
        sonyIsoValues.put(3, 160);
        sonyIsoValues.put(4, 200);
        sonyIsoValues.put(5, 250);
        sonyIsoValues.put(6, 320);
        sonyIsoValues.put(7, 400);
        sonyIsoValues.put(8, 500);
        sonyIsoValues.put(9, 640);
        sonyIsoValues.put(10, 800);
        sonyIsoValues.put(11, 1000);
        sonyIsoValues.put(12, 1250);
        sonyIsoValues.put(13, 1600);
        sonyIsoValues.put(14, 2000);
        sonyIsoValues.put(15, 2500);
        sonyIsoValues.put(16, 3200);
        sonyIsoValues.put(17, 4000);
        sonyIsoValues.put(18, 5000);
        sonyIsoValues.put(19, 6400);
        sonyIsoValues.put(20, 8000);
        sonyIsoValues.put(21, 10000);
        sonyIsoValues.put(22, 12800);
        sonyIsoValues.put(23, 16000);
        sonyIsoValues.put(24, 20000);
        sonyIsoValues.put(25, 25600);
        // TODO add higher values for A7 and escpecially A7S
    }

    // TODO Add auto-iso which has the value 0

    private final int value;

    private Iso(int value) {
        this.value = value;
    }

    public int asInt() {
        return value;
    }

    public static Iso of(int value) {
        return new Iso(value);
    }

    public String toString() {
        return "ISO " + value;
    }

}
