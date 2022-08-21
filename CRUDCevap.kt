package com.example.retrofitkullanm

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Keep
data class CRUDCevap(@SerializedName("success")
                     @Expose
                     var success: String,
                     @SerializedName("message")
                     @Expose
                     var message:String):Serializable