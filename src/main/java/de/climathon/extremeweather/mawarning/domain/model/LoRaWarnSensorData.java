package de.climathon.extremeweather.mawarning.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = LoRaWarnSensorData.Builder.class)
public class LoRaWarnSensorData {

    public static final LoRaWarnSensorData NO_DATA = new LoRaWarnSensorData();

    private LocalDateTime timestamp;
    private Float longitude;
    private Float latitude;
    private Float datapoint;
    private String unit;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Float getLongitude() {
        return longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public Float getDatapoint() {
        return datapoint;
    }

    public String getUnit() {
        return unit;
    }

    private LoRaWarnSensorData() {
        // empty object
    }

    private LoRaWarnSensorData(final Builder builder) {
        timestamp = builder.timestamp;
        longitude = builder.longitude;
        latitude = builder.latitude;
        datapoint = builder.datapoint;
        unit = builder.unit;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * {@code LoRaWarnSensorData} builder static inner class.
     */
    @JsonPOJOBuilder
    public static final class Builder {
        private LocalDateTime timestamp;
        private Float longitude;
        private Float latitude;
        private Float datapoint;
        private String unit;

        private Builder() {
        }

        /**
         * Sets the {@code timestamp} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param timestamp the {@code timestamp} to set
         * @return a reference to this Builder
         */
        public Builder withTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * Sets the {@code longituse} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param longitude the {@code longitude} to set
         * @return a reference to this Builder
         */
        public Builder withLongitude(Float longitude) {
            this.longitude = longitude;
            return this;
        }

        /**
         * Sets the {@code latitude} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param latitude the {@code latitude} to set
         * @return a reference to this Builder
         */
        public Builder withLatitude(Float latitude) {
            this.latitude = latitude;
            return this;
        }

        /**
         * Sets the {@code datapoint} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param datapoint the {@code datapoint} to set
         * @return a reference to this Builder
         */
        public Builder withDatapoint(Float datapoint) {
            this.datapoint = datapoint;
            return this;
        }

        /**
         * Sets the {@code unit} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param unit the {@code unit} to set
         * @return a reference to this Builder
         */
        public Builder withUnit(String unit) {
            this.unit = unit;
            return this;
        }

        /**
         * Returns a {@code LoRaWarnSensorData} built from the parameters previously set.
         *
         * @return a {@code LoRaWarnSensorData} built with parameters of this {@code LoRaWarnSensorData.Builder}
         */
        public LoRaWarnSensorData build() {
            return new LoRaWarnSensorData(this);
        }
    }
}
