package com.tor.common.network

/**
Created by ikbaltoriq on 28,August,2024
 **/
sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Throwable) : Result<Nothing>()
}