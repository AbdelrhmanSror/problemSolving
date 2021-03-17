package com.company

import java.util.*
import kotlin.collections.HashMap


fun main() {
    /*val scan = Scanner(System.`in`)
    val arr = Array<Int>(100000) { 0 }
    for (i in 0 until 100000) {
        val arrItem = scan.nextLine().trim().toInt()
        arr[i] = arrItem
    }*/
    println(countInversions(arrayOf(2,1,3,1,2)))
}

    fun countInversions(arr: Array<Int>): Long {
        return mergeSort(arr)
    }

    fun mergeSort(arr: Array<Int>, temp: Array<Int> = Array(arr.size) { 0 }): Long {
        return sort(arr, temp, 0, arr.size - 1)
    }

    private fun sort(arr: Array<Int>, temp: Array<Int>, start: Int, end: Int): Long {
        if (start >= end) {
            return 0L
        }
        // Find the middle point
        val middle = (start + end) / 2
        var counter = 0L

        // Sort first and second halves
        counter += sort(arr, temp, start, middle)
        counter += sort(arr, temp, middle + 1, end)
        // Merge the two halves
        return merge(arr, temp, start, middle, end) + counter

    }


    fun merge(arr: Array<Int>, temp: Array<Int>, leftStart: Int, middle: Int, rightEnd: Int): Long {
        val leftEnd = (leftStart + rightEnd) / 2
        val rightStart = leftEnd + 1
        val size = rightEnd - leftStart + 1
        var left = leftStart
        var right = rightStart
        var index = leftStart
        var counter = 0L
        var i=0
        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] <= arr[right]) {
                temp[index] = arr[left]
                left++
                i++
            } else {
                temp[index] = arr[right]
                right++
                counter += ((leftEnd - leftStart + 1) - i)
            }
            index++
        }



        System.arraycopy(arr, left, temp, index, leftEnd - left + 1)
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1)
        System.arraycopy(temp, leftStart, arr, leftStart, size)
        return counter

    }
