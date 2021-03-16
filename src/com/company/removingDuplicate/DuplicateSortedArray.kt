package com.company.removingDuplicate

import com.company.swap

fun main() {
    val x = arrayOf(1, 1, 0, 1, 3, 3, 5 )

    removeDuplicate(x).forEach {
        print(it)
    }
   // print("d".first().toInt())
}


// Complete the arrayManipulation function below.
fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
    var max=0L
    val extendArray=Array(n) { 0 }
    for(array in queries){
        extendArray[array[0]-1]+=array[2]
        if(array[1]<array.size)
        extendArray[array[1]]-=array[2]
    }
    for (diff in extendArray){
        if(diff>=0){
            max+=diff
        }
    }
    return max

}

/**
 * removing duplicate from sorting array no zero element
 * takes o(n)
 */
fun removeDuplicate(array: Array<Int>): Array<Int> {
    var j = 0
    for (i in 0..array.size - 2) {
        if (array[i + 1] > array[i]) {
            array[j + 1] = array[i + 1]
            j++
        }
    }
    return array.sliceArray(0..j)

}

fun moveZerosToRight(arr: Array<Int>) {
    var j = 0
    for (i in 0 until arr.size - 1) {
        if (arr[j] == 0) {
            if (arr[i + 1] == 0) {
                arr.swap(i, j)
                j = i-1
            }
        } else {
            j++
        }
    }
}