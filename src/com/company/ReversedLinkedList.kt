package com.company

fun main() {
    val node5 = LinkedListNode<Int>(null, 6)
    val node4 = LinkedListNode<Int>(node5, 5)
    val node3 = LinkedListNode<Int>(node4, 3)
    val root = LinkedListNode<Int>(node3, 1)
    reverse(root)
}


data class LinkedListNode<T>(var next: LinkedListNode<T>?, var value: T) {
    val size:Int by lazy {
        (next?.size ?: 0) + 1
    }


}

fun reverse(node: LinkedListNode<Int>) {
    var first = reversedLinkedListLoop(node)//node.last
    //reversedLinkedList(node)
    while (first != null) {
        println("printing the current node is :${first.value}")
        first = first.next
    }
}

//uses O(N) TIME AND CONSTANT SPACE
fun reversedLinkedListLoop(node: LinkedListNode<Int>?): LinkedListNode<Int>? {
    var prev: LinkedListNode<Int>? = null
    var current = node
    while (current != null) {
        val temp = current.next
        current.next = prev
        prev = current
        current = temp
    }
    return prev
}

//uses O(N) TIME AND O(N) SPACE
fun reversedLinkedList(node: LinkedListNode<Int>?): LinkedListNode<Int> {
    if (node!!.next == null) {
        return node
    }
    val next = reversedLinkedList(node.next)
    node.next = next.next
    next.next = node
    return node

}
