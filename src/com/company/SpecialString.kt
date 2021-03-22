package com.company

import java.lang.Long.min
import java.util.*
import kotlin.collections.ArrayList


fun main() {

    println(getSpecialStringCount("aabaa"))


}


/**
 * A string is said to be a special string if either of two conditions is met:
 * All of the characters are the same, e.g. aaa.
 * All characters except the middle one are the same, e.g. aadaa.
 * A special substring is any substring of a string which meets one of those criteria.
 * Given a string, determine how many special substrings can be formed from it.
 */
fun getSpecialStringCount(s: String): Long {
    var counter = 0L
    when {
        s.isEmpty() -> return 0
        s.length == 1 -> return 1
        else -> {
            val charList = ArrayList<Point>()
            var tempCount: Long = 0
            var start = 0
            var ch = s[0]
            var startIndex: Int
            var middleIndex: Int
            //counter of special string that pass case 1
            //also accumulate counter of sequential char in list
            //so is string is aabaa   the list will contains a:2  b:1  a:2
            for (i in 1 until s.length) {
                //if current string equal to previous string then add all possible palindrome of this string to counter
                if (ch == s[i]) {
                    tempCount += (i - start)
                } else {
                    //when the case fails we reset the counter after passing its value to the actual counter
                    counter += tempCount
                    charList.add(Point(ch, (i - start).toLong()))
                    tempCount = 0
                    ch = s[i]
                    //update the new start index
                    start = i
                }
            }
            charList.add(Point(ch, (s.length - start).toLong()))
            //adding the length of string to counter because char itself is considered as special string
            counter += tempCount + s.length
            //continue with checking the special string that achieve case 2
            if (charList.size >= 3) {
                for (i in 2 until charList.size) {
                    startIndex = i - 2
                    middleIndex = (startIndex + i) / 2
                    //if the current char number is equal to previous char number and
                    // middle char count is equal to 1 and doesn't equal to any of current and previous char then there is a special string
                    if (charList[startIndex].key == charList[i].key && charList[middleIndex].count == 1L && charList[middleIndex].key != charList[startIndex].key) {
                        counter += min(charList[startIndex].count, charList[i].count)
                    }
                }
            }


        }
    }
    return counter
}


data class Point(var key: Char, var count: Long)
