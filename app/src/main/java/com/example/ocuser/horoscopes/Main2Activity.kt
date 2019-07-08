package com.example.ocuser.horoscopes

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val index = intent.getIntExtra("index",0)

        //ページャー
        val pager = findViewById<ViewPager>(R.id.pager)
        val fm = supportFragmentManager
        val pageadapter = MyPageAdapter( fm , index )
        pager.adapter = pageadapter


        //リサイクラービュー
        val rcyMenu = findViewById<RecyclerView>(R.id.rcyMenu)

        //リサイクラービューのアダプタ
        val adapter = MenuAdapter(this, listOf("総合運","恋愛運","金運","仕事運" , "相性")){index,view->
            //メニュークリック時のイベント
            pager.currentItem = index
            view.findViewById<TextView>(R.id.txtMenuItem).setBackgroundColor(Color.LTGRAY)

        }

        rcyMenu.adapter = adapter

        rcyMenu.layoutManager = LinearLayoutManager(this, LinearLayout.HORIZONTAL,false)

        //ページャーのページが変わった後のイベント
        pager.addOnPageChangeListener(object: ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(p0: Int) {
                rcyMenu.smoothScrollToPosition( p0 +1)
                val viewholder = rcyMenu.findViewHolderForAdapterPosition(p0) as MenuAdapter.MenuViewHolder
                viewholder.txtMenuItem.setBackgroundColor( Color.MAGENTA )
                Toast.makeText( applicationContext, viewholder.txtMenuItem.text , Toast.LENGTH_SHORT).show()
            }
        })

    }
}

