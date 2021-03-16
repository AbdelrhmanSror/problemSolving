package com.company

import java.util.*
import kotlin.math.abs

/**
 *
 */
fun main() {
    
    var x = findLeastPrice(1000, arrayOf(700,750), arrayOf(100,350,650))
    print(x)
}

data class ClosestPrice(var difference: Int = Int.MAX_VALUE, var price: Int = Int.MAX_VALUE)

fun findLeastPrice(priceToSpend: Int, flavorsName: Array<Int>, flavorOptions: Array<Int>): Int {
    //diff to price
    val closest = ClosestPrice()
    for (i in flavorsName) {
        update(priceToSpend, i, 0, closest)


    }
    for (i in flavorsName) {
        for (j in flavorOptions) {
            update(priceToSpend, i, j, closest)


        }
    }
    return closest.price
}

private fun update(priceToSpend: Int, i: Int, j: Int, closest: ClosestPrice) {
    val difference = priceToSpend.findDiff(i + j)
    if (difference < closest.difference) {
        closest.difference = difference
        closest.price = i + j
    } else if (difference == closest.difference) {
        if (closest.price > (i + j)) {
            closest.price = i + j
        }


    }
}

fun Int.findDiff(value: Int): Int {
    return abs(this - value)
}