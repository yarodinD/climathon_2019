package de.climathon.extremeweather.mawarning.view.rs.impl;

import de.climathon.extremeweather.mawarning.domain.MeasurementDataAggregator;
import de.climathon.extremeweather.mawarning.domain.model.DeviceRawData;
import de.climathon.extremeweather.mawarning.domain.model.MeasurementDataType;
import de.climathon.extremeweather.mawarning.view.rs.LoRaWanReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoRaWanReceiverBean implements LoRaWanReceiver {

    private final MeasurementDataAggregator aggregator;

    @Autowired
    public LoRaWanReceiverBean(final MeasurementDataAggregator aggregator) {
        this.aggregator = aggregator;
    }

    @PostMapping(path = "/v1/lorawan", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Override
    public void retrieveData(@RequestBody DeviceRawData rawData) {
        if (rawData.getTemperature() != null) {
            aggregator.addData(MeasurementDataType.TEMP, rawData.getTemperature().getValue());
        }

        if (rawData.getPrecipitation() != null) {
            aggregator.addData(MeasurementDataType.PRECIPITATION, rawData.getPrecipitation().getValue());
        }

        if (rawData.getHumidity() != null) {
            aggregator.addData(MeasurementDataType.HUMIDITY, rawData.getHumidity().getValue());
        }

    }
}
