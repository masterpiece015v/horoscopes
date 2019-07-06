package com.example.ocuser.horoscopes

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MenuAdapter(context: Context, val menuList : List<String>, private val onItemClicked:(index : Int,view : View)->Unit) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>(){

    private val inflater = LayoutInflater.from( context )

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MenuViewHolder {
        val view = inflater.inflate(R.layout.list_menu,p0,false)
        val viewHolder = MenuViewHolder(view)

        return viewHolder
    }

    override fun getItemCount() = menuList.size

    override fun onBindViewHolder(p0: MenuViewHolder, p1: Int) {
        p0.txtMenuItem.text = menuList[p1]

        //ビューがクリックされたとのイベント
        p0.view.setOnClickListener{
            onItemClicked(p1 , it )
        }
    }


    class MenuViewHolder(val view : View):RecyclerView.ViewHolder(view){
        val txtMenuItem = view.findViewById<TextView>(R.id.txtMenuItem)

    }
}