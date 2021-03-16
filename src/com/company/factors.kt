package com.company


fun main() {

    /* factor(arrayOf(1, 2, 3, 4, 5)).forEach {
         print(" \t $it")
     }*/
    //println(getTotalX(arrayOf(100, 99 ,98 ,97 ,96 ,95 ,94 ,93, 92, 91), arrayOf(1, 2 ,3 ,4 ,5 ,6 ,7 ,8 ,9 ,10)))
    val x=-3f/121
    print(x.rem(26))
}


fun factor(array: Array<Int>): Array<Int> {
    val newArray = Array<Int>(array.size) {
        1
    }
    var mull = 1

    for (i in array.indices) {
        mull *= array[i]
    }
    for (i in array.indices) {
        newArray[i] = mull / array[i]
    }
    return newArray


}


fun lcm(a: Int, b: Int): Int {
    return a * (b / findGreatestCommonDivisor(a, b))
}
private  fun lcm(input: Array<Int>): Int {
    var result = input[0]
    for (i in 1 until input.size) {
        result = lcm(result, input[i])
    }
    return result
}

private fun gcd(input: Array<Int>): Int {
    var result = input[0]
    for (i in 1 until input.size) {
        result = findGreatestCommonDivisor(result, input[i])
    }
    return result
}


fun findGreatestCommonDivisor(first: Int, second: Int): Int {
    return when {
        first == 0 -> second
        second == 0 -> first
        else -> {
            findGreatestCommonDivisor(second, first % second)

        }
    }
}


fun getTotalX(a: Array<Int>, b: Array<Int>): Int {
    val max = lcm(a)
    val min = gcd(b)
    var counter=0
    if(max<=0||min<=0)
        return 0
    for(i in max..min step max){
        if(min%i==0) {
            counter++
        }
    }

    return counter


}