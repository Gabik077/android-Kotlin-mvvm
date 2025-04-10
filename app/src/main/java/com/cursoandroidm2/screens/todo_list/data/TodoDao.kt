package com.cursoandroidm2.screens.todo_list.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cursoandroidm2.screens.todo_list.data.entities.TodoEntity


@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodos(todos: TodoEntity)

    @Query("SELECT * FROM todos")
    suspend fun getAllTodos(): List<TodoEntity>

}