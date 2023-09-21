package com.example.chatcompose.domain

import com.example.chatcompose.data.repo.ChatRepository
import javax.inject.Inject

class GetChatMessageUseCase @Inject constructor(private val chatRepository: ChatRepository) {
    operator fun invoke() = chatRepository.getMessage
}