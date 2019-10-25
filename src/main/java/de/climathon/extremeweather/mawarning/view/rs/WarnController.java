package de.climathon.extremeweather.mawarning.view.rs;

import de.climathon.extremeweather.mawarning.view.rs.model.WarnLevelDto;
import java.util.List;

public interface WarnController {

    WarnLevelDto getWarnLevelByCoordinate(String longitude, String latitude);

    List<WarnLevelDto> getWarnings();
}
