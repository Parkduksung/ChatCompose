package com.example.chatcompose.data.repo

import com.example.chatcompose.model.ChatMessage
import com.example.chatcompose.model.mockList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor() : ChatRepository {
    override val getMessage: Flow<List<ChatMessage>>
        get() = flowOf(mockList)
}