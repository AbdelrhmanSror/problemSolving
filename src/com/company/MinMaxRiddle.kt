package com.company

import java.util.*
import kotlin.collections.HashMap
import kotlin.math.min

fun main() {
    /* riddle(arrayOf(6, 3, 5, 1, 12)).forEach {
         println(it)
     }*/
    riddle2(arrayOf(78, 69, 53, 20,
            45, 98, 71, 94
    )).forEach {
        println(it)
    }
}

/**
 * Given an integer array of size ,
 * find the maximum of the minimum(s) of every window size in the array.
 * The window size varies from  1 to n .
 */

//Brute force Solution takes O(n^3) and O(N) space
fun riddle(arr: Array<Long>): Array<Long> {
    val windowSizeMax = Array<Long>(arr.size) { 0 }
    val windowSizePrevMin = Array<Long>(arr.size) { 0 }

    for (i in arr.indices) {
        for (j in i until arr.size) {
            val min: Long = if (j - i == 1 || j - i == 0) {
                min(arr[j], arr[i])
            } else {
                min(arr[j], windowSizePrevMin[j - i - 1])
            }
            windowSizeMax[j - i] = maxOf(windowSizeMax[j - i], min)
            windowSizePrevMin[j - i] = min

        }
    }
    return windowSizeMax

}

//optimized solution takes O(N)time  O(N)space
fun riddle2(array: Array<Long>): Array<Long> {
    val heightStack = Stack<Long>()
    val positionStack = Stack<Int>()
    val windowMap = HashMap<Int, Long>()
    var i = 0
    while (i < array.size) {

        if (heightStack.isEmpty() && positionStack.isEmpty()) {
            heightStack.push(array[i])
            positionStack.push(i)

        } else {
            calMinNumberOfWindow(heightStack, array, i, positionStack, windowMap)
        }
        i++
    }

    for (j in heightStack.indices) {
        val position = positionStack.pop()
        windowMap[i - position] = if (windowMap.containsKey(i - position)) maxOf(windowMap[i - position]!!, heightStack.pop()) else heightStack.pop()

    }
    var currentValue = 0L
    for (j in array.size - 1 downTo 0) {
        if (windowMap.containsKey(j + 1) && windowMap[j + 1]!! > currentValue) {
            currentValue = windowMap[j + 1]!!
            array[j] = currentValue
        } else {
            array[j] = currentValue
        }
    }
    return array
}

private fun calMinNumberOfWindow(heightStack: Stack<Long>, array: Array<Long>, i: Int, positionStack: Stack<Int>, windowMap: HashMap<Int, Long>) {
    if (heightStack.isNotEmpty() && array[i] < heightStack.peek()) {
        while (array[i] < heightStack.peek()) {
            val position = positionStack.pop()
            windowMap[i - position] = if (windowMap.containsKey(i - position)) maxOf(windowMap[i - position]!!, heightStack.pop()) else heightStack.pop()
            if (heightStack.isEmpty() || array[i] >= heightStack.peek()) {
                Pair(heightStack, positionStack).push(array[i], position)
            }
        }
    } else if (array[i] >= heightStack.peek()) {
        Pair(heightStack, positionStack).push(array[i], i)
    }
}

fun Pair<Stack<Long>, Stack<Int>>.push(firstInput: Long, secondInput: Int) {
    first.push(firstInput)
    second.push(secondInput)
}

