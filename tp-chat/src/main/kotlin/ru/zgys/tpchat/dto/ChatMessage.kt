package ru.zgys.tpchat.dto

data class ChatMessage(
    val sender: String,
    val type: MessageType,
    val content: String? = null
)

enum class MessageType {
    CHAT, JOIN, LEAVE
}