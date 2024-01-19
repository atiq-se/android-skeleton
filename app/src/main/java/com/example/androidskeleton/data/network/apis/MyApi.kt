package com.example.androidskeleton.data.network.apis

import com.example.androidskeleton.data.responses.MyResponse
import retrofit2.http.GET

interface MyApi : BaseApi{
    @GET("vg2-quiz/quiz.json")
    suspend fun getInfoByApi() : MyResponse
}