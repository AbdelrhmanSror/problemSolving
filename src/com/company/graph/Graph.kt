package com.company.graph

import java.util.*
import kotlin.collections.HashMap

 class Graph<T> {
    private val connections: HashMap<T, LinkedList<T>> = HashMap()

    /**
     *if the parent does not exist we create it and then add child to it later
     */
    fun addConnection(parent: T, vararg child: T) {
        if (!connections.containsKey(parent)) {
            connections[parent] = LinkedList()
        }
        connections[parent]?.addAll(child)
    }

    fun getParents(): List<T> {
        return connections.keys.toList()

    }

    fun checkExistence(vertex: T) {
        if (isEmpty() || !contains(vertex))
            throw Exception("there is no either graph to start searching in or the starting point does not exist in this graph")

    }

    fun getChild(parent: T): LinkedList<T>? {
        return connections[parent]
    }

    fun contains(value: T): Boolean {
        return connections.containsKey(value)
    }

    fun isEmpty(): Boolean {
        return connections.isEmpty()
    }


     override fun toString(): String {
         return connections.toString()
     }
 }