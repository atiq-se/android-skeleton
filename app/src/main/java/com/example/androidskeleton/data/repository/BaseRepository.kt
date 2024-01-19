package com.example.androidskeleton.data.repository

import com.example.androidskeleton.data.network.apis.BaseApi
import com.example.androidskeleton.data.network.apis.SafeCall

abstract class BaseRepository(private val api: BaseApi) : SafeCall {
}