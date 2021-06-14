package com.company

import kotlin.math.pow

//given an array which each element appears 3 times except one element appears one time.
//return the element that appears one time in o(n)time and o(1) space.

fun main() {
   print( getElementAppearsOnce(arrayOf(5, 1, 3, 3, 3, 1, 1)))

}

fun getElementAppearsOnce(elements: Array<Int>):Int {
    //assuming all integers is 32 bit
    val sumOfBitsInNumbers = Array<Int>(32) { 0 }
    for (element in elements) {
        for (bit in 0 until 32) {
            sumOfBitsInNumbers[bit] += (element shr bit) and 1
        }
    }
    var elementAppearsOnce=0
    sumOfBitsInNumbers.forEachIndexed { index, bit ->
        if (bitDoesNotDivideByThree(bit)){
            elementAppearsOnce+=2.0.pow(index).toInt()
        }
    }
    return elementAppearsOnce

}
fun bitDoesNotDivideByThree(bit:Int)=bit % 3 != 0