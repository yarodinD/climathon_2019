package de.climathon.extremeweather.mawarning.view.rs.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WarnLevelDto {

    private static final String LEVEL_RED = "red";
    private static final String LEVEL_YELLOW = "yellow";
    private static final String LEVEL_GREEN = "green";
    private static final String LEVEL_UNKNOWN = "not_known";

    private Double warnScore;
    private Float longitude;
    private Float latitude;
    private Float radius;

    public String getColorCode() {
        if (warnScore < 3.0) {
            return LEVEL_GREEN;
        } else if (warnScore < 7.0) {
            return LEVEL_YELLOW;
        }
        return LEVEL_RED;
    }

    public Double getWarnScore() {
        return this.warnScore;
    }

    public void setWarnScore(final Double warnScore) {
        this.warnScore = warnScore;
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
}
