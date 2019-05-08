package com.example.ocuser.horoscopes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.jsoup.Jsoup

data class AstroFortun(val img : Int,  var rank : String, var score : String, var content : String )

class MainActivity : AppCompatActivity(){

    val horoEngMap = mapOf(
            "おひつじ座" to "aries","おうし座" to "taurus","ふたご座" to "gemini",
            "かに座" to "cancer","しし座" to "leo","おとめ座" to "virgo",
            "てんびん座" to "libra","さそり座" to "scorpio","いて座" to "sagittarius",
            "やぎ座" to "capricorn","みずがめ座" to "aquarius","うお座" to "pisces"
    )

    var horoMap :MutableMap<String,AstroFortun> = mutableMapOf(
            "おひつじ座" to AstroFortun(R.drawable.aries,"","" ,""),
            "おうし座" to AstroFortun( R.drawable.taurus,"","",""),
            "ふたご座" to AstroFortun( R.drawable.gemini,"","",""),
            "かに座" to AstroFortun( R.drawable.cancer,"","",""),
            "しし座" to AstroFortun( R.drawable.leo,"","",""),
            "おとめ座" to AstroFortun( R.drawable.virgo,"","",""),
            "てんびん座" to AstroFortun( R.drawable.libra,"","",""),
            "さそり座" to AstroFortun( R.drawable.scorpio, "","","" ),
            "いて座" to AstroFortun(R.drawable.sagittarius, "","","" ),
            "やぎ座" to AstroFortun( R.drawable.capricorn,"","",""),
            "みずがめ座" to AstroFortun( R.drawable.aquarius,"","",""),
            "うお座" to AstroFortun(R.drawable.pisces,"","","")
    )

    val horoList = listOf(
            "おひつじ座", "おうし座", "ふたご座",
            "かに座","しし座","おとめ座",
            "てんびん座","さそり座","いて座",
            "やぎ座", "みずがめ座", "うお座")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("-----","onCreate()")


        //スピナーに星座を登録する
        val spnHoroscopes = findViewById(R.id.spnHoroscopes) as Spinner

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

                val res = horoMap[item]
                if( res != null ){
                    val imgId = res.img

                    if( imgId != null) {
                        findViewById<ImageView>(R.id.imgHoro).setImageResource(imgId)
                    }

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

            val res = horoMap[key]

            if( res != null ){
                res.rank = rank
                res.score = score
                res.content = content
            }

        }
    }

}