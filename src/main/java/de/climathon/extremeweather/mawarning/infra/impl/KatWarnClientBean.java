package de.climathon.extremeweather.mawarning.infra.impl;

import de.climathon.extremeweather.mawarning.domain.model.KatWarnModel;
import de.climathon.extremeweather.mawarning.infra.KatWarnClient;
import java.time.Duration;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class KatWarnClientBean implements KatWarnClient {

    @Override
    public KatWarnModel getWarningsForLocation(final Float longitude, final Float latitude) {
        return getMockData(longitude, latitude);
    }

    private KatWarnModel getMockData(float longitude, float latitude) {
        KatWarnModel model = new KatWarnModel();
        model.setLatitude(latitude);
        model.setLongitude(longitude);
        model.setFrom(LocalDateTime.now().minus(Duration.ofHours(1)));
        model.setTo(LocalDateTime.now().plus(Duration.ofHours(2)));
        if ((49.48950 >= latitude) && (latitude < 49.48959) && (8.4672 >= longitude) && (longitude < 8.4673)) {
            model.setWarningLevel("green");
            model.setWarningType(null);
        }

        if ((49.48960 >= latitude) && (latitude < 49.48990) && (8.4673 >= longitude) && (longitude < 8.4680)) {
            model.setWarningLevel("yellow");
            model.setWarningType("Sturmwarnung");
        }

        if ((49.48990 >= latitude) && (latitude < 49.49) && (8.4672 >= longitude) && (longitude < 8.4673)) {
            model.setWarningLevel("red");
            model.setWarningType("Orkan");
        }
        return model;
    }
}
