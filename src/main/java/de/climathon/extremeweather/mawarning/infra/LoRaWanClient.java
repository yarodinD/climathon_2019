package de.climathon.extremeweather.mawarning.infra;

import de.climathon.extremeweather.mawarning.domain.model.LoRaWarnSensorData;

public interface LoRaWanClient {

    LoRaWarnSensorData getTemperatureForLocation(Float longitude, Float latitude);
}
