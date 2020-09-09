package ru.zgys.tpchat.config

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

@Configuration
@EnableWebSocketMessageBroker
class WebsocketConfig: WebSocketMessageBrokerConfigurer {

    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
        with (registry) {
            setApplicationDestinationPrefixes("/app")
            enableStompBrokerRelay("/topic/public")
                .setRelayHost("localhost")
                .setRelayPort(61613)
                .setClientLogin("guest")
                .setClientPasscode("guest")
        }
    }

    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        with(registry) {
            addEndpoint("/ws").withSockJS()
        }
    }
}