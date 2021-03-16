package com.company

fun main() {
    print(findLowestMissingPositiveNumber(arrayOf( 1, 1, 0, -1, -2)))
}

fun findLowestMissingPositiveNumber(array: Array<Int>): Int {
    var number = -1
    for (i in array.indices) {
        if (array[i] in 1..array.size) {
            array.doSwapping(i, array[i] - 1)
        }
    }
    for (i in array.indices) {
        if (array[i] in 1..array.size) {
            array.doSwapping(i, array[i] - 1)
        }
    }
    loop@ for (i in array.indices) {
        if (i + 1 != array[i]) {
            number = i + 1
            break@loop
        }
    }
    if (number == -1) {
        return array.size
    }
    return number

}

private fun Array<Int>.doSwapping(first: Int, last: Int) {
    val temp = this[last]
    this[last] = this[first]
    this[first] = temp
}