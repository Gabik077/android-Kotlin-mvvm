package com.cursoandroidm2.screens.login.views.composables

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(showAppBar: Boolean = true, requestCameraPermission: () -> Unit) {
    if (!showAppBar) return
    TopAppBar(
        title = { Text(text = "Jetpack Compose App") },
        actions = {
            IconButton(onClick = { requestCameraPermission() }) {
                Icon(
                    imageVector = Icons.Filled.AddCircle,
                    contentDescription = "Abrir cámara"
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

        // Vista previa de la barra de herramientas y la vista de foto
       AppBar(true,{})

}