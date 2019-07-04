package com.example.ocuser.horoscopes

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter


class MyPageAdapter(fm: FragmentManager): FragmentPagerAdapter(fm){
    override fun getItem( position : Int ): Fragment {

        val fragment = Fragment01()
        return fragment

    }

    override fun getCount() : Int{
        return 5
    }
}