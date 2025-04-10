package com.cursoandroidm2.screens.posts.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class PostEntity(
    @PrimaryKey(autoGenerate = false) val id: Int = 0,
    val body: String,
    val title: String,
    val userId: Int
)
