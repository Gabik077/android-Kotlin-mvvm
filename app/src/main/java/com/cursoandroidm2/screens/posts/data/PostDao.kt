package com.cursoandroidm2.screens.posts.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cursoandroidm2.screens.posts.data.entities.PostEntity

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(posts: PostEntity)

    @Query("SELECT * FROM posts")
    suspend fun getAllPosts(): List<PostEntity>

}