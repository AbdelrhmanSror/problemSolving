package com.company.graph

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet


data class Node<T>(var parent: T, var rank: Int = 0)

fun main() {
    val graph = Graph<String>()
    graph.addConnection("You", "Claire", "Bob", "Alice")
    graph.addConnection("Alice", "Peggy")
    graph.addConnection("Bob", "Peggy", "Anuj")
    graph.addConnection("Anuj", "")
    graph.addConnection("Peggy", "")
    graph.addConnection("Claire", "Thom", "Jonny")
    graph.addConnection("Thom", "")
    graph.addConnection("Jonny", "")
    print(GraphCycle1(graph).hasCycle())


}

interface GraphCycle<T> {
    fun hasCycle(): Boolean
}

/**
 * for undirected graph only
 * class for detecting if there is a cycle in graph or not using union rank and path compression
 * complexity in worst case is log(n) which is much more better
 */
class GraphCycle2<T>(private val graph: Graph<T>) : GraphCycle<T> {
    private val nodeMap = HashMap<T, Node<T>>()

    init {
        graph.getParents().forEach {
            createIfNotExist(it)
        }
    }

    override fun hasCycle(): Boolean {
        graph.getParents().forEach { parent ->
            graph.getChild(parent)?.forEach {
                val src = findRoot(nodeMap, parent)
                val des = findRoot(nodeMap, it)
                if (src == des) {
                    return true
                }
                union(nodeMap, src, des)

            }


        }

        return false

    }

    private fun findRoot(map: HashMap<T, Node<T>>, node: T): T {
        //here this if statement is as if i said [if(nodeMap[node].parent!=node)]
        if (map[node]!!.parent == node) {
            return node
        }
        return findRoot(map, map[node]!!.parent)

    }


    private fun union(map: HashMap<T, Node<T>>, src: T, des: T) {
        when {
            map[src]!!.rank > map[des]!!.rank -> {
                map[des]?.parent = src

            }
            map[src]!!.rank < map[des]!!.rank -> {
                map[src]?.parent = des


            }
            else -> {
                map[src]!!.parent = des
                map[des]!!.rank++


            }
        }

    }

    private fun createIfNotExist(parent: T) {
        if (!nodeMap.containsKey(parent))
            nodeMap[parent] = Node(parent, 0)


    }

}

/**
 * for directed graph only
 */
class GraphCycle1<T>(private val graph: Graph<T>) : GraphCycle<T> {
    //running in O(v+e) time and O(v)space
    override fun hasCycle(): Boolean {
        return hasCycle() { x: T, y: HashSet<T>, z: HashSet<T> ->
            search(x, y, z)
        }
    }

    private fun hasCycle(search: ((x: T, y: HashSet<T>, z: HashSet<T>) -> Boolean)): Boolean {
        //to store all items visited until now in all recursion stack
        val visited = HashSet<T>()
        //to store all visited items in the current recursion stack
        val recStack = HashSet<T>()
        //go through each vertex in graph
        for (vertex in graph.getParents()) {
            //if vertex has not been visited yet ,go on and visit it
            if (!visited.contains(vertex))
                if (search(vertex, visited, recStack))
                    return true

        }
        return false
    }

    private fun search(vertex: T, visited: HashSet<T>, recStack: HashSet<T>): Boolean {
        //mark vertex as visited and add it to the the recursion stack
        visited.add(vertex)
        recStack.add(vertex)
        val childs = graph.getChild(vertex)
        childs?.forEach {
            if (!visited.contains(it)) {
                if (search(it, visited, recStack))
                    return true
                //check if the node has already been visited again in the current recursion stack
            } else if (recStack.contains(it))
                return true
        }
        //as we back from the current stack we remove the current vertex from the stack
        recStack.remove(vertex)
        return false

    }
}
