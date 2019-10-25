package de.climathon.extremeweather.mawarning.infra.impl;

import de.climathon.extremeweather.mawarning.domain.model.LoRaWarnSensorData;
import de.climathon.extremeweather.mawarning.infra.LoRaWanClient;
import org.springframework.stereotype.Component;

@Component
public class LoRaWanClientBean implements LoRaWanClient {

    @Override
    public LoRaWarnSensorData getTemperatureForLocation(Float longitude, Float latitude) {
        return LoRaWarnSensorData.NO_DATA;
    }
}
