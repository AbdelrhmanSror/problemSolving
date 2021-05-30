package com.company.heaps

import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

fun main() {
    val array = arrayListOf(4, 7, 8, 3, 2, 6, 5)
    val x: Heap<Int> = MinHeap<Int>()
    val y: Heap<Int> = MaxHeap<Int>()
    x.addAll(array)
    y.addAll(array)
    print(y.peek())

}

abstract class Heap<T : Number>() {
    val arrayV = ArrayList<T>()

    init {
        constructHeap()
    }

    fun size() = arrayV.size

    fun poll(): T {
        if (arrayV.isEmpty()) throw IllegalStateException("heap is empty")
        val item = arrayV[0]
        swap(arrayV, 0, arrayV.size - 1)
        arrayV.removeAt(arrayV.size - 1)
        heapifyDown(index = 0)
        return item


    }

    fun add(item: T) {
        arrayV.add(item)
        heapifyUp(index = arrayV.size - 1)

    }

    fun addAll(array: ArrayList<T>) {
        array.forEach { add(it) }

    }

    fun peek(): T {
        if (arrayV.isEmpty()) throw IllegalStateException("heap is empty") else return arrayV[0]
    }

    protected fun leftChildIndex(index: Int) = 2 * index + 1
    protected fun rightChildIndex(index: Int) = 2 * index + 2
    protected fun parentIndex(index: Int) = (index - 1) / 2
    protected fun leftChild(index: Int) = arrayV[leftChildIndex(index)]
    protected fun rightChild(index: Int) = arrayV[rightChildIndex(index)]
    protected fun parentChild(index: Int) = arrayV[parentIndex(index)]
    protected fun hasLeftChild(index: Int) = leftChildIndex(index) < arrayV.size
    protected fun hasRightChild(index: Int) = rightChildIndex(index) < arrayV.size
    protected fun hasParent(index: Int) = parentIndex(index) >= 0

    // o(nlog(n))
    private fun constructHeap() {
        for (i in (arrayV.size / 2) - 1 downTo 0) {
            heapifyDown(arrayV, i)
        }
    }

    //time O(log(n))
    abstract fun heapifyUp(array: ArrayList<T> = arrayV, index: Int, size: Int = array.size)

    //time O(log(n))
    abstract fun heapifyDown(array: ArrayList<T> = arrayV, index: Int, size: Int = array.size)
    protected fun swap(array: ArrayList<T>, index1: Int, index2: Int) {
        val temp = array[index1]
        array[index1] = array[index2]
        array[index2] = temp
    }


}


class MinHeap<T : Number>() : Heap<T>() {


    override fun heapifyUp(array: ArrayList<T>, index: Int, size: Int) {
        if (hasParent(index) && parentChild(index).compareTo(arrayV[index], '>')) {
            swap(arrayV, parentIndex(index), index)
            heapifyUp(index = parentIndex(index))
        }

    }

    // 0 1 2 3 4 5 6
    // 4 7 8 3 2 6 5
    override fun heapifyDown(array: ArrayList<T>, index: Int, size: Int) {
        var lowestIndexValue = index
        if (hasLeftChild(index) && leftChild(index).compareTo(array[index], '<'))
            lowestIndexValue = leftChildIndex(index)
        if (hasRightChild(index) && rightChild(index).compareTo(array[lowestIndexValue], '<'))
            lowestIndexValue = rightChildIndex(index)
        if (lowestIndexValue != index) {
            swap(array, index, lowestIndexValue)
            heapifyDown(index = lowestIndexValue)
        }


    }


}


class MaxHeap<T : Number>() : Heap<T>() {

    override fun heapifyUp(array: ArrayList<T>, index: Int, size: Int) {
        if (hasParent(index) && parentChild(index).compareTo(arrayV[index], '<')) {
            swap(arrayV, parentIndex(index), index)
            heapifyUp(index = parentIndex(index))
        }
    }

    // 0 1 2 3 4 5 6
    // 4 7 8 3 2 6 5
    override fun heapifyDown(array: ArrayList<T>, index: Int, size: Int) {
        var greatestIndexValue = index
        if (hasLeftChild(index) && leftChild(index).compareTo(array[index], '>'))
            greatestIndexValue = leftChildIndex(index)
        if (hasRightChild(index) && rightChild(index).compareTo(array[greatestIndexValue], '>'))
            greatestIndexValue = rightChildIndex(index)
        if (greatestIndexValue != index) {
            swap(array, index, greatestIndexValue)
            heapifyDown(index = greatestIndexValue)
        }


    }


}