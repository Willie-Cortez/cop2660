package com.cortez.willie.cop2660

import java.net.SocketOptions

fun main(){

    fun start(): String="OK"

    println(start())


// added 3/15/2021
// named arguments
//    fun joinToString(
//        separator: String = ", ",
//        prefix: String = "",
//        postfix: String = "",
//        /* ... */
//    ): String

    fun joinOptions(options: Collection<String>) =
        options.joinToString(",","[","]")

// trying to understand how it works
    val chars = listOf<String>('a'.toString(), 'b'.toString(), 'c'.toString(), 'd'.toString(), 'e'.toString())
    chars.joinToString()
    println(chars)

}