package com.example.retrofitkullanm

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Keep
data class Kisiler(
                   @SerializedName("k_ad")
                   @Expose
                   var kisiAd:String,
                   @SerializedName("k_sifre")
                   @Expose
                   var kisi_sifre:String):Serializable {
}