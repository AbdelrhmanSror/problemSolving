package com.company

fun main() {
    print(stairCase(3))
}


//improved solution to find number of ways possible to climb stair case using recursion and memoization
fun stairCase(n: Int, stepMap: HashMap<Int, Int> = HashMap()): Int {
    if (n < 0) return 0
    if (n == 0) return 1
    var counter = 0
    var value = 0
    for (i in 1..3) {
        value += if (stepMap.containsKey(n - i)) {
            stepMap[n - i]!!
        } else {
            stairCase(n - i, stepMap)

        }
    }
    counter += value
    stepMap[n] = value
    //println(stepMap)

    return counter
}

