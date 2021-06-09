package com.company.graph

/**
 * you are given a tree with an even number of nodes,consider each connection
 * between a parent and child to be an edge you would like to remove some of these edges
 * such that the disconnected subtree that remain has an even number of nodes.
 * for example
 *              1
 *          2          3
 *                 4        5
 *              6  7  8
 *
 * will become
 *                  1
 *                2
 *  max number of edges would be 2
 *  first edge is the one between 3 and 4 because 4 has an odd number of nodes
 *  second edge would be between 1 and 3 ,because 3 has an odd number of nodes
 *
 */
fun main() {
    val graph = Graph<Int>()
    /* graph.addConnection(1, 2, 3)
     graph.addConnection(2)
     graph.addConnection(3, 4, 5)
     graph.addConnection(4, 6, 7, 8)
     graph.addConnection(5)
     graph.addConnection(6)
     graph.addConnection(7)
     graph.addConnection(8)*/
    graph.addConnection(0, 2, 1, 4)
    graph.addConnection(2, 3)
    graph.addConnection(4, 5)
    graph.addConnection(5, 6)
    graph.addConnection(5, 7)
    print(maxRemovedEdges(graph))
}
//o(n) number of nodes in tree and o(n) space

fun <T> maxRemovedEdges(graph: Graph<T>): Int {
    //to store the visited nodes so we do not have to visit it again
    val visited = HashSet<T>()
    //to store the new size of each node after removing the childs having odd number
    val nodeSize = HashMap<T, Int>()
    //counter of max removed edges
    var counter = 0
    //copying the size of each node to nodeSize
    for (vertex in graph.getParents()) {
        nodeSize[vertex] = graph.getChild(vertex)?.size ?: 0
    }
    for (vertex in graph.getParents()) {
        //if vertex has not been visited yet ,go on and visit it
        if (!visited.contains(vertex))
            counter += search(graph, null, vertex, visited, nodeSize)

    }
    return counter

}

private fun <T> search(graph: Graph<T>, parent: T?, vertex: T, visited: HashSet<T>, nodeSize: HashMap<T, Int>): Int {
    //mark vertex as visited
    visited.add(vertex)
    var counter = 0
    val childs = graph.getChild(vertex)
    childs?.forEach {
        if (!visited.contains(it))
            counter += search(graph, vertex, it, visited, nodeSize)

    }
    //if parent  is not null continue checking in ,this checking for the the first node because it has no parent
    parent?.let {
        //if the node size is odd we increment the counter to increase number of removing edges , and update the size of the node in nodeSize
        if (childs != null && nodeSize[vertex]!! % 2 != 0) {
            counter++
            nodeSize[parent] = nodeSize[parent]!! - 1
        }
    }



    return counter

}
