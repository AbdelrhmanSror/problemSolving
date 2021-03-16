package com.company


fun main() {
    //print(activityNotifications(arrayOf(1,2,3,4,4),4))
    print(notificationDecision(arrayOf(1, 2, 3, 4, 4), 4))
}

//naive solution
fun activityNotifications(array: Array<Int>, days: Int): Int {
    var notification = 0
    for (i in array.indices) {
        if (i + (days - 1) < array.size - 1) {
            val temp = Array<Number>(days) { 0 }
            System.arraycopy(array, i, temp, 0, days)
            val median = getMedians(temp)
            if ((array[i + days]) >= median[days - 1].toInt() * 2) {
                notification++
            }

        }
    }
    return notification
}

//more optimized solution based on counting sort algorithm
fun notificationDecision(array: Array<Int>, d: Int): Int {
    val freq = createFreq()
    var notification = 0
    var median = 0.0
    for (i in array.indices) {
        //as long as the i+d is less than the size of the array continue
        if (i + (d - 1) < array.size - 1) {
            updateFreq(array, freq, i..i + (d - 1))
            median = findMedian(freq, d)
            if (2 * median <= array[i + d]) notification++
        }
    }
    return notification

}

fun findMedian(freq: Array<Int>, d: Int): Double {
    var first: Int? = null
    var last: Int? = null
    var median = 0.0
    var count = 0
    //for sure i know the location of the two number in the middle to get the average of them
    // because they are sorted so it is easily to know the location of the medians

    if (d.rem(2) == 0) {
        for (j in freq.indices) {
            count += freq[j]
            if (first == null && count >= d / 2) {
                first = j
            }
            if (last == null && count >= d / 2 + 1) {
                last = j
                break
            }
        }
        median = (first!! + last!!) / 2.0
    } else {
        loop@ for (j in freq.indices) {
            count += freq[j]
            if (first == null && count >= d / 2 + 1) {
                first = j
                median = first.toDouble()
                break@loop
            }

        }
    }


    return median
}


fun createFreq() = Array<Int>(201) { 0 }
fun updateFreq(array: Array<Int>, freq: Array<Int>, range: IntRange) {
    //if the indicator is on the first item then just create and initialize the frequency
    // otherwise go on with increasing and decreasing the frequency of the item
    if (range.first > 0) {
        freq[array[range.first - 1]]--
        freq[array[range.last]]++
    } else if (range.first == 0) {
        for (i in range) {
            freq[array[i]]++
        }
    }
}

