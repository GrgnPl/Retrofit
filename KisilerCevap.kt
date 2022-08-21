package com.example.retrofitkullanm

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class KisilerCevap(@SerializedName("login")
                        @Expose
                        var kisiler:List<Kisiler>,
                        @SerializedName("success")
                        @Expose
                        var success:Int) {
}