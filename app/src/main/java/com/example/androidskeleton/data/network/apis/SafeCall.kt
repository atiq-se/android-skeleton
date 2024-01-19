package com.example.androidskeleton.data.network.apis

import com.example.androidskeleton.data.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

interface SafeCall {
    suspend fun <T> safeApiCall(apiCall: suspend () -> T) : Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> {
                        Resource.Failure(0, throwable)
                    }
                    else -> {
                        Resource.Failure(1, throwable)
                    }
                }
            }
        }
    }

    suspend fun <T> safeCall(apiCall: suspend () -> T): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                Resource.Failure(0, throwable)
            }
        }
    }
}