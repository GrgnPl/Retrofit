package com.example.retrofitkullanm

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable
@Keep
data class CRUDCevap(
    val error: Boolean,
    val message: String,
    val image: String?
)