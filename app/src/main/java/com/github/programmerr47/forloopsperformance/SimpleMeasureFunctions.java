package com.github.programmerr47.forloopsperformance;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Michael Spitsin
 * @since 2017-01-08
 */
public class SimpleMeasureFunctions {
    private SimpleMeasureFunctions() {}

    private static final Random rnd = new Random();

    public static List<String> rndStringList(int size) {
        List<String> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            result.add(rndString());
        }
        return result;
    }

    private static String rndString() {
        return String.valueOf(rnd.nextInt());
    }

    public static long[] measureAvgTime(Runnable... actions) {
        long[] result = new long[actions.length];
        for (int i = 0; i < actions.length; i++) {
            result[i] = measureAvgTime(actions[i]);
        }
        return result;
    }

    public static long measureAvgTime(Runnable action) {
        return measureAvgTime(action, 5);
    }

    public static long measureAvgTime(Runnable action, int attempts) {
        StringBuilder output = new StringBuilder("Attempts: ");
        long avgResult = 0;
        for (int i = 0; i < attempts; i++) {
            long result = measureTime(action);
            avgResult += result;
            output.append(result + " ");
        }

//        System.out.println(output);
        Log.v("Test Loops Time", output.toString());
        return avgResult / attempts;
    }

    public static long measureTime(Runnable action) {
        System.gc();
        long indexStart = System.nanoTime();
        action.run();
        long indexEnd = System.nanoTime();
        return ms(indexEnd - indexStart);
    }

    private static long ms(long nano) {
        return nano / 1000000;
    }
}
