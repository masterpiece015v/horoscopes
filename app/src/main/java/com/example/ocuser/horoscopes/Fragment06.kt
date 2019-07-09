package com.example.ocuser.horoscopes

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class Fragment06(): Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layout = inflater?.inflate(R.layout.fragment06, container, false)
        val index = arguments!!.getInt("index")

        //相性の良い星座取得
        val compa2 = MainActivity.astroList[index].compa2
        layout.findViewById<TextView>(R.id.txtBadZodiac).text = compa2

        //相性の良いタレントを取得する
        val talentList = mutableListOf<TalentData>()
        val talentdb = TalentDb(activity!!.applicationContext)

        val cur = talentdb.getCursor("select * from talentTable where zodiac=?",arrayOf(compa2))

        while( cur.moveToNext() ){
            talentList.add(
                    TalentData(
                            cur.getString(cur.getColumnIndex("groupname")),
                            cur.getString(cur.getColumnIndex("name")),
                            cur.getString(cur.getColumnIndex("birthday")),
                            cur.getInt(cur.getColumnIndex("imagename"))
                    )
            )

            //Log.d("debug",cur.getString(cur.getColumnIndex("name")))

        }
        val adapter = TalentAdapter(activity!!.applicationContext,talentList){

        }
        layout.findViewById<RecyclerView>(R.id.rcyTalent6).adapter = adapter
        layout.findViewById<RecyclerView>(R.id.rcyTalent6).layoutManager = LinearLayoutManager(activity!!.applicationContext, LinearLayout.VERTICAL,false)
        return layout
    }

}
