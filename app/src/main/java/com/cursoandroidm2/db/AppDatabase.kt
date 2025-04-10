package com.cursoandroidm2.db


import androidx.room.Database
import androidx.room.RoomDatabase
import com.cursoandroidm2.screens.album.data.AlbumDao
import com.cursoandroidm2.screens.album.data.AlbumEntity
import com.cursoandroidm2.screens.todo_list.data.entities.TodoEntity
import com.cursoandroidm2.screens.posts.data.PostDao
import com.cursoandroidm2.screens.posts.data.entities.PostEntity
import com.cursoandroidm2.screens.todo_list.data.TodoDao

@Database(entities = [TodoEntity::class, PostEntity::class, AlbumEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
    abstract fun postDao(): PostDao
    abstract fun albumDao(): AlbumDao

}