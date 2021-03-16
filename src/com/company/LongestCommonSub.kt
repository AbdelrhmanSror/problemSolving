package com.company

import kotlin.math.max

fun main() {
    print(commonChild("ABCDEF", "FBDAMN"))
}
//optimized solution regrading of space complexity instead of O(n^2) space we use 2n which nearly becomes O(n)
fun commonChild(s1: String, s2: String): Int {
    val countArray = Array<Array<Int>>(2) { Array(s1.length + 1) { 0 } }
    var row = 0
    for (i in s2.indices) {
         row = i and 1
        for (j in s1.indices) {
            countArray[row][j + 1] = if (s2[j] == s1[i]) (countArray[1-row][j] + 1)
            else (max(countArray[row][j], countArray[1-row][j + 1]))

        }
    }
    return countArray[row][s1.length]
}
