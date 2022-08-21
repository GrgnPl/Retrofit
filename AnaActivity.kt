package com.example.timtalctf2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.Keep
import kotlinx.android.synthetic.main.activity_ana.*
@Keep
class AnaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ana)

        button.setOnClickListener {
            Toast.makeText(applicationContext,"bu kadar kolay değil :)", Toast.LENGTH_LONG).show()
        }
    }
}