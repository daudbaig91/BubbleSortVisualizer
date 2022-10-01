package com.example.davisualiser

import android.view.View

class AnimationRotateimage {
    fun rotateY(view: View, int: Int){
        if (int == 1) {
            view.animate().apply {
                duration = 500
                rotationY(180f)
            }.start()
        }else{
            view.animate().apply {
                duration = 500
                rotationY(0f)
            }.start()
        }
    }
    fun rotateX(view: View,int: Int){
        if (int == 1) {
            view.animate().apply {
                duration = 500
                rotationX(180f)
            }.start()
        }else{
            view.animate().apply {
                duration = 500
                rotationX(0f)
            }.start()
        }
    }
}