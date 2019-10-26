package de.climathon.extremeweather.mawarning.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.StringJoiner;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MeasurementValue {

    private Double value;
    private String unit;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MeasurementValue.class.getSimpleName() + "[", "]")
                .add("value=" + value)
                .add("unit='" + unit + "'")
                .toString();
    }
}
