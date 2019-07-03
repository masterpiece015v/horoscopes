package com.example.ocuser.horoscopes

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(var context : Context? ): SQLiteOpenHelper(context,"HoroDb",null,1){
    override fun onCreate( db: SQLiteDatabase? ){
        db?.execSQL("create table astroTable(" +
                "name text primary key,rank text ,score text, title text,content text,charm text,compa1 text , compa2 text" +
                ");")

    }
    override fun onUpgrade( db : SQLiteDatabase? , oldVersion:Int,newVersion:Int){
        db?.execSQL("drop table if exists astroTable")
        onCreate( db )
    }


}