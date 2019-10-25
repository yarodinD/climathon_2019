package de.climathon.extremeweather.mawarning.view.rs.impl;

import de.climathon.extremeweather.mawarning.domain.WarnAggregationService;
import de.climathon.extremeweather.mawarning.view.rs.WarnController;
import de.climathon.extremeweather.mawarning.view.rs.model.WarnLevelDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/warnlevel")
public class WarnControllerBean implements WarnController {

    private final WarnAggregationService warnAggregateionService;

    @Autowired
    public WarnControllerBean(final WarnAggregationService service) {
        this.warnAggregateionService = service;
    }

    @Override
    @GetMapping("/coordinates")
    public WarnLevelDto getWarnLevelByCoordinate(@RequestParam("long") final String longitude,
                                                 @RequestParam("lat") final String latitude) {
        float longitudeAsFloat = Float.parseFloat(longitude);
        float latitudeAsFloat = Float.parseFloat(latitude);
        return warnAggregateionService.gerWarningByCoordinate(longitudeAsFloat, latitudeAsFloat);
    }

    @Override
    @GetMapping("/all")
    public List<WarnLevelDto> getWarnings() {
        return List.of();
    }


}
