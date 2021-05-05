package com.company


fun main() {
    print("${isMajority(arrayOf(2, 2, 1, 1))}")
}

fun isMajority(array: Array<Int>): Boolean {
    val index = findMajorityIndex(array)
    var count = 0
    for (i in array.indices) {
        if (array[index] == array[i])
            count++
    }
    if (count > array.size / 2)
        return true
    return false
}

fun findMajorityIndex(array: Array<Int>): Int {
    var majorityIndex = 0
    var count = 0
    for (i in array.indices) {
        if (array[i] == array[majorityIndex]) {
            count++
            continue
        }
        count--
        if (count == 0) {
            majorityIndex = i
            count++
        }
    }
    return majorityIndex
}
