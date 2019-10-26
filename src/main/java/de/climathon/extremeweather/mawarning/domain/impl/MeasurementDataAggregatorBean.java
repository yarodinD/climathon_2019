package de.climathon.extremeweather.mawarning.domain.impl;

import de.climathon.extremeweather.mawarning.domain.MeasurementDataAggregator;
import de.climathon.extremeweather.mawarning.domain.MeasurementDataProvider;
import de.climathon.extremeweather.mawarning.domain.model.MeasurementData;
import de.climathon.extremeweather.mawarning.domain.model.MeasurementDataType;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeasurementDataAggregatorBean implements MeasurementDataAggregator {

    private final List<MeasurementDataProvider> providers;

    @Autowired
    public MeasurementDataAggregatorBean(final List<MeasurementDataProvider> providers) {
        this.providers = List.copyOf(providers);
    }

    @Override
    public MeasurementData getMeasurements() {
        MeasurementData measurementData = new MeasurementData();
        for (MeasurementDataProvider provider : providers) {

            Double value = provider.getValue();
            switch (provider.getType()) {
                case TEMP: measurementData.setTemperature(value); break;
                case DEWPOINT: measurementData.setDewPoint(value); break;
                case HUMIDITY: measurementData.setHumidity(value); break;
                case WINDSPEED: measurementData.setWindspeed(value); break;
                case PRECIPITATION: measurementData.setPrecipitation(value); break;
                default: throw new IllegalStateException("Unexpected value: " + provider.getType());
            }
        }
        return measurementData;
    }

    @Override
    public void addData(MeasurementDataType type, Double value) {
        Optional<MeasurementDataProvider> provider = providers.stream().filter(providers -> providers.getType().equals(type)).findFirst();
        if (provider.isPresent()) {
            provider.get().setValue(value);
        }
    }
}
