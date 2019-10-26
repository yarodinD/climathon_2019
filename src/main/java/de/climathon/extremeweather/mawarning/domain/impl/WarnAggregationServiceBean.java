package de.climathon.extremeweather.mawarning.domain.impl;

import de.climathon.extremeweather.mawarning.domain.MeasurementDataAggregator;
import de.climathon.extremeweather.mawarning.domain.WarnAggregationService;
import de.climathon.extremeweather.mawarning.domain.model.HumidityWarnLevel;
import de.climathon.extremeweather.mawarning.domain.model.MeasurementData;
import de.climathon.extremeweather.mawarning.domain.model.staticdata.StaticData;
import de.climathon.extremeweather.mawarning.view.rs.model.WarnLevelDto;
import de.climathon.extremeweather.mawarning.view.rs.model.WarningMessages;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarnAggregationServiceBean implements WarnAggregationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WarnAggregationServiceBean.class);

    private final MeasurementDataAggregator measurementDataAggregator;

    @Autowired
    public WarnAggregationServiceBean(final MeasurementDataAggregator measurementDataAggregator) {
        this.measurementDataAggregator = measurementDataAggregator;
    }

    @Override
    public WarnLevelDto gerWarningByCoordinate(final Float longitude, final Float latitude) {

        WarnLevelDto result = new WarnLevelDto();
        result.setLongitude(longitude);
        result.setLatitude(latitude);

        List<String> resultList = new ArrayList<>();

        MeasurementData measurements = measurementDataAggregator.getMeasurements();

        Double humidity = measurements.getHumidity();
        Double temperature = measurements.getTemperature();
        Double precipitation = measurements.getPrecipitation();
        Double dewPoint = measurements.getDewPoint();
        Double windspeed = measurements.getWindspeed();

        if ((humidity == null) || (humidity < 40)) {
            resultList.add(getWarningsLowHumidity(temperature, precipitation));
        } else {
            resultList.add(getWarningByHumudityAndTemp(humidity, temperature));
        }

        if (dewPoint != null) {
            resultList.add(checkDewPoint(dewPoint));
        }

        if (windspeed != null) {
            resultList.add(checkWindspeed(windspeed, temperature));
        }

        cleanResultList(resultList);

        result.setWarnings(resultList);
        return result;
    }

    private String checkWindspeed(final Double windspeed, final Double temperature) {
        String result = WarningMessages.NO_WARNING;

        if (temperature > 26) {
            result = WarningMessages.HEAT_WINDCHILL;
        }

        if (windspeed > 74) {
            result = WarningMessages.STORM;
        }

        if (windspeed > 88) {
            result = WarningMessages.STORM_HEAVY;
        }

        if (windspeed > 102) {
            result = WarningMessages.STORM_GALE;
        }

        if (windspeed > 117) {
            result = WarningMessages.STORM_HURRICANE;
        }
        return result;
    }

    private String checkDewPoint(final Double dewPoint) {
        String result = WarningMessages.NO_WARNING;
        if (dewPoint > 15) {
            result = WarningMessages.DEW_MINOR;
        }
        if (dewPoint > 17) {
            result = WarningMessages.DEW_MEDIUM;
        }
        if (dewPoint > 22) {
            result = WarningMessages.DEW_MAJOR;
        }
        return result;
    }


    private List<String> cleanResultList(final List<String> resultList) {
        List<String> cleaned = resultList.stream().filter(s -> !s.equals(WarningMessages.NO_WARNING)).collect(Collectors.toList());
        if (cleaned.isEmpty()) {
            return List.of(WarningMessages.NO_WARNING);
        }
        return cleaned;
    }

    private String getWarningsLowHumidity(final Double temperature, final Double precipitation) {
        if (temperature == null) {
            return WarningMessages.NO_WARNING;
        }

        String result = WarningMessages.NO_WARNING;
        if (temperature < -10) {
            result = WarningMessages.COLD_EXTREME;
        }
        if (temperature < -2) {
           result = WarningMessages.COLD;
        }
        if ((temperature < 2) && (precipitation > 0)) {
            result = WarningMessages.COLD_GLAZEICE;
        }

        if (temperature > 26) {
            result = WarningMessages.HEAT_DANGER_ATTENTION;
        }
        if (temperature > 32) {
            result = WarningMessages.HEAT_DANGER_INCREASED;
        }
        if (temperature > 36) {
            result = WarningMessages.HEAT_DANGER_MEDIUM;
        }
        if (temperature > 41) {
            result = WarningMessages.HEAT_DANGER_HIGH;
        }
        return result;
    }

    private String getWarningByHumudityAndTemp(final Double humidity, final Double temperature) {
        HumidityWarnLevel humidityWarnLevel = StaticData.calculateWarnLevelByTempAndHumidity(temperature, humidity);

        String result;
        switch(humidityWarnLevel) {
            case NO_WARNING: result = WarningMessages.NO_WARNING; break;
            case VERY_LOW: result = WarningMessages.HEAT_DANGER_ATTENTION; break;
            case LOW: result = WarningMessages.HEAT_DANGER_INCREASED; break;
            case MEDIUM: result = WarningMessages.HEAT_DANGER_MEDIUM; break;
            case HIGH: result = WarningMessages.HEAT_DANGER_HIGH; break;
            default: throw new IllegalStateException();
        };

        return result;
    }
}
