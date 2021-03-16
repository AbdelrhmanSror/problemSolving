package com.company


fun main() {
    findSubSetCanAddUp(arrayOf(3,43,4,12,5,2), 9).forEach {
        println(it)
    }
}

fun findSubSetCanAddUp(arr: Array<Int>, value: Int): ArrayList<Int> {
    val outputArray = ArrayList<Int>()
    findSubSetCanAddUp(arr, outputArray, value)
    return outputArray
}

fun findSubSetCanAddUp(arr: Array<Int>, outputArray: ArrayList<Int>, value: Int, startIndex: Int = 0, sum: Int = 0): Boolean {
    if (sum == value) {
        return true
    }
    if (sum > value) {
        return false
    }
    for (i in startIndex until arr.size) {
        val result = findSubSetCanAddUp(arr, outputArray, value, i + 1, sum + arr[i])
        if (result) {
            outputArray.add(arr[i])
            return result
        }

    }
    return false
}