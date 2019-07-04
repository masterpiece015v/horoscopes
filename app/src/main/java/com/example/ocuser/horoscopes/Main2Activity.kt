package com.example.ocuser.horoscopes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.widget.ImageView
import android.widget.TextView

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val index = intent.getIntExtra("index",0)

        val pager = findViewById<ViewPager>(R.id.pager)

        val fm = supportFragmentManager
        val pageadapter = MyPageAdapter( fm , index )
        pager.adapter = pageadapter


    }
}

