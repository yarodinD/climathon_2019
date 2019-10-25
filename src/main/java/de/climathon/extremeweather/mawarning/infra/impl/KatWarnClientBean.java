package de.climathon.extremeweather.mawarning.infra.impl;

import de.climathon.extremeweather.mawarning.domain.model.KatWarnModel;
import de.climathon.extremeweather.mawarning.infra.KatWarnClient;
import org.springframework.stereotype.Component;

@Component
public class KatWarnClientBean implements KatWarnClient {

    @Override
    public KatWarnModel getWarningsForLocation(final Float longitude, final Float latitude) {
        return KatWarnModel.NO_DATA;
    }
}
