package com.cursoandroidm2.screens.todo_list.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "todos")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val completed: Boolean,
    val title: String,
    val userId: Int
)