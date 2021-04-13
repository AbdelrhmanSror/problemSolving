package com.company

fun main() {
    //print(superDigit(x,100000))

    print(digitSum("3546630947312051453014172159647935984478824945973141333062252613718025688716704470547449723886626736", 100000))

}


fun digitSum(n: String, k: Int = 0): String {
    if (n.length == 1)
        return n
    return digitSum(n.sumOfRepeatDigits(k).sumDigit().toString())
}

/**
 * responsible for sum of each number of a digit that repeats k times
 */
fun String.sumOfRepeatDigits(k: Int): String {
    if (k == 0) return this
    var number = 0L
    this.forEach {
        number += it.toString().toLong()
    }

    return number.times(k).toString()

}

//splitting each number in a digit then sum all numbers together
fun String.sumDigit(): Long {
    var number = 0L
    this.forEach {
        number += it.toString().toLong()
    }
    return number

}
