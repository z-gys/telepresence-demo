package ru.zgys.demo.listener

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component
import ru.zgys.demo.dto.ChatMessage

@Component
class HistoryListener {

    @RabbitListener(queues = ["history"])
    fun historyListener(@Payload message: ChatMessage) {
        println(message.content)
    }
}