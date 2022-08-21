package com.example.retrofitkullanm

import androidx.annotation.Keep
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Keep
class RetrofitClient {

    companion object
    {
    fun getClient(baseUrl:String):Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl) //base url belirledik http://grgnpl.com adresi
            .addConverterFactory(GsonConverterFactory.create()) // json parse ediliyor
            .build()
    }
    }
}