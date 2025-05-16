package com.cursoandroidm2.screens.perfilinstagram.composables.instagram_profile_gallery

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.cursoandroidm2.screens.perfilinstagram.models.Photo

@Composable
fun InstagramProfileGallery(
    modifier: Modifier = Modifier,
    tabTitles: List<String> = listOf("Posts", "Reels", "Tagged"),
    photosPerTab: List<List<Photo>>
) {

    var selectedTopTabIndex by remember { mutableStateOf(0) }

    Column(modifier = modifier.fillMaxSize()) {
        // Tabs arriba del grid
        val topTabIcons = listOf(
            Icons.Default.List,     // Posts
            Icons.Default.PlayArrow,  // Reels
            Icons.Default.Person      // Tagged
        )
        TabRow(
            selectedTabIndex = selectedTopTabIndex,
            //backgroundColor = Color.White,
            contentColor = Color.Black,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[selectedTopTabIndex]),
                    color = Color.Black
                )
            }
        ){
            topTabIcons.forEachIndexed { index, icon ->
                Tab(
                    selected = selectedTopTabIndex == index,
                    onClick = { selectedTopTabIndex = index },
                    icon = {
                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            tint = if (selectedTopTabIndex == index) Color.Black else Color.Gray

                        )
                    },

                    )
            }
        }

        //Grilla de fotos
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
           // modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(2.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            items(photosPerTab[selectedTopTabIndex].size) { index ->
               AsyncImage(
                    model = photosPerTab[selectedTopTabIndex][index].url,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f) // Mantiene la relación de aspecto 1:1
                        .height(100.dp) // Altura fija para las imágenes
               )

            }
        }

// Tabs inferiores (barra tipo Instagram)

        BottomTabs(
            modifier = Modifier.wrapContentHeight()
        )
    }


}

@Preview(showBackground = true)
@Composable
fun InstagramProfileGalleryPreview() {
    InstagramProfileGallery(Modifier, photosPerTab = listOf(listOf(), listOf(), listOf()))
}
