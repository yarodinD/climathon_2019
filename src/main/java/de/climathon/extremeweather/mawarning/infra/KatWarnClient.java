package de.climathon.extremeweather.mawarning.infra;

import de.climathon.extremeweather.mawarning.domain.model.KatWarnModel;

public interface KatWarnClient {
    KatWarnModel getWarningsForLocation(Float longitude, Float latitude);
}
