package com.company.dynamicPorgramming

import java.util.*
import kotlin.Comparator
import kotlin.collections.HashMap
import kotlin.math.pow

/**
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message,
 * count the number of ways it can be decoded.
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 * You can assume that the messages are decodable. For example, '001' is not allowed */

/**
 * the approach i will take is to add up prev number of ways to the current way .
 * also if it is applicable to construct a number with current number and previous number i will add up the previous of previous numberOfWays
 */


fun main() {
    println(getNumberOfDecodedWays("111"))
    println(getNumberOfWays("111"))
}
// if the string is  1567
//will check when power is 3 for validity of 1
//will check when power is 2 for validity of 15
//will check when power is 3 for validity of 156 and so on

fun numberOnLeftLessThan(comparedNumber: Int, stringNumber: String, power: Int): Boolean {
    return stringNumber.toDouble() / 10.0.pow(power).toInt() < comparedNumber
}

fun getNumberOfDecodedWays(s: String, dictionary: HashMap<String, Int> = HashMap()): Int {
    if (s.length == 1) return 0
    var power = s.length - 1
    var counter = 0
    while (power > 0 && numberOnLeftLessThan(27, s, power)) {
        //the reminder string number after first n number based on the power
        // number is 1567  and power is 3 will return 567
        //number is 1567  and power is 2 will return 67
        //number is 1567  and power is 1 will return 7 and so on
        val rightPartNumber = (s.toDouble() % (10.0.pow(power))).toInt()
        if (rightPartNumber < 27) counter++
        counter += if (dictionary.containsKey(rightPartNumber.toString()))
            dictionary[rightPartNumber.toString()]!!
        else
            getNumberOfDecodedWays(rightPartNumber.toString(), dictionary)
        power--
    }
    dictionary[s] = counter
    return counter

}


class CompareElement : Comparator<Int> {
    override fun compare(o1: Int, o2: Int): Int {
        return when {
            o1 > o2 -> 1
            o1 < o2 -> -1
            else -> 0
        }
    }
}

private data class Node(val numberOfWays: Int, val prevNode: Node? = null)

fun getNumberOfWays(message: String): Int {
    var tail: Node? = null
    for (number in message.indices) {
        when (number) {
            //if 0 so no previous node
            0 -> {
                tail = Node(1, null)
            }
            1 -> {
                tail = Node(2, tail)
            }
            else -> {
                var numberOfWays = tail!!.numberOfWays
                if (message[number - 1].toRealInt() * 10 + message[number].toRealInt() < 27) {
                    numberOfWays += tail.prevNode!!.numberOfWays
                }
                tail = Node(numberOfWays, tail)

            }
        }
    }
    return tail!!.numberOfWays
}

fun Char.toRealInt(): Int {
    return this.toInt() - 48
}