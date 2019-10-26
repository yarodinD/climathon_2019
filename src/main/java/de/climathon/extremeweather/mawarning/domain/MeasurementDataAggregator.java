package de.climathon.extremeweather.mawarning.domain;

import de.climathon.extremeweather.mawarning.domain.model.MeasurementData;

public interface MeasurementDataAggregator {

    MeasurementData getMeasurements();
}
