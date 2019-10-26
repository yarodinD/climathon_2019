package de.climathon.extremeweather.mawarning.view.rs;

import de.climathon.extremeweather.mawarning.domain.model.DeviceRawData;

public interface LoRaWanReceiver {

    void retrieveData(DeviceRawData rawData);

}
