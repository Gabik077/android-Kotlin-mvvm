package com.cursoandroidm2.screens.firebase.view.composables

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cursoandroidm2.screens.firebase.data.FirebaseScreenMessage

// Composable para mostrar la lista completa de mensajes
@Composable
fun MessageList(messages: List<FirebaseScreenMessage>) {
    LazyColumn(
        modifier = Modifier.height(450.dp)  // Establece la altura fija de la lista
    ) {
        items(messages) { message ->
            MessageItem(message = message)
        }
    }
}