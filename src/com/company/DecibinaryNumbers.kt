package com.company

import kotlin.math.pow

fun main() {
    print(decibinaryNumbers(1000000))


}


// Complete the decibinaryNumbers function below.
fun decibinaryNumbers(x: Long): Long {
    var i = 1
    var number = 0
    var result = 0L
    while (i <= x) {
        val outputList = ArrayList<Long>()
        getDeciBinaryNumbers(outputList, number)
        if (i + outputList.size - 1 >= x) {
            outputList.sort()
            result = outputList[x.toInt() - i]
            return result

        }
        if (i + 2 * (outputList.size-1)+1 >= x) {
            outputList.clear()
            getDeciBinaryNumbers(outputList, number + 1)
            outputList.sort()
            result = outputList[x.toInt() - (i + outputList.size) ]
            return result
        }
        i += 2 * outputList.size
        number += 2
    }
    return result

}

/**
 * [outputList] is the list of various int that represent this number in deciBinary
 * [value] the actual value we want to find its deciBinary
 * [valueYetNow] the deciBinary value yet constructed
 * [level] level of tree so we multiply the number by 2^level
 * [number] the number that represent the current value in deciBinary
 */
fun getDeciBinaryNumbers(outputList: ArrayList<Long>, value: Int, valueYetNow: Int = 0, level: Int = 0, number: Long = 0L) {
    if (value == valueYetNow) {
        outputList.add(number)
        return
    } else if (2.0.pow(level) > value || valueYetNow > value) {
        return
    }
    for (i in 0..(value / 2.0.pow(level)).toInt()) {
        getDeciBinaryNumbers(outputList, value, valueYetNow + i * 2.0.pow(level).toInt(), level + 1, number + i * 10.0.pow(level).toInt())
    }
}


// Complete the decibinaryNumbers function below.
fun decibinaryNumbers2(x: Long): Long {
    var i = 1
    var number = 0L
    var result=0L
    while (i <= x) {
        val outputList = ArrayList<Long>()
        getDeciBinaryNumbers(outputList, number.toInt())
        if (i + outputList.size-1 >= x) {
            outputList.sort()
            result = outputList[x.toInt() - i]

        }
        i += outputList.size
        number += 1
    }
    return result

}

