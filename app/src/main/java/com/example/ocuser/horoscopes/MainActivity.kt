package com.example.ocuser.horoscopes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.*

class MainActivity : AppCompatActivity() {
    val horoMap = mapOf(
            "おひつじ座" to R.drawable.aries,"おうし座" to R.drawable.taurus,"ふたご座" to R.drawable.gemini,
            "かに座" to R.drawable.cancer,"しし座" to R.drawable.leo,"おとめ座" to R.drawable.virgo,
            "てんびん座" to R.drawable.libra,"さそり座" to R.drawable.scorpio,"いて座" to R.drawable.sagittarius,
            "やぎ座" to R.drawable.capricorn,"みずがめ座" to R.drawable.aquarius,"うお座" to R.drawable.pisces
    )
    val horoMapEng = mapOf(
            "おひつじ座" to "aries","おうし座" to "taurus","ふたご座" to "gemini",
            "かに座" to "cancer","しし座" to "leo","おとめ座" to "virgo",
            "てんびん座" to "libra","さそり座" to "scorpio","いて座" to "sagittarius",
            "やぎ座" to "capricorn","みずがめ座" to "aquarius","うお座" to "pisces"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //スピナーに星座を登録する
        val spnHoroscopes = findViewById<Spinner>(R.id.spnHoroscopes)
        val horoList = listOf(
                "おひつじ座", "おうし座", "ふたご座",
                "かに座","しし座","おとめ座",
                "てんびん座","さそり座","いて座",
                "やぎ座", "みずがめ座", "うお座")
        //アダプターの登録
        val adapter = ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                horoList
        )
        spnHoroscopes.adapter = adapter
        //スピナー選択時のイベント
        spnHoroscopes.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(parent:AdapterView<*>?, view: View?, position:Int, id:Long){
                val spnParent = parent as Spinner
                val item = spnParent.selectedItem as String
                val imgId = horoMap[item]
                if( imgId != null) {
                    findViewById<ImageView>(R.id.imgHoro).setImageResource(imgId)
                }
                    //Toast.makeText(applicationContext,horoMap[item],Toast.LENGTH_SHORT).show()
            }
        }

        //イメージクリックのイベント
        findViewById<ImageView>(R.id.imgHoro).setOnClickListener {
            /*
            findViewById<WebView>(R.id.webHoro).webViewClient = WebViewClient()
            findViewById<WebView>(R.id.webHoro).settings.javaScriptEnabled = true
            val url = "https://fortune.yahoo.co.jp/12astro/" + horoMapEng[findViewById<Spinner>(R.id.spnHoroscopes).selectedItem.toString()]
            findViewById<WebView>(R.id.webHoro).loadUrl( url )
            Toast.makeText(applicationContext,findViewById<Spinner>(R.id.spnHoroscopes).selectedItem.toString() ,Toast.LENGTH_SHORT).show()
            */

        }

    }
}