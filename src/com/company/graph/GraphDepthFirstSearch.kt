package com.company.graph

import java.util.*
import kotlin.collections.HashSet


fun main() {
    val graph = Graph<String>()
    graph.addConnection("You", "Claire", "Bob", "Alice")
    graph.addConnection("Bob", "Peggy", "Anuj")
    graph.addConnection("Alice", "Peggy")
    graph.addConnection("Anuj", "")
    graph.addConnection("Peggy", "")
    graph.addConnection("Claire", "Thom", "Jonny")
    graph.addConnection("Thom", "")
    graph.addConnection("Jonny", "")
    val dfs = Dfs<String>(graph)

    dfs.searchGraph("Peggy", "You")


}

class Dfs<T>(private val graph: Graph<T>) {
    fun searchGraph(nameToSearch: T, startFrom: T) {
        //check if the starting point is existed in the graph ,also if the graph is not empty
        graph.checkExistence(startFrom)
        //if the starting point is the same as the name we search for so simply return it
        if (nameToSearch == startFrom)
            print(" traversal points is $nameToSearch ")
        //contains the vertexes that we have visited before so we never visit it again.
        val visited = HashSet<T>()
        val parentVertex = search(nameToSearch, startFrom, visited)
        if (parentVertex != null)
            println("path found $nameToSearch from $parentVertex ")
        else
            println("path not found ")


    }

    private fun search(nameToSearch: T, vertex: T, visited: HashSet<T>): T? {
        visited.add(vertex)
        if (nameToSearch == vertex)
            return vertex
        val childs = graph.getChild(vertex)
        childs?.forEach {
            if (!visited.contains(it)) {
                val search = search(nameToSearch, it, visited)
                if (search != null)
                    return it
            }
        }
        return null


    }

}
