package de.climathon.extremeweather.mawarning.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceRawData {

    @JsonProperty("Device ID")
    private String deviceId;

    @JsonProperty("Protocol version")
    private String protocolVersion;

    @JsonProperty("Battery voltage")
    private MeasurementValue battery;

    @JsonProperty("Air temperature")
    private MeasurementValue temperature;

    @JsonProperty("Solar radiation")
    private MeasurementValue solarRadiation;

    @JsonProperty("Precipitation")
    private MeasurementValue precipitation;

    @JsonProperty("Air humidity")
    private MeasurementValue humidity;

    public MeasurementValue getHumidity() {
        return humidity;
    }

    public void setHumidity(MeasurementValue humidity) {
        this.humidity = humidity;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(String protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public MeasurementValue getBattery() {
        return battery;
    }

    public void setBattery(MeasurementValue battery) {
        this.battery = battery;
    }

    public MeasurementValue getTemperature() {
        return temperature;
    }

    public void setTemperature(MeasurementValue temperature) {
        this.temperature = temperature;
    }

    public MeasurementValue getSolarRadiation() {
        return solarRadiation;
    }

    public void setSolarRadiation(MeasurementValue solarRadiation) {
        this.solarRadiation = solarRadiation;
    }

    public MeasurementValue getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(MeasurementValue precipitation) {
        this.precipitation = precipitation;
    }
}
