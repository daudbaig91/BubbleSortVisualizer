package com.example.davisualiser

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.util.TypedValue
import android.view.animation.TranslateAnimation
import android.widget.RelativeLayout
import android.widget.SeekBar
import java.time.Duration


class SwapAnimation {
    @SuppressLint("NotConstructor")
    fun SwapAnimation(duration: Long,distance:Float ): BubbleSortTranslate {

        val translateAnimation = TranslateAnimation(0F, distance,
            0f,0f)
        translateAnimation.duration = duration

        val translateAnimation2 = TranslateAnimation(0F,-distance
            , 0f,0f)
        translateAnimation2.duration = duration

        return BubbleSortTranslate(
            translateAnimation,
            translateAnimation2
        )
    }
fun dpToPx(dp: Float, context: Context): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp,
        context.getResources().getDisplayMetrics()
    ).toInt()
}
    fun dist(r1:RelativeLayout, r2:RelativeLayout, context: Context):Float{
        var distance1:Float
        val destX = r2.x
        distance1 = (destX- dpToPx(20.toFloat(),context))
        return  distance1
    }
}
