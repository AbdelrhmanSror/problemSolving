package com.company


fun main() {

    val node1= createRoot(3,7,8,10,11)
    val node2= createRoot(99,1,8,10,11)

    println(findIntersection(node1,node2))

    // alternate(root)
    //print(sumUpTwoLinkedList(l1, l2))
}

fun createRoot(vararg values: Int): LinkedListNode<Int> {
    val root = LinkedListNode<Int>(null, 0)
    var current = root

    for (i in 0 until values.size - 1) {
        current.next = LinkedListNode<Int>(null, 0)
        current.value = values[i]
        current = current.next!!
    }
    current.value = values[values.size - 1]
    return root

}

fun findIntersection(l1: LinkedListNode<Int>, l2: LinkedListNode<Int>): LinkedListNode<Int>? {
    var firstNode: LinkedListNode<Int>? = l1
    var secondNode: LinkedListNode<Int>? = l2
    val firstSize = firstNode?.size ?: 0
    val secondSize = secondNode?.size ?: 0
    if (firstSize > secondSize)
        for (i in 0 until (firstSize - secondSize))
            firstNode = firstNode?.next
    else
        for (i in 0 until (secondSize - firstSize))
            secondNode = secondNode?.next



    while (firstNode != secondNode) {
        firstNode = firstNode?.next
        secondNode = secondNode?.next
    }
    return firstNode

}


/*
fun alternate(l: LinkedListNode<Int>) {
    var root: LinkedListNode<Int>? = alternateHighLow(l)
    println(root)
    while (root != null) {
        println(root.value)
        root = root.next

    }


}


fun alternateHighLow(l: LinkedListNode<Int>): LinkedListNode<Int> {
    var prev: LinkedListNode<Int>? = null
    var current: LinkedListNode<Int>? = l
    var next: LinkedListNode<Int>? = current?.next
    var counter = 0
    println(counter)
    while (next != null) {
        val highLow = if (counter % 2 == 0) next.value > current!!.value else next.value < current!!.value
        if (highLow) {
            prev = current
            current = next
            next = current.next
        } else {
            swapTwoNodes(current, next)
            prev?.next = next
            prev = next
            next = current.next

        }
        counter++
    }
    return l
*/
/* if (l!!.next == null)
         return l
     val next = alternateHighLow(l.next,counter+1)
     val highLow = if (counter % 2 == 0) next.value > l.value else next.value < l.value
     return if (highLow) {
         l.next=next
         l
     }
     else
         swapTwoNodes(l, next)*//*


}
*/

private fun swapTwoNodes(l: LinkedListNode<Int>, next: LinkedListNode<Int>): LinkedListNode<Int> {
    l.next = next.next
    next.next = l
    return next
}
/*

fun sumUpTwoLinkedList(l1: LinkedListNode<Int>, l2: LinkedListNode<Int>): Int {
    val sum1 = sum(l1).toInt()
    println(sum1)
    val sum2 = sum(l2).toInt()
    println(sum2)
    return sum1 + sum2

}

fun sum(l1: LinkedListNode<Int>): String {
    if (l1.next == null)
        return "${l1.value}"
    val sum = "${l1.value}${sum(l1.next!!)}"
    return sum
}*/
