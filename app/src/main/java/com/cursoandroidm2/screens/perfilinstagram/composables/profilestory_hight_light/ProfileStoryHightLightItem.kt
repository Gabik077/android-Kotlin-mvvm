package com.cursoandroidm2.screens.perfilinstagram.composables.profilestory_hight_light

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.cursoandroidm2.screens.perfilinstagram.models.Story

@Composable
fun ProfileStoryHightLightItem(
    modifier: Modifier = Modifier,
    story: Story,
    onClick: () -> Unit
) {
   Column(modifier = modifier,
       horizontalAlignment = Alignment.CenterHorizontally) {
           AsyncImage(

               model = story.storyImage,
                contentDescription = "Story Image",
               modifier = modifier
                   .clip(CircleShape)
                   .height(60.dp)
                   .width(60.dp)
                   .clickable(onClick = onClick) // Añadir el clickeable aquí
               ,
               placeholder = painterResource(id = com.cursoandroidm2.R.drawable.ic_launcher_background),
               error = painterResource(id = com.cursoandroidm2.R.drawable.ic_launcher_background),

           )
       @Composable
       fun ProfileStoryHightLightItem(
           modifier: Modifier = Modifier,
           story: Story,
           onClick: () -> Unit
       ) {
           Column(modifier = modifier,
               horizontalAlignment = Alignment.CenterHorizontally) {
               AsyncImage(

                   model = story.storyImage,
                   contentDescription = "Story Image",
                   modifier = modifier
                       .clip(CircleShape)
                       .height(60.dp)
                       .width(60.dp)
                       .clickable(onClick = onClick) // Añadir el clickeable aquí
                   ,
                   placeholder = painterResource(id = com.cursoandroidm2.R.drawable.ic_launcher_background),
                   error = painterResource(id = com.cursoandroidm2.R.drawable.ic_launcher_background),

                   )
               Spacer(modifier = Modifier.height(4.dp))
               Text(
                   text = story.storyTitle,
                   style = MaterialTheme.typography.bodySmall,
                   textAlign = TextAlign.Center
               )
           }
       }
       Spacer(modifier = Modifier.height(4.dp))
         Text(
              text = story.storyTitle,
              style = MaterialTheme.typography.bodySmall,
              textAlign = TextAlign.Center
         )
   }
}

@Preview(showBackground = true)
@Composable
fun ProfileStoryHightLightItemPreview() {
    ProfileStoryHightLightItem(story = Story(
        storyImage = "https://example.com/story.jpg",
        storyTitle = "Story Name"

    ),
            onClick = {}
    )
}