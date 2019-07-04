package com.example.ocuser.horoscopes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class Fragment01(): Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val layout = inflater?.inflate(R.layout.fragment01, container, false)

        val recyclerView = layout!!.findViewById<RecyclerView>(R.id.lstAstro)

        //リサイクラービューのアダプタ
        val adapter = AstroAdapter( context!! , MainActivity.astroList){

        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context!!, LinearLayout.VERTICAL,false)

        return layout
    }
}
