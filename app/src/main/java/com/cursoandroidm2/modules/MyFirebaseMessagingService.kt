package com.cursoandroidm2.modules

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        // Manejar el mensaje aquí
        remoteMessage.data.isNotEmpty().let {
            val data = remoteMessage.data
            // Puedes manejar la data aquí
            Log.d("MyFirebaseMessagingService", "Data: $data")
        }

        remoteMessage.notification?.let {
            val title = it.title
            val body = it.body
            // Aquí puedes mostrar una notificación si es necesario
        }
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        // Enviar el token al servidor si es necesario
        Log.d("MyFirebaseMessagingService", "Token: $token")

        val sharedPreferences = getSharedPreferences("sharedPref", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("firebaseToken", token)
        editor.apply()
        //enviar al backend
    }
}
