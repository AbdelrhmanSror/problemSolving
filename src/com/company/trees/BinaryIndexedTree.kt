package com.company.trees



fun main(){
    val x=BIT(arrayOf(2,1,1,3))
    x.update(0,1)
   print( x.query(3))


}
/**
 * given an array of length 24 where each element represents the number of new subscribers during the corresponding hour.
 * implement a data structure that efficiently supports the following :
 * update (hour ,value)  increment the element at index hour by value.
 * query(start,end ): retrieve all number of subscribers that have signed up between start and end (inclusive)
 */
//binary index tree class
//log(n) for both updating and querying operation
class BIT(private val array: Array<Int>) {
    //getting the sum of a range if values up to i
    private var bitArray: Array<Int> = Array(array.size + 1) { 0 }

    init {
        array.forEachIndexed { index, value->
            update(index,value)
        }

    }

    fun query(i: Int):Int {
        //array is 1-based
        var sum = 0
        var index = i + 1
        while (index > 0) {
            sum += bitArray[index]
            index -= index and -index
        }
        return sum

    }

    //increment the element at index i
    fun update(i:Int,value:Int) {
        //array is 1-based
        var index = i + 1
        while (index < bitArray.size) {
            bitArray[index] += value
            index += index and -index
        }


    }

   fun printBitArray(){
       bitArray.forEach {
           print("$it ")
       }
   }
}