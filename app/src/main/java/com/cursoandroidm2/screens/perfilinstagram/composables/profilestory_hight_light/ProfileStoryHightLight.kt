package com.cursoandroidm2.screens.perfilinstagram.composables.profilestory_hight_light

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cursoandroidm2.screens.perfilinstagram.models.Story
import com.cursoandroidm2.screens.perfilinstagram.models.UserInstagramObject

@Composable
fun ProfileStoryHightLight(
    modifier: Modifier = Modifier,
    stories: List<Story>,
    onStoryClick: (Story) -> Unit
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        items(stories.size) {
            ProfileStoryHightLightItem(
                story = stories[it], //item de la historia
                modifier = Modifier.padding(horizontal = 4.dp),// Espacio entre ítems
                onClick = { onStoryClick(stories[it]) } // Accion al hacer click
            )
        }

    }

}

 @Preview(showBackground = true)
    @Composable
    fun ProfileStoryHightLightPreview() {
        ProfileStoryHightLight(stories = UserInstagramObject.user.stories,
            onStoryClick = {}
        )
    }
