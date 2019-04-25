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
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.BufferedInputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() , LoaderManager.LoaderCallbacks<String>{

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
        Log.d("-----","onCreate()")

        //loaderManager.initLoader(1,null,this)
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
            supportLoaderManager.initLoader(1,null,this)
            /*
            findViewById<WebView>(R.id.webHoro).webViewClient = WebViewClient()
            findViewById<WebView>(R.id.webHoro).settings.javaScriptEnabled = true
            val url = "https://fortune.yahoo.co.jp/12astro/" + horoMapEng[findViewById<Spinner>(R.id.spnHoroscopes).selectedItem.toString()]
            findViewById<WebView>(R.id.webHoro).loadUrl( url )
            Toast.makeText(applicationContext,findViewById<Spinner>(R.id.spnHoroscopes).selectedItem.toString() ,Toast.LENGTH_SHORT).show()
            */

        }

    }
    //ローダーが破棄されるときに呼ばれるメソッド
    override fun onLoaderReset(p0: Loader<String>) {
        // To change body of created functions use File | Settings | File Templates.
    }

    //取得したデータを出力する
    override fun onLoadFinished(p0: Loader<String>, p1: String?) {
        if( p1 != null ) {
            findViewById<TextView>(R.id.txtHtml).text = p1
        }
    }
    //実行するローダーを生成して返す
    override fun onCreateLoader(p0: Int, p1: Bundle?): Loader<String> {
        Log.d("-----","onCreateLoader()")
        class HtmlLoader( context : Context) : AsyncTaskLoader<String>(context){
            private var cache : String? = null
            //バックグラウンド処理
            override fun loadInBackground(): String? {
                val res = httpGet("https://www.yahoo.co.jp")
                Log.d("----","loadInBackground()")
                if( res != null ){
                    return res.toString()
                }

                return null

            }

            override fun deliverResult(data: String?) {
                if( isReset || data == null ) return
                cache = data
                super.deliverResult(data)
            }

            override fun onStartLoading() {
                if( cache != null ){
                    deliverResult( cache )
                }
                if( takeContentChanged() || cache == null ){
                    forceLoad()
                }
            }

            override fun onStopLoading() {
                cancelLoad()
            }

            override fun onReset() {
                super.onReset()
                onStopLoading()
                cache= null
            }

            fun httpGet( url : String) : Document?{
                //val con = URL( url ).openConnection() as HttpURLConnection

                /*con.apply{
                    requestMethod = "GET"
                    connectTimeout = 3000
                    readTimeout = 5000
                    instanceFollowRedirects = true
                }*/

                //con.connect()

                val document = Jsoup.connect("https://www.yahoo.co.jp").get()

                /*if( con.responseCode in 200..299 ){
                    return BufferedInputStream( con.inputStream )
                }*/
                if( document != null ){
                    return document
                }
                //失敗
                return null
            }

        }
        val htmlLoader = HtmlLoader( this )
        return htmlLoader
    }
}