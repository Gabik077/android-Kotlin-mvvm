package com.cursoandroidm2.screens.firebase.formulario.repository

import com.cursoandroidm2.screens.firebase.formulario.FormularioUsuario
import com.cursoandroidm2.screens.firebase.formulario.data.FormularioProducto
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import javax.inject.Inject

class FormularioFirebaseRepository  @Inject constructor(
    private val firestore: FirebaseFirestore
)
{

    fun addUser(user: FormularioUsuario, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        firestore.collection("users")
            .add(user)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { exception -> onFailure(exception) }
    }
    fun addProduct(product: FormularioProducto, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        firestore.collection("products")
            .add(product)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { exception -> onFailure(exception) }
    }
}