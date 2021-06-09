package com.company.graph

import java.util.*
import kotlin.collections.ArrayList

/**
 * we are givren a hashmap associating courseId with list of courseIds values,
 * which tells us that the prerequisites of courseId are courseId.
 * return ordering of courses such that we can complete the curriculum.
 * return null if there is no such ordering.
 * e.g.   c300:c100 ,c200
 *        c200:c100
 *        c100:none
 * should return c100,c200,c300
 */

/*
first take the list of courses and list of prerequisites courses
add the courses that do not have any prerequisites to a
 */
fun main() {
    val graph = Graph<Int>()
    graph.addConnection(5, 0, 3)
    graph.addConnection(3, 5, 1)
    graph.addConnection(3, 1)
    graph.addConnection(4, 0, 1)
    graph.addConnection(1)
    graph.addConnection(0)


    getTopologicalSort(graph)
}

// o(v+e) time and o(v) space
//works only for DAG directed acyclic graph.
fun <T> getTopologicalSort(graph: Graph<T>) {
    val queueSort = arrayListOf<T>()
    val set = hashSetOf<T>()
    // first take the list of courses and list of prerequisites courses
    // add the courses that do not have any prerequisites to queue and set for quick access
    graph.getParents().map {
        if (graph.getChild(it) == null || graph.getChild(it)!!.size == 0) {
            queueSort.add(it)
            set.add(it)
        }
    }
    graph.getParents().forEach { parent ->
        if (!set.contains(parent)) {
            graph.getChild(parent)?.forEach { child ->
                if (!set.contains(child))
                    search(graph, child, queueSort, set)
            }
            queueSort.add(parent)
            set.add(parent)
        }
    }
    print(queueSort)


}

private fun <T> search(graph: Graph<T>, vertex: T, queueSort: ArrayList<T>, visited: HashSet<T>) {
    visited.add(vertex)
    val childs = graph.getChild(vertex)
    childs?.forEach {
        if (!visited.contains(it)) {
            search(graph, it, queueSort, visited)
        }
    }
    queueSort.add(vertex)


}
