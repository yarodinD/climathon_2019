package de.climathon.extremeweather.mawarning.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.time.ZonedDateTime;
import java.util.StringJoiner;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = WaterLevelData.Builder.class)
public class WaterLevelData {
    private ZonedDateTime timestamp;
    private Double value;
    private WaterLevelTrend trend;
    private WaterLevelState stateMnwMhw;
    private WaterLevelState stateNswHsw;

    private WaterLevelData(final Builder builder) {
        timestamp = builder.timestamp;
        value = builder.value;
        trend = builder.trend;
        stateMnwMhw = builder.stateMnwMhw;
        stateNswHsw = builder.stateNswHsw;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public Double getValue() {
        return value;
    }

    public WaterLevelTrend getTrend() {
        return trend;
    }

    public WaterLevelState getStateMnwMhw() {
        return stateMnwMhw;
    }

    public WaterLevelState getStateNswHsw() {
        return stateNswHsw;
    }

    @JsonPOJOBuilder
    public static final class Builder {
        private ZonedDateTime timestamp;
        private Double value;
        private WaterLevelTrend trend;
        private WaterLevelState stateMnwMhw;
        private WaterLevelState stateNswHsw;

        private Builder() {
        }

        public Builder withTimestamp(final ZonedDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder withValue(Double value) {
            this.value = value;
            return this;
        }

        public Builder withTrend(WaterLevelTrend trend) {
            this.trend = trend;
            return this;
        }

        public Builder withStateMnwMhw(WaterLevelState stateMnwMhw) {
            this.stateMnwMhw = stateMnwMhw;
            return this;
        }

        public Builder withStateNswHsw(WaterLevelState stateNswHsw) {
            this.stateNswHsw = stateNswHsw;
            return this;
        }

        public WaterLevelData build() {
            return new WaterLevelData(this);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", WaterLevelData.class.getSimpleName() + "[", "]")
                .add("timestamp=" + timestamp)
                .add("value=" + value)
                .add("trend=" + trend)
                .add("stateMnwMhw=" + stateMnwMhw)
                .add("stateNswHsw=" + stateNswHsw)
                .toString();
    }
}
