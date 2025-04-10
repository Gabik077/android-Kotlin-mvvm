package com.cursoandroidm2.fcm.repository

import android.content.Context
import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import javax.inject.Inject

class FcmRepository @Inject constructor(
   private val fcm: FirebaseMessaging
) {

    fun getFcmToken() {
        fcm.token.addOnCompleteListener { task ->
            // Si la tarea no es exitosa, muestra un mensaje de advertencia
            if (!task.isSuccessful) {
                Log.w("ERROR FCM", "Fetching FCM registration token failed", task.exception)
                return@addOnCompleteListener
            }

            // Si la tarea fue exitosa, imprime el token
            val token = task.result
            Log.d("FcmRepository", "FCM Token: $token")
        }
    }
}