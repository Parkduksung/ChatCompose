package com.example.chatcompose.data.repo

import com.example.chatcompose.model.ChatMessage
import kotlinx.coroutines.flow.Flow

interface ChatRepository {

    val getMessage : Flow<List<ChatMessage>>
}