package de.climathon.extremeweather.mawarning.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.StringJoiner;

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

    @JsonProperty("Wind speed")
    private MeasurementValue windSpeed;

    public MeasurementValue getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(MeasurementValue windSpeed) {
        this.windSpeed = windSpeed;
    }

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

    @Override
    public String toString() {
        return new StringJoiner(", ", DeviceRawData.class.getSimpleName() + "[", "]")
                .add("deviceId='" + deviceId + "'")
                .add("protocolVersion='" + protocolVersion + "'")
                .add("battery=" + battery)
                .add("temperature=" + temperature)
                .add("solarRadiation=" + solarRadiation)
                .add("precipitation=" + precipitation)
                .add("humidity=" + humidity)
                .add("windSpeed=" + windSpeed)
                .toString();
    }
}
