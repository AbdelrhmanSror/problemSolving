package com.company

fun main(){
    twoSum(intArrayOf(3,2,4),6).forEach {
        println(it)
    }
}
fun twoSum(nums: IntArray, target: Int): IntArray {
    val array = IntArray(2)
    val set = HashMap<Int, Int>()
    //assigning each value with its location
    for (i in nums.indices) {
        set[nums[i]] = i
    }
    for (i in nums.indices) {
        if (set.containsKey(target-nums[i])&&set[target-nums[i]]!=i) {
            array[0] = i
            array[1] = set[target-nums[i]]!!
            return array;
        }
    }
    return array
}