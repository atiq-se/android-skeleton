package com.example.androidskeleton.data.repository

import com.example.androidskeleton.data.network.apis.MyApi
import javax.inject.Inject

class MyRepository @Inject constructor(private val api: MyApi) : BaseRepository(api) {
    suspend fun getInfoByApi() = safeApiCall {
        api.getInfoByApi()
    }

}