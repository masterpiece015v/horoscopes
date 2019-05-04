package com.example.ocuser.horoscopes

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.LoaderManager
import android.support.v4.content.AsyncTaskLoader
import android.support.v4.content.Loader
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

data class AstroFortun(val rank : String, val score : String, val content : String )

class MainActivity : AppCompatActivity(){
    val horoImgMap = mapOf(
            "おひつじ座" to R.drawable.aries,"おうし座" to R.drawable.taurus,"ふたご座" to R.drawable.gemini,
            "かに座" to R.drawable.cancer,"しし座" to R.drawable.leo,"おとめ座" to R.drawable.virgo,
            "てんびん座" to R.drawable.libra,"さそり座" to R.drawable.scorpio,"いて座" to R.drawable.sagittarius,
            "やぎ座" to R.drawable.capricorn,"みずがめ座" to R.drawable.aquarius,"うお座" to R.drawable.pisces
    )
    val horoEngMap = mapOf(
            "おひつじ座" to "aries","おうし座" to "taurus","ふたご座" to "gemini",
            "かに座" to "cancer","しし座" to "leo","おとめ座" to "virgo",
            "てんびん座" to "libra","さそり座" to "scorpio","いて座" to "sagittarius",
            "やぎ座" to "capricorn","みずがめ座" to "aquarius","うお座" to "pisces"
    )

    lateinit var horoResMap :MutableMap<String,AstroFortun>

    val horoList = listOf(
            "おひつじ座", "おうし座", "ふたご座",
            "かに座","しし座","おとめ座",
            "てんびん座","さそり座","いて座",
            "やぎ座", "みずがめ座", "うお座")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("-----","onCreate()")

        //結果のマップを初期化
        horoResMap = mutableMapOf()

        //スピナーに星座を登録する
        val spnHoroscopes = findViewById<Spinner>(R.id.spnHoroscopes)

        //アダプターの登録
        val adapter = ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                horoList
        )
        spnHoroscopes.adapter = adapter
        horoEngMap.forEach{
            val url = "https://fortune.yahoo.co.jp/12astro/${it.value}"
            httpGet( url , it.key)
        }

        //スピナー選択時のイベント
        spnHoroscopes.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            //星座を選ぶと画像が変わる
            override fun onItemSelected(parent:AdapterView<*>?, view: View?, position:Int, id:Long){
                val spnParent = parent as Spinner
                val item = spnParent.selectedItem as String
                val txtRank = findViewById(R.id.txtRank) as TextView
                val txtScore = findViewById(R.id.txtScore) as TextView
                val txtContent = findViewById( R.id.txtContent ) as TextView

                val imgId = horoImgMap[item]
                if( imgId != null) {
                    findViewById<ImageView>(R.id.imgHoro).setImageResource(imgId)
                }

                val res = horoResMap[item]
                if( res != null ){
                    txtRank.text = res.rank
                    txtScore.text = res.score
                    txtContent.text = res.content
                }

            }
        }

    }

    //コルーチン
    fun httpGet( url : String , key : String)  = GlobalScope.launch(Dispatchers.Main){
        async(Dispatchers.Default){
            val document = Jsoup.connect(url ).get()

            val rank = document.select("#jumpdtl").select("strong").first().text()
            val score = document.select(".bg01-03").select("p").first().text()
            val content = document.select(".yftn12a-md48").first().text()

            horoResMap.put(key , AstroFortun(rank,score,content) )

        }
    }

}