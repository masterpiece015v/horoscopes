package com.example.ocuser.horoscopes

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.jsoup.Jsoup

data class AstroFortun(val name : String,val engName : String ,val imgName : Int ,var rank : String,var score : String,var title : String,var content : String,var charm : String,var compa1:String, var compa2:String)

class MainActivity : AppCompatActivity(){

    companion object{
        val astroList = listOf(
                AstroFortun("おひつじ座","aries",R.drawable.aries,"","","","","","",""),
                AstroFortun("おうし座","taurus",R.drawable.taurus,"","","","","","",""),
                AstroFortun("ふたご座","gemini",R.drawable.gemini,"","","","","","",""),
                AstroFortun("かに座","cancer",R.drawable.cancer,"","","","","","",""),
                AstroFortun("しし座","leo",R.drawable.leo,"","","","","","",""),
                AstroFortun("おとめ座","virgo",R.drawable.virgo,"","","","","","",""),
                AstroFortun("てんびん座","libra",R.drawable.libra,"","","","","","",""),
                AstroFortun("さそり座","scorpio",R.drawable.scorpio,"","","","","","",""),
                AstroFortun("いて座","sagittarius",R.drawable.sagittarius,"","","","","","",""),
                AstroFortun("やぎ座","capricorn",R.drawable.capricorn,"","","","","","",""),
                AstroFortun("みずがめ座","aquarius",R.drawable.aquarius,"","","","","","",""),
                AstroFortun("うお座","pisces",R.drawable.pisces,"","","","","","","")
        )
    }
    
    //リストの項目をクリックしたときのイベント
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView:RecyclerView  = findViewById(R.id.lstAstro)

        //sqliteの作成
        val dbastro = DbAstro( this )
        dbastro.init()

        //シェアードプリファレンスから年月日を取得
        val pref = getSharedPreferences("date", Context.MODE_PRIVATE)
        val oldYear = pref.getInt("year",0)
        val oldMonth = pref.getInt( "month",0)
        val oldDay = pref.getInt( "day" , 0 )

        //現在の日付を取得
        val dt = DateTime()
        val changeFlg : Boolean = if( oldYear < dt.year) {
            pref.edit().putInt("year",dt.year).apply()
            pref.edit().putInt("month",dt.month).apply()
            pref.edit().putInt("day",dt.day).apply()
            true
        }else if(oldMonth < dt.month ) {
            pref.edit().putInt("year",dt.year).apply()
            pref.edit().putInt("month",dt.month).apply()
            pref.edit().putInt("day",dt.day).apply()
            true
        }else if( oldDay < dt.day){
            pref.edit().putInt("year",dt.year).apply()
            pref.edit().putInt("month",dt.month).apply()
            pref.edit().putInt("day",dt.day).apply()
            true
        }else{
            if( oldYear == 0 ){
                pref.edit().putInt("year",dt.year).apply()
                pref.edit().putInt("month",dt.month).apply()
                pref.edit().putInt("day",dt.day).apply()
            }
            false
        }

        //Log.d( "debug", changeFlg.toString() )
        //Log.d( "debug" , "${oldYear}${dt.year}" )
        //日付が変わっていれば占いを取得する
        if( changeFlg ) {
            astroList.forEach {astro ->
                val url = "https://fortune.yahoo.co.jp/12astro/${astro.engName}"
                //httpGet(url, astro)
                //コルーチン
                GlobalScope.launch(Dispatchers.Main){
                    async(Dispatchers.Default){
                        val document = Jsoup.connect(url).get()

                        astro.rank = document.select("#jumpdtl").select("strong").first().text()
                        astro.score = document.select(".bg01-03").select("p").first().text()

                        val yftn12a = document.select(".yftn12a-md48")
                        //Log.d("debug","${yftn12a.size}")
                        astro.title = yftn12a[0].select("dt").first().text()
                        astro.content = yftn12a[0].select("dd").first().text()
                        astro.charm = yftn12a[1].select("dd").first().text()

                        val spans = document.select("span")
                        //spans.forEachIndexed { index, element ->
                        //    Log.d("debug","${index},${element.text()}")
                        //}
                        astro.compa1 = spans[4].text()
                        astro.compa2 = spans[7].text()

                        //Log.d("debug" , "${astro.charm},${astro.compa1},${astro.compa2}")

                    }.await()
                    //テーブルを更新する
                    val valueMap = mutableMapOf<String,String>()
                    valueMap["rank"] = astro.rank
                    valueMap["score"] = astro.score
                    valueMap["title"] = astro.title
                    valueMap["content"] = astro.content
                    valueMap["charm"] = astro.charm
                    valueMap["compa1"] = astro.compa1
                    valueMap["compa2"] = astro.compa2
                    dbastro.update("astroTable","name=?",arrayOf<String>(astro.name),valueMap )

                    //取得後リサイクラービューに再表示する
                    //recyclerView.adapter!!.notifyDataSetChanged()
                }
            }
        }else{
            //データベースから取得する
            val sql = "select * from astroTable where name = ?"
            astroList.forEach{
                val cur = dbastro.getCursor(sql,arrayOf( it.name ))
                cur.moveToFirst()

                it.rank = cur.getString( cur.getColumnIndex("rank") )
                it.score = cur.getString( cur.getColumnIndex("score") )
                it.title = cur.getString( cur.getColumnIndex( "title") )
                it.content = cur.getString( cur.getColumnIndex( "content") )
                it.charm = cur.getString( cur.getColumnIndex("charm"))
                it.compa1 = cur.getString( cur.getColumnIndex("compa1") )
                it.compa2 = cur.getString( cur.getColumnIndex("compa2"))

                cur.close()
            }
        }

        //リサイクラービューのアダプタ
        val adapter = AstroAdapter(this,astroList){
            //Toast.makeText(this,"${it}",Toast.LENGTH_SHORT).show()
            //タップしたときのメソッド
            val intent = Intent(this,Main2Activity::class.java)
            intent.putExtra("index", it )
            //intent.putExtra("content",astroList.get(it).content )
            //intent.putExtra("imgName", astroList.get(it).imgName )
            startActivity( intent )
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
    }


}