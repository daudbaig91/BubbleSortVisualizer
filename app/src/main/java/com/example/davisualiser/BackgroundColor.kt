package com.example.davisualiser
import android.graphics.Color
import android.util.Log
import android.widget.LinearLayout
import androidx.core.view.iterator

import android.widget.TextView

//package com.example.davisualiser


class BackgroundColor {
    var changedNumber: Int = 0


    fun backgroundChanger(linearl:LinearLayout,pos:Int):LinearLayout {
        Log.d("test3",changedNumber.toString())
        if(changedNumber != 0){
            (linearl.getChildAt(changedNumber)as TextView).setTextColor(Color.parseColor("#000000"))
            (linearl.getChildAt(changedNumber) as TextView).setBackgroundColor(Color.TRANSPARENT)
        }



        (linearl.getChildAt(pos) as TextView).setTextColor(Color.parseColor("#FFFFFF"))
        (linearl.getChildAt(pos) as TextView).setBackgroundColor(Color.BLACK)

        changedNumber = pos


        return linearl
    }
}