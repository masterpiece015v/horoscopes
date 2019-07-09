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

        val adList = listOf("総合運","恋愛運","金運","仕事運","恋愛相性1位","恋愛相性12位")

        //リサイクラービューのアダプタ
        val adapter = MenuAdapter(this,adList ){index,view->
            //メニュークリック時のイベント
            pager.currentItem = index
            view.findViewById<TextView>(R.id.txtMenuItem).setBackgroundColor(Color.LTGRAY)

        }

        rcyMenu.adapter = adapter
        rcyMenu.layoutManager = LinearLayoutManager(this, LinearLayout.HORIZONTAL,false)

        var nowp = 0

        //ページャーのページが変わった後のイベント
        pager.addOnPageChangeListener(object: ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(p0: Int) {

                if( p0 >= 0 && p0 < adList.size ) {
                    if( nowp <= p0) {
                        rcyMenu.smoothScrollToPosition(p0 + 1)
                    }else if( p0 > 0 ){
                        rcyMenu.smoothScrollToPosition( p0 - 1 )
                    }
                }

                val viewholder1 = rcyMenu.findViewHolderForAdapterPosition(p0) as MenuAdapter.MenuViewHolder
                viewholder1.txtMenuItem.setBackgroundColor( Color.LTGRAY )

                val viewholder2 = rcyMenu.findViewHolderForAdapterPosition(nowp) as MenuAdapter.MenuViewHolder
                viewholder2.txtMenuItem.setBackgroundColor( Color.WHITE )

                nowp = p0

                //Toast.makeText( applicationContext, viewholder.txtMenuItem.text , Toast.LENGTH_SHORT).show()
            }
        })


    }
}

