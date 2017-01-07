package com.github.programmerr47.tapeline;

/**
 * @author Michael Spitsin
 * @since 2017-01-08
 */
public class LongMeasureResult implements MeasureResult {
    private final long result;

    public LongMeasureResult(long result) {
        this.result = result;
    }

    @Override
    public void print() {
        System.out.print(result + "; ");
    }
}
