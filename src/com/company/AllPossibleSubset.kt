package com.company

fun main() {
/*
    printAllPossibleSubset(arrayOf(1, 2, 3,4,5,6,7,8))
*/
    print("ecar".compareTo("r"))
}

fun printAllPossibleSubset(array: Array<Int>) {
    val subSetList = ArrayList<String>()
    for (i in array.indices) {
        val currentSetList = ArrayList<String>()
        currentSetList.add("${array[i]}")
        subSetList.forEach {
            currentSetList.add("${it},${array[i]}")
        }
        subSetList.addAll(currentSetList)
        currentSetList.clear()
    }
    println("{}")
    subSetList.forEach {
        println(it)
    }

}