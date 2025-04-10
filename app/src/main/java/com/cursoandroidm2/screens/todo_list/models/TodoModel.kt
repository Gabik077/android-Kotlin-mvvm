package com.cursoandroidm2.screens.todo_list.models

data class TodoModel(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)
