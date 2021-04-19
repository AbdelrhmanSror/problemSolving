package com.company

import kotlin.math.max
import kotlin.math.pow

// you can also use imports, for example:
// import kotlin.math.*

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

fun main() {
}

    fun solution(A: IntArray): Int {
        // write your code in Kotlin
        val map = HashSet<Int>()
        var largeNumber = Int.MIN_VALUE
        var number = 1
        A.forEach {
            map.add(it)
            largeNumber = max(largeNumber, it)
        }
        run loop@{
            for (i in 1..largeNumber + 1) {
                if (!map.contains(i)) {
                    number = i
                    return@loop
                }
            }
        }
        return number

    }






