package com.cursoandroidm2.screens.users.views

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cursoandroidm2.global_composables.TextFieldFormulario
import com.cursoandroidm2.screens.users.viewmodel.UserViewModel
import com.cursoandroidm2.screens.users.views.composables.BotonEditarUsuario
import com.cursoandroidm2.screens.users.views.composables.TextFieldEditUser
import com.cursoandroidm2.screens.users.views.composables.TituloEditarUsuario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun EditUserScreen(userName: String, email: String, phone: String, address: String,password: String,name: String, lastName: String,id: Int, navController: NavController) {
    val viewModel: UserViewModel = hiltViewModel() //se inyecta el viewmodel
    Log.d("EditUserScreen", "EditUserScreen: $userName, $email, $phone, $address, $password, $name, $lastName, $id")

    // Inicializa el estado del ViewModel con los parámetros pasados
    LaunchedEffect(userName, email, phone, address, password,name,lastName,id) {

        // Solo inicializa los valores si están vacíos (por ejemplo, si se cargan por primera vez)
        viewModel.username = userName
        viewModel.email = email
        viewModel.phone = phone
        viewModel.address = address
        viewModel.password = password
        viewModel.name = name
        viewModel.lastname = lastName
        viewModel.id = id
    }



    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {

        TituloEditarUsuario()



        TextFieldEditUser(viewModel.username, "Nombre de Usuario") {viewModel.onUsernameChange(it) }
        TextFieldEditUser(viewModel.password, "Contraseña") { viewModel.onPasswordChange(it) }
        TextFieldEditUser(viewModel.name, "Nombre") {viewModel.onNameChange(it) }
        TextFieldEditUser(viewModel.lastname, "Apellido") {viewModel.onLastnameChange(it) }
        TextFieldEditUser(viewModel.email, "Correo") { viewModel.onEmailChange(it) }
        TextFieldEditUser(viewModel.phone, "Teléfono") { viewModel.onPhoneChange(it) }
        TextFieldEditUser(viewModel.address, "Dirección") { viewModel.onAddressChange(it) }



        Spacer(modifier = Modifier.height(16.dp))

        // Botón para actualizar el usuario
        BotonEditarUsuario {

            CoroutineScope(Dispatchers.Main).launch {
                // Esperamos que termine la actualización del usuario
                viewModel.updateUser()

                // Navegamos a la pantalla de lista de usuarios después de que termine
                navController.navigate("UserScreen")
            }

        }

    }
}


@Preview(showBackground = true)
@Composable
fun MyPreviewEditUserScreen() {

}
