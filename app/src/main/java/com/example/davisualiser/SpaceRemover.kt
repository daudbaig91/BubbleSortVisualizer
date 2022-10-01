package com.example.davisualiser

class SpaceRemover {
    fun SpaceRemover(str:String):String{
        val arr = str.split(' ').toList()
        var Str1 = ""
        for(x in arr) Str1 += x
        return Str1
    }
}