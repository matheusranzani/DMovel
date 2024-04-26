package com.example.myapplication

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

fun greet() {
    println("Hello")
}

fun add(a: Int, b: Int): Int {
    return a + b
}

fun greetPerson(name: String = "Guest") {
    println("Hello $name")
}

fun multiply(a: Int, b: Int) = a * b

class ExampleUnitTest {

    val greetLambda:() -> Unit = { println("Hello from Lambda") }

    val addlambda:(Int, Int) -> Int = { a, b -> a + b }

    val f1 = { a: Int ->
        val c = a + 10
        c
    }

    @Test
    fun addition_isCorrect() {
        greet()
        greetPerson()
        greetPerson("Chuck")
    }
}