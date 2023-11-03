package com.example.sampleappwac.api

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface RetrofitClient {

    companion object {
        private val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        private val client = OkHttpClient.Builder()
            .readTimeout(1, TimeUnit.MINUTES)
            .addInterceptor(Interceptor { chain ->
                var request = chain.request()
                val urlBuilder = request.url.newBuilder()
                request = request.newBuilder().url(urlBuilder.build())
                    .addHeader("Accept-Encoding", "identity")
                    .build()
                try {
                    var response = chain.proceed(request)
                    if (response.code != 200) {
                        response = Response.Builder()
                            .code(200)
                            .message(response.message)
                            .protocol(Protocol.HTTP_1_1)
                            .request(request)
                            .body(response.body)
                            .build()
                    }
                    response
                } catch (e: Exception) {
                    e.printStackTrace()
                    val dummy = JSONObject().apply {
                        put("url", "$urlBuilder")
                    }.toString()
                    Response.Builder()
                        .code(200)
                        .message("OK")
                        .protocol(Protocol.HTTP_1_1)
                        .request(Request.Builder().url("http://localhost/").build())
                        .message(e.message ?: "")
                        .body(dummy.toResponseBody("text/plain".toMediaType()))
                        .build()
                }
            })
            .addInterceptor(logging)
            .build()


        private fun createRetrofitClient(): RetrofitClient = Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().registerTypeAdapterFactory(IgnoreFailureTypeAdapterFactory()).setLenient().create()))
            .client(client)
            .build()
            .create(RetrofitClient::class.java)

        val apiService: RetrofitClient by lazy { createRetrofitClient() }
    }

    @GET("v3/17db81c4-f48e-408a-bf06-c289ee825e06")
    suspend fun getHomeData(): HomeResponse
}