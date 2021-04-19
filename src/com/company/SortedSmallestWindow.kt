package com.company

import org.w3c.dom.ranges.Range
import kotlin.math.max
import kotlin.math.min

//given an array of integer are out of order determine the bound of smallest window that must be sorted in order,
//for the entire array to be sorted
//for example [3,7,5,6,9]  should return [1,3]
data class WindowIndex(var first: Int = Int.MAX_VALUE, var last: Int = Int.MIN_VALUE)


fun main() {
    print(smallestWindow2(arrayOf(3, 7, 5, 6, 9)))
}

fun Array<Int>.indicesDown() = this.size - 1 downTo 0
// o(n) time o(1) space
fun smallestWindow2(array: Array<Int>): WindowIndex {
    val windowIndex = WindowIndex()
    var max = array[0]
    var min = array[array.size - 1]
    //finding the last number that will be used in swapping
    for (i in array.indices) {
        //find the max number that will be used to detmine the last number will be swapped
        max = max(max, array[i])
        if (array[i] < max) windowIndex.last = i
    }
    for (i in array.indicesDown()) {
        min = min(min, array[i])
        if (array[i] > min) windowIndex.first = i
    }
    return windowIndex
}


// o(n^2) time solution
fun smallestWindow(array: Array<Int>): WindowIndex {
    //applying bubbles sort
    val windowIndex = WindowIndex()
    for (i in array.indices) {
        for (j in i + 1 until array.size - 1) {
            if (array[i] > array[j]) {
                array.swap(i, j)
                windowIndex.first = min(windowIndex.first, min(i, j))
                windowIndex.last = max(windowIndex.last, max(i, j))
            }

        }
    }
    return windowIndex
}
