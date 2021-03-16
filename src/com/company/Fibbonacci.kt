package com.company

fun main() {
    print(fibonacci(20))
}
fun fibonacciRecursion(n: Long, numberMap: HashMap<Long, Long> = HashMap()): Long {
    println(n)
    val result: Long
      when {
        numberMap.contains(n) -> return numberMap[n]!!
        n == 0L -> return 0L
        n == 1L -> return 1L
        else -> {
            result=fibonacciRecursion(n - 1, numberMap) + fibonacciRecursion(n - 2, numberMap)
            numberMap[n] = result

        }
    }
    return result


}

fun fibonacci(n: Int): Int {
    var first = 0
    var second = 1
    var sum = 0
    when (n) {
        0 -> return first
        1 -> return second
        else -> {
            for (i in 2..n) {
                sum = first + second
                first = second
                second = sum
            }
        }
    }
    return sum

    // Complete the function.

}