package com.cortez.willie.cop2660

import java.net.SocketOptions

fun main(){

    fun start(): String="OK"

    println(start())



//----------------------------------//
// added 3/15/2021
    println("Named Arguments")

//    fun joinToString(
//        separator: String = ", ",
//        prefix: String = "",
//        postfix: String = "",
//        /* ... */
//    ): String

    fun joinOptions(options: Collection<String>) =
        options.joinToString(",","[","]")


    val chars = listOf<String>('a'.toString(), 'b'.toString(), 'c'.toString(), 'd'.toString(), 'e'.toString())
    chars.joinToString()
    println(chars)

//----------------------------------//
//added 3/16/2021
    println("Triple quoted strings")

    val question = "life, the universe, and everything"
    val answer = 42

    val tripleQuotedString = """
    #question = "$question"
    #answer = $answer""".trimMargin("#")

    println(tripleQuotedString)
//----------------------------------//
    println("String templates")

    val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"

    //fun getPattern(): String = """\d{2} $month \d{4}"""

    fun getPattern():  String = """\d{2}\.\d{2}\.\d{4}"""

    println("13.02.1992".matches(getPattern().toRegex()))

//----------------------------------//
    println("Nullable types")

    class PersonalInfo(
        val email: String?
        )
    class Client(
        val personalInfo: PersonalInfo?
        )


    fun sendMessageToClient(client: Client?, message: String?, mailer: Mailer) {
        val personalInfo = client?.personalInfo?.email?.let {  email ->
        //val email = personalInfo?.email
        //Condition 'email != null' is always 'true'
        if (email != null && message != null) {
            mailer.sendMessage(email, message)
            }
            println(mailer.sendMessage("me@gmail.com","Hello!"))
        }

    }
//---------------------------------------------//
    //The equivalent of VOID in java
    //    fun failWithWrongAge() : Void {
    //        println("Trying with Void return type")
    //    }

    fun failWithWrongAge(age: Int?): Nothing {
        throw IllegalArgumentException("Wrong age: $age")
    }

    fun checkAge(age: Int?) {
        if (age == null || age !in 0..150) failWithWrongAge(age)
        println("Congrats! Next year you'll be ${age + 1}.")
    }

    checkAge(10)

//------------------------------------------//
    val it = 7
    fun containsEven(collection: Collection<Int>): Boolean =
        collection.any { it % 2 == 0}

        if (it % 2 == 0){
            println("$it is even")
        }else{
            println("$it is odd")
        }

    }
//not to be declared local
interface Mailer {
    fun sendMessage(email: String, message: String)
}

