package com.example.androidskeleton.data.network

sealed class Resource<out T> {
    data class Success<out T>(val value: T) : Resource<T>()

    data class Failure(
        val errorType: Int, val error: Throwable
    ) : Resource<Nothing>()

    data class Loading(val loading: Boolean) : Resource<Nothing>()
}