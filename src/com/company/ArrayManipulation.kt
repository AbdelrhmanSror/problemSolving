package com.company

/**
 * Starting with a 1-indexed array of zeros and a list of operations,
 * for each operation add a value to each the array element between two given indices,inclusive.
 * Once all operations have been performed, return the maximum value in the array.
 */
fun main() {
    print(arrayManipulation(10, arrayOf(
            arrayOf(2, 6, 8),
            arrayOf(3, 5, 7),
            arrayOf(1, 8, 1), arrayOf(5, 9, 15))))
}


// Complete the arrayManipulation function below.
fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
    var max = 0L
    var tempMax = 0L
    val extendArray = Array(n) { 0 }
    //adding the value at start range with positive while in the end range in  negative,
    // this will indicate that the value of this range is out and not included in the next calculations
    queries.forEach {
        extendArray[it[0] - 1] += it[2]
        if (it[1] < n)
            extendArray[it[1]] -= it[2]
    }
    extendArray.forEach {
        tempMax += it
        if (tempMax >= max)
            max = tempMax
    }
    return max

}
