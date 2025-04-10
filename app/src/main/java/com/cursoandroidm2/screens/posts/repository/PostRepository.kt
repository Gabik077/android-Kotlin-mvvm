package com.cursoandroidm2.screens.posts.repository

import com.cursoandroidm2.api.ApiService
import com.cursoandroidm2.screens.todo_list.data.entities.TodoEntity
import com.cursoandroidm2.screens.posts.data.PostDao
import com.cursoandroidm2.screens.posts.data.entities.PostEntity
import com.cursoandroidm2.screens.posts.models.PostModel
import com.cursoandroidm2.screens.todo_list.models.TodoModel
import javax.inject.Inject

class PostRepository  @Inject constructor(
    private val api: ApiService,
    private val postDao: PostDao
){
    suspend fun getPosts(): List<PostModel> {
        var post : List<PostModel> = emptyList()
        try {

            val postDB = getPostsFromDB()//trae de db

            if (postDB.isEmpty()) { //si no hay datos en db
                post =   api.getPosts() //trae de api
                post.forEach {//guarda en db
                    guardarPostsDB(it)
                }
            }else{//la segunda vez que se ejecuta
                post = postDB
            }


        }catch (e: Exception){
            emptyList<PostModel>()
        }
        return  post

    }
        //BASE DE DATOS
    private suspend fun guardarPostsDB(posts: PostModel){
        val postEntity = posts.toEntity() //pasamos de modelo a entidad
        postDao.insertPost(postEntity)
    }
    private suspend fun getPostsFromDB(): List<PostModel> {
        return postDao.getAllPosts().map { it.toModel() }//pasamos de entidad a modelo
    }
    //PASA DE MODELO A ENTIDAD
    private fun PostModel.toEntity(): PostEntity {//pasamos de modelo a entidad
        return PostEntity(
            body = body,
            id = id,
            title = title,
            userId = userId
        )

    }

    private fun PostEntity.toModel(): PostModel {//pasamos de entidad a modelo
        return PostModel(
            body = body,
            id = id,
            title = title,
            userId = userId
        )
    }
}
