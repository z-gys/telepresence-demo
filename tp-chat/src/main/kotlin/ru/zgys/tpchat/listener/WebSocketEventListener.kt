package ru.zgys.tpchat.listener

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.messaging.simp.SimpMessageSendingOperations
import org.springframework.messaging.simp.stomp.StompHeaderAccessor
import org.springframework.stereotype.Component
import org.springframework.web.socket.messaging.SessionConnectedEvent
import org.springframework.web.socket.messaging.SessionDisconnectEvent
import ru.zgys.tpchat.dto.ChatMessage
import ru.zgys.tpchat.dto.MessageType

@Component
class WebSocketEventListener(
    private val messagingTemplate: SimpMessageSendingOperations
) {

    companion object {
        val log: Logger = LoggerFactory.getLogger(WebSocketEventListener::class.java)
    }

    @EventListener
    fun handleWebSocketConnectListener(event: SessionConnectedEvent) = log.info("Received a new web socket connection")

    @EventListener
    fun handleWebSocketDisconnectListener(event: SessionDisconnectEvent) {
        val headerAccessor = StompHeaderAccessor.wrap(event.message)

        val username = headerAccessor.sessionAttributes?.get("username") as String?
        username?.let {
            log.info("User disconnected: $it")

            val message = ChatMessage(it, MessageType.LEAVE)
            messagingTemplate.convertAndSend("/topic/public", message)
        }
    }
}