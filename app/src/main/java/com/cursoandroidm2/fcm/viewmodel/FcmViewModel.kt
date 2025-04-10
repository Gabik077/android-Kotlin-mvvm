package com.cursoandroidm2.fcm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cursoandroidm2.fcm.repository.FcmRepository
import javax.inject.Inject

class FcmViewModel @Inject constructor(
    private val repository: FcmRepository
) : ViewModel() {

    private val _token = MutableLiveData<String>()
    val token: LiveData<String> = _token

    fun fetchFcmToken() {

        repository.getFcmToken()
    }
}