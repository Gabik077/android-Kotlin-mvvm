package com.cursoandroidm2.screens.users.models

import android.net.Uri
import com.google.gson.annotations.SerializedName
import java.io.File


data class UserModel(
    val address: String,
    val email: String,
    val id: Int,
    @SerializedName("last_name")
    val lastName: String,
    val name: String,
    val phone: String,
    val photo: File?,
    @SerializedName("user_name")
    val userName: String,
    val password: String

){


    companion object {
        var FILE_PHOTO : File ? = null

    }
}


