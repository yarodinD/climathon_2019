package de.climathon.extremeweather.mawarning.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.time.ZonedDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = LoRaWarnSensorData.Builder.class)
public class LoRaWarnSensorData {

    private final String command;
    private final Long sequenceNumber;
    private final String eui;
    private final ZonedDateTime timestamp;
    private final Long fCounter;
    private final Byte battery;
    private final String data;

    private LoRaWarnSensorData(Builder builder) {
        command = builder.command;
        sequenceNumber = builder.sequenceNumber;
        eui = builder.eui;
        timestamp = builder.timestamp;
        fCounter = builder.fCounter;
        battery = builder.battery;
        data = builder.data;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public String getCommand() {
        return command;
    }

    public Long getSequenceNumber() {
        return sequenceNumber;
    }

    public String getEui() {
        return eui;
    }

    public Long getfCounter() {
        return fCounter;
    }

    public Byte getBattery() {
        return battery;
    }

    public String getData() {
        return data;
    }

    @JsonPOJOBuilder
    public static final class Builder {
        private String command;
        private Long sequenceNumber;
        private String eui;
        private ZonedDateTime timestamp;
        private Long fCounter;
        private Byte battery;
        private String data;

        private Builder() {
        }

        @JsonProperty("cmd")
        public Builder withCommand(String command) {
            this.command = command;
            return this;
        }

        @JsonProperty("seqno")
        public Builder withSequenceNumber(Long sequenceNumber) {
            this.sequenceNumber = sequenceNumber;
            return this;
        }

        @JsonProperty("EUI")
        public Builder withEui(String eui) {
            this.eui = eui;
            return this;
        }

        @JsonProperty("ts")
        public Builder withTimestamp(ZonedDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        @JsonProperty("fcnt")
        public Builder withFCounter(Long fCounter) {
            this.fCounter = fCounter;
            return this;
        }

        @JsonProperty("bat")
        public Builder withBattery(Byte battery) {
            this.battery = battery;
            return this;
        }

        @JsonProperty("data")
        public Builder withData(String data) {
            this.data = data;
            return this;
        }

        public LoRaWarnSensorData build() {
            return new LoRaWarnSensorData(this);
        }
    }
}
