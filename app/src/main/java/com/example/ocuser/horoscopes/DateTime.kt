package com.example.ocuser.horoscopes

import java.util.*

class DateTime(){
    private var calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR )
    val month = calendar.get(Calendar.MONTH)+1
    val day = calendar.get(Calendar.DAY_OF_MONTH)
}