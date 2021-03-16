package com.company

fun main() {

   val x= arrayOf(942381765, 627450398, 954173620 ,583762094 ,236817490)
    // print(isTherePairCanAddUpTo(17, arrayOf(10,15,3,7)))
    //miniMaxSum(x)
    print(pairs(2, arrayOf(1,5,3,4,2)))
}

// Complete the pairs function below.
fun pairs(k: Int, arr: Array<Int>): Int {
    val pairMap=HashSet<Int>()
    var counter=0
    for (element in arr){
        pairMap.add(element)
    }
    arr.sort()
    for (element in arr){
        if(pairMap.contains(element-k)){
            counter++
        }
    }
    return counter



}


// Complete the miniMaxSum function below.
fun miniMaxSum(arr: Array<Int>): Unit {
    arr.sort()
    var rest=0L
    for(i in 1 until arr.size-1){
        rest+=arr[i]
    }
    print("${rest+arr[0]} ${rest+arr[arr.size-1]}")
}

fun isTherePairCanAddUpTo(n: Int, array: Array<Int>): Boolean {
    val map = HashSet<Int>()
    for (i in array.indices) {
        if (map.contains(n - array[i])) {
            return true
        }
        map.add(array[i])
    }
    return false
}