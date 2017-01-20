package com.github.programmerr47.forloopsperformance;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static com.github.programmerr47.forloopsperformance.SimpleMeasureFunctions.measureAvgTime;
import static com.github.programmerr47.forloopsperformance.SimpleMeasureFunctions.rndStringList;
import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void generalTest() {
        measureForTime(0, 30000, 1000);
    }

    public void detailTestForOneSample() {
        measureForTime(15000, 16000, 1000);
    }

    private void measureForTime(int start, int end, int step) {
        for (int i = start; i < end; i += step) {
            final List<String> rndStringList = rndStringList(i);

            long[] measures = measureAvgTime(() -> {
                String sum = "";
                for (int index = 0; index < rndStringList.size(); index++) {
                    sum += rndStringList.get(index);
                }
            }, () -> {
                String sum = "";
                for (String rndString : rndStringList) {
                    sum += rndString;
                }
            }, () -> {
                String sum = "";
                for (Iterator<String> it = rndStringList.iterator(); it.hasNext(); ) {
                    sum += it.next();
                }
            });

            System.out.println(i + ": " + Arrays.toString(measures));
        }
    }
}