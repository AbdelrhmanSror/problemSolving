package com.company

/**
 *  at index i of the new array is the product of all the numbers in the original array except the one at i.
 *  For example, if our input was [1, 2, 3, 4, 5],
 *  the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1],
 *  the expected output would be [2, 3, 6].
 *  Follow-up: what if you can't use division?
 */

fun main(){
    factorsNoDivision(arrayOf(6,5,2,3,4)).forEach {
        println(it)
    }
}
//using division
fun factors(array: Array<Int>):Array<Int>{
    var factor:Int=1
    for(i in array){
        factor*=i
    }
    for(i in array.indices){
        array[i]=factor/array[i]
    }
    return array


}


fun factorsNoDivision(array: Array<Int>):Array<Int>{
    val leftSideFactor=Array<Int>(array.size){1}
    val rightSideFactor=Array<Int>(array.size){1}
    //left
    for(i in 1 until array.size){
        leftSideFactor[i]=array[i-1]*leftSideFactor[i-1]
    }
    //right
    for(i in array.size-2 downTo 0 ){
        rightSideFactor[i]=array[i+1]*rightSideFactor[i+1]
    }
    for(i in array.indices){
        array[i]=leftSideFactor[i]*rightSideFactor[i]
    }

    return array

}

fun Array<Int>.mul(from:Int,to:Int):Int{
    var factor=1
    for (i in from..to){
        factor*=this[i]
    }
    return factor

}