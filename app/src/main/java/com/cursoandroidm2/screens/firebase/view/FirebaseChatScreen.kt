package com.cursoandroidm2.screens.firebase.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cursoandroidm2.screens.firebase.view.composables.ButtonChat
import com.cursoandroidm2.screens.firebase.view.composables.TextFieldChatAutor
import com.cursoandroidm2.screens.firebase.view.composables.TextFieldChatMsg
import com.cursoandroidm2.screens.firebase.view.composables.TituloChat
import com.cursoandroidm2.screens.firebase.viewmodel.FirebaseScreenViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import com.cursoandroidm2.screens.firebase.data.FirebaseScreenMessage
import com.cursoandroidm2.screens.firebase.view.composables.MessageItem
import com.cursoandroidm2.screens.firebase.view.composables.MessageList

@Composable
fun FirebaseChatScreen() {

    val viewModel: FirebaseScreenViewModel = hiltViewModel() //se inyecta el viewmodel

    // Obtén el estado de los mensajes (esto se actualiza cada vez que el flujo emite nuevos datos)
    val messages = viewModel.messages.value


    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        TituloChat()
        MessageList(messages = messages)
        TextFieldChatAutor(autor = viewModel.autor) { viewModel.onAutorChange(it) }
        TextFieldChatMsg(msg = viewModel.message) { viewModel.onMessageChange(it) }
        ButtonChat(onLoginClick = {viewModel.createFirebaseMessage()})
    }

}







@Preview(showBackground = true)
@Composable
fun PreviewMessageList() {
    MessageList(
        messages = listOf(
            FirebaseScreenMessage("User1", "Hello"),
            FirebaseScreenMessage("User2", "How are you?")
        )
    )
}
