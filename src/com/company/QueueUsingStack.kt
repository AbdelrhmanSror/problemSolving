package com.company

import java.util.*

fun main() {
    val scan = Scanner(System.`in`)
    val queueUsingStack = QueueUsingStack()
    val q = scan.nextLine().trim().toInt()
    for (i in 0 until q) {
        val operation = scan.nextLine().split(" ").map {
            it.trim().toInt()
        }.toTypedArray()
        when {
            operation[0] == 1 -> queueUsingStack.enqueue(operation[1])
            operation[0] == 2 -> queueUsingStack.dequeue()
            else -> println(queueUsingStack.peek())
        }

    }


}

class QueueUsingStack {
    private val inputStack = Stack<Int>()
    private val outputStack = Stack<Int>()
    fun enqueue(value: Int) {
        inputStack.add(value)
    }

    fun dequeue() {
        balance()
        outputStack.pop()
    }

    fun peek(): Int {
        balance()
        return outputStack.peek()
    }

    private fun balance() {
        if (outputStack.isEmpty()) {
            for (i in inputStack.indices) {
                outputStack.add(inputStack.pop())
            }
        }
    }

}