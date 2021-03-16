package com.company

import kotlin.math.cos

fun main(){
   print(getMinimumCost(3, arrayOf(2,5,6)))
}
// Complete the getMinimumCost function below.
fun getMinimumCost(k: Int, c: Array<Int>): Int {
    var previous = -1
    var cost = 0
    c.sort()
    for ((counter, i) in (c.size-1 downTo 0).withIndex()) {
        if (counter.rem(k) == 0)
            previous++
        cost += (previous + 1) * c[i]
    }
    return cost


}