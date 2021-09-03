package com.example.myapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.RemoteApi.retrofitService
import com.example.myapplication.database.daos.UserDao
import com.example.myapplication.database.entities.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class UserVM(
    private val userDao: UserDao
) : ViewModel() {
    private val _strings = MutableStateFlow(emptyList<User>())
    val strings: StateFlow<List<User>> = _strings

    fun fetch() {
        viewModelScope.launch {
            _strings.value = retrofitService.fetchStrings()
        }
    }

    fun save() {
        viewModelScope.launch {
            _strings.value.forEach {
                userDao.addUser(it)
            }
        }
    }

    fun read() {
        _strings.value = userDao.getAllUsers()
            .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList()).value
    }

    fun reset() {
        _strings.value = emptyList()
    }
}