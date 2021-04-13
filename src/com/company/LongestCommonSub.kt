package com.company

import kotlin.math.max

fun main() {
   println(getCommonChildCount("abcd", "abdc"))
    //println(commonChild("abcd", "abdc"))

}


//optimized solution regrading of space complexity instead of O(n^2) space we use 2n which nearly becomes O(n)
fun getCommonChildCount(s1:String,s2:String):Int{
    //2d array with size of 2 row and string length column
    //we will work with one row at a time
    val maxCount=Array(2){IntArray(s1.length+1){0} }
    //variable indicates to current row that we can get value from maxCount and the next row is what we can  set value in
    var cIndex:Int=0
    for(i in s1.indices){
        cIndex=i and 1
        for(j in s2.indices){
            if(s1[i]==s2[j]){
                //if the two char is equal then get the value from the previous setuped row and current  previous column column
                maxCount[(i+1) and 1][j+1]=maxCount[cIndex][j]+1
            }else{
                //if not equal then pick the max value from previously setuped row and column and currently setuped row and previous column
                maxCount[(i+1) and 1][j+1]= maxOf(maxCount[cIndex][j+1],maxCount[(i+1) and 1][j])
            }

        }
        //assign current index to coming row
        //it has no action until loop breaks down
        cIndex=(i+1) and 1
    }
    return maxCount[cIndex][s1.length]

}

