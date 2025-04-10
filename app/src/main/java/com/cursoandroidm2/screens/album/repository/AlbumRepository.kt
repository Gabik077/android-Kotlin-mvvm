package com.cursoandroidm2.screens.album.repository

import android.util.Log
import com.cursoandroidm2.api.ApiService
import com.cursoandroidm2.screens.album.data.AlbumDao
import com.cursoandroidm2.screens.album.data.AlbumEntity
import com.cursoandroidm2.screens.album.models.AlbumModel
import com.cursoandroidm2.screens.posts.models.PostModel

import javax.inject.Inject

class AlbumRepository @Inject constructor(
    private val api: ApiService,
    private val albumDao: AlbumDao
) {

    suspend fun getAlbum(): List<AlbumModel> {
        var album: List<AlbumModel> = emptyList()

        try {

           val albumDB = getAlbumFromDB()//trae de db
            if (albumDB.isEmpty()) {

                album = api.getAlbum()//trae de api
                album.forEach {
                    guardarAlbumsDB(it)//guarda en db
                }
            }else
            {
                album = albumDB
            }



        } catch (e: Exception) {
            Log.d("AlbumRepository", "Error: ${e.message}")
            emptyList<AlbumModel>()
        }

        return album
    }

    private suspend fun guardarAlbumsDB(album: AlbumModel){
        val albumEntity = album.toEntity() //pasamos de modelo a entidad
        albumDao.insertAlbum(albumEntity)
    }

    private suspend fun getAlbumFromDB(): List<AlbumModel> {
        return albumDao.getAlbum().map { it.toModel() }//pasamos de entidad a modelo
    }

    //PASA DE MODELO A ENTIDAD
    private fun AlbumModel.toEntity(): AlbumEntity {//pasamos de modelo a entidad
        return AlbumEntity(
            body = body,
            id = id,
            title = title,
            userId = userId,
            thumbnailUrl = thumbnailUrl,
            url = url,
            albumId = albumId
        )

    }

    private fun AlbumEntity.toModel(): AlbumModel {//pasamos de entidad a modelo
        return AlbumModel(
            body = body,
            id = id,
            title = title,
            userId = userId,
            thumbnailUrl = thumbnailUrl,
            url = url,
            albumId = albumId
        )
    }
}