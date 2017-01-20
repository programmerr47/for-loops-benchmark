package com.github.programmerr47.forloopsperformance;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.github.programmerr47.forloopsperformance.SimpleMeasureFunctions.measureAvgTimeEdgeCutOff;
import static com.github.programmerr47.forloopsperformance.SimpleMeasureFunctions.rndIntList;

public class ColtMcAnlisTestingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        findViewById(R.id.holy_button).setOnClickListener(ignored -> measure());
    }

    private void measure() {
        measureForIndex();
        System.gc();
        measureForEach();
        System.gc();
        measureForIterator();
    }

    private void measureForIndex() {
        ArrayList<Integer> integers = rndIntList(4000000);
        long avg = measureAvgTimeEdgeCutOff(() -> {
            int size = integers.size();
            for(int i = 0; i < size; i++) {
                Object object = integers.get(i);
                //...
            }
        }, 10);

        Log.v("Test Loops Time", "Average (for index): " + avg);
    }

    private void measureForEach() {
        ArrayList<Integer> integers = rndIntList(4000000);
        long avg = measureAvgTimeEdgeCutOff(() -> {
            for(Object obj : integers) {
                //...
            }
        }, 10);

        Log.v("Test Loops Time", "Average (for each): " + avg);
    }

    private void measureForIterator() {
        ArrayList<Integer> integers = rndIntList(4000000);
        long avg = measureAvgTimeEdgeCutOff(() -> {
            for (Iterator it = integers.iterator(); it.hasNext();) {
                Object obj = it.next();
                //...
            }
        }, 10);

        Log.v("Test Loops Time", "Average (for iterator): " + avg);
    }
}
