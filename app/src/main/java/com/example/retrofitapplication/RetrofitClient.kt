package com.example.retrofitapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val BASE_URL = "http://gpt.centralindia.cloudapp.azure.com"  //url for the other to run ()
    fun getInstance(): Retrofit {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL) //j site a req maarbe
            .addConverterFactory(GsonConverterFactory.create()) //interface er endpoint points gulo k add kore dicche with the base url
            .build() //now build hocche
        return retrofit
    }


}