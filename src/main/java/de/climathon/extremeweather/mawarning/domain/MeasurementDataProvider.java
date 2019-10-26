package de.climathon.extremeweather.mawarning.domain;

import de.climathon.extremeweather.mawarning.domain.model.MeasurementDataType;

public interface MeasurementDataProvider {

    MeasurementDataType getType();

    Double getValue();
    void setValue(Double value);
}
