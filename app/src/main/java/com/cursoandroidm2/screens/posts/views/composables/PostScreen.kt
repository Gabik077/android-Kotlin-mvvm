package com.cursoandroidm2.screens.posts.views.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cursoandroidm2.screens.posts.models.PostModel
import com.cursoandroidm2.screens.posts.viewmodel.PostViewModel

@Composable
fun PostScreen(navController: NavController){

    val postViewModel: PostViewModel = hiltViewModel()

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Text("POST LIST", fontSize = 30.sp , modifier = Modifier.padding(top = 20.dp))

        Spacer(modifier = Modifier.height(56.dp))

        ListPostComposable(postViewModel.posts)

    }
}

@Composable
fun ListPostComposable(tareas: List<PostModel>) {

    Column(modifier = Modifier.padding(16.dp)) {
        LazyColumn(modifier = Modifier.fillMaxHeight()) {
            items(tareas.size) { index ->
                ItemPost(tareas[index])
            }

        }

    }


}