package de.climathon.extremeweather.mawarning.view.rs.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.climathon.extremeweather.mawarning.domain.model.MeasurementData;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WarnLevelDto {

    private static final String LEVEL_RED = "red";
    private static final String LEVEL_YELLOW = "yellow";
    private static final String LEVEL_GREEN = "green";
    private static final String LEVEL_UNKNOWN = "not_known";

    private Float longitude;
    private Float latitude;
    private Float radius;
    private List<String> warnings;
    private MeasurementData measurements;

    public List<String> getWarnings() {
        return warnings;
    }

    public void setWarnings(final List<String> warnings) {
        this.warnings = warnings;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getRadius() {
        return radius;
    }

    public void setRadius(Float radius) {
        this.radius = radius;
    }

    public MeasurementData getMeasurements() {
        return measurements;
    }

    public void setMeasurements(MeasurementData measurements) {
        this.measurements = measurements;
    }
}
