package com.example.timtalctf2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.annotation.Keep
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitkullanm.ApiUtils
import com.example.retrofitkullanm.CRUDCevap
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Keep
class MainActivity : AppCompatActivity() {
    val kdi = ApiUtils.getKisilerDaoInterface()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        girisbutton.setOnClickListener {
            val username = usernameview.text.toString()
            val password = passview.text.toString()
            kdi.kisiGir(username,password).enqueue(object : Callback<CRUDCevap>{
                override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
                    Log.e("Başarı", response.body()?.success.toString())
                    Log.e("Mesaj",response.body()?.message.toString())
                    val intent = Intent(this@MainActivity,AnaActivity::class.java)
                    startActivity(intent)
                }

                override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {

                }
            })
        }
    }

}