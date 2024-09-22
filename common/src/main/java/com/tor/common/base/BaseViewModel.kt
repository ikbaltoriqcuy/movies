package com.tor.common.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

/**
Created by ikbaltoriq on 27,August,2024
 **/
abstract class BaseViewModel: ViewModel() {
    private val job = Job()
    val coroutineScope = CoroutineScope(Dispatchers.Main + job)

    private val _isLoading = MutableLiveData<Boolean>().apply { value = false }
    val isLoading: MutableLiveData<Boolean> get() = _isLoading

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: MutableLiveData<String> get() = _errorMessage

    fun setIsLoading(isLoading: Boolean) {
        _isLoading.value = isLoading
    }

    fun setErrorMessage(errorMessage:  String) {
        _errorMessage.value = errorMessage
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}