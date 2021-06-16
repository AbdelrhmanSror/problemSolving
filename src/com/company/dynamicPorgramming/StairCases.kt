package com.company.dynamicPorgramming

fun main() {
    print(stairCase(3))
}


//improved solution to find number of ways possible to climb stair case using recursion and memoization
fun stairCase(n: Int, stepMap: HashMap<Int, Int> = HashMap()): Int {
    if (n < 0) return 0
    if (n == 0) return 1
    var value = 0
    for (step in 1..3) {
        value += if (stepMap.containsKey(n - step)) {
            stepMap[n - step]!!
        } else {
            stairCase(n - step, stepMap)

        }
    }
    stepMap[n] = value

    return stepMap[n]!!
}

