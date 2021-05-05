package com.company

import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    print(balancedBracket("((()))"))


}

fun isBalanced(c1: Char, c2: Char): Boolean {
    if ((c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}') || (c1 == '(' && c2 == ')'))
        return true
    return false


}

fun balancedBracket(bracket: String): Boolean {
    val stack = Stack<Char>()
    bracket.forEach {
        if (stack.size > 0) {
            if (isBalanced(stack.peek(), it)) {
                stack.pop()
            } else
                stack.push(it)


        } else {
            stack.push(it)
        }
    }
    return stack.isEmpty()
}


class Stack2 {
    private val stack = ArrayList<Int>()
    private val maxStack = ArrayList<Int>()
    val size: Int = stack.size
    var max: Int? = Int.MIN_VALUE
        get() = if (maxStack.isEmpty()) null else maxStack[maxStack.size - 1]
        private set

    fun push(value: Int) {
        stack.add(value)
        if (maxStack.isNotEmpty())
            maxStack.add(maxOf(maxStack[maxStack.size - 1], value))
        else
            maxStack.add(value)

    }

    fun peek() = stack[stack.size - 1]
    private fun ArrayList<Int>.removeLast(): Int = this.removeAt(this.size - 1)
    fun pop(): Int {
        if (stack.isEmpty()) {
            throw Exception("stack is empty")
        }
        maxStack.removeAt(maxStack.size - 1)
        return stack.removeLast()
    }


}