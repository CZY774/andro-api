package com.czy.helloworldandroid

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users = _users

    private val _error = MutableLiveData<String>()
    val error = _error

    fun fetchUsers() {
        viewModelScope.launch {
            try {
                val userList = RetroFitInstance.apiService.getUsers()
                _users.value = userList.users
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }
}