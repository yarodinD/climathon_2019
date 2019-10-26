package de.climathon.extremeweather.mawarning.domain;

import de.climathon.extremeweather.mawarning.domain.model.MeasurementData;
import de.climathon.extremeweather.mawarning.domain.model.MeasurementDataType;

public interface MeasurementDataAggregator {

    MeasurementData getMeasurements();

    void addData(MeasurementDataType type,  Double value);
}
