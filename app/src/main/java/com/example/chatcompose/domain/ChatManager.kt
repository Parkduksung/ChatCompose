package com.example.chatcompose.domain

import android.util.Log
import com.example.chatcompose.model.ChatMessage
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Singleton
class ChatManager @Inject constructor(getChatMessageUseCase: GetChatMessageUseCase) :
    CoroutineScope {


    private val _chatMessageList = mutableListOf<ChatMessage>()

    private val _chatMessageFlow = MutableStateFlow(ChatMessageState(emptyList()))
    private val chatMessageFlow: StateFlow<ChatMessageState> = _chatMessageFlow.asStateFlow()

    private val errorHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e("ChatManager", "Error: $throwable")
    }

    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + errorHandler


    fun getChatMessageFlow(): StateFlow<ChatMessageState> = chatMessageFlow

    init {
        getChatMessageUseCase().onEach {
            _chatMessageList.addAll(it)
            _chatMessageFlow.emit(ChatMessageState(_chatMessageList.toList().sortedByDescending { it.time }))
        }.launchIn(this)

    }

    fun removeItem(item: ChatMessage) {
        launch {
            _chatMessageList.remove(item)
            _chatMessageFlow.emit(ChatMessageState(_chatMessageList.toList()))
        }
    }

}

data class ChatMessageState(
    val list: List<ChatMessage>,
)