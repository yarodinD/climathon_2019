package de.climathon.extremeweather.mawarning.infra.impl;

import de.climathon.extremeweather.mawarning.config.WaterLevelConfiguration;
import de.climathon.extremeweather.mawarning.domain.model.WaterLevelData;
import de.climathon.extremeweather.mawarning.infra.WaterLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WaterLevelClientBean  implements WaterLevelClient {

    private final RestTemplate restTemplate;
    private final String stationId;

    @Autowired
    public WaterLevelClientBean(final RestTemplateBuilder restTemplateBuilder,
                                final WaterLevelConfiguration waterLevelConfiguration) {
        this.restTemplate = restTemplateBuilder.rootUri(waterLevelConfiguration.getBaseUri()).build();
        this.stationId = waterLevelConfiguration.getWaterLevelMeasurementStation();
    }

    @Override
    public WaterLevelData getWaterLevelForRhine() {
        return restTemplate.getForObject("/stations/{stationId}/W/currentmeasurement.json", WaterLevelData.class, stationId);
    }
}
