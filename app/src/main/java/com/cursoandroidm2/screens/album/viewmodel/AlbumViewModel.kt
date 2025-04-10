package com.cursoandroidm2.screens.album.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cursoandroidm2.screens.album.models.AlbumModel
import com.cursoandroidm2.screens.album.repository.AlbumRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel  @Inject constructor(private val albumRepository: AlbumRepository) : ViewModel() {
    private val _albumList = mutableStateListOf<AlbumModel>()
    val albumList: List<AlbumModel>
        get() = _albumList

    init {
        getAlbum()
    }

    private fun getAlbum() {
        viewModelScope.launch {
            try {
                _albumList.clear()
                val album = albumRepository.getAlbum()
                Log.d("PostViewModel", "posts: $album")
                _albumList.addAll(album)
            } catch (_: Exception) {
                _albumList.addAll(emptyList())
            }
        }
    }


}