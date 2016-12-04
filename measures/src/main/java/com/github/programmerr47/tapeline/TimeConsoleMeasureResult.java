package com.github.programmerr47.tapeline;

/**
 * @author Michael Spitsin
 * @since 2016-12-04
 */
public final class TimeConsoleMeasureResult implements MeasureResult {
    private final long ms;

    public TimeConsoleMeasureResult(long ms) {
        this.ms = ms;
    }

    @Override
    public void print() {
        System.out.println("Function executed with " + ms + "ms");
    }
}
