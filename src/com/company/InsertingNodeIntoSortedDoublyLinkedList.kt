package com.company

import java.util.*


class DoublyLinkedListNode(nodeData: Int) {
    public var data: Int = nodeData
    public var next: DoublyLinkedListNode? = null
    public var prev: DoublyLinkedListNode? = null

}

class DoublyLinkedList {
    public var head: DoublyLinkedListNode?
    public var tail: DoublyLinkedListNode?

    init {
        head = null
        tail = null
    }

    public fun insertNode(nodeData: Int) {
        val node = DoublyLinkedListNode(nodeData)

        if (head == null) {
            head = node
        } else {
            tail?.next = node
            node?.prev = tail
        }

        tail = node
    }

}

fun printDoublyLinkedList(head: DoublyLinkedListNode?, sep: String) {
    var node = head;

    while (node != null) {
        println(node?.data)
        node = node?.next

        if (node != null) {
            println(sep)
        }
    }
}

// Complete the sortedInsert function below.

/*
 * For your reference:
 *
 * DoublyLinkedListNode {
 *     data: Int
 *     next: DoublyLinkedListNode?
 *     prev: DoublyLinkedListNode?
 * }
 *
 */
fun sortedInsert(llist: DoublyLinkedListNode?, data: Int): DoublyLinkedListNode? {
    val newNode = DoublyLinkedListNode(data)
    if (llist == null || llist.data >= data) {
        newNode.next = llist
        llist?.prev = newNode
        return newNode
    }
    var currentNode = llist
    while (currentNode != null && currentNode.data <= data) {
        if (currentNode.next == null) {
            currentNode.next = newNode
            newNode.prev = currentNode
            return llist
        }
        currentNode = currentNode.next
    }

    currentNode?.prev?.next = newNode
    currentNode?.prev = newNode
    newNode.next = currentNode
    return llist
}

fun reverse(llist: DoublyLinkedListNode?): DoublyLinkedListNode? {
    val temp=llist?.next
    llist?.next=llist?.prev
    llist?.prev=temp
    return if (temp==null)llist else reverse(temp)

}