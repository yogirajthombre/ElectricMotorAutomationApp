package com.example.electricmotorautomationapp.api



import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


class ApiClient {

    var baseUrl : String = "https://electricmotorautomation.herokuapp.com/api/"


    fun create_retrofit_instance():ApiService{
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(baseUrl).build().create(ApiService::class.java)
    }

    fun create_retrofit_instance_with_header(token:String):ApiService{
        val httpClient = OkHttpClient.Builder()

        httpClient.addInterceptor(object : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                val original = chain.request()
                val request = original.newBuilder()
                        .header("Authorization",token)
                        .build()
                return chain.proceed(request)
            }
        })
        val client = httpClient.build()
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiService::class.java)

    }

}


