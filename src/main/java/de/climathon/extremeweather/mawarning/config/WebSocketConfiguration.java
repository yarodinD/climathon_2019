package de.climathon.extremeweather.mawarning.config;

import de.climathon.extremeweather.mawarning.infra.impl.LoRaWanClientBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

@Configuration

public class WebSocketConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketConfiguration.class);

    public WebSocketConfiguration() {
        WebSocketClient webSocketClient = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
        stompClient.setMessageConverter(new StringMessageConverter());
        // stompClient.setTaskScheduler(taskScheduler);

        try {
            stompClient
                    .connect("wss://mvv.loriot.io/app?token=vgEAKwAAAA1tdnYubG9yaW90LmlvkdUZ1OtxmDyLCjpH81dcPg==", new LoRaWanClientBean());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
