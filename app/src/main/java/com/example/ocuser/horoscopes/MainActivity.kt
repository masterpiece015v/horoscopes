package com.example.ocuser.horoscopes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //スピナーに星座を登録する
        val spnHoroscopes = findViewById<Spinner>(R.id.spnHoroscopes)

        val horoList = listOf("おひつじ座",
                "おうし座",
                "ふたご座")

        //アダプターの登録
        val adapter = ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                R.id.spnHoroscopes,
                horoList
        )

        spnHoroscopes.adapter = adapter

    }
}
