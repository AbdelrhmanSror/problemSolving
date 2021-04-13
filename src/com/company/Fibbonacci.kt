package com.company

fun main() {
    print(fib(3))
}


fun fib(n: Int, numberMap: HashMap<Int, Long> = HashMap()): Long {
    return when {
        numberMap.contains(n) -> numberMap[n]!!
        n == 0 -> 0
        n == 1 -> 1
        else -> {
            val x=fib(n - 1,numberMap) + fib(n - 2,numberMap)
            numberMap[n]=x
            return x

        }
    }
}
