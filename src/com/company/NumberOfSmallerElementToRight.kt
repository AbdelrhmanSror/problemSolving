package com.company

import org.w3c.dom.ranges.Range
import java.util.*

// find the number of smaller element to the right of each number in the array
//for example [3,4,9 ,6,1] return [1,1,2,1,0]
//there is 1 smaller element to the right o 3
//there is 1 smaller element to the right o 4
//there is 2 smaller element to the right o 9
//there is 1 smaller element to the right o 6
//there is no smaller element to the right o 0

fun main() {
    findSmallerElements2(arrayOf(3, 4, 9, 6, 1)).printALl()


}

fun Array<Int>.printALl() {
    print("[ ")
    this.forEach { print("$it ") }
    println("]")
}


fun findSmallerElements2(array: Array<Int>): Array<Int> {
    val treeSet=TreeSet<Int>()
    val noSmallerElements = IntArray(array.size) { 0 }
    for (i in array.indicesDown()){
        noSmallerElements[i]=treeSet.count { it<array[i] }
            treeSet.add(array[i])
    }
    return  noSmallerElements.toTypedArray()

}


fun findSmallerElements(array: Array<Int>): Array<Int> {
    val noSmallerElements = IntArray(array.size) { 0 }
    for (i in array.indices) {
        var counter = 0
        for (j in i + 1 until array.size) {
            if (array[j] < array[i])
                counter++
        }
        noSmallerElements[i] = counter
    }
    return noSmallerElements.toTypedArray()
}