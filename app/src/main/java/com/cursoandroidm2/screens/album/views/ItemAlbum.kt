package com.cursoandroidm2.screens.album.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.cursoandroidm2.screens.album.models.AlbumModel
import com.cursoandroidm2.screens.posts.models.PostModel
import com.cursoandroidm2.screens.posts.views.composables.ItemPost

@Composable
fun ItemAlbum(album: AlbumModel) {
    Column { //columna

             //COIL
              AsyncImage(

                  model = album.thumbnailUrl,
                  contentDescription = null,
                  modifier = Modifier
                      .size(150.dp)

              )


            Spacer(modifier = Modifier.width(12.dp))

                Text(
                    album.title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

            Spacer(modifier = Modifier.width(12.dp))
        }
      //  HorizontalDivider()

}


@Preview(showBackground = true)
@Composable
fun ItemList() {
    ItemPost(PostModel("body", 1, "Titulo", 0))
}
