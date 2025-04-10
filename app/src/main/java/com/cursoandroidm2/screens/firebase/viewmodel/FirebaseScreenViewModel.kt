package com.cursoandroidm2.screens.firebase.viewmodel


import com.cursoandroidm2.screens.firebase.data.FirebaseScreenMessage
import com.cursoandroidm2.screens.firebase.repository.FirebaseScreenRepository

import android.os.Bundle
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.*


@HiltViewModel
class FirebaseScreenViewModel  @Inject constructor(private val chatRepository: FirebaseScreenRepository) : ViewModel() {

    var message by mutableStateOf("")
    var autor by mutableStateOf("")


    // Este es tu Flow que obtiene los mensajes
    val messagesFlow: Flow<List<FirebaseScreenMessage>> = chatRepository.getMessagesFlow()

    // Estado que se actualiza con los mensajes recolectados
    private val _messages = mutableStateOf<List<FirebaseScreenMessage>>(emptyList())
    val messages: State<List<FirebaseScreenMessage>> = _messages

    init {
        startCollectingMessages()
        chatRepository.getRemoteConfig()
    }

    fun onMessageChange(newMessage: String) {
        message = newMessage
    }
    fun onAutorChange(newAutor: String) {
        autor = newAutor
    }
        //es llamado por la vista
    fun createFirebaseMessage() {

        chatRepository.createFirebaseMessage(autor, message)//se crea el mensaje en firebase

        chatRepository.logEvent("mensaje_enviado", Bundle().apply {
            putString("autor", autor)
            putString("mensaje", message)
        })

            chatRepository.logEvent("first_open", Bundle().apply {
                putString("autor", autor)
                putString("mensaje", message)
            })


        message = ""
    }

    private fun startCollectingMessages() {
        viewModelScope.launch {
            messagesFlow.collect { newMessages ->
                _messages.value = newMessages
                Log.d("FirebaseScreenViewModel", "Messages updated: $newMessages")
            }
        }
    }


}