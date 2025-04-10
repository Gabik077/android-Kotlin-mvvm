package com.cursoandroidm2.screens.firebase.view.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cursoandroidm2.screens.firebase.data.FirebaseScreenMessage

// Composable para mostrar cada mensaje en la lista
@Composable
fun MessageItem(message: FirebaseScreenMessage) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = "Autor: ${message.author}", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = message.content, style = MaterialTheme.typography.bodyLarge)
        Text(text = "Fecha: ${message.timestamp}", style = MaterialTheme.typography.bodySmall)
    }
}