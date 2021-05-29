package com.company.tries

import kotlin.math.pow


fun main() {
    println(maxXor(arrayOf(4, 7)))
}

//giving an array of integer find the max xor of two integers.
//o(n^2) time
fun findMax(array: Array<Int>): Int {
    var max = Int.MIN_VALUE
    for (i in array.indices) {
        for (j in i + 1 until array.size) {
            max = maxOf(max, array[i].xor(array[j]))
        }
    }
    return max

}


// time complexity for insertion and finding max is o(k) where k represents the number of bit of the number
//and because we repeats this operation n times which is the length of the array we would say that the total time complexity is o(n*k).
//for space o(n*k) because we reserve n  numbers with k is max number of bits these numbers have.
fun maxXor(input: Array<Int>): Int {
    val trie = Trie2()
    trie.insert(input)
    var max = Int.MIN_VALUE
    for (q in input) {
        max = maxOf(trie.search(q), max)
    }
    return max

}


class Trie2(private val map: Array<Trie2?> = Array(2) { null }) {
    fun insert(values: Array<Int>) {
        for (i in values)
            insert(i)
    }

    fun search(value: Int): Int {
        var current: Trie2? = this
        var number = 0
        val binary = Integer.toBinaryString(value)
        for (i in binary.indices) {
            val invertValue = current?.map?.get(binary[i].toString().toInt().invert())
            current = if (invertValue != null) {
                number += (2.0.pow(binary.length - 1 - i).toInt())
                invertValue

            } else {
                current?.map?.get(binary[i].toString().toInt())
            }
        }
        return number
    }

    private fun Int.invert(): Int {
        return if (this == 0) 1 else 0
    }


    private fun insert(value: Int) {
        var current: Trie2 = this
        val binary = Integer.toBinaryString(value)
        for (bit in binary.indices) {
            //val currentNumber = value shr i and 1
            current.map[binary[bit].toString().toInt()] = current.map[binary[bit].toString().toInt()] ?: Trie2()
            //println("${current.map[0]}  ${current.map[1]}  $bit  $value  $binary  ${binary[bit].toString().toInt()} ")
            current = current.map[binary[bit].toString().toInt()]!!

        }
    }
}

