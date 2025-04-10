package com.cursoandroidm2.screens.firebase.view.composables

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TituloChat() {
    Text(
        text ="Firebase Chat",
        fontSize = 30.sp,
    )
    Spacer(modifier = Modifier.height(16.dp))
}
