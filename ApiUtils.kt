package com.example.retrofitkullanm

import androidx.annotation.Keep

class ApiUtils {

    @Keep
    companion object //Bu fonksiyonla interface'e erişim sağlıyoruz.
    {
    val BASE_URL = "/" Domain Adresiniz

    fun getKisilerDaoInterface():KisilerDaoInterface
    {
    return RetrofitClient.getClient(BASE_URL).create(KisilerDaoInterface::class.java)

    }
}
