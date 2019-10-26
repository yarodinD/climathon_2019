package de.climathon.extremeweather.mawarning.infra;

import de.climathon.extremeweather.mawarning.domain.model.DeviceRawData;

public interface LoRaWanClient {

    DeviceRawData getTemperatureForLocation(Float longitude, Float latitude);

}
