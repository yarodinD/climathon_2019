package de.climathon.extremeweather.mawarning.infra.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import de.climathon.extremeweather.mawarning.domain.model.WaterLevelState;
import java.io.IOException;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class WaterLevelStateConverter {

    public static class Deserialize extends JsonDeserializer<WaterLevelState> {

        @Override
        public WaterLevelState deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
                throws IOException, JsonProcessingException {
            return WaterLevelState.byValue(jsonParser.getValueAsString());
        }
    }
}
