package com.company

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main() {
    freqQuery(arrayOf(
            arrayOf(1, 1),
            arrayOf(1, 2),
            arrayOf(1, 1),
            arrayOf(2, 1),
            arrayOf(3, 2))).forEach { println(it) }
}

// Complete the freqQuery function below.
fun freqQuery(queries: Array<Array<Int>>): Array<Int> {
    val map = HashMap<Int, Int>()
    val array = ArrayList<Int>()
    val occurenceMap = HashMap<Int, Int>()
    for (arr in queries) {
        if (arr[0] == 1) {
            if (map.contains(arr[1])) {
                occurenceMap[map[arr[1]]!!] = occurenceMap[map[arr[1]]]?.minus(1)!!
                map[arr[1]] = map[arr[1]]?.plus(1)!!
                incrementIfExist(occurenceMap, map, arr)


            } else {
                map[arr[1]] = 1
                incrementIfExist(occurenceMap, map, arr)
            }
        } else if (arr[0] == 2) {
            if (map.contains(arr[1])) {
                occurenceMap[map[arr[1]]!!] = occurenceMap[map[arr[1]]]?.minus(1)!!
                map[arr[1]] = map[arr[1]]?.minus(1)!!
                if (map[arr[1]] == 0)
                    map.remove(arr[1])
                if (map.containsKey(arr[1])) {
                    incrementIfExist(occurenceMap, map, arr)
                }
            }
        } else {
            if (occurenceMap.containsKey(arr[1])) {
                if (occurenceMap[arr[1]]!!>0) {
                    array.add(1)
                } else array.add(0)
            }else array.add(0)
        }
    }
    return array.toTypedArray()
}

private fun incrementIfExist(occurenceMap: HashMap<Int, Int>, map: HashMap<Int, Int>, arr: Array<Int>) {
    if (occurenceMap.containsKey(map[arr[1]]))
        occurenceMap[map[arr[1]]!!] = occurenceMap[map[arr[1]]]?.plus(1)!!
    else {
        occurenceMap[map[arr[1]]!!] = 1
    }
}

