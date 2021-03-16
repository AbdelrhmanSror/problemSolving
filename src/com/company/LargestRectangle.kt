package com.company

import java.util.*

fun main() {
    print(Histogram().largestRectangle(arrayOf(1,3,2,1,2)))
}

class Histogram() {
    private val heightStack = Stack<Int>()
    private val positionStack = Stack<Int>()
    private var max = 0L
    private var i = 0
    fun largestRectangle(array: Array<Int>): Long {
        while (i < array.size) {
            if (heightStack.isEmpty()) {
                heightStack.push(array[i])
                positionStack.push(i)
            } else {
                if (heightStack.isNotEmpty() && array[i] < heightStack.peek()) {
                    while (array[i] < heightStack.peek()) {
                        val position = positionStack.pop()
                        max = maxOf(max, area(position,heightStack.pop()))
                        if (heightStack.isEmpty() || array[i] > heightStack.peek()) {
                            Pair(heightStack, positionStack).push(array[i], position)
                        }
                    }
                } else if (array[i] > heightStack.peek()) {
                    Pair(heightStack, positionStack).push(array[i], i)
                }
            }
            i++
        }
        for (j in heightStack.indices) {
            max = maxOf(max, area(positionStack.pop(),heightStack.pop()))

        }
        return max
    }

    private fun area(endPointWidth: Int, height: Int): Long {
        return height * (i - endPointWidth).toLong()

    }

    fun Pair<Stack<Int>, Stack<Int>>.push(firstInput: Int, secondInput: Int) {
        first.push(firstInput)
        second.push(secondInput)
    }
}

