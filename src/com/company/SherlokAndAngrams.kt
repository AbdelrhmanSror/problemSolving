package com.company

import java.sql.Array
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


fun main() {
    print(SherlokAndAnagrams("abab").sherlockAndAnagrams())
}


/**
 * Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string.
 * Given a string,find the number of pairs of substrings of the string that are anagrams of each other.
 */
class SherlokAndAnagrams(private val s: String) {
    //key is the sum of chars ascii and value is number of times that this ascii has been repeated
    private val anagramMap = HashMap<String, Int>()
    private var previousAnagrams = arrayListOf<String>()
    private var anagramCounter = 0
    // Complete the sherlockAndAnagrams function below.

    fun sherlockAndAnagrams(): Int {
        //abab 5
        for (char in s) {
            val latestAnagrams = arrayListOf<String>()
            addOrIncrementIfExist("$char", latestAnagrams)
            for (i in previousAnagrams) {
                val tempString= String((i+char).toCharArray().sortedArray())
                addOrIncrementIfExist(tempString, latestAnagrams)

            }
            previousAnagrams = latestAnagrams
            println(previousAnagrams)

        }
        return anagramCounter
    }

    private fun addOrIncrementIfExist(currentString: String, latestAnagrams: ArrayList<String>) {
        //check if map contains the current char so if it is we increment the the number of times and also increment the anagram counter
        if (anagramMap.containsKey(currentString)) {
            anagramMap[currentString] = anagramMap[currentString]?.plus(1)!!
            anagramCounter += anagramMap[currentString]!! -1

        } else {
            anagramMap[currentString] = 1
        }
        latestAnagrams.add(currentString)
    }


}
