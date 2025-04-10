package com.cursoandroidm2.screens.users.views.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun BotonEditarUsuario(onLoginClick: () -> Unit) {
    Button(
        onClick = { onLoginClick() },
        enabled = true,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Editar Usuario")
    }
}