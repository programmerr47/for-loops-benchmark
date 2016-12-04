package com.github.programmerr47.tapeline;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author Michael Spitsin
 * @since 2016-12-04
 */
public final class Measurements implements Measurement, Iterable<Measurement> {
    private final Collection<Measurement> measurements;

    public Measurements(Collection<Measurement> measurements) {
        this.measurements = measurements;
    }

    @Override
    public MeasureResult measure() {
        List<MeasureResult> measureResults = new ArrayList<>();
        for (Measurement measurement : measurements) {
            measureResults.add(measurement.measure());
        }
        return new MeasureResults(measureResults);
    }

    @Override
    public Iterator<Measurement> iterator() {
        return measurements.iterator();
    }
}
