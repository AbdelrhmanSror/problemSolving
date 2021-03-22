package com.company

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    println(alternatingChars("AAABBB"))
}

fun alternatingChars(s: String): Int {
    var counter = 0
    for (i in 1 until s.length) {
        if (s[i] == s[i - 1]) {
            counter++
        }
    }
    return counter
}