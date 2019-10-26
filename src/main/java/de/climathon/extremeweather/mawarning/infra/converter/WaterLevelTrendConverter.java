package de.climathon.extremeweather.mawarning.infra.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import de.climathon.extremeweather.mawarning.domain.model.WaterLevelTrend;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class WaterLevelTrendConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(WaterLevelTrendConverter.class);

    public static class Deserialize extends JsonDeserializer<WaterLevelTrend> {

        @Override
        public WaterLevelTrend deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
                throws IOException, JsonProcessingException {

            String valueAsString = jsonParser.getValueAsString();
            try {
                Integer value = Integer.valueOf(valueAsString);
                return WaterLevelTrend.byValue(value);
            } catch (NumberFormatException e) {
                LOGGER.warn("Unknown value for WaterLevelTrend: {}", valueAsString);
                return null;
            }
        }
    }
}
