package de.climathon.extremeweather.mawarning.infra;

import de.climathon.extremeweather.mawarning.domain.model.WaterLevelData;

public interface WaterLevelClient {

    WaterLevelData getWaterLevelForRhine();
}
