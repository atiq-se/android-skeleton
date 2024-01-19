package com.example.androidskeleton.data.network

import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RemoteDataSource @Inject constructor(){
    companion object {
        private const val BASE_URL = "https://app.check24.de/"
    }

    fun <Api> buildApi(api: Class<Api>): Api {
        return Retrofit.Builder().baseUrl(BASE_URL).client(getRetrofitClient())
            .addConverterFactory(GsonConverterFactory.create()).build().create(api)
    }

    private fun getRetrofitClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        val credential = Credentials.basic("candidate", "LnpwL7HoZjTL")
        builder.addInterceptor { chain ->
            chain.proceed(chain.request().newBuilder().also { request ->
                request.addHeader("Accept", "application/json")
                request.addHeader("Authorization", credential)
            }.build())
        }.also { client ->
            //if (BuildConfig.DEBUG) {
                val logging = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                client.addInterceptor(logging)
           // }
        }
        return builder.build()
    }
}