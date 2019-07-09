package com.example.ocuser.horoscopes

import android.content.ContentValues
import android.content.Context
import android.database.Cursor

class TalentDb(private val context : Context){
    val dbhepler = TalentDbHelper( context )
    fun init(){
        val sql = "select count(*) as cnt from talentTable"
        val cur = dbhepler.writableDatabase.rawQuery( sql,arrayOf())
        cur.moveToFirst()
        val cnt = cur.getInt(cur.getColumnIndex("cnt"))
        cur.close()
        if( cnt == 0 ){
            insert( "talentTable",mapOf("groupname" to "元SMAP" , "name" to "木村 拓哉", "birthday" to "1972年11月13日" ,"zodiac" to "さそり座" , "bloodtype" to "O型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "元SMAP" , "name" to "中居 正広", "birthday" to "1972年8月18日" ,"zodiac" to "しし座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "元SMAP" , "name" to "香取 慎吾", "birthday" to "1977年1月31日" ,"zodiac" to "しし座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "元SMAP" , "name" to "草彅 剛", "birthday" to "1974年7月9日" ,"zodiac" to "かに座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "元SMAP" , "name" to "稲垣 吾郎", "birthday" to "1973年12月8日" ,"zodiac" to "いて座" , "bloodtype" to "O型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "嵐" , "name" to "松本 潤", "birthday" to "1983年8月30日" ,"zodiac" to "おとめ座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "嵐" , "name" to "二宮 和也", "birthday" to "1983年6月17日" ,"zodiac" to "ふたご座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "嵐" , "name" to "相葉 雅紀", "birthday" to "1982年12月24日" ,"zodiac" to "やぎ座" , "bloodtype" to "AB型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "嵐" , "name" to "櫻井 翔", "birthday" to "1982年1月25日" ,"zodiac" to "みずがめ座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "嵐" , "name" to "大野 智", "birthday" to "1980年11月26日" ,"zodiac" to "いて座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "KAT-TUN" , "name" to "亀梨 和也", "birthday" to "1986年2月23日" ,"zodiac" to "うお座" , "bloodtype" to "B型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "KAT-TUN" , "name" to "上田 竜也", "birthday" to "1983年10月4日" ,"zodiac" to "てんびん座" , "bloodtype" to "B型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "KAT-TUN" , "name" to "中丸 雄一", "birthday" to "1983年9月4日" ,"zodiac" to "おとめ座" , "bloodtype" to "O型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "元KAT-TUN" , "name" to "赤西 仁", "birthday" to "1984年7月4日" ,"zodiac" to "かに座" , "bloodtype" to "O型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "元KAT-TUN" , "name" to "田口 淳之介", "birthday" to "1985年11月29日" ,"zodiac" to "いて座" , "bloodtype" to "AB型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "元KAT-TUN" , "name" to "田中 聖", "birthday" to "1985年11月5日" ,"zodiac" to "さそり座" , "bloodtype" to "B型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "TOKIO" , "name" to "城島 茂", "birthday" to "1970年11月17日" ,"zodiac" to "さそり座" , "bloodtype" to "O型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "元TOKIO" , "name" to "山口 達也", "birthday" to "1972年1月10日" ,"zodiac" to "やぎ座" , "bloodtype" to "O型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "TOKIO" , "name" to "松岡 昌宏", "birthday" to "1977年1月11日" ,"zodiac" to "やぎ座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "TOKIO" , "name" to "国分 太一", "birthday" to "1974年9月2日" ,"zodiac" to "やぎ座" , "bloodtype" to "O型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "TOKIO" , "name" to "長瀬 智也", "birthday" to "1978年11月7日" ,"zodiac" to "さそり座" , "bloodtype" to "O型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "V6" , "name" to "坂本 昌行", "birthday" to "1971年7月24日" ,"zodiac" to "しし座" , "bloodtype" to "O型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "V6" , "name" to "長野博", "birthday" to "1972年10月9日" ,"zodiac" to "てんびん座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "V6" , "name" to "井ノ原 快彦", "birthday" to "1976年5月17日" ,"zodiac" to "おうし座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "V6" , "name" to "三宅 健", "birthday" to "1979年7月2日" ,"zodiac" to "かに座" , "bloodtype" to "O型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "V6" , "name" to "森田 剛", "birthday" to "1979年2月20日" ,"zodiac" to "うお座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "V6" , "name" to "岡田 准一", "birthday" to "1980年11月18日" ,"zodiac" to "さそり座" , "bloodtype" to "B型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "Kinki Kids" , "name" to "堂本 光一", "birthday" to "1979年1月1日" ,"zodiac" to "やぎ座" , "bloodtype" to "B型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "Kinki Kids" , "name" to "堂本 剛", "birthday" to "1979年4月10日" ,"zodiac" to "おひつじ座" , "bloodtype" to "AB型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "元タッキー&翼" , "name" to "滝沢 秀明", "birthday" to "1982年3月29日" ,"zodiac" to "おひつじ座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "元タッキー&翼" , "name" to "今井 翼", "birthday" to "1981年10月17日" ,"zodiac" to "てんびん座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "NEWS" , "name" to "小山 慶一郎", "birthday" to "1984年5月1日" ,"zodiac" to "おうし座" , "bloodtype" to "O型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "NEWS" , "name" to "加藤 シゲアキ", "birthday" to "1987年7月11日" ,"zodiac" to "かに座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "NEWS" , "name" to "増田 貴久　", "birthday" to "1986年7月4日" ,"zodiac" to "かに座" , "bloodtype" to "O型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "NEWS" , "name" to "手越 祐也　", "birthday" to "1987年11月11日" ,"zodiac" to "さそり座" , "bloodtype" to "B型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "関ジャニ∞" , "name" to "横山 裕", "birthday" to "1981年5月9日" ,"zodiac" to "おうし座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "元関ジャニ∞" , "name" to "渋谷 すばる", "birthday" to "1981年9月22日" ,"zodiac" to "おうし座" , "bloodtype" to "O型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "関ジャニ∞" , "name" to "村上 信五", "birthday" to "1982年1月26日" ,"zodiac" to "みずがめ座" , "bloodtype" to "AB型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "関ジャニ∞" , "name" to "安田 章大", "birthday" to "1984年9月11日" ,"zodiac" to "おとめ座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "関ジャニ∞" , "name" to "丸山 隆平", "birthday" to "1983年11月26日" ,"zodiac" to "いて座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "関ジャニ∞" , "name" to "大倉 忠義", "birthday" to "1985年5月16日" ,"zodiac" to "おうし座" , "bloodtype" to "O型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "関ジャニ∞" , "name" to "錦戸 亮", "birthday" to "1984年11月3日" ,"zodiac" to "さそり座" , "bloodtype" to "O型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "Hey! Say! JUMP" , "name" to "山田 涼介", "birthday" to "1993年5月9日" ,"zodiac" to "おうし座" , "bloodtype" to "B型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "Hey! Say! JUMP" , "name" to "知念 侑李", "birthday" to "1993年11月30日" ,"zodiac" to "いて座" , "bloodtype" to "AB型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "Hey! Say! JUMP" , "name" to "有岡 大貴", "birthday" to "1991年4月15日" ,"zodiac" to "おひつじ座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "Hey! Say! JUMP" , "name" to "伊野尾 慧", "birthday" to "1990年6月22日" ,"zodiac" to "かに座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "Hey! Say! JUMP" , "name" to "中島 裕翔", "birthday" to "1993年8月10日" ,"zodiac" to "しし座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "Hey! Say! JUMP" , "name" to "岡本 圭人", "birthday" to "1993年4月1日" ,"zodiac" to "おひつじ座" , "bloodtype" to "O型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "Hey! Say! JUMP" , "name" to "八乙女 光", "birthday" to "1990年12月2日" ,"zodiac" to "いて座" , "bloodtype" to "O型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "Hey! Say! JUMP" , "name" to "高木 雄也", "birthday" to "1990年3月26日" ,"zodiac" to "いて座" , "bloodtype" to "O型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "Hey! Say! JUMP" , "name" to "薮 宏太", "birthday" to "1990年1月31日" ,"zodiac" to "みずがめ座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "Kis-My-Ft2" , "name" to "北山 宏光", "birthday" to "1985年9月17日" ,"zodiac" to "おとめ座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "Kis-My-Ft3" , "name" to "千賀 健永", "birthday" to "1991年3月23日" ,"zodiac" to "おひつじ座" , "bloodtype" to "AB型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "Kis-My-Ft4" , "name" to "宮田 俊哉", "birthday" to "1988年9月14日" ,"zodiac" to "おとめ座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "Kis-My-Ft5" , "name" to "横尾 渉", "birthday" to "1986年5月16日" ,"zodiac" to "おうし座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "Kis-My-Ft6" , "name" to "藤ヶ谷 太輔", "birthday" to "1987年6月25日" ,"zodiac" to "かに座" , "bloodtype" to "AB型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "Kis-My-Ft7" , "name" to "玉森 裕太", "birthday" to "1990年3月17日" ,"zodiac" to "うお座" , "bloodtype" to "B型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "Kis-My-Ft8" , "name" to "二階堂 高嗣", "birthday" to "1990年8月6日" ,"zodiac" to "しし座" , "bloodtype" to "B型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "Sexy Zone" , "name" to "中島 健人", "birthday" to "1994年3月13日" ,"zodiac" to "うお座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "Sexy Zone" , "name" to "菊池 風磨", "birthday" to "1995年3月7日" ,"zodiac" to "うお座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "Sexy Zone" , "name" to "佐藤 勝利", "birthday" to "1996年10月30日" ,"zodiac" to "てんびん座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "Sexy Zone" , "name" to "松島 聡", "birthday" to "1997年11月27日" ,"zodiac" to "いて座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "Sexy Zone" , "name" to "マリウス 葉", "birthday" to "36615" ,"zodiac" to "おひつじ座" , "bloodtype" to "O型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "A.B.C-Z" , "name" to "橋本 良亮", "birthday" to "1993年7月15日" ,"zodiac" to "かに座" , "bloodtype" to "B型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "A.B.C-Z" , "name" to "戸塚 祥太", "birthday" to "1986年11月13日" ,"zodiac" to "さそり座" , "bloodtype" to "B型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "A.B.C-Z" , "name" to "河合 郁人", "birthday" to "1987年10月20日" ,"zodiac" to "てんびん座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "A.B.C-Z" , "name" to "五関 晃一", "birthday" to "1985年6月17日" ,"zodiac" to "ふたご座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "A.B.C-Z" , "name" to "塚田 僚一", "birthday" to "1986年12月10日" ,"zodiac" to "いて座" , "bloodtype" to "O型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "ジャニーズWEST" , "name" to "重岡 大毅", "birthday" to "1992年8月26日" ,"zodiac" to "おとめ座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "ジャニーズWEST" , "name" to "桐山 照史", "birthday" to "1989年8月31日" ,"zodiac" to "おとめ座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "ジャニーズWEST" , "name" to "中間 淳太", "birthday" to "1987年10月21日" ,"zodiac" to "てんびん座" , "bloodtype" to "O型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "ジャニーズWEST" , "name" to "神山 智洋", "birthday" to "1993年7月1日" ,"zodiac" to "かに座" , "bloodtype" to "型　兵","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "ジャニーズWEST" , "name" to "藤井 流星", "birthday" to "1993年8月18日" ,"zodiac" to "しし座" , "bloodtype" to "B型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "ジャニーズWEST" , "name" to "濵田 崇裕", "birthday" to "1988年12月19日" ,"zodiac" to "いて座" , "bloodtype" to "AB型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "ジャニーズWEST" , "name" to "小瀧 望", "birthday" to "1996年7月30日" ,"zodiac" to "ふたご座" , "bloodtype" to "O型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "少年隊" , "name" to "錦織 一清", "birthday" to "1965年5月22日" ,"zodiac" to "ふたご座" , "bloodtype" to "O型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "少年隊" , "name" to "植草 克秀", "birthday" to "1966年7月24日" ,"zodiac" to "ふたご座" , "bloodtype" to "O型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "少年隊" , "name" to "東山 紀之", "birthday" to "1966年9月30日" ,"zodiac" to "てんびん座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "ソロ" , "name" to "近藤 真彦", "birthday" to "1964年7月19日" ,"zodiac" to "かに座" , "bloodtype" to "なし","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "ソロ" , "name" to "佐野 瑞樹", "birthday" to "1973年9月26日" ,"zodiac" to "てんびん座" , "bloodtype" to "O型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "ソロ" , "name" to "屋良 朝幸", "birthday" to "1983年2月1日" ,"zodiac" to "みずがめ座" , "bloodtype" to "AB型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "ソロ" , "name" to "風間 俊介", "birthday" to "1983年6月17日" ,"zodiac" to "ふたご座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "ソロ" , "name" to "生田 斗真", "birthday" to "1984年10月7日" ,"zodiac" to "てんびん座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "ソロ" , "name" to "長谷川 純", "birthday" to "1985年10月29日" ,"zodiac" to "さそり座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "ソロ" , "name" to "内 博貴", "birthday" to "1986年9月10日" ,"zodiac" to "おとめ座" , "bloodtype" to "AB型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "ソロ" , "name" to "中山 優馬", "birthday" to "1994年1月13日" ,"zodiac" to "やぎ座" , "bloodtype" to "A型","imagename" to 0))
            insert( "talentTable",mapOf("groupname" to "ソロ" , "name" to "山下 智久", "birthday" to "1985年4月9日" ,"zodiac" to "おひつじ座" , "bloodtype" to "A型","imagename" to 0))

        }
    }
    //挿入
    fun insert(tableName:String, valueMap : Map<String,Any>){
        val values = ContentValues()

        valueMap.forEach{
            if( it.key == "imagename" ){
                values.put(it.key,it.value as Int)
            }else{
                values.put(it.key,it.value as String)
            }
        }

        val db = dbhepler.writableDatabase
        db.insertOrThrow(tableName,null,values )

    }

    //更新
    //where = " name = ?"の形式
    fun update( tableName : String , where : String, keyArray : Array<String>, valueMap : Map<String,String>){

        val values = ContentValues()

        valueMap.forEach{
            values.put( it.key,it.value )
        }
        val db = dbhepler.writableDatabase

        db.update( tableName, values,where,keyArray )
    }

    //カーソルの取得
    fun getCursor( sql : String, array : Array<String> ):Cursor{
        val db = dbhepler.writableDatabase
        val cur = db.rawQuery(sql,array)

        return cur
    }
}