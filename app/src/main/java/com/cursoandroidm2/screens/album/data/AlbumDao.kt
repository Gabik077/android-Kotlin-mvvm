package com.cursoandroidm2.screens.album.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cursoandroidm2.screens.posts.data.entities.PostEntity


@Dao
interface AlbumDao {
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertAlbum(posts: AlbumEntity)

        @Query("SELECT * FROM album")
        suspend fun getAlbum(): List<AlbumEntity>

    }

