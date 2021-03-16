package com.company

import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

fun main(){
    print(primality(9))
}
// Complete the primality function below.
fun primality(n: Int): String {
    if(n<=1)return "Not prime"
    val nearestSquareRoot=(sqrt(n.toDouble()).roundToInt()).toDouble().pow(2)
    for (i in 2 .. sqrt(nearestSquareRoot).toInt()) {
        if (n.rem(i) == 0) {
            return "Not prime"
        }
    }
    return "Prime"



}


