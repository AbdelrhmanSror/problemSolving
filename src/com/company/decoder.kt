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
    print(minimumSwaps(arrayOf(2, 3, 4, 1, 5)))
}


// Complete the arrayManipulation function below.
fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
    var max = 0L
    val queryMap = HashMap<Int, Long>()
    for (array in queries) {
        for (i in array[0]..array[1]) {
            if (queryMap.containsKey(i)) {
                queryMap[i] = queryMap[i]?.plus(array[2])!!
            } else {
                queryMap[i] = array[2].toLong()
            }
            if (max < queryMap[i]!!) {
                max = queryMap[i]!!
            }
        }
    }

    return max

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

fun minimumSwaps(arr: Array<Int>): Int {
    var counter = 0
    val extendArray = TreeMap<Int, Int>(CompareElement())
    for (i in arr.indices) {
        extendArray[arr[i]] = i
    }
    for (i in arr.indices) {
        val firstSorted = extendArray.firstKey()
        if (arr[i] > firstSorted) {
            counter++
            extendArray[arr[i]] = extendArray[firstSorted]!!
            arr.swap(i, extendArray[firstSorted]!!)
        }
        extendArray.remove(firstSorted)

    }

    return counter
}

fun Array<Int>.swap(first: Int, last: Int) {
    val temp = this[first]
    this[first] = this[last]
    this[last] = temp
}

data class Node(val numberOfWays: Int, val prevNode: Node? = null)

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