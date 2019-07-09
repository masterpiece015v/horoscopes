package com.example.ocuser.horoscopes

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class TalentAdapter(context: Context, val talentList : List<TalentData>, private val onItemClicked:()->Unit) : RecyclerView.Adapter<TalentAdapter.MenuViewHolder>(){

    private val inflater = LayoutInflater.from( context )

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MenuViewHolder {
        val view = inflater.inflate(R.layout.list_row_talent,p0,false)
        val viewHolder = MenuViewHolder(view)


        return viewHolder
    }

    override fun getItemCount() = talentList.size

    override fun onBindViewHolder(p0: MenuViewHolder, p1: Int) {
        if( talentList[p1].imgtalent != 0 ) {
            p0.imgTalent.setImageResource(talentList[p1].imgtalent)
        }
        p0.txtGroupName.text = talentList[p1].groupname
        p0.txtTalentName.text = talentList[p1].name
        p0.txtBirthday.text = talentList[p1].birthday

        //ビューがクリックされたとのイベント
        p0.view.setOnClickListener{
            onItemClicked()
        }
    }


    class MenuViewHolder(val view : View):RecyclerView.ViewHolder(view){
        val imgTalent = view.findViewById<ImageView>(R.id.imgTalent)
        val txtGroupName = view.findViewById<TextView>(R.id.txtGroupName)
        val txtTalentName = view.findViewById<TextView>(R.id.txtTalentName)
        val txtBirthday = view.findViewById<TextView>(R.id.txtBirthday)
    }
}