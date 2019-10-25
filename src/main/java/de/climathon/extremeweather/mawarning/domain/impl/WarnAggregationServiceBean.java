package de.climathon.extremeweather.mawarning.domain.impl;

import de.climathon.extremeweather.mawarning.domain.WarnAggregationService;
import de.climathon.extremeweather.mawarning.domain.model.KatWarnModel;
import de.climathon.extremeweather.mawarning.domain.model.LoRaWarnSensorData;
import de.climathon.extremeweather.mawarning.infra.KatWarnClient;
import de.climathon.extremeweather.mawarning.infra.LoRaWanClient;
import de.climathon.extremeweather.mawarning.view.rs.model.WarnLevelDto;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarnAggregationServiceBean implements WarnAggregationService {

    private final KatWarnClient katWarnClient;
    private final LoRaWanClient loRaWanClient;

    @Autowired
    public WarnAggregationServiceBean(final KatWarnClient katWarnClient, final LoRaWanClient loRaWanClient) {
        this.katWarnClient = katWarnClient;
        this.loRaWanClient = loRaWanClient;
    }

    @Override
    public WarnLevelDto gerWarningByCoordinate(final Float longitude, final Float latitude) {

        WarnLevelDto result = new WarnLevelDto();
        result.setLongitude(longitude);
        result.setLatitude(latitude);

        double dangerLevel = 0.0;

        KatWarnModel warningsForLocation = katWarnClient.getWarningsForLocation(longitude, latitude);
        if (warningsForLocation != KatWarnModel.NO_DATA) {
            if (warningsForLocation.getFrom().isAfter(LocalDateTime.now())) {
                dangerLevel += 3.0;
            }
            if (warningsForLocation.getFrom().isBefore(LocalDateTime.now())) {
                dangerLevel += 6.0;
            }
        }

        LoRaWarnSensorData temperature = loRaWanClient.getTemperatureForLocation(longitude, latitude);
        if (temperature != LoRaWarnSensorData.NO_DATA) {
            if (temperature.getDatapoint() > 40.0) {
                dangerLevel += 4.0;
            }
        }

        result.setWarnScore(dangerLevel);
        return result;
    }
}
