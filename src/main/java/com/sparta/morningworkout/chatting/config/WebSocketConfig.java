package com.sparta.morningworkout.chatting.config;

import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketMessagingAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // 메시지 처리 활성하
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
//            WebSocketMessageBrokerConfigurer.super.registerStompEndpoints(registry);
        registry.addEndpoint("/ws")
                .setAllowedOrigins("*");
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        WebSocketMessageBrokerConfigurer.super.configureMessageBroker(registry);
        registry.enableSimpleBroker("/sub"); // receive 처리 -> sub/channel/채널아이디
        registry.setApplicationDestinationPrefixes("/pub"); // send 처리 -> pub/send
    }


}
