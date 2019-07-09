package com.example.ocuser.horoscopes

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class TalentDbHelper(var context : Context? ): SQLiteOpenHelper(context,"TalentDb",null,1){
    override fun onCreate( db: SQLiteDatabase? ){
        db?.execSQL("create table talentTable(" +
                "id integer PRIMARY KEY AUTOINCREMENT , groupname text ,name text ,birthday text, zodiac text,bloodtype text , imagename int" +
                ");")
    }
    override fun onUpgrade( db : SQLiteDatabase? , oldVersion:Int,newVersion:Int){
        db?.execSQL("drop table if exists talentTable")
        onCreate( db )
    }

}