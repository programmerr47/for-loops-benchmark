package com.github.programmerr47.tapeline;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author Michael Spitsin
 * @since 2016-12-04
 */
public final class MeasureResults implements MeasureResult, Iterable<MeasureResult> {
    private final Collection<MeasureResult> measureResults;

    public MeasureResults(List<MeasureResult> measureResults) {
        this.measureResults = measureResults;
    }

    @Override
    public void print() {
        for (MeasureResult measureResult : measureResults) {
            measureResult.print();
        }
    }

    @Override
    public Iterator<MeasureResult> iterator() {
        return measureResults.iterator();
    }
}
