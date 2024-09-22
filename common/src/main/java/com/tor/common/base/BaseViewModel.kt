package com.tor.common.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
Created by ikbaltoriq on 27,August,2024
 **/
abstract class BaseViewModel: ViewModel() {
    private val job = Job()
    val coroutineScope = CoroutineScope(Dispatchers.Main + job)

    private val _isLoading = MutableStateFlow(false)
    val isLoading: Flow<Boolean> get() = _isLoading.asStateFlow()

    private val _errorMessage = MutableStateFlow("")
    val errorMessage: Flow<String> get() = _errorMessage.asStateFlow()

    fun setIsLoading(isLoading: Boolean) {
        coroutineScope.launch {
            _isLoading.emit(isLoading)
        }
    }

    fun setErrorMessage(errorMessage:  String) {
        coroutineScope.launch {
            _errorMessage.emit(errorMessage)
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}