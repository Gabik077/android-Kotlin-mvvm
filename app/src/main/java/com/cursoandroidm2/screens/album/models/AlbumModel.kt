package com.cursoandroidm2.screens.album.models

data class AlbumModel(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String,
    val body: String,
    val userId: Int
)