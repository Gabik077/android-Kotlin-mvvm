package com.cursoandroidm2.screens.todo_list.repository

import com.cursoandroidm2.api.ApiService
import com.cursoandroidm2.screens.todo_list.data.TodoDao
import com.cursoandroidm2.screens.todo_list.data.entities.TodoEntity
import com.cursoandroidm2.screens.todo_list.models.TodoModel
import javax.inject.Inject

class TodoRepository  @Inject constructor(
    private val api: ApiService,//se inyecta la dependencia del data soruce api
    private val todoDao: TodoDao, //se inyecta la dependencia del data source db
    ){

    suspend fun getTareas(): List<TodoModel> {
        var todos : List<TodoModel> = emptyList()
         try {

             val tareasDB = getTareasDB()//trae de db

            if (tareasDB.isEmpty()) { //si no hay datos en db
                    todos =   api.getTodos() //trae de api
                    todos.forEach {
                        saveTareasDB(it)
                    }
             }else{
                    todos = tareasDB
             }


        }catch (e: Exception){
         emptyList<TodoModel>()
        }
        return  todos

    }

    private suspend fun saveTareasDB(todos: TodoModel){
        val todoEntity = todos.toEntity() //pasamos de modelo a entidad
        todoDao.insertTodos(todoEntity)
    }
    private suspend fun getTareasDB(): List<TodoModel> {
        return todoDao.getAllTodos().map { it.toModel() }
    }
        //PASA DE MODELO A ENTIDAD
    private fun TodoModel.toEntity(): TodoEntity {
        return TodoEntity(
            title = title,
            id = id,
            completed = completed,
            userId = userId
            )

    }

    private fun TodoEntity.toModel(): TodoModel {
        return TodoModel(
            title = title,
            id = id,
            completed = completed,
            userId = userId
        )
    }
}