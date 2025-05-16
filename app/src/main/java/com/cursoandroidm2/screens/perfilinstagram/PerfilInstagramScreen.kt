package com.cursoandroidm2.screens.perfilinstagram

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cursoandroidm2.screens.perfilinstagram.composables.Profile_description.ProfileDescription
import com.cursoandroidm2.screens.perfilinstagram.composables.header.ProfileHeader
import com.cursoandroidm2.screens.perfilinstagram.composables.instagram_profile_gallery.FullScreenStoryViewer
import com.cursoandroidm2.screens.perfilinstagram.composables.instagram_profile_gallery.InstagramProfileGallery
import com.cursoandroidm2.screens.perfilinstagram.composables.profile_action_buttons.ProfileActionButtons
import com.cursoandroidm2.screens.perfilinstagram.composables.profile_information.ProfileInformation
import com.cursoandroidm2.screens.perfilinstagram.composables.profilestory_hight_light.ProfileStoryHightLight
import com.cursoandroidm2.screens.perfilinstagram.models.Story
import com.cursoandroidm2.screens.perfilinstagram.models.UserInstagram
import com.cursoandroidm2.screens.perfilinstagram.models.UserInstagramObject
import com.cursoandroidm2.screens.perfilinstagram.models.UserInstagramObject.user

@Composable
fun PerfilInstagramScreen(modifier: Modifier = Modifier) {
    var selectedStory by remember { mutableStateOf<Story?>(null) }

    Box(
        modifier = modifier
            .fillMaxWidth()
           // .background(Color.Black)
        , contentAlignment = Alignment.Center
    ) {
    Column {

        ProfileHeader(modifier, "Gabriel Cabrera")
        ProfileInformation(modifier, user = user)
        ProfileDescription(modifier = modifier.padding(16.dp), user = user)
        ProfileActionButtons(modifier, user = user)
        Spacer(modifier = Modifier.height(8.dp))
        ProfileStoryHightLight(stories = user.stories,
                onStoryClick = { selectedStory = it },

        )
        InstagramProfileGallery(
            modifier,
            photosPerTab = listOf(
                UserInstagramObject.userPhotos,
                UserInstagramObject.userPhotos.shuffled(),//desordenar la lista sin modificar el original
                UserInstagramObject.userPhotos.take(15)//toma los primeros 15 elementos de la lista
            )
        )
    }
        // Overlay de historia si está activa
        selectedStory?.let { story ->
            FullScreenStoryViewer(
                story = story,
                onClose = { selectedStory = null },
                nextStory = { /* Lógica para pasar a la siguiente historia */ },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PerfilInstagramScreenPreview() {
    PerfilInstagramScreen()
}