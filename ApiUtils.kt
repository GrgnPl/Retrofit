package com.example.retrofitkullanm

import androidx.annotation.Keep

class ApiUtils {

    @Keep
    companion object //Bu fonksiyonla interface'e erişim sağlıyoruz.
    {
    val BASE_URL = "https://siberguvenliklisesi.com/ctfapp/"

    fun getKisilerDaoInterface():KisilerDaoInterface
    {
    return RetrofitClient.getClient(BASE_URL).create(KisilerDaoInterface::class.java) //Static olan Retrofit Client sınıfındaki getClient Fonksiyonunu çağırdık, yukarıda oluşturmuş olduğumuz Baseurl'i mizi de atadık.
    }

    }
}