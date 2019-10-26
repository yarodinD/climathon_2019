package de.climathon.extremeweather.mawarning.domain.impl.providers;

import de.climathon.extremeweather.mawarning.domain.MeasurementDataProvider;
import de.climathon.extremeweather.mawarning.domain.model.MeasurementDataType;
import org.springframework.stereotype.Component;

@Component
public class PrecipitationDataProvider implements MeasurementDataProvider {

    private static Double CACHED_VALUE;

    @Override
    public MeasurementDataType getType() {
        return MeasurementDataType.PRECIPITATION;
    }

    @Override
    public Double getValue() {
        return CACHED_VALUE;
    }

    @Override
    public void setValue(Double value) {
        CACHED_VALUE = value;
    }
}
