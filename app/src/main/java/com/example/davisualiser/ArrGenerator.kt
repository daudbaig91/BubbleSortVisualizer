package com.example.davisualiser

import android.annotation.SuppressLint

class ArrGenerator {

    @SuppressLint("NotConstructor")
    fun Randomarr():IntArray{
        val rnds = (6..14).random()
        val list = IntArray(rnds)
        for (i in 0 until rnds) {
            list[i] = ((1..99).random())
        }
        return list
    }

    @SuppressLint("NotConstructor")
    fun SortedAsc():IntArray{
        var list = Randomarr().sortedArray()
        return  list
    }

    @SuppressLint("NotConstructor")
    fun Sorteddesc():IntArray{
        var list = Randomarr().sortedArray().reversedArray()
        return  list
    }

    @SuppressLint("NotConstructor")
    fun nearlySortedAsc():IntArray{
        val list = Randomarr().sortedArray()
        val randm = (0..list.size-2).random()
        val randm3 = (1..2).random()
        val temp = list[randm]
        list[randm] = list[randm+randm3]
        list[randm
        +randm3] = temp
        for(i in 0 until list.size-3)
            if((0..4).random() == 1){
                val rand = (1..2).random()
                val temp = list[i]
                list [i] = list[i + rand]
                list [i+rand] = temp
            }
        return  list
    }


    @SuppressLint("NotConstructor")
    fun nearlySorteddesc():IntArray{
        return  nearlySortedAsc().reversedArray()
    }


}
