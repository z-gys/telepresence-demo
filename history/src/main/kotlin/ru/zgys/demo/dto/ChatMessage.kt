package ru.zgys.demo.dto

data class ChatMessage(
    val sender: String = "unknown",
    val type: MessageType = MessageType.CHAT,
    val content: String? = null
)

enum class MessageType {
    CHAT, JOIN, LEAVE
}