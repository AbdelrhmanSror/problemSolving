package com.company

import kotlin.math.max
import kotlin.math.min


fun main() {
    println(findMaxSumSubArrayWrapAround(arrayOf(8, -1, 3, 4)))

}
//given an array of integers ,find max sum of any contiguous sub array
//for example [34,-50,42,14,-5,86] ,the max sub array would be 137 since we would tak elements [42,14,-5,86]
//[-5,-1,-8,-9]  max sum would be 0 since we would choose not to take any elements.
//follow up what if the element can wrap around for example given [8,-1,3,4] return 15 because we would choose 3,4,8 as wrap around max sum subarray


fun findMaxSumSubArrayWrapAround(array: Array<Int>):Int{
    return max(findMaxSum(array),array.sum()- findMinSumWrapAround(array))
}
//using kadane's algorithm
fun findMinSumWrapAround(array: Array<Int>): Int {
    var min_ending_here = 0
    var min_so_far = 0
    for (i in array) {
        min_ending_here = min(min_ending_here + i, i)
        min_so_far = min(min_so_far, min_ending_here)
    }


    return min_so_far


}


//using kadane's algorithm
fun findMaxSum(array: Array<Int>): Int {
    var max_ending_here = 0
    var max_so_far = 0
    for (i in array) {
        max_ending_here = max(max_ending_here + i, i)
        max_so_far = max(max_ending_here, max_so_far)
    }
    return max_so_far


}
