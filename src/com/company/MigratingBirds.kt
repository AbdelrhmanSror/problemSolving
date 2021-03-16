package com.company

fun main(){
    val arrCount = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = migratoryBirds(arr)

    println(result)}
//1 2 3 4 5 4 3 2 1 3 4
data class MigratingBirds(var number: Int=1)
// Complete the migratoryBirds function below.
fun migratoryBirds(arr: Array<Int>): Int {
    val birdMap = HashMap<Int, MigratingBirds>()
    var minType=arr[0]
    var maxNumber=Int.MIN_VALUE
    for (index in arr.indices){
        when {
            birdMap.containsKey(arr[index]) -> {
                birdMap[arr[index]]!!.number = birdMap[arr[index]]!!.number.plus(1)
                if(birdMap[arr[index]]!!.number>maxNumber){
                    maxNumber=birdMap[arr[index]]!!.number
                    minType=arr[index]
                }
                else if(birdMap[arr[index]]!!.number==maxNumber&&arr[index]<minType){
                    minType=arr[index]
                }

            }
            else -> {
                birdMap[arr[index]]=MigratingBirds()

            }
        }
    }
    return minType


}