package com.cursoandroidm2.screens.firebase.repository

import android.os.Bundle
import android.util.Log
import com.cursoandroidm2.screens.firebase.data.FirebaseScreenMessage
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class FirebaseScreenRepository  @Inject constructor(
    private val database: FirebaseDatabase,//instancia firebase realtime database
    private val firebaseRemoteConfig: FirebaseRemoteConfig,
    private val  firebaseAnalytics: FirebaseAnalytics
)
{

    fun createFirebaseMessage(autor: String, mensaje: String) {
        //crea un mensaje en firebase realtime database
        val message = FirebaseScreenMessage(autor, mensaje)
        database.reference.child("messages").push().setValue(message)
    }

    fun getMessagesFlow(): Flow<List<FirebaseScreenMessage>> = callbackFlow {
        val messagesReference = database.reference.child("messages")

        // Agregar listener para cambios en los datos
        val listener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val messages = dataSnapshot.children.mapNotNull {
                    it.getValue(FirebaseScreenMessage::class.java)
                }
                // Emitir los mensajes cuando haya un cambio
                trySend(messages)//envia los mensajes al flujo
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // En caso de error, puedes manejarlo aquí si es necesario
                trySend(emptyList()) // O podrías emitir un error si es adecuado
            }
        }

        // Suscribirse al listener
        messagesReference.addValueEventListener(listener)

        // Cancelar el flujo cuando ya no sea necesario
        awaitClose {
            messagesReference.removeEventListener(listener)
        }
    }

    fun getRemoteConfig() {
        firebaseRemoteConfig.fetchAndActivate()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val updated = task.result
                    Log.d("RemoteConfig", "Config updated: $updated")
                    val exampleValue = firebaseRemoteConfig.getString("map_api_key")
                    val appVersion = firebaseRemoteConfig.getString("app_version")

                    Log.d("RemoteConfig", "App Version: $appVersion")
                    Log.d("RemoteConfig", "Example Key Value: $exampleValue")
                } else {
                    Log.e("RemoteConfig", "Fetch failed", task.exception)
                }
            }
    }

    fun logEvent(eventName: String, evenValue: Bundle) {
        val customEventBundle = Bundle().apply {
            putAll(evenValue)
        }
        firebaseAnalytics.logEvent(eventName, customEventBundle)
    }



}


