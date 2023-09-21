package com.example.chatcompose.model

data class ChatMessage(
    val id: Int,
    val message: String,
    val time : Long = System.currentTimeMillis()
)

val mockList = mutableListOf<ChatMessage>().apply {
    (1..30).forEach {
        add(ChatMessage(it, "$it Message"))
    }
}