package com.cursoandroidm2.modules

import android.content.Context
import androidx.room.Room
import com.cursoandroidm2.db.AppDatabase
import com.cursoandroidm2.screens.album.data.AlbumDao
import com.cursoandroidm2.screens.todo_list.data.TodoDao
import com.cursoandroidm2.screens.posts.data.PostDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    fun provideTodoDao(database: AppDatabase): TodoDao {
        return database.todoDao()
    }
    @Provides
    fun providePostDao(database: AppDatabase): PostDao {
        return database.postDao()
    }
    @Provides
    fun provideAlbumDao(database: AppDatabase): AlbumDao {
        return database.albumDao()
    }

}