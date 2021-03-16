package com.company

import java.util.*
import kotlin.collections.HashMap


fun main() {
    val ans = FriendsCircleQueries<Int>(arrayOf(arrayOf(1000000000, 23), arrayOf(11, 3778), arrayOf(7, 47), arrayOf(11, 1000000000)))
    ans.findCount().forEach {
        println(it)
    }
}

data class Circle<T>(var parent: T, var rank: Int = 0, var count: Int = 1)

class FriendsCircleQueries<T>(private val array: Array<Array<T>>) {
    private val nodeMap = HashMap<T, Circle<T>>()
    private var max = Int.MIN_VALUE
    private val outputArray = Array<Int>(array.size) { 0 }

    fun findCount(): Array<Int> {
        for (input in array) {
            createIfNotExist(input[0], input[1])
        }
        for (i in array.indices) {
            val src = findRoot(array[i][0])
            val des = findRoot(array[i][1])
            if (src != des) {
                max = maxOf(union(src, des).count, max)
            }
            outputArray[i] = max
        }
        return outputArray

    }

    private fun findRoot(node: T): T {
        if (nodeMap[node]!!.parent == node) {
            return node
        }
        return findRoot(nodeMap[node]!!.parent)

    }


    private fun union(src: T, des: T): Circle<T> {
        return when {
            nodeMap[src]!!.rank > nodeMap[des]!!.rank -> {
                nodeMap[des]?.parent = src
                nodeMap[src]!!.count += nodeMap[des]!!.count
                nodeMap[src]!!

            }
            nodeMap[src]!!.rank < nodeMap[des]!!.rank -> {
                nodeMap[src]?.parent = des
                nodeMap[des]!!.count += nodeMap[src]!!.count
                nodeMap[des]!!


            }
            else -> {
                nodeMap[src]!!.parent = des
                nodeMap[des]!!.rank++
                nodeMap[des]!!.count += nodeMap[src]!!.count
                nodeMap[des]!!

            }
        }

    }

    private fun createIfNotExist(src: T, des: T) {
        if (!nodeMap.containsKey(src))
            nodeMap[src] = Circle(src, 0)
        if (!nodeMap.containsKey(des))
            nodeMap[des] = Circle(des, 0)


    }

}