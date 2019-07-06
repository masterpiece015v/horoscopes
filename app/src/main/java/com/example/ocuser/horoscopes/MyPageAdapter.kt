package com.example.ocuser.horoscopes

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter


class MyPageAdapter(fm: FragmentManager , val index :Int ): FragmentPagerAdapter(fm){
    override fun getItem( position : Int ): Fragment {
        var fragment : Fragment? = null
        when(position){
            0-> fragment = Fragment01()
            1-> fragment = Fragment02()
            2-> fragment = Fragment03()
            3-> fragment = Fragment04()
        }
        val bundle = Bundle()
        bundle.putInt("index",index )

        if( fragment != null )
            fragment.arguments = bundle

        return fragment!!
    }

    override fun getCount() : Int{
        return 4
    }
}