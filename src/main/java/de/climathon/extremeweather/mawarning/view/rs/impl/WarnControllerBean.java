package de.climathon.extremeweather.mawarning.view.rs.impl;

import de.climathon.extremeweather.mawarning.view.rs.WarnController;
import de.climathon.extremeweather.mawarning.view.rs.model.WarnLevelDto;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/warnlevel")
public class WarnControllerBean implements WarnController {

    @Override
    @GetMapping("/coordinates")
    public WarnLevelDto getWarnLevelByCoordinate(@RequestParam("long") final String longitude,
                                                 @RequestParam("lat") final String latitude) {
        return new WarnLevelDto();
    }

    @Override
    @GetMapping("/all")
    public List<WarnLevelDto> getWarnings() {
        return List.of();
    }


}
