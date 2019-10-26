package de.climathon.extremeweather.mawarning.domain.model;

public enum WaterLevelTrend {
    INCREASING(1), DECREASING(-1), UNCHANGED(0), UNKnOWN(-999);

    private Integer value;

    WaterLevelTrend(final Integer value) {
        this.value = value;
    }

    public static WaterLevelTrend byValue(final Integer value) {
        for (WaterLevelTrend trend : values()) {
            if (trend.value.equals(value)) {
                return trend;
            }
        }
        return  null;
    }
}
