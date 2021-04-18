package com.company

import java.util.*
import kotlin.Comparator
import kotlin.math.ceil
import kotlin.math.floor

/**
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message,
 * count the number of ways it can be decoded.
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 * You can assume that the messages are decodable. For example, '001' is not allowed */

/**
 * the approach i will take is to add up prevnumber of ways to the current way .
 * also if it is applicable to construct a number with current number and previous number i will add up the previous of previous numberOfWays
 */


fun main() {
    //print(getNumberOfWays("111"))
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