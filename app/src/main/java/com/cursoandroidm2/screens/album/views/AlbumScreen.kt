package com.cursoandroidm2.screens.album.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cursoandroidm2.screens.album.models.AlbumModel
import com.cursoandroidm2.screens.album.viewmodel.AlbumViewModel


@Composable
fun AlbumScreen(navController: NavController){

    val albumViewModel: AlbumViewModel = hiltViewModel() //se inyecta AlbumViewModel

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Text("ALBUM", fontSize = 30.sp , modifier = Modifier.padding(top = 20.dp))

        Spacer(modifier = Modifier.height(56.dp))

        GridAlbumComposable(albumViewModel.albumList)

    }
}

@Composable
fun GridAlbumComposable(itemList: List<AlbumModel>) {
    Column(modifier = Modifier.padding(16.dp)) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(150.dp), // Ajusta el tamaño de las celdas
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(itemList.size) { index  ->
                ItemAlbum(itemList[index])
            }
        }
    }
}