package com.example.ocuser.horoscopes

import java.text.SimpleDateFormat
import java.util.*

class DateTime(){
    private var calendar = Calendar.getInstance(Locale.getDefault())
    val year = calendar.get(Calendar.YEAR )
    val month = calendar.get(Calendar.MONTH)+1
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    /*private val date = Date()
    val yf = SimpleDateFormat("yyyy",Locale.getDefault())
    val mf = SimpleDateFormat("M",Locale.getDefault())
    val df = SimpleDateFormat("d",Locale.getDefault())

    val year = Integer.parseInt( yf.format(date) )
    val month = Integer.parseInt(mf.format(date) )
    val day = Integer.parseInt(df.format(date))
*/
}