package com.cursoandroidm2.screens.firebase.formulario.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BotonFormulario(onLoginClick: () -> Unit) {
    Button(
        onClick = { onLoginClick() },
        enabled = true,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Guardar Formulario")
    }
}