package com.cursoandroidm2.screens.posts.views.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import com.cursoandroidm2.screens.posts.models.PostModel


@Composable
fun ItemPost(post: PostModel) {
    Column { //columna
        Row(//fila
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
          /*  AsyncImage(

                model = "https://via.placeholder.com/150/9c184f",
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(16.dp)), // Rounded corners
                contentScale = ContentScale.Crop
            )*/
            RoundedAsyncImage("https://via.placeholder.com/150/9c184f")

            Spacer(modifier = Modifier.width(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 10.dp, 16.dp, 0.dp)
            ) {


                Text(
                    post.title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
        }
        HorizontalDivider()
    }
}


@Preview(showBackground = true)
@Composable
fun ItemList() {
    ItemPost(PostModel("body", 1, "Titulo", 0))
}
