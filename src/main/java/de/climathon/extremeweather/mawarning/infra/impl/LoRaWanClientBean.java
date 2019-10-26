package de.climathon.extremeweather.mawarning.infra.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.climathon.extremeweather.mawarning.domain.model.DeviceRawData;
import de.climathon.extremeweather.mawarning.infra.LoRaWanClient;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoRaWanClientBean extends StompSessionHandlerAdapter implements LoRaWanClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoRaWanClientBean.class);

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        LOGGER.info("New session established : {}", session.getSessionId());
        LOGGER.info("After connected: {},{}", session, connectedHeaders);
        session.subscribe("/app", this);
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        LOGGER.info("handle Frame: {}, {}", headers, payload);
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        LOGGER.error("Exception from Websocket", exception);
    }

    @Override
    public DeviceRawData getTemperatureForLocation(Float longitude, Float latitude) {
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<List<DeviceRawData>> typeReference = new TypeReference<List<DeviceRawData>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("data_source.txt");

        try {
            List<DeviceRawData> data = objectMapper.readValue(inputStream, typeReference);

            LOGGER.debug("list read {} entries,  data {}", data.size(), data);

            data.stream().map(DeviceRawData::getTemperature).filter(Objects::nonNull).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
