package com.company

import kotlin.collections.HashMap

fun main() {
    val array = arrayOf(2, 3, 4, 1, 5)
    println(minimumSwaps2(array))
}

/**
 * You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates.
 * You are allowed to swap any two elements.
 * Find the minimum number of swaps required to sort the array in ascending order.
 */
fun minimumSwaps2(array: Array<Int>): Int {
    val hashMap = HashMap<Int, Int>()
    var counter = 0
    //record the position of each element in hash map for easy-quick access
    array.forEachIndexed { index, i ->
        hashMap[i] = index
    }
    for (i in array.indices) {
        if (array[i] - 1 != i) {
            val num2 = hashMap[i + 1]!! //index of number 2
            //update the position of both swapped items
            hashMap[array[i]] = num2 //index of number 1
            hashMap[array[num2]] = i //index of number 1
            //swapping the current number with the number that is rightful for the current position
            array.swap(num2, i)
            counter++
        }
    }
    return counter
}

fun <T> Array<T>.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

