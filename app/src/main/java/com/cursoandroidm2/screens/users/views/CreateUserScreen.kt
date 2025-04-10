package com.cursoandroidm2.screens.users.views

import android.graphics.BitmapFactory
import android.net.Uri

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavController
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter


import com.cursoandroidm2.global_composables.TextFieldFormulario
import com.cursoandroidm2.screens.firebase.viewmodel.FirebaseScreenViewModel
import com.cursoandroidm2.screens.users.models.UserModel
import com.cursoandroidm2.screens.users.models.UserModel.Companion.FILE_PHOTO
import com.cursoandroidm2.screens.users.viewmodel.UserViewModel
import com.cursoandroidm2.screens.users.views.composables.BotonFormularioUsuario
import com.cursoandroidm2.screens.users.views.composables.TituloFormularioUsuario
@Composable
fun CreateUserScreen(navController: NavController,
                     viewModel: UserViewModel = hiltViewModel()) {


    val uri by viewModel.uriFoto.collectAsState() // se escucha el flujo de la URI


    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
      )
    {
        TituloFormularioUsuario()

        uri?.let {

            PhotoViewer(it)

        } ?: run {
            Log.d("TAG", "No hay foto")
        }


        TextFieldFormulario(viewModel.username, "Username") {viewModel.onUsernameChange(it) }
        TextFieldFormulario(viewModel.password, "Password") { viewModel.onPasswordChange(it) }
        TextFieldFormulario(viewModel.password2, "Password2") { viewModel.onPassword2Change(it) }
        TextFieldFormulario(viewModel.name, "Name") { viewModel.onNameChange(it) }
        TextFieldFormulario(viewModel.lastname, "Lastname") { viewModel.onLastnameChange(it) }
        TextFieldFormulario(viewModel.email, "Email") { viewModel.onEmailChange(it) }
        TextFieldFormulario(viewModel.phone, "Phone") { viewModel.onPhoneChange(it) }
        TextFieldFormulario(viewModel.address, "Address") { viewModel.onAddressChange(it) }

        Spacer(modifier = Modifier.height(16.dp))
        BotonFormularioUsuario {
          Log.d("FILE_PHOTO", viewModel.filePhoto.value?.absolutePath ?: "No hay foto")
            viewModel.createUser()
       navController.navigate("UserScreen")
        }
    }
}



@Composable
fun PhotoViewer(uri: Uri?) {

        // Usamos ContentResolver para obtener un InputStream de la URI
    Log.d("TAG", "PhotoViewer: $uri")


    if(uri.toString().isEmpty()){
        Log.d("TAG", "No hay foto")
        return

    }

    uri?.let {
        Image(
            painter = rememberAsyncImagePainter(it),
            contentDescription = "Imagen de perfil",
            modifier = Modifier.size(100.dp)
        )
    }



}

@Preview(showBackground = true)
@Composable
fun MyPreview() {
 //   CreateUserScreen()
}
