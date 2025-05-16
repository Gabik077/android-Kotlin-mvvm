package com.cursoandroidm2.navigation

import android.util.Log
import com.cursoandroidm2.screens.login.views.activity.LoginInit
import com.cursoandroidm2.screens.login.viewmodel.LoginViewModel
import com.cursoandroidm2.screens.menu.MainScreen
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cursoandroidm2.screens.album.views.AlbumScreen
import com.cursoandroidm2.screens.firebase.formulario.view.FormularioScreen
import com.cursoandroidm2.screens.firebase.view.FirebaseChatScreen
import com.cursoandroidm2.screens.perfilinstagram.PerfilInstagramScreen
import com.cursoandroidm2.screens.posts.views.composables.PostScreen
import com.cursoandroidm2.screens.todo_list.views.ListaDeItems
import com.cursoandroidm2.screens.users.viewmodel.UserViewModel
import com.cursoandroidm2.screens.users.views.CreateUserScreen
import com.cursoandroidm2.screens.users.views.EditUserScreen
import com.cursoandroidm2.screens.users.views.UserScreen

@Composable
fun MainNavigation(viewModel: LoginViewModel,userviewModel: UserViewModel) {
    val context = LocalContext.current // Obtiene el contexto actual
    val navController = rememberNavController() //para la navegación entre pantallas (Compose)

    //Navigacion entre Composables
    NavHost(navController, startDestination = "login") {
        composable(route = "login") {
            LoginInit(viewModel)
        }
        composable(route = "MainScreen") {
            viewModel.showAppBar = false
            MainScreen(navController)//composable de la pantalla principal
        }

        composable(route = "ListaDeItems"){
            ListaDeItems(navController = navController)//composable lista items
        }

        composable(route = "PostScreen"){
            viewModel.showAppBar = false
            PostScreen(navController = navController)
        }
        composable(route = "AlbumScreen"){
            viewModel.showAppBar = false
            AlbumScreen(navController = navController)
        }
        composable(route = "FirebaseChatScreen"){
            viewModel.showAppBar = false
            FirebaseChatScreen()
        }
        composable(route = "FormularioFireStore"){
            viewModel.showAppBar = false
            FormularioScreen()
        }
        composable(route = "UserScreen"){
            viewModel.showAppBar = false
            UserScreen(navController)
        }

        composable(route = "AddUser"){
            viewModel.showAppBar = true
            CreateUserScreen(navController,userviewModel)
        }
        composable(route = "PerfilInstagram"){
            viewModel.showAppBar = false
            PerfilInstagramScreen()
        }

        composable("EditUser/{userName}/{email}/{phone}/{address}/{password}/{name}/{lastName}/{id}") { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName") ?: ""
            val email = backStackEntry.arguments?.getString("email") ?: ""
            val phone = backStackEntry.arguments?.getString("phone") ?: ""
            val address = backStackEntry.arguments?.getString("address") ?: ""
            val password = backStackEntry.arguments?.getString("password") ?: ""
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val lastName = backStackEntry.arguments?.getString("lastName") ?: ""
            val id = backStackEntry.arguments?.getString("id") ?: ""

            Log.d("EditUserScreen", "EditUserScreen: $userName, $email, $phone, $address, $password, $name, $lastName, $id")

            EditUserScreen(userName, email, phone, address,password,name,lastName,id.toInt(), navController)
        }

    }

    // Observar el estado de isLoggedIn desde el ViewModel
    val isLoggedIn by viewModel.isLoggedIn.observeAsState()//se escucha la variable reactiva
    Log.d("LoginViewModel", "isLoggedIn: $isLoggedIn")
    // Acción cuando isLoggedIn cambia a true
    LaunchedEffect(isLoggedIn) {
        if (isLoggedIn == true) {
            //navegar a la siguiente pantalla

            navController.navigate("MainScreen"){
                popUpTo("login") { inclusive = true } // Elimina el login de la pila de navegación
            }
        }else{
            Toast.makeText(context, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
        }
    }


}