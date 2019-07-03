package com.example.ocuser.horoscopes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val name = intent.getStringExtra("name")
        findViewById<TextView>(R.id.txtName2).text = name
        val content = intent.getStringExtra( "content")
        findViewById<TextView>(R.id.txtContent2).text = content

    }
}
