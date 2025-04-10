package com.cursoandroidm2.screens.firebase.formulario.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.cursoandroidm2.screens.firebase.formulario.FormularioUsuario
import com.cursoandroidm2.screens.firebase.formulario.data.FormularioProducto
import com.cursoandroidm2.screens.firebase.formulario.repository.FormularioFirebaseRepository
import com.cursoandroidm2.screens.firebase.repository.FirebaseScreenRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class FormularioFirebaseViewModel  @Inject constructor(private val formularioRepository: FormularioFirebaseRepository) : ViewModel() {

    //valores para el formulario
    var age by mutableStateOf("")
    var username by mutableStateOf("")
    var email by mutableStateOf("")

    var productName by mutableStateOf("")
    var productPrice by mutableFloatStateOf(0f)

    fun onAgeChange(newage: String) {
        age = newage
    }
    fun onUsernameChange(newuser: String) {
        username = newuser
    }
    fun onEmailChange(newemail: String) {
        email = newemail
    }
    fun onProductNameChange(newMessage: String) {
        productName = newMessage
    }
    fun onProductPriceChange(newprice: Float) {
        productPrice = newprice
    }



    fun insertarDatosFormulario() {
        val usuario = FormularioUsuario(username, email, age)
        val producto = FormularioProducto(productName, productPrice)

        formularioRepository.addUser(
            usuario,
            onSuccess = { println("User added successfully") },
            onFailure = { exception -> println("Error adding user: $exception") }
        )

        formularioRepository.addProduct(
            producto,
            onSuccess = { println("Product added successfully") },
            onFailure = { exception -> println("Error adding product: $exception") }
        )

        username = ""
        email = ""
        age = ""
        productName = ""
        productPrice = 0f
    }



}