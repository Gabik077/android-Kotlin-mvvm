package com.cursoandroidm2.screens.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun MainScreen(navController: NavController) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Menu Principal",
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(56.dp))
        Button(onClick = {
            navController.navigate("ListaDeItems")
            //   val intent = Intent(navController.context, PantallaConfiguracion::class.java)
            //  startActivity(navController.context, intent, null)

        }) {
            Text("Ir a Lista de Items")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("PostScreen")
        }) {
            Text("Ir a Lista Posts")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("AlbumScreen")
        }) {
            Text("Ir a Album")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate("FirebaseChatScreen")
        }) {
            Text("Firebase Chat")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate("FormularioFireStore")
        }) {
            Text("Formulario FireStore")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("UserScreen")
        }) {
            Text("Ir a Lista de Usuarios")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("PerfilInstagram")
        }) {
            Text("Ir a Perfil Instagram")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MyPreview() {
    MainScreen(navController = rememberNavController())
}



