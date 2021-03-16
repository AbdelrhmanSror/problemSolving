package com.company

fun main() {
    print(stepPerms(7,arrayOf(1,2,3)))
}

// Complete the stepPerms function below.
fun stepPerms(n: Int,steps:Array<Int>, stepMap: HashMap<Int, Int> = HashMap()): Int {
    return when {
        n == 1 || n == 0 -> {
            1
        }
        n < 0 -> {
            0
        }
        stepMap.containsKey(n) -> {
            stepMap[n]!!
        }
        else -> {
            for (i in steps) {
                if (stepMap.containsKey(n)) {
                    stepMap[n] = stepMap[n]!!.plus(stepPerms(n - i, steps,stepMap))
                } else
                    stepMap[n] = stepPerms(n - i, steps,stepMap)
            }
            stepMap[n]!!
        }
    }

}