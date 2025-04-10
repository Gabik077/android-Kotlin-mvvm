package com.cursoandroidm2.screens.login.views.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import com.cursoandroidm2.screens.login.views.composables.ButtonLogin
import com.cursoandroidm2.screens.login.views.composables.PassWordField
import com.cursoandroidm2.screens.login.views.composables.TextFieldLogin
import com.cursoandroidm2.screens.login.views.composables.TituloLogin
import com.cursoandroidm2.screens.login.viewmodel.LoginViewModel

import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.hilt.navigation.compose.hiltViewModel
import com.cursoandroidm2.navigation.MainNavigation
import com.cursoandroidm2.screens.album.viewmodel.AlbumViewModel
import com.cursoandroidm2.screens.login.views.composables.AppBar
import com.cursoandroidm2.screens.users.models.UserModel
import com.cursoandroidm2.screens.users.models.UserModel.Companion.FILE_PHOTO
import com.cursoandroidm2.screens.users.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date

@AndroidEntryPoint
class Login : ComponentActivity() {

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private var cameraPhotoFilePath: Uri? = null // para mostrar la imagen en la pantalla
    private var photoFile: File? = null//enviar al servidor
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModelCreateUser: UserViewModel by viewModels()//viewmodel para crear usuario
        setContent {

            MaterialTheme {
                // Contenido principal de la aplicación
                Scaffold(
                    topBar = { AppBar(viewModel.showAppBar, ::requestCameraPermission) }
                ) { paddingValues ->
                    // Contenido de la pantalla
                    Column(modifier = Modifier.padding(paddingValues)) {
                        // Contenido de la pantalla
                        MainNavigation(viewModel,viewModelCreateUser)//navegacion
                    }
                }
            }
          /*  MaterialTheme {
                MainNavigation(viewModel)//navegacion
            }*/
        }

        //escuchar eventos del viewmodel cuando no se usa Jetpack compose
     /*   viewModel.isLoggedIn.observe(this) { isLoggedIn ->
            if (isLoggedIn) {
                //navegar a la Activity principal
                 val intent = Intent(this, MainActivity::class.java)
                 startActivity(intent)
                 finish()

            }
        }*/

        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result -> //se ejecuta despues de volver de la camara
                //RESULTADO DE LA CAMARA

                Log.d("photoFile", "onCreate: $photoFile")
                cameraPhotoFilePath?.let { uri -> //si es distinto de null muestra la foto
               //     binding.imagenUsuario.setImageURI(uri) // Muestra la imagen seleccionada en el ImageView
                    Log.d("photoFile", "onCreate: $uri")

                    //guardar la URI
                  viewModelCreateUser.filePhoto.value = photoFile!!

                    viewModelCreateUser.setUriFoto(uri ) //se obtiene la uri de la foto
                }


                //RESULTADO DE LA GALERIA
                if (result.resultCode == RESULT_OK) {

                    result.data?.data?.let { uri ->


                    }
                }

            }

    }

    companion object {
        private const val REQUEST_CODE_PERMISSIONS = 10
        private val REQUIRED_PERMISSIONS =
            mutableListOf(
                Manifest.permission.CAMERA
            ).apply {
                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
                    add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                }
            }.toTypedArray()
    }

    private fun tienePermisos() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(
            applicationContext, it
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestCameraPermission() {
        when {
            tienePermisos() -> {
               launchCamera()
            }
            else -> {
                //Abre popup para solicitar permisos
                ActivityCompat.requestPermissions(
                    this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS
                )
            }
        }
    }

    private fun launchCamera(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE) //INTENT IMPLICITO PARA ABRIR LA CAMARA
        photoFile = try {
            createImageFileInAppDir()//se crea el nombre de la imagen
        } catch (ex: IOException) {
            Toast.makeText(applicationContext, "Error creating file", Toast.LENGTH_SHORT).show()
            null
        }

        photoFile?.also { file ->
            val photoURI: Uri = FileProvider.getUriForFile(
                applicationContext,
                "curso.androidm2.provider",
                file
            )
            cameraPhotoFilePath = photoURI
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
        }

        //abre la camara
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
        resultLauncher.launch(intent) //se ejecuta la camara
    }

    @Throws(IOException::class)
    private fun createImageFileInAppDir(): File {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imagePath = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File(imagePath, "JPEG_${timeStamp}_" + ".jpg")
    }
}//CIERRA CLASE

@Composable
fun LoginInit(viewModel: LoginViewModel) {


    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        TituloLogin()
        TextFieldLogin(username = viewModel.username) { viewModel.onUsernameChange(it) }
        PassWordField(password = viewModel.password) { viewModel.onPasswordChange(it) }
        ButtonLogin(onLoginClick = {viewModel.login()})
    }

}





@Preview(showBackground = true)
@Composable
fun MyPreview() {
   // LoginInit( viewModel = LoginViewModel())
}

