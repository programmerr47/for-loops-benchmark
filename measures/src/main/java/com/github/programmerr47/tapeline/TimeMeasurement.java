package com.github.programmerr47.tapeline;

/**
 * @author Michael Spitsin
 * @since 2016-12-04
 */
public final class TimeMeasurement implements Measurement {
    private final Runnable measureFunction;

    public TimeMeasurement(Runnable measureFunction) {
        this.measureFunction = measureFunction;
    }

    @Override
    public MeasureResult measure() {
        long startTime = System.nanoTime();
        measureFunction.run();
        long endTime = System.nanoTime();
        return new TimeConsoleMeasureResult((endTime - startTime) / 1000000);
    }
}
