package com.company.graph/*
 * Copyright 2019 Abdelrhman Sror. All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 *
 */

import java.util.*
import kotlin.collections.HashSet


fun main() {
    val graph=Graph<String>()
    graph.addConnection("You", "Claire", "Bob", "Alice")
    graph.addConnection("Alice", "Peggy")
    graph.addConnection("Bob", "Peggy", "Anuj")
    graph.addConnection("Anuj", "")
    graph.addConnection("Peggy", "")
    graph.addConnection("Claire", "Thom", "Jonny")
    graph.addConnection("Thom", "")
    graph.addConnection("Jonny", "")
    val bfs = Bfs(graph)
    bfs.searchGraph("Peggy", "You")


}

/**
 * If you search your entire network for a person,
 * that means you’ll follow each edge
 * So the running time is at least O(number of edges). You also keep a queue of every person to search.
 * Adding one person to the queue takes constant time: O(1). Doing this for every person will take O(number of people) total.
 * Breadth-first search takes O(number of people + number of edges), and it’s more commonly written as O(V+E) (V for number of vertices,
 * E for number of edges).
 */
class Bfs<T>(private val graph: Graph<T>) {
     fun searchGraph(nameToSearch: T, startFrom: T) {
        //check if the starting point is existed in the graph ,also if the graph is not empty
       graph.checkExistence(startFrom)
        //if the starting point is the same as the name we search for so simply return it
        if (nameToSearch == startFrom)
            print(" traversal points is $nameToSearch ")

        //the list of subsequent vertexes to to check it
        val listOfConnectionToVisit = LinkedList<T>()
        //contains the vertexes that we have visited before so we never visit it again.
        val visited = HashSet<T>()
        //adding the current starting vertext to the queue
        listOfConnectionToVisit.add(startFrom)
        while (listOfConnectionToVisit.isNotEmpty()) {
            //poll the next vertex from the queue and add it to the visited list
            val vertex = listOfConnectionToVisit.poll()
            visited.add(startFrom)
            //get childs of the current vertex
            val childs = graph.getChild(vertex)
            //iterating through list of childs
            childs?.forEach {
                if (it != nameToSearch) {
                    if (!visited.contains(it)) {
                        println("traverse $it from $vertex  ")
                        listOfConnectionToVisit.add(it)
                    }
                } else {
                    println("path found $it from $vertex ")
                    return
                }

            }

        }
        println("path  not found ")


    }

}