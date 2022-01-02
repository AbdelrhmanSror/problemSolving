package com.company

import java.util.*

/**
 * There are  16 hourglasses in array . An hourglass sum is the sum of an hourglass' values.
 * Calculate the hourglass sum for every hourglass in arr ,
 * then print the maximum hourglass sum. The array will always be 6*6 .
 */

fun main() {
    val scan = Scanner(System.`in`)

    val arr = Array<Array<Int>>(6) { Array<Int>(6) { 0 } }

    for (i in 0 until 6) {
        arr[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

     println(hourglassSum(arr))

}

fun hourglassSum(arr: Array<Array<Int>>): Int {
    var max = Int.MIN_VALUE
    for (row in 0 until 4) {
        for (col in 0 until 4) {
            val first = arr[row][col]
            val second = arr[row][col + 1]
            val third = arr[row][col + 2]
            val fourth = arr[row + 1][col + 1]
            val fifth = arr[row + 2][col]
            val sixth = arr[row + 2][col + 1]
            val seventh = arr[row + 2][col + 2]
            val sum = first + second + third + fourth + fifth + sixth + seventh
            if (max < sum)
                max = sum


        }
    }
    return max
}

