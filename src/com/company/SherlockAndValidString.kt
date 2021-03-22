package com.company

import java.util.*
import kotlin.collections.HashMap

fun main() {
    val scan = Scanner(System.`in`)
    val s = scan.nextLine()
    print(isValid(s))

}

/**
 * Sherlock considers a string to be valid if all characters of the string appear the same number of times.
 * It is also valid if he can remove just  character at  index in the string, and the remaining characters will occur the same number of times.
 * Given a string , determine if it is valid. If so, return YES, otherwise return NO.
 */
fun isValid(s: String): Boolean {
    //recurrence of each character
    val rC = HashMap<Char, Int>()
    //recurrence of recurrence of each char
    val rC2 = HashMap<Int, Int>()
    //accumulate each char in hashmap with its recurrence
    rC.calRecurrence(s.toCharArray().toTypedArray())
    rC2.calRecurrence(rC.values.toTypedArray())
    //if there is more than 2 recurrence for chars so this string can not be valid meaning.
    // if i have string that has some chars with recurrence of 2 and other recurrence of 3 and other recurrence of 4 so this string can not be valid
    if (rC2.size > 2) {
        return false
    }
    //i need the minimum recurrence of recurrence of each char to be equal 1 so i can delete it to make string valid otherwise it is not valid.
    val min = rC2.minBy { it.value }
    val max = rC2.maxBy { it.value }
    if (min!!.value == max!!.value && min.key == max.key) return true
    if (min.value == 1) {
        //if the recurrence of char is 1 so we can delete to make string valid
        // or if we can only delete one char to make its occurrence equal to the other char occurrence
        //otherwise we can not make string valid
        return min.key - 1 == 0 || min.key - 1 == max.key
    }
    return false
}

fun <T : Any> HashMap<T, Int>.calRecurrence(s: Array<T>) {
    s.forEach {
        if (this.containsKey(it)) {
            this[it] = this[it]!! + 1
        } else {
            this[it] = 1
        }
    }

}

