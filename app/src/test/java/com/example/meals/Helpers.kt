package com.example.meals

import java.io.InputStreamReader

object Helpers {
    fun readFileResources(filename: String):String{
        val inputStream = Helpers::class.java.getResourceAsStream(filename)
        val builder = StringBuilder()
        val reader = InputStreamReader(inputStream,"UTF-8")
        reader.readLines().forEach(){
            builder.append(it)
        }
        return builder.toString()
    }
}