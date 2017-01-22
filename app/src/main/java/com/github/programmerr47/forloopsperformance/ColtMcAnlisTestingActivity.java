package com.github.programmerr47.forloopsperformance;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;

import static com.github.programmerr47.forloopsperformance.SimpleMeasureFunctions.measureAvgTimeEdgeCutOff;
import static com.github.programmerr47.forloopsperformance.SimpleMeasureFunctions.rndIntList;

public class ColtMcAnlisTestingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        findViewById(R.id.b_simple_index).setOnClickListener(view -> simpleIndexMeasure());
        findViewById(R.id.b_simple_foreach).setOnClickListener(view -> simpleForEachMeasure());
        findViewById(R.id.b_simple_iterator).setOnClickListener(view -> simpleIteratorMeasure());
        findViewById(R.id.b_sum_index).setOnClickListener(view -> sumIndexMeasure());
        findViewById(R.id.b_sum_foreach).setOnClickListener(view -> sumForEachMeasure());
        findViewById(R.id.b_sum_iterator).setOnClickListener(view -> sumIteratorMeasure());
    }

    private void simpleIndexMeasure() {
        simpleMeasure(integers -> {
            long avg = measureAvgTimeEdgeCutOff(() -> {
                for (int i = 0; i < integers.size(); i++) {
                    Object object = integers.get(i);
                    //...
                }
            }, 10);

            Log.v("Test Loops Time", "Average (for index): " + avg);
        });
    }

    private void simpleForEachMeasure() {
        simpleMeasure(integers -> {
            long avg = measureAvgTimeEdgeCutOff(() -> {
                for (Object obj : integers) {
                    //...
                }
            }, 10);

            Log.v("Test Loops Time", "Average (for each): " + avg);
        });
    }

    private void simpleIteratorMeasure() {
        simpleMeasure(integers -> {
            long avg = measureAvgTimeEdgeCutOff(() -> {
                for (Iterator it = integers.iterator(); it.hasNext(); ) {
                    Object obj = it.next();
                    //...
                }
            }, 10);

            Log.v("Test Loops Time", "Average (for iterator): " + avg);
        });
    }

    private void simpleMeasure(Consumer<ArrayList<Integer>> consumer) {
        measure(4000000, consumer);
    }

    private void sumIndexMeasure() {
        sumMeasure(integers -> {
            long avg = measureAvgTimeEdgeCutOff(() -> {
                long sum = 0;
                for (int index = 0; index < integers.size(); index++) {
                    sum += integers.get(index);
                }
            }, 10);

            Log.v("Test Loops Time", "Average (index): " + avg);
        });
    }

    private void sumForEachMeasure() {
        sumMeasure(integers -> {
            long avg = measureAvgTimeEdgeCutOff(() -> {
                long sum = 0;
                for (int integer : integers) {
                    sum += integer;
                }
            }, 10);

            Log.v("Test Loops Time", "Average (for each): " + avg);
        });
    }

    private void sumIteratorMeasure() {
        sumMeasure(integers -> {
            long avg = measureAvgTimeEdgeCutOff(() -> {
                long sum = 0;
                for (Iterator<Integer> it = integers.iterator(); it.hasNext(); ) {
                    sum += it.next();
                }
            }, 10);

            Log.v("Test Loops Time", "Average (for iterator): " + avg);
        });
    }

    private void sumMeasure(Consumer<ArrayList<Integer>> consumer) {
        measure(4000000, consumer);
    }

    private void measure(int testCount, Consumer<ArrayList<Integer>> consumer) {
        ArrayList<Integer> integers = rndIntList(testCount);
        consumer.accept(integers);
        System.gc();
    }
}
