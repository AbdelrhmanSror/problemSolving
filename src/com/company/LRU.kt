package com.company
//class that gets least recently used item based on size of page frame
//implementation using hashmap to facilitate the access to linkedList node in constant time so deletion will be in constant time


fun main() {
    val lru = LRU(3)
    lru.set("a", 1)
    lru.set("b", 2)
    lru.set("c", 3)
    lru.set("d", 4)
    println(lru.get("b"))


}

data class CustomNode(val key: String, val value: Int) {
    var previous: CustomNode? = null
    var next: CustomNode? = null
}

class CustomLinkedList {
    var head: CustomNode? = null
    var tail: CustomNode? = null

    fun add(node: CustomNode) {
        if (head == null) {
            head = node
            tail = node
        } else {
            tail?.next = node
            node.previous = tail
            tail = node
        }

    }

    fun remove(node: CustomNode?) {
        node?.let {
            val prev = it.previous
            prev?.next = it.next
            it.next?.previous = prev
            it.next = null
            it.previous = null
        }


    }
}

class LRU(private val size: Int) {
    private val map = HashMap<String, CustomNode>()
    private val list = CustomLinkedList()
    var sizeNow = 0
        private set

    fun set(key: String, value: Int) {
        if (map.contains(key))
            map.remove(key)
        val node = CustomNode(key, value)
        list.add(node)
        map[key] = node
        sizeNow++
        if (sizeNow > size) {
            val head = list.head
            list.remove(head)
            map.remove(head!!.key)
            sizeNow--
        }

    }

    fun get(key: String): Int? {
        if (map.containsKey(key)) {
            val node = map[key]
            list.remove(node)
            list.add(node!!)
            return node.value
        }
        return null

    }
}