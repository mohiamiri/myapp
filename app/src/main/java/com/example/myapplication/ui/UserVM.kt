package com.example.myapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.RemoteApi.retrofitService
import com.example.myapplication.database.entities.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserVM : ViewModel() {
    private val _strings = MutableStateFlow(emptyList<User>())
    val strings: StateFlow<List<User>> = _strings

    fun fetch() {
        viewModelScope.launch {
            _strings.value = retrofitService.fetchStrings()
        }
    }

    fun save() {

    }

    fun read() {

    }

    fun reset() {
        _strings.value = emptyList()
    }
}