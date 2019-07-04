package com.example.ocuser.horoscopes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val index = intent.getIntExtra("index",0)

        findViewById<TextView>(R.id.txtName2).text = MainActivity.astroList[index].name
        findViewById<TextView>(R.id.txtContent2).text = MainActivity.astroList[index].content
        findViewById<ImageView>(R.id.imgHoro2).setImageResource( MainActivity.astroList[index].imgName )

    }
}

