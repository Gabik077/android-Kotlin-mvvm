package com.cursoandroidm2.screens.login.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cursoandroidm2.screens.login.models.LoginModel
import com.cursoandroidm2.screens.login.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : ViewModel() {
    var username by mutableStateOf("") // MutableState para el username
    var password by mutableStateOf("") // MutableState para el password
    var showAppBar by mutableStateOf(false) // MutableState para controlar la visibilidad de la barra de herramientas

    // LiveData para el estado del login
    private val _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn: LiveData<Boolean> = _isLoggedIn //para observer el estado del login



    fun onUsernameChange(newUsername: String) {
        username = newUsername // Actualiza el estado del username
    }

    fun onPasswordChange(newPassword: String) {
        password = newPassword // Actualiza el estado del password
    }

    fun login() { //para el boton login
        viewModelScope.launch {
            try {
                _isLoggedIn.value =
                    loginRepository.login(LoginModel(username, password)) // Realiza el login
            } catch (_: Exception) {
                _isLoggedIn.value = false
            }
            _isLoggedIn.value =
                loginRepository.login(LoginModel(username, password)) // Realiza el login
        }


    }

    fun resetLoginState() {
        _isLoggedIn.value = false
    }


}