package com.cursoandroidm2.api

import com.cursoandroidm2.screens.album.models.AlbumModel
import com.cursoandroidm2.screens.login.models.LoginModel
import com.cursoandroidm2.screens.login.models.LoginResponse
import com.cursoandroidm2.screens.posts.models.PostModel
import com.cursoandroidm2.screens.todo_list.models.TodoModel
import com.cursoandroidm2.screens.users.models.UserModel
import com.google.gson.JsonObject
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path


interface ApiService {

    @GET("users/1/todos")
    suspend fun getTodos(): List<TodoModel>

    @GET("users/1/posts")
    suspend fun getPosts(): List<PostModel>//NUEVO DATA CLASS POST

    @GET("albums/1/photos")
    suspend fun getAlbum(): List<AlbumModel>//NUEVO DATA CLASS ALBUM

    @POST("api/v1/login")
    suspend fun login(@Body loginModel: LoginModel): LoginResponse

    @GET("api/v1/users")
    suspend fun getUsers(): List<UserModel>

    @POST("api/v1/addUser")
    suspend fun createUser(@Body user: UserModel): JsonObject

    @POST("api/v1/editUser")
    suspend fun editUser(@Body user: UserModel): JsonObject

    @DELETE("api/v1/user/{id}")
    suspend fun deleteUser(@Path("id") userId: Int): JsonObject

    @Multipart
    @POST("crearUsuario") // Cambia la URL con tu endpoint
    suspend fun uploadImage(
        @Part("nombreUsuario") nombreUsuario: RequestBody,
        @Part("apellido") apellido: RequestBody,
        @Part("email") email: RequestBody,
        @Part("password") password: RequestBody,
        @Part("telefono") telefono: RequestBody,
        @Part("direccion") direccion: RequestBody,
        @Part image: MultipartBody.Part
    ): Call<JsonObject>

}
