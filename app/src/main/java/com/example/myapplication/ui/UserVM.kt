package com.example.myapplication.ui

import androidx.lifecycle.*
import com.example.myapplication.database.entities.User
import com.example.myapplication.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserVM @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _strings = MutableStateFlow(emptyList<User>())
    val strings: StateFlow<List<User>> = _strings

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing

    fun refresh() {
        viewModelScope.launch {
            _isRefreshing.emit(true)
            delay(3000L)
            _isRefreshing.emit(false)
        }
    }

    fun fetch() {
        viewModelScope.launch {
            _strings.emit(repository.fetchUsers())
        }
    }

    fun save() {
        viewModelScope.launch {
            _strings.value.forEach {
                repository.addUser(it)
            }
        }
    }

    fun read() {
        viewModelScope.launch {
            repository.getAllUsers().collect {
                _strings.emit(it)
            }
        }
    }

    fun reset() {
        _strings.value = emptyList()
    }

    fun delete() {
        viewModelScope.launch {
            repository.deleteUsers()
        }
    }
}