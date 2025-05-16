package com.cursoandroidm2.screens.perfilinstagram.composables.profile_action_buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.cursoandroidm2.screens.perfilinstagram.models.UserInstagram
import com.cursoandroidm2.screens.perfilinstagram.models.UserInstagramObject
import com.cursoandroidm2.ui.theme.SoftGray
import com.cursoandroidm2.ui.theme.black

@Composable
fun ProfileActionButtons(
    modifier: Modifier = Modifier,
    user: UserInstagram,
    onFollowClick: () -> Unit = {},
    onMessageClick: () -> Unit = {}
) {
    Row(modifier = modifier.fillMaxWidth()) {
        ProfileButton(

            text = "Seguir",
            onClick = onFollowClick,
            modifier = modifier.weight(1f).padding(start = 16.dp),
        )
        Spacer(modifier = Modifier.width(2.dp))
        ProfileButton(

            text = "Mensaje",
            onClick = onMessageClick,
            modifier = modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(2.dp))

        ProfileButton(

            text = "",
            onClick = onMessageClick,
            modifier = modifier.weight(0.5f).padding(end = 16.dp)
        )

    }
}

@Composable
fun ProfileButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Button(onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = SoftGray,
            contentColor = black,
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
        ) {

        Text(text = text)
        if(text.isEmpty()){

            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile Icon",

                )
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun ProfileActionButtonsPreview() {
    ProfileActionButtons(user = UserInstagramObject.user)
}