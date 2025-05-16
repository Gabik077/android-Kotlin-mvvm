package com.cursoandroidm2.screens.users.viewmodel

import android.net.Uri
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.cursoandroidm2.screens.todo_list.models.TodoModel
import com.cursoandroidm2.screens.todo_list.repository.TodoRepository
import com.cursoandroidm2.screens.users.models.UserModel
import com.cursoandroidm2.screens.users.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    private val _userList = mutableStateListOf<UserModel>()
    var username by mutableStateOf("")
    var email by mutableStateOf("")
    var phone by mutableStateOf("")
    var address by mutableStateOf("")
    var lastname by mutableStateOf("")
    var password by mutableStateOf("")
    var password2 by mutableStateOf("")
    var name by mutableStateOf("")
    var id by mutableStateOf(0)
    val filePhoto = mutableStateOf<File?>(null)

    private val _uriFoto = MutableStateFlow<Uri?>(null)
    val uriFoto: StateFlow<Uri?> = _uriFoto
    fun setUriFoto(uri: Uri) {
        _uriFoto.value = uri
    }



    fun onUsernameChange(username: String) {
        this.username = username
    }
    fun onEmailChange(email: String) {
        this.email = email
    }
    fun onPhoneChange(phone: String) {
        this.phone = phone
    }
    fun onAddressChange(address: String) {
        this.address = address
    }
    fun onLastnameChange(lastname: String) {
        this.lastname = lastname
    }
    fun onPasswordChange(password: String) {
        this.password = password
    }
    fun onPassword2Change(password2: String) {
        this.password2 = password2
    }
    fun onNameChange(name: String) {
        this.name = name
    }


    val userList: List<UserModel>
        get() = _userList

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            try {
                _userList.clear()
                _userList.addAll(userRepository.getUsers())
                Log.d("UserViewModel", "UserList: ${_userList.size}")
            } catch (e: Exception) {
                _userList.clear()
            }

        }
    }

    fun createUser() {


        viewModelScope.launch {
            try {
                userRepository.createUser(
                    UserModel(
                        address = address,
                        email = email,
                        id = 0,
                        lastName = lastname,
                        name = name,
                        phone = phone,
                        photo = filePhoto.value,
                        userName = username,
                        password = password
                    )
                )
            } catch (e: Exception) {
                _userList.clear()
            }

        }
    }

    fun updateUser() {
        viewModelScope.launch {
            try {
                userRepository.editUser(
                    UserModel(
                        address = address,
                        email = email,
                        id = id,
                        lastName = lastname,
                        name = name,
                        phone = phone,
                        photo = null,
                        userName = username,
                        password = password
                    )
                )
            } catch (e: Exception) {
                _userList.clear()
            }

        }
    }

    fun deleteUser(id: Int) {
        viewModelScope.launch {
            try {
                userRepository.deleteUser(id)
                getUsers()
            } catch (e: Exception) {
                _userList.clear()
            }

        }
    }
}