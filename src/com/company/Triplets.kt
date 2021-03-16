package com.company

import java.io.File


fun main() {

    print(countTriplets2(arrayOf(1,2,4,15,18,8,16),2))
}

data class Triplet(var noOfElements: Long, var noOfWays: Long)

/**
 * if the division of current number by r not exist in map then we create new object
 * and with number of elements 1 and no of ways 0 cause i can not form triplet with only 1
 * if the division exist then if the number of ways is not 0 then this will be our addition to counter also take the number of elements
 * and add it to number of ways to current elements and so on until we finish the for loop
 */
fun countTriplets2(arr: Array<Long>, r: Long): Long {
    val tripletMap = HashMap<Long, Triplet>()
    var counter = 0L
    for (num in arr) {
        var prevNoOfWays = 0L
        var prevNoElements=0L
        //if there is number in map that result in dividing current num over then the counter will be the number of ways
        if (num%r<=0&&tripletMap.containsKey(num / r)) {
            prevNoElements=tripletMap[num / r]!!.noOfElements
            prevNoOfWays = tripletMap[num / r]!!.noOfWays
            counter += prevNoOfWays
        }
        if (!tripletMap.containsKey(num)) {
            tripletMap[num] = Triplet(1, prevNoElements)
        } else {
            tripletMap[num]!!.noOfElements++
            tripletMap[num]!!.noOfWays=tripletMap[num]!!.noOfWays+prevNoElements


        }
    }

    return counter
}
