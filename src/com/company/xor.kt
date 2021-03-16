package com.company

import kotlin.math.pow

fun main() {
    maxXor(arrayOf(71615901, 446920302, 311451718, 143049466), arrayOf(813089204,
            674134632,
            501563759,
            345989646,
            827253788,
            833775092)).forEach {
        println(it)
    }

}

// Complete the maxXor function below.
fun maxXor(input: Array<Int>, queries: Array<Int>): Array<Int> {
    val trie = Trie()
    trie.insert(input)
    for (q in queries.indices) {
        queries[q] = trie.search(queries[q])
    }
    return queries

}


class Trie(private val map: Array<Trie?> = Array(2) { null }) {
    fun insert(values: Array<Int>) {
        for (i in values)
            insert(i)
    }

    fun search(value: Int): Int {
        var current: Trie = this
        var number = 0
        for (i in 31 downTo 0) {
            val currentNumber = value shr i and 1
            current = if (current.map[currentNumber.invert()] != null) {
                number += (2.0.pow(i).toInt())
                current.map[currentNumber.invert()]!!

            } else {
                current.map[currentNumber]!!
            }
        }
        return number
    }

    private fun Int.invert(): Int {
        return if (this == 0) 1 else 0
    }


    private fun insert(value: Int) {
        var current: Trie = this
        for (i in 31 downTo 0) {
            val currentNumber = value shr i and 1
            current.map[currentNumber] = current.map[currentNumber] ?: Trie()
            current = current.map[currentNumber]!!
        }
    }
}



