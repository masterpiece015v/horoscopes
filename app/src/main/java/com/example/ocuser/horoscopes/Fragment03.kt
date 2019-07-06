package com.example.ocuser.horoscopes

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class Fragment03(): Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val layout = inflater?.inflate(R.layout.fragment03, container, false)
        val index = arguments!!.getInt("index")

        layout.findViewById<TextView>(R.id.txtName3).text = "${MainActivity.astroList[index].name}の金運"
        layout.findViewById<TextView>(R.id.txtContent3).text = MainActivity.astroList[index].gold
        layout.findViewById<ImageView>(R.id.imgHoro3).setImageResource( MainActivity.astroList[index].imgName )
        return layout
    }
}
