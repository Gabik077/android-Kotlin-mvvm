package com.cursoandroidm2.screens.perfilinstagram.composables.instagram_profile_gallery

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.cursoandroidm2.screens.perfilinstagram.models.Story

@Composable
fun FullScreenStoryViewer(
    modifier: Modifier = Modifier,
    story: Story,
    onClose: () -> Unit,
    nextStory: () -> Unit = { } // Función para pasar a la siguiente historia
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Black)
            .clickable{ nextStory() } // pasa a la siguiente historia
        , contentAlignment = Alignment.Center
    ) {
       AsyncImage(
           model = story.storyImage,//url de la imagen
           contentDescription = "imagen de la historia",
           modifier = Modifier.fillMaxWidth()
               .aspectRatio(9f/16f),//relacion de aspecto
              contentScale = ContentScale.Crop,
           placeholder =  painterResource(id = com.cursoandroidm2.R.drawable.ic_launcher_background),
           error = painterResource(id = com.cursoandroidm2.R.drawable.ic_launcher_background) // Placeholder y error

       )
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        )
        {
            Icon(
               imageVector =  Icons.Default.Close,
                contentDescription = "Cerrar historia",
                tint = Color.White,
                modifier = Modifier
                    .padding(8.dp)
                    .size(32.dp)
                    .clickable { onClose() } // Cierra la historia al hacer clic
            )
            // Aquí puedes agregar más contenido, como el título de la historia
        }
    }

}

@Preview(showBackground = true)
@Composable
fun previewFullScreenStoryViewer() {
    FullScreenStoryViewer(
        story = Story(
            storyImage = "https://example.com/story.jpg",
            storyTitle = "Story Name"
        ),
        onClose = {}
    )
}