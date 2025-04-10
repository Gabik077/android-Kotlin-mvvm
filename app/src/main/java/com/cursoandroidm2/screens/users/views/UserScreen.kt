package com.cursoandroidm2.screens.users.views

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.cursoandroidm2.screens.users.models.UserModel
import com.cursoandroidm2.screens.users.viewmodel.UserViewModel
import com.cursoandroidm2.screens.users.views.composables.UserItem

@Composable
fun UserScreen(navController: NavController){
   val userViewModel: UserViewModel = hiltViewModel()

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Text("LISTA DE USUARIOS", fontSize = 24.sp , modifier = Modifier.padding(top = 20.dp))

        Spacer(modifier = Modifier.height(56.dp))

        UserListComposable(userViewModel.userList, navController, userViewModel)
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate("AddUser")
        }) {
            Text("Agregar nuevo Usuario")
        }

    }
}

@Composable
fun UserListComposable(users: List<UserModel>, navController: NavController, userViewModel: UserViewModel) {

    Column(modifier = Modifier.padding(16.dp)) {
        LazyColumn() {
            items(users.size) { index ->
                UserItem(users[index],
                onClick = { user ->
                   //accion del onclick
                    Log.d("UserScreen id", "User id: ${user.id}")

                    navController.navigate("EditUser/${user.userName}/${user.email}/${user.phone}/${user.address}/${user.password}/" +
                            "${user.name}/${user.lastName}/${user.id}")

                }, onClickBorrar = { user ->
                    //accion del onclick
                    Log.d("borrar user id", "User id: ${user.id}")
                    userViewModel.deleteUser(user.id)


                })


            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun UserScreenPreview() {
  //  UserScreen(null)
}
