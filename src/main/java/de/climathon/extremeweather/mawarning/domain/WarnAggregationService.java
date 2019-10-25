package de.climathon.extremeweather.mawarning.domain;

import de.climathon.extremeweather.mawarning.view.rs.model.WarnLevelDto;

public interface WarnAggregationService {

    WarnLevelDto gerWarningByCoordinate(Float longitude, Float latitude);

}
