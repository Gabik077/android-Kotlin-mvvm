package com.cursoandroidm2.screens.firebase.formulario.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cursoandroidm2.screens.firebase.formulario.composables.BotonFormulario
import com.cursoandroidm2.global_composables.TextFieldFormulario
import com.cursoandroidm2.screens.firebase.formulario.composables.TituloFormulario
import com.cursoandroidm2.screens.firebase.formulario.viewmodel.FormularioFirebaseViewModel

@Composable
fun FormularioScreen(){

    val viewModel: FormularioFirebaseViewModel = hiltViewModel() //se inyecta el viewmodel

    Column(
    Modifier
    .fillMaxSize()
    .padding(16.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center)
    {
        TituloFormulario()
        TextFieldFormulario(viewModel.username, "Username") { viewModel.onUsernameChange(it) }
        TextFieldFormulario(viewModel.email, "Email") { viewModel.onEmailChange(it) }
        TextFieldFormulario(viewModel.age, "Edad") { viewModel.onAgeChange(it) }
        TextFieldFormulario(viewModel.productName, "nombre de producto") { viewModel.onProductNameChange(it) }
        TextFieldFormulario(viewModel.productPrice.toString(), "precio de producto") { viewModel.onProductPriceChange(it.toFloat()) }
        BotonFormulario { viewModel.insertarDatosFormulario() }
    }
}


@Preview(showBackground = true)
@Composable
fun MyPreview() {
    FormularioScreen()
}
