package com.company


fun main() {
    print(power(2,8))
}

fun power(a: Int, b: Int): Int {
    var c = 0
    var ans = 0
    if (b == 1)
        return a
    else
        c = a * a
    ans = power(c, b / 2)
    println(ans)
    return if (b % 2 != 0)
        a * ans
    else
        ans
}