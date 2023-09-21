package com.example.chatcompose.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.chatcompose.model.ChatMessage

@Composable
fun ChatListScreen(
    viewModel: MainViewModel = hiltViewModel()
) {

    val list = viewModel.chatMessageList.collectAsState().value.list
//
    LazyColumn(Modifier.fillMaxSize(), reverseLayout = true) {
        items(list) {
            ChatMessage(item = it, onRemove = viewModel::removeItem)
        }
    }
}


@Composable
fun ChatMessage(
    item: ChatMessage,
    onRemove: (ChatMessage) -> Unit
) {

    Row(
        Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clickable {
                onRemove(item)
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        Text("${item.id}")
        Text("${item.message}")

    }

}