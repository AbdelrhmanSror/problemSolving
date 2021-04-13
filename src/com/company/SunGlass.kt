package com.company

import java.util.*


fun main() {
    val scan = Scanner(System.`in`)

    val arr = Array<Array<Int>>(6) { Array<Int>(6) { 0 } }

    for (i in 0 until 6) {
        arr[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    println(sunGlassMax(arr))

}

/**
 * There are  16 hourglasses in array . An hourglass sum is the sum of an hourglass' values.
 * Calculate the hourglass sum for every hourglass in arr ,
 * then print the maximum hourglass sum. The array will always be 6*6 .
 */
fun sunGlassMax(arr: Array<Array<Int>>): Int {
    var max = Int.MIN_VALUE
    for (i in 0..3) {
        for (j in 0..3) {
            val value = getSumValues(i, j, arr)
            if (max < value) max = value

        }
    }
    return max
}

fun getSumValues(startRow: Int, startColumn: Int, arr: Array<Array<Int>>): Int {
    //firstRowFirstColumn
    val fRfC = Pair(startRow, startColumn)
    //firstRowSecondColumn
    val fRsC = Pair(startRow, startColumn + 1)
    //firstRowThirdColumn
    val fRtC = Pair(startRow, startColumn + 2)
    //secondRowSecondColumn
    val sRsC = Pair(startRow + 1, startColumn + 1)
    //thirdRowFirstColumn
    val tRfC = Pair(startRow + 2, startColumn)
    //thirdRowSecondColumn
    val tRsC = Pair(startRow + 2, startColumn + 1)
    //thirdRowThirdColumn
    val tRtC = Pair(startRow + 2, startColumn + 2)
    return arr[fRfC.first][fRfC.second] + arr[fRsC.first][fRsC.second] + arr[fRtC.first][fRtC.second] + arr[sRsC.first][sRsC.second] + arr[tRfC.first][tRfC.second] + arr[tRsC.first][tRsC.second] + arr[tRtC.first][tRtC.second]


}

