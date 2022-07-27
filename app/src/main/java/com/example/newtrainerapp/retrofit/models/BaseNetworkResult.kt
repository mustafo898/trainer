package com.example.newtrainerapp.retrofit.models

sealed class BaseNetworkResult<T>(
    val data: T? = null,
    val message: String? = null,
    val isLoading: Boolean? = null,
    val isCorrect: Boolean? = null
) {
    class Success<T>(data: T) : BaseNetworkResult<T>(data = data)
    class Correct<T>(correct: Boolean?) : BaseNetworkResult<T>(isCorrect = correct)
    class Error<T>(message: String?) : BaseNetworkResult<T>(message = message)
    class Loading<T>(isLoading: Boolean?) : BaseNetworkResult<T>(isLoading = isLoading)
}