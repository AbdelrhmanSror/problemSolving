package com.company.graph



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

    print(GraphCycle(graph).hasCycle())


}
class GraphCycle<T>(private val graph: Graph<T>) {
    fun hasCycle(): Boolean {
        val visited = HashSet<T>()
        for (parent in graph.getParents()) {
            if (!visited.contains(parent))
                if (search(null, parent, visited))
                    return true

        }
        return false
    }

    private fun search(parent: T?, vertex: T, visited: HashSet<T>): Boolean {
        visited.add(vertex)
        val childs = graph.getChild(vertex)
        childs?.forEach {
            if (!visited.contains(it)) {
                if (search(parent, it, visited))
                    return true
            } else if (parent == it)
                return true
        }
        return false

    }
}