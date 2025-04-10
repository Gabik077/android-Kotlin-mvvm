package com.cursoandroidm2.screens.todo_list.views

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.activityViewModels
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cursoandroidm2.screens.todo_list.models.TodoModel
import com.cursoandroidm2.screens.todo_list.viewmodel.TodoViewModel
import javax.inject.Inject


@Composable
fun ListaDeItems(navController: NavController) {

     val todoViewModel: TodoViewModel = hiltViewModel()


    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Text("TODO LIST", fontSize = 30.sp , modifier = Modifier.padding(top = 20.dp))

        Spacer(modifier = Modifier.height(56.dp))

        ListComposable(todoViewModel.tareas)

    }
}


@Composable
fun ListComposable(tareas: List<TodoModel>) {

        Column(modifier = Modifier.padding(16.dp)) {
            LazyColumn(modifier = Modifier.fillMaxHeight()) {
               items(tareas.size) { index ->
                   ItemListTodo(tareas[index])
                }

            }

        }


}


@Preview(showBackground = true)
@Composable
fun MyPreview() {
    ListaDeItems(navController = rememberNavController())
}
