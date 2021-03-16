package com.company

import java.util.*

fun main() {
    print(birthday(arrayOf(2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1), 18, 7))

}

/**
 * Lily has a chocolate bar that she wants to share it with Ron for his birthday.
 * Each of the squares has an integer on it.
 * She decides to share a contiguous segment of the bar selected ,
 * such that the length of the segment matches Ron's birth month ,
 * and the sum of the integers on the squares is equal to his birth day.
 * You must determine how many ways she can divide the chocolate.
 */
fun birthday(s: Array<Int>, d: Int, m: Int): Int {
    var counterMonth = 0
    var sumDay = 0
    var counter = 0
    var index = 0
    for (i in s) {
        val sum=sumDay+i
        if(counterMonth+1==m&&sum==d){
            //if the sum of current number and previous ones is as same as the d and counterMonth matches the m so
            // we know that we have one successful case then we increment the counter
            counter++
            sumDay=sum
            sumDay-=s[index]
            index++
        }
        //if the sum of current number and previous ones is still less than the d and counterMonth also  less than the m
        //we increment the counter month and add up the current number to the sum day
        else if(counterMonth+1<m&&sum<d){
            counterMonth++
            sumDay=sum
        }else{
            sumDay=sum-s[index]
            index++
        }
    }
    return counter

}
