package com.example.ocuser.horoscopes

import android.content.ContentValues
import android.content.Context
import android.database.Cursor

class DbAstro(private val context : Context){
    val dbhepler = DbHelper( context )
    fun init(){
        val sql = "select count(*) as cnt from astroTable"
        val cur = dbhepler.writableDatabase.rawQuery( sql,arrayOf())
        cur.moveToFirst()
        val cnt = cur.getInt(cur.getColumnIndex("cnt"))
        cur.close()
        if( cnt == 0 ){
            insert("astroTable",mapOf("name" to "おひつじ座") )
            insert("astroTable",mapOf("name" to "おうし座") )
            insert("astroTable",mapOf("name" to "ふたご座") )
            insert("astroTable",mapOf("name" to "かに座") )
            insert("astroTable",mapOf("name" to "しし座") )
            insert("astroTable",mapOf("name" to "おとめ座") )
            insert("astroTable",mapOf("name" to "てんびん座") )
            insert("astroTable",mapOf("name" to "さそり座") )
            insert("astroTable",mapOf("name" to "いて座") )
            insert("astroTable",mapOf("name" to "やぎ座") )
            insert("astroTable",mapOf("name" to "みずがめ座") )
            insert("astroTable",mapOf("name" to "うお座") )
        }
    }

    //挿入
    fun insert(tableName:String, valueMap : Map<String,String>){
        val values = ContentValues()

        valueMap.forEach{
            values.put(it.key,it.value)
        }

        val db = dbhepler.writableDatabase
        db.insertOrThrow(tableName,null,values )

    }

    //更新
    //where = " name = ?"の形式
    fun update( tableName : String , where : String, keyArray : Array<String>, valueMap : Map<String,String>){

        val values = ContentValues()

        valueMap.forEach{
            values.put( it.key,it.value )
        }
        val db = dbhepler.writableDatabase

        db.update( tableName, values,where,keyArray )
    }

    //カーソルの取得
    fun getCursor( sql : String, array : Array<String> ):Cursor{
        val db = dbhepler.writableDatabase
        val cur = db.rawQuery(sql,array)

        return cur
    }
}