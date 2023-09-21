package com.example.chatcompose.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatcompose.domain.ChatManager
import com.example.chatcompose.domain.ChatMessageState
import com.example.chatcompose.model.ChatMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val chatManager: ChatManager
) : ViewModel() {



    val chatMessageList: StateFlow<ChatMessageState> = chatManager.getChatMessageFlow().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000), ChatMessageState(emptyList())
    )


    fun removeItem(item: ChatMessage) {
        chatManager.removeItem(item)
    }
}