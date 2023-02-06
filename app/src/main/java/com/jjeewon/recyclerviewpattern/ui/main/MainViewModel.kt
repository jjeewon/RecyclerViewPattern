package com.jjeewon.recyclerviewpattern.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjeewon.recyclerviewpattern.data.model.User
import com.jjeewon.recyclerviewpattern.data.repository.MainRepository
import com.jjeewon.recyclerviewpattern.utils.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper,
) : ViewModel() {
    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>>
        get() = _users.asStateFlow()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            if (!networkHelper.isNetworkConnected()) return@launch
            val result = mainRepository.getUsers()
            if (!result.isSuccessful) return@launch
            _users.value = result.body() ?: emptyList()
        }
    }
}