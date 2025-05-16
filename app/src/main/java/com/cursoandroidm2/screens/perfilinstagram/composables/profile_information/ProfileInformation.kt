package com.cursoandroidm2.screens.perfilinstagram.composables.profile_information

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.cursoandroidm2.screens.perfilinstagram.models.UserInstagram
import com.cursoandroidm2.screens.perfilinstagram.models.UserInstagramObject

@Composable
fun ProfileInformation(
    modifier: Modifier = Modifier,
    user: UserInstagram
) {
    Row(modifier = modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround) {
    AsyncImage(
        model = user.profileImageUr,
        contentDescription = "Profile Image",
        modifier = modifier.clip(CircleShape).height(60.dp).width(60.dp),
    )
    ProfileInformationItem(amount = user.posts, type = "Publicaciones")
    ProfileInformationItem(amount = user.followers, type = "Seguidores")
    ProfileInformationItem(amount = user.following, type = "Siguidos")

}
}







@Preview(showBackground = true)
@Composable
fun ProfileInformationPreview(){
    ProfileInformation(user = UserInstagramObject.user)
}