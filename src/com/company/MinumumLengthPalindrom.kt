package com.company

import java.lang.StringBuilder
import kotlin.math.max

/**
 * Good morning! Here's your coding interview problem for today.
 * This problem was asked by Quora.
 * Given a string, find the palindrome that can be made by inserting the fewest number of characters as possible anywhere in the word.
 * If there is more than one palindrome of minimum length that can be made,
 * return the lexicographically earliest one (the first one alphabetically).
 * For example, given the string "race", you should return "ecarace",
 * since we can add three letters to it (which is the smallest amount to make a palindrome).
 * There are seven other palindromes that can be made from "race" by adding three letters,
 * but "ecarace" comes first alphabetically.
 * As another example, given the string "google", you should return "elgoogle".


 */
fun main() {
    print(getMinLength("abcde"))
}

//time complexity  is O(N^2) space complexity is O(N^2)
fun getMinLength(actualString: String): Int {
    val reversString = actualString.reversed()
    val countArray = Array<Array<Int>>(actualString.length + 1) { Array(actualString.length + 1) { 0 } }
    for (i in reversString.indices) {
        for (j in actualString.indices) {
            countArray[i + 1][j + 1] = if (reversString[j] == actualString[i]) (countArray[i][j] + 1)
            else (max(countArray[i + 1][j], countArray[i][j + 1]))

        }
    }
    return actualString.length - countArray[actualString.length][actualString.length]
}


