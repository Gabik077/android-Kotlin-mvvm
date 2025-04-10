package com.cursoandroidm2.screens.firebase.view.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ButtonChat(onLoginClick: () -> Unit) {
    Button(
        onClick = { onLoginClick() },
        enabled = true,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Enviar Mensaje")
    }
}