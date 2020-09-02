package ru.zgys.tpchat.controller

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessageHeaderAccessor
import org.springframework.stereotype.Controller
import ru.zgys.tpchat.dto.ChatMessage

@Controller
class ChatController {

    @MessageMapping("chat.sendMessage")
    @SendTo("/topic/public")
    fun sendMessage(@Payload message: ChatMessage): ChatMessage = message

    @MessageMapping("chat.addUser")
    @SendTo("/topic/public")
    fun addUser(@Payload message: ChatMessage, headerAccessor: SimpMessageHeaderAccessor): ChatMessage {
        headerAccessor.sessionAttributes?.put("username", message.sender)
        return message
    }
}