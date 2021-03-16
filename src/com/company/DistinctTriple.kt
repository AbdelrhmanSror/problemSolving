package com.company
import java.util.*

//1 4 5
//2 3 3
//1 2 3

fun main() {
    val scan = Scanner(System.`in`)

    val arra = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val arrb = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val arrc = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
    val ans = triplets(arra, arrb, arrc)

    println(ans)}
// Complete the triplets function below.
fun triplets(arr1: Array<Int>, arr2: Array<Int>, arr3: Array<Int>): Long {
    var index1 = 0
    var index3 = 0
    var counter = 0L
    val a=arr1.sortedArrayDescending()
    val b=arr2.toSet().sortedDescending().toIntArray()
    val c=arr3.toSet().sortedDescending().toIntArray()
     for (index2 in b.indices) {
        loop2@ while (index1 < a.size && index3 < c.size) {
            when {
                b[index2] >= a[index1] && b[index2] >= c[index3] -> {
                    counter += (a.size - index1) * (c.size - index3)
                    break@loop2
                }
                b[index2] < a[index1] -> {
                    index1++
                }
                b[index2] < c[index3] -> {
                    index3++
                }
                else -> {
                    index1++
                    index3++
                }
            }
        }
    }
    return counter

}