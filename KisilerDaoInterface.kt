package com.example.retrofitkullanm

import androidx.annotation.Keep
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

@Keep
interface KisilerDaoInterface {
    //Web Servislerimizdeki metotları burada kullanacağız


    @POST("giris.php") //Base URL'mizin sonraki devamı
    @FormUrlEncoded
    fun kisiGir(@Field("kisi_ad")kisi_ad:String,@Field("kisi_sifre")kisi_sifre:String):Call<CRUDCevap>
}