package com.example.myapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.database.entities.User
import com.example.myapplication.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserVM @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {
    private val _strings = MutableStateFlow(emptyList<User>())
    val strings: StateFlow<List<User>> = _strings

    fun fetch() {
        viewModelScope.launch {
            _strings.value = repository.fetchUsers()
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
            repository.getAllUsers().collect { _strings.value = it }
        }
    }

    fun reset() {
        _strings.value = emptyList()
    }
}