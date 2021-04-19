package com.company

import java.util.*


fun main() {

    println(smallestRotatedString("daily", 3))
}

//giving a string of length n and an integer k ,the string can be manipulated by taking one of the first k letter and moving to the end of the string
//return the smallest lexicographically string after rotation
fun smallestRotatedString(s: String, k: Int): String {
    var currentRotatedString = s
    var smallestString = s
    //when k ==1 we only allowed to swap first item in string
    //making a loop on string that starts from first until last element excluded
    //because if we would iterate to last index would return our original string back again
    return if (k == 1) {
        for (i in 0 until s.length - 1) {
            currentRotatedString = currentRotatedString.substring(k until s.length) + currentRotatedString.substring(0 until k)
            if (currentRotatedString < smallestString)
                smallestString = currentRotatedString
        }
        smallestString
    } else
        s.toCharArray().sorted().joinToString("")

}
