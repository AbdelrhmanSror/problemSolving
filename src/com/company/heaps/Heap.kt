package com.company.heaps

import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

fun main() {
    val array = arrayListOf(4, 7, 8, 3, 2, 6, 5)
    val x: Heap = MinHeap()
    val y: Heap = MaxHeap()
    x.addAll(array)
    y.addAll(array)

}

abstract class Heap() {
    val arrayV = ArrayList<Int>()

    init {
        constructHeap()
    }

    fun size() = arrayV.size

    fun poll(): Int {
        if (arrayV.isEmpty()) throw IllegalStateException("heap is empty")
        val item = arrayV[0]
        swap(arrayV, 0, arrayV.size - 1)
        arrayV.removeAt(arrayV.size - 1)
        heapifyDown(index = 0)
        return item


    }

    fun add(item: Int) {
        arrayV.add(item)
        heapifyUp(index = arrayV.size - 1)

    }

    fun addAll(array: ArrayList<Int>) {
        array.forEach { add(it) }

    }

    fun peek(): Int {
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
    abstract fun heapifyUp(array: ArrayList<Int> = arrayV, index: Int, size: Int = array.size)

    //time O(log(n))
    abstract fun heapifyDown(array: ArrayList<Int> = arrayV, index: Int, size: Int = array.size)
    protected fun swap(array: ArrayList<Int>, index1: Int, index2: Int) {
        val temp = array[index1]
        array[index1] = array[index2]
        array[index2] = temp
    }


}

class MinHeap() : Heap() {


    override fun heapifyUp(array: ArrayList<Int>, index: Int, size: Int) {
        if (hasParent(index) && parentChild(index) > arrayV[index]) {
            swap(arrayV, parentIndex(index), index)
            heapifyUp(index = parentIndex(index))
        }

    }

    // 0 1 2 3 4 5 6
    // 4 7 8 3 2 6 5
    override fun heapifyDown(array: ArrayList<Int>, index: Int, size: Int) {
        var lowestIndexValue = index
        if (hasLeftChild(index) && leftChild(index) < array[index])
            lowestIndexValue = leftChildIndex(index)
        if (hasRightChild(index) && rightChild(index) < array[lowestIndexValue])
            lowestIndexValue = rightChildIndex(index)
        if (lowestIndexValue != index) {
            swap(array, index, lowestIndexValue)
            heapifyDown(index = lowestIndexValue)
        }


    }


}

class MaxHeap() : Heap() {

    override fun heapifyUp(array: ArrayList<Int>, index: Int, size: Int) {
        if (hasParent(index) && parentChild(index) < arrayV[index]) {
            swap(arrayV, parentIndex(index), index)
            heapifyUp(index = parentIndex(index))
        }
    }

    // 0 1 2 3 4 5 6
    // 4 7 8 3 2 6 5
    override fun heapifyDown(array: ArrayList<Int>, index: Int, size: Int) {
        var greatestIndexValue = index
        if (hasLeftChild(index) && leftChild(index) > array[index])
            greatestIndexValue = leftChildIndex(index)
        if (hasRightChild(index) && rightChild(index) > array[greatestIndexValue])
            greatestIndexValue = rightChildIndex(index)
        if (greatestIndexValue != index) {
            swap(array, index, greatestIndexValue)
            heapifyDown(index = greatestIndexValue)
        }


    }


}