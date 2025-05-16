package com.cursoandroidm2.screens.login.repository

import android.util.Log
import com.cursoandroidm2.api.ApiService
import com.cursoandroidm2.screens.album.models.AlbumModel
import com.cursoandroidm2.screens.login.models.LoginModel
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val apiService: ApiService,
) {
   suspend fun login(loginModel: LoginModel): Boolean {
        Log.d("LoginRepository", "Realizando login con datos: $loginModel")

       try {
           //val loginData = apiService.login(loginModel)//trae de db

          // Log.d("LoginRepository", "Login exitoso: ${loginData.user_name} - ${loginData.status}")
           return true//loginData.status == "ok" // retorna true o false

       } catch (e: Exception) {
           Log.d("LoginRepository", "Error: ${e.message}")
           emptyList<AlbumModel>()
       }

         return false
    }
}
//MVVM

suspend fun getAlbum(): List<AlbumModel> {
    var album: List<AlbumModel> = emptyList()



    return album
}