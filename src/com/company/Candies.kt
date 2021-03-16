package com.company



/**
 * Alice is a kindergarten teacher.
 * She wants to give some candies to the children in her class.
 * All the children sit in a line and each of them has a rating score according to his or her performance in the class.
 * Alice wants to give at least 1 candy to each child. If two children sit next to each other,
 * then the one with the higher rating must get more candies. Alice wants to minimize the total number of candies she must buy.
 * For example, assume her students' ratings are [4, 6, 4, 5, 6, 2].
 * She gives the students candy in the following minimal amounts: [1, 2, 1, 2, 3, 1].
 * She must buy a minimum of 10 candies
 */
// Complete the candies function below.
fun candies(n: Int, arr: Array<Int>): Long {
    val countArray = Array<Int>(arr.size) { 1 }
    var counter = 0L
    for (i in 0 until arr.size - 1) {
        if (arr[i] < arr[i + 1]) {
            countArray[i + 1] = countArray[i] + 1
        }
    }
    for (i in arr.size - 1 downTo 1) {
        if (arr[i - 1] > arr[i]) {
            countArray[i - 1] = maxOf(countArray[i - 1], countArray[i] + 1)
        }
    }
    countArray.forEach {
        println(it)
        counter += it
    }
    return counter

}