package de.climathon.extremeweather.mawarning.domain.model;

public enum WaterLevelState {
    LOW("low"), NORMAL("normal"), HIGH("high"), UNKNOWN("unknown"), COMMENTED("commented"), OUTDATED("outdated");

    private final String value;

    WaterLevelState(final String value) {
        this.value = value;
    }

    public static WaterLevelState byValue(final String value) {
        for(WaterLevelState state : values()) {
            if(state.value.equals(value)) {
                return state;
            }
        }
        return null;
    }
}
