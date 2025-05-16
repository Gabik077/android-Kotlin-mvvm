package com.cursoandroidm2.screens.perfilinstagram.composables.Profile_description

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cursoandroidm2.screens.perfilinstagram.models.UserInstagram
import com.cursoandroidm2.screens.perfilinstagram.models.UserInstagramObject

@Composable
fun ProfileDescription(
    modifier: Modifier = Modifier,
    user: UserInstagram
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(text = user.name)//nunca va ser nulo
        user.description?.let {//si es nulo no lo muestra
            Text(text = it)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileDescriptionPreview() {
    ProfileDescription(user = UserInstagramObject.user)
}