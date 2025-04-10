package com.cursoandroidm2.screens.todo_list.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cursoandroidm2.screens.todo_list.models.TodoModel
import com.cursoandroidm2.screens.todo_list.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(private val todoRepository: TodoRepository) : ViewModel() {

    private val _todoList = mutableStateListOf<TodoModel>()
    val tareas: List<TodoModel>
        get() = _todoList
    @HiltViewModel
    class TodoViewModel @Inject constructor(private val todoRepository: TodoRepository) : ViewModel() {

        private val _todoList = mutableStateListOf<TodoModel>()
        val tareas: List<TodoModel>
            get() = _todoList

        // private val todoRepository = TodoRepository()

        // LiveData para el estado del login
        private val _isListLoaded = MutableLiveData<Boolean>()
        val isListLoaded: LiveData<Boolean> = _isListLoaded //para observar el estado del login

        init {
            getTareas()
        }

        private fun getTareas() {

            viewModelScope.launch {
                try {
                    _isListLoaded.value = false
                    _todoList.clear()
                    val todos = todoRepository.getTareas()

                    _todoList.addAll(todos)
                    _isListLoaded.value = true
                } catch (e: Exception) {
                    _isListLoaded.value = false
                }
            }

        }
    }

   // private val todoRepository = TodoRepository()

    // LiveData para el estado del login
    private val _isListLoaded = MutableLiveData<Boolean>()
    val isListLoaded: LiveData<Boolean> = _isListLoaded //para observar el estado del login

    init {
        getTareas()
    }

    private fun getTareas() {

        viewModelScope.launch {
            try {
                _isListLoaded.value = false
                _todoList.clear()
                val todos = todoRepository.getTareas()

                _todoList.addAll(todos)
                _isListLoaded.value = true
            } catch (e: Exception) {
                _isListLoaded.value = false
            }
        }

    }
}