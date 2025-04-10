package com.cursoandroidm2.screens.users.repository

import android.util.Log
import androidx.lifecycle.viewmodel.CreationExtras
import com.cursoandroidm2.api.ApiService
import com.cursoandroidm2.screens.todo_list.data.TodoDao
import com.cursoandroidm2.screens.users.models.UserModel
import com.google.gson.JsonObject
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: ApiService,//se inyecta la dependencia de retrofit
 )
{

    suspend fun getUsers(): List<UserModel> {
        val users: List<UserModel>
        try {
            users = api.getUsers() //trae de api
        } catch (e: Exception) {
            Log.d("UserRepository", "Error: ${e.message}")
           return emptyList()
        }

        return users
        }

    suspend  fun createUser(user: UserModel): String {
        try {
            val requestBody = user.photo?.asRequestBody("image/*".toMediaTypeOrNull())
            val imagePart = requestBody?.let {
                MultipartBody.Part.createFormData(
                    "image",
                    user.photo.name,
                    it
                )
            }
            val nombreUsuario = user.userName.toRequestBody("text/plain".toMediaTypeOrNull())
            val apellido = user.lastName.toRequestBody("text/plain".toMediaTypeOrNull())
            val email = user.email.toRequestBody("text/plain".toMediaTypeOrNull())
            val password = user.password.toRequestBody("text/plain".toMediaTypeOrNull())
            val telefono = user.phone.toRequestBody("text/plain".toMediaTypeOrNull())
            val direccion = user.address.toRequestBody("text/plain".toMediaTypeOrNull())

         if(imagePart == null) {
            Log.d("UserRepository", "Error: La imagen es nula")
            return "Error al crear usuario"

         }
          api.uploadImage(nombreUsuario, apellido, email, password, telefono, direccion, imagePart)
        } catch (e: Exception) {
            Log.d("UserRepository", "Error: ${e.message}")
            return  "Error al crear usuario"
        }

        return "Usuario creado con éxito"
    }


    suspend fun editUser(user: UserModel): String {
        try {
            api.editUser(user)
        } catch (e: Exception) {
            Log.d("UserRepository", "Error: ${e.message}")
            return  "Error al editar usuario"
        }

        return "Usuario editado con éxito"
    }

    suspend fun deleteUser(userId: Int): String {
        try {
            api.deleteUser(userId)
        } catch (e: Exception) {
            Log.d("UserRepository", "Error: ${e.message}")
            return  "Error al eliminar usuario"
        }

        return "Usuario eliminado con éxito"
    }

}