package com.github.programmerr47.forloopsperformance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static com.github.programmerr47.forloopsperformance.SimpleMeasureFunctions.measureAvgTime;
import static com.github.programmerr47.forloopsperformance.SimpleMeasureFunctions.rndStringList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        measureForTime(0, 30000, 1000);
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

            Log.v("Test Loops Time", i + ": " + Arrays.toString(measures));
        }
    }
}
