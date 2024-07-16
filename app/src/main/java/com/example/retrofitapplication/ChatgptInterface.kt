package com.example.retrofitapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import com.google.gson.JsonObject
import com.google.gson.JsonPrimitive


interface ChatgptInterface {
    @GET("api/hello/{question}")
    fun getResponse(@Path("question") question: String): Call<JsonPrimitive>

}