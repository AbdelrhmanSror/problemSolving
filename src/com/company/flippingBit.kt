package com.company

import kotlin.math.pow

fun main() {
    print(flippingBits(4))
}

// Complete the flippingBits function below.
fun flippingBits(n: Long): Long {
    val binary = n.toULong().toString(radix = 2)
    println(binary)
    return binary.complement().toLong(2)


}
fun String.complement(): String {
    val number = CharArray(32) { '0' }
    for (i in this.indices) {
        number[31-i] = this[this.length-1-i]
    }
    for (i in number.indices) {
        number[i] = if (number[i] == '1') '0' else '1'
    }
    return String(number)
}