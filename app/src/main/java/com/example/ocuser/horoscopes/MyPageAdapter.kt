package com.example.ocuser.horoscopes

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter


class MyPageAdapter(fm: FragmentManager , val index :Int ): FragmentPagerAdapter(fm){
    override fun getItem( position : Int ): Fragment {
        val fragment = Fragment01()

        val bundle = Bundle()
        bundle.putInt("index",index )
        fragment.arguments = bundle

        return fragment

    }

    override fun getCount() : Int{
        return 5
    }
}