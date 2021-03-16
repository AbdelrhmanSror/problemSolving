package com.company

import java.util.*
import kotlin.Comparator
import kotlin.math.min

fun main() {
    getMedians(arrayOf(2, 1, 5, 7, 2, 0, 5)).forEach { println(it) }

}

fun getMedians(array: Array<Number>):Array<Number>{
    val minHeap=PriorityQueue<Int>(Comparator { o1: Int, o2: Int ->
        //to get the max number instead of min number when dequeueing from the queue
        -1*o1.compareTo(o2)
    })
    val maxHeap=PriorityQueue<Int>()
    array.forEachIndexed { index, i ->
        addNumber(minHeap,maxHeap,i.toInt())
        balance(minHeap,maxHeap)
        array[index]= getMedian(minHeap,maxHeap)

    }
   return array

}

fun balance(minHeap:PriorityQueue<Int>,maxHeap:PriorityQueue<Int>){
    if(minHeap.size>maxHeap.size+1)
        maxHeap.add(minHeap.remove())
    else if(minHeap.size<maxHeap.size+1)
        minHeap.add(maxHeap.remove())

}

fun addNumber(lower: PriorityQueue<Int>, higher: PriorityQueue<Int>, value: Int) {
    if (lower.isNotEmpty() && value < lower.peek()) {
        lower.add(value)
    } else {
        higher.add (value)
    }
}
fun getMedian(lower: PriorityQueue<Int>, higher: PriorityQueue<Int>): Double {
    return when {
        lower.size == higher.size -> {
            (lower.peek() + higher.peek()) / 2.0     }
        lower.size > higher.size -> {
            lower.peek().toDouble()
        }
        else -> {
            higher.peek().toDouble()

        }
    }
}
