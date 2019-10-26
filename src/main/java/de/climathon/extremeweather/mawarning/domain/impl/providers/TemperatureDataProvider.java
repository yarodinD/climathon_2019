package de.climathon.extremeweather.mawarning.domain.impl.providers;

import de.climathon.extremeweather.mawarning.domain.MeasurementDataProvider;
import de.climathon.extremeweather.mawarning.domain.model.MeasurementDataType;
import org.springframework.stereotype.Component;

@Component
public class TemperatureDataProvider implements MeasurementDataProvider {

    @Override
    public MeasurementDataType getType() {
        return MeasurementDataType.TEMP;
    }

    @Override
    public Double getValue() {
        return null;
    }
}
