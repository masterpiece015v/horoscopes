package com.example.ocuser.horoscopes

import android.content.Context
import android.content.ReceiverCallNotAllowedException
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.LoaderManager
import android.support.v4.content.AsyncTaskLoader
import android.support.v4.content.Loader
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.BufferedInputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

data class AstroFortun(val name : String, val engName : String , val imgName : Int ,var rank : String, var score : String, var content : String )

class MainActivity : AppCompatActivity(){

    val astroList = listOf(
            AstroFortun("おひつじ座","aries",R.drawable.aries,"","",""),
            AstroFortun("おうし座","taurus",R.drawable.taurus,"","",""),
            AstroFortun("ふたご座","gemini",R.drawable.gemini,"","",""),
            AstroFortun("かに座","cancer",R.drawable.cancer,"","",""),
            AstroFortun("しし座","leo",R.drawable.leo,"","",""),
            AstroFortun("おとめ座","virgo",R.drawable.virgo,"","",""),
            AstroFortun("てんびん座","libra",R.drawable.libra,"","",""),
            AstroFortun("さそし座","scorpio",R.drawable.scorpio,"","",""),
            AstroFortun("いて座","sagittarius",R.drawable.sagittarius,"","",""),
            AstroFortun("やぎ座","capricorn",R.drawable.capricorn,"","",""),
            AstroFortun("みずがめ座","aquarius",R.drawable.aquarius,"","",""),
            AstroFortun("うお座","pisces",R.drawable.pisces,"","","")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("-----","onCreate()")

        //占いを取得する
        astroList.forEach{
            val url = "https://fortune.yahoo.co.jp/12astro/${it.engName}"
            httpGet( url , it )
        }

        val recyclerView = findViewById<RecyclerView>(R.id.lstAstro)

        val adapter = AstroAdapter(this,astroList){
            //タップしたときのメソッド
        }

        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
    }

    //コルーチン
    fun httpGet( url : String , astro : AstroFortun)  = GlobalScope.launch(Dispatchers.Main){
        async(Dispatchers.Default){
            val document = Jsoup.connect(url ).get()

            val rank = document.select("#jumpdtl").select("strong").first().text()
            val score = document.select(".bg01-03").select("p").first().text()
            val content = document.select(".yftn12a-md48").first().text()

            astro.rank = rank
            astro.score = score
            astro.content = content

        }
    }

}