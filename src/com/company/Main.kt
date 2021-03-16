package com.company

import java.io.File
import java.io.InputStream
import java.lang.NumberFormatException

fun main() {
    getListOfCases()
}

fun getListOfCases(): List<BadHorse> {
    val listOfBadHorse = arrayListOf<BadHorse>()
    val inputStream: InputStream = File("src/simple.txt").inputStream()
    val lineList = mutableListOf<String>()
    inputStream.bufferedReader().useLines { lines ->
        lines.forEach {
            lineList.add(it)
        }
    }
    val j = 0
    for(i in 0 until(100)) {
        if (lineList[j].isNumber()) {
            val listOfCase = lineList.slice((j + 1)..lineList[j].toInt())
            println(lineList[0])
            BadHorse(listOfCase).apply {
                this.printPairs()
            }
            listOfBadHorse.add(BadHorse(listOfCase))
        }

    }
    return listOfBadHorse
}

fun String.isNumber(): Boolean {
    return try {
        val number = this.toInt()
        true
    } catch (e: NumberFormatException) {
        false
    }
}

private fun piApproximation(terms: Int, n: Int = 1, iteratin: Int = 1): Double {

    var sign: Int
    var pi = 0.0
    if (terms == 0) {
        return 0.0
    }
    with(iteratin)
    {
        sign = when {
            this % 2 == 0 -> 1
            else -> -1
        }
    }
    println("$sign 1/$n")
    pi = (1.0 / n) + sign * piApproximation(terms - 1, n + 2, iteratin + 1)
    return pi


}

