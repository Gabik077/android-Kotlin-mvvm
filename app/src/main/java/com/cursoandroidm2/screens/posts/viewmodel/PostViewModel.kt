package com.cursoandroidm2.screens.posts.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cursoandroidm2.screens.posts.models.PostModel
import com.cursoandroidm2.screens.posts.repository.PostRepository
import com.cursoandroidm2.screens.todo_list.models.TodoModel
import com.cursoandroidm2.screens.todo_list.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel  @Inject constructor(private val postRepository: PostRepository) : ViewModel() {
    private val _postList = mutableStateListOf<PostModel>()
    val posts: List<PostModel>
        get() = _postList

    init {
        getPosts()
    }


    private fun getPosts() {

        viewModelScope.launch {
            try {

                _postList.clear()
                val posts = postRepository.getPosts()
                Log.d("PostViewModel", "posts: $posts")
                _postList.addAll(posts)
            } catch (_: Exception) {
                _postList.addAll(emptyList())
            }
        }

    }
}