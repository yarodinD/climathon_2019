package de.climathon.extremeweather.mawarning.domain.model.staticdata;


import de.climathon.extremeweather.mawarning.domain.model.HumidityWarnLevel;
import org.springframework.util.Assert;

public class StaticData {

    // temperature to humidity relations; values indicate felt temperatures;
    // danger levels are defined by ranges on those values
    public static final Integer[][] TEMP_HUMIDITY_LEVELS = {
            {27, 28, 29, 30, 31, 32, 34, 35, 37, 39, 41, 43, 46, 48, 51, 54, 57},
            {27, 28, 29, 30, 32, 33, 35, 37, 39, 41, 43, 46, 49, 51, 54, 57, 99},
            {27, 28, 30, 31, 33, 34, 36, 38, 41, 43, 46, 49, 52, 55, 58, 99, 99},
            {28, 29, 30, 32, 34, 36, 38, 40, 43, 46, 48, 52, 55, 59, 99, 99, 99},
            {28, 29, 31, 33, 35, 37, 40, 42, 45, 48, 51, 55, 59, 99, 99, 99, 99},
            {28, 30, 32, 34, 36, 39, 41, 44, 48, 51, 55, 59, 99, 99, 99, 99, 99},
            {29, 31, 33, 35, 38, 40, 43, 47, 50, 54, 58, 99, 99, 99, 99, 99, 99},
            {29, 31, 34, 36, 39, 42, 46, 49, 53, 58, 99, 99, 99, 99, 99, 99, 99},
            {30, 32, 35, 38, 41, 44, 48, 52, 57, 99, 99, 99, 99, 99, 99, 99, 99},
            {30, 33, 36, 39, 43, 47, 51, 55, 99, 99, 99, 99, 99, 99, 99, 99, 99},
            {31, 34, 37, 41, 45, 49, 54, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99},
            {31, 35, 38, 42, 47, 51, 57, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99},
            {32, 36, 40, 44, 49, 54, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99}
    };

    public static HumidityWarnLevel calculateWarnLevelByTempAndHumidity(final Double temperature, final Double humidity) {
        Assert.notNull(temperature, "Temperature must not be null");
        Assert.notNull(humidity, "Humidity must not be null");

        int roundedTemp = Double.valueOf(Math.floor(temperature)).intValue();
        int roundedHumidity = (Double.valueOf(Math.floor(humidity)).intValue() / 5) * 5;

        if ((roundedTemp < 27) || (roundedHumidity < 40)) {
            return HumidityWarnLevel.NO_WARNING;
        }

        if (roundedTemp > 43) {
            return HumidityWarnLevel.HIGH;
        }

        Integer feltTemp = TEMP_HUMIDITY_LEVELS[roundedHumidity - 40][roundedTemp - 27];

        if (feltTemp >= 27 && feltTemp <=32) {
            return HumidityWarnLevel.VERY_LOW;
        }

        if (feltTemp > 32 && feltTemp <= 40) {
            return HumidityWarnLevel.LOW;
        }

        if (feltTemp > 40 && feltTemp <=54) {
            return HumidityWarnLevel.MEDIUM;
        }

        if (feltTemp > 54) {
            return HumidityWarnLevel.HIGH;
        }
        return HumidityWarnLevel.UNKNOWN;
    }
}
