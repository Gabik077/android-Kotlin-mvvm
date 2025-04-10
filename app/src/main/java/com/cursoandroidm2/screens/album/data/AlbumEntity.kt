package com.cursoandroidm2.screens.album.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "album")
data class AlbumEntity(
    @PrimaryKey(autoGenerate = false) val id: Int = 0,
    val body: String,
    val title: String,
    val userId: Int,
    val thumbnailUrl: String,
    val url: String,
    val albumId: Int
)
