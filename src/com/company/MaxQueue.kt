package com.company

fun main() {

    maxLength(arrayOf(1,2,3,4,5,6,7,8,9), 3)

}

fun maxLength(array: Array<Int>, k: Int) {
    val x = CustomizedQueue()
    for (i in 0 until k)
        x.enqueuingItemDescendingOrder(array[i])
    println(x.peek())
    for ((nextRemovedItem, i) in (k until array.size).withIndex()) {
        if (x.peek() == array[nextRemovedItem])
            x.dequeue()
        x.enqueuingItemDescendingOrder(array[i])
        println(x.peek())
    }


}

class CustomizedQueue {
    private var node: LinkedListNode<Int>? = null
    fun print() {
        var current = node
        while (current != null) {
            print("${current.value}-->")
            current = current.next
        }
        println("null")


    }

    //adding the items in descending order in queue if there is an item that would break this order ,just remove it
    fun enqueuingItemDescendingOrder(item: Int) {
        //the item less than current item in queue
        val number = findItemLessThan(item)
        if (number != null) {
            removeStartFromToEnd(number)
        }
        enqueue(item)

    }

    //find the first item less than the specific item
    private fun findItemLessThan(number: Int): Int? {
        var current = node
        while (current != null) {
            if (current.value < number)
                return current.value
            current = current.next
        }
        return null
    }

    fun peek(): Int? {
        return node?.value
    }

    //removing item from the queue
    fun dequeue() {
        if (node != null)
            node = node!!.next
    }

    //adding item to the queue
    fun enqueue(number: Int) {
        if (node == null)
            node = LinkedListNode(null, number)
        else {
            var current = node
            while (current!!.next != null) {
                current = current.next
            }
            current.next = LinkedListNode(null, number)
        }

    }

    //will remove item starting from specific item to the end of the list
    fun removeStartFromToEnd(number: Int) {
        var current = node
        //removing the root if it is equal to the number needed to be removed
        if (current != null && current.value == number)
            node = null
        while (current?.next != null && current.next!!.value != number) {
            current = current.next
        }
        if (current?.next != null) {
            current.next = null
        }

    }

}