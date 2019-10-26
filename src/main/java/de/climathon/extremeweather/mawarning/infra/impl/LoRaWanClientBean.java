package de.climathon.extremeweather.mawarning.infra.impl;

import de.climathon.extremeweather.mawarning.domain.model.LoRaWarnSensorData;
import de.climathon.extremeweather.mawarning.infra.LoRaWanClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

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
    public LoRaWarnSensorData getTemperatureForLocation(Float longitude, Float latitude) {
        return null;
    }
}
