package com.company.heaps


fun main() {
    getMedians(arrayOf(2, 1, 5, 7, 2, 0, 5)).forEach { println(it) }

}

fun getMedians(array: Array<Number>): Array<Number> {
    //heap that holds max of min numbers
    //all elements smaller than the median in max heap
    val maxHeap = MaxHeap<Number>()
    //heap that holds min of max numbers
    //all element larger than the median in min heap
    val minHeap = MinHeap<Number>()
    //nlog(n) , since for each element we perform a constant number of poll and add operation ,each of which take log(n) in the worst case
    array.forEachIndexed { index, i ->
        addNumber(minHeap, maxHeap, i.toInt())
        balance(minHeap, maxHeap)
        array[index] = getMedian(minHeap, maxHeap)

    }
    return array

}


fun balance(minHeap: MinHeap<Number>, maxHeap: MaxHeap<Number>) {
    if (minHeap.size() > maxHeap.size() + 1)
        maxHeap.add(minHeap.poll())
    else if (maxHeap.size() > minHeap.size() + 1)
        minHeap.add(maxHeap.poll())

}

fun addNumber(minHeap: MinHeap<Number>, maxHeap: MaxHeap<Number>, value: Int) {
    if (maxHeap.size() > 0 && value .compareTo(maxHeap.peek(),'<')) {
        maxHeap.add(value)
    } else {
        minHeap.add(value)
    }
}

fun getMedian(minHeap: MinHeap<Number>, maxHeap: MaxHeap<Number>): Double {
    return when {
        minHeap.size() == maxHeap.size() -> {
            (minHeap.peek().toDouble()+maxHeap.peek().toDouble()) / 2.0
        }
        minHeap.size() > maxHeap.size() -> {
            minHeap.peek().toDouble()
        }
        else -> {
            maxHeap.peek().toDouble()

        }
    }
}

