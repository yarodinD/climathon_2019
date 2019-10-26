package de.climathon.extremeweather.mawarning.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sensors.waterlevel")
public class WaterLevelConfiguration {

    private String baseUri;
    private String WaterLevelMeasurementStation;

    public String getBaseUri() {
        return baseUri;
    }

    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }

    public String getWaterLevelMeasurementStation() {
        return WaterLevelMeasurementStation;
    }

    public void setWaterLevelMeasurementStation(String waterLevelMeasurementStation) {
        WaterLevelMeasurementStation = waterLevelMeasurementStation;
    }
}
