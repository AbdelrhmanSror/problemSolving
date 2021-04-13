package com.company

fun main() {
    val array = arrayOf(1, 2, 5, 3, 7, 8, 6, 4)
    minimumBribes(array)
}

/**
 * It is New Year's Day and people are in line for the Wonderland rollercoaster ride.
 * Each person wears a sticker indicating their initial position in the queue from  to .
 * Any person can bribe the person directly in front of them to swap positions, but they still wear their original sticker.
 * One person can bribe at most two others.
 * Determine the minimum number of bribes that took place to get to a given queue order.
 * Print the number of bribes, or, if anyone has bribed more than two people, print Too chaotic.
 */
fun minimumBribes(q: Array<Int>) {
    var counter = 0
    var i = q.size - 1
    while (i >= 0) {
        if (q[i] - 1 > i) {
            val diff = (q[i] - 1) - i
            if (diff > 2) {
                println("Too chaotic")
                return
            }
            counter += diff
            q.doSwap(i, i + 1)
            if (diff == 2) q.doSwap(i + 1, i + 2)
            i += diff + 1
        }
        i--
    }
    println(counter)
}

fun <T> Array<T>.doSwap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

