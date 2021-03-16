package com.company

fun main() {
    print("${canBalance(intArrayOf(1, 2, 3, 1, 0, 1, 3))}")
}

fun canBalance(nums: IntArray): Boolean {
    val middleElement = nums.size / 2
    val firstSideRange = middleElement - 1
    val secondSideRange = middleElement + 1
    print(nums.size)
    var leftSideTotal = 0
    var rightSideTotal = 0
    for (i in 0..firstSideRange) {
        leftSideTotal += nums[i]
    }
    for (i in secondSideRange until nums.size) {
        rightSideTotal += nums[i]
    }
    return if (leftSideTotal + nums[middleElement] == rightSideTotal || rightSideTotal + nums[middleElement] == leftSideTotal)
        true;
    else {
        canBalanceLastTry(nums, middleElement, rightSideTotal, leftSideTotal)
                ||canBalanceLastTry(nums, middleElement, leftSideTotal, rightSideTotal)

    }
}

fun canBalanceLastTry(nums: IntArray, i: Int, rightSideTotal: Int, leftSideTotal: Int): Boolean {
    return when {
        leftSideTotal + nums[i] < rightSideTotal -> {
            canBalanceLastTry(nums, i - 1, rightSideTotal - nums[i], leftSideTotal + nums[i])

        }
        leftSideTotal + nums[i] > rightSideTotal -> {
            false
        }
        else -> {
            true
        }
    }
}