package com.cursoandroidm2.screens.login.views.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cursoandroidm2.screens.login.models.LoginModel

@Composable
fun ButtonLogin(onLoginClick: () -> Unit) {
    Button(
        onClick = { onLoginClick() },
        enabled = true,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Login")
    }
}


@Preview(showBackground = true)
@Composable
fun MyPreview() {
    ButtonLogin(onLoginClick = {})
}