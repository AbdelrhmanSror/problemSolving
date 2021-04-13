package com.company



fun main(){
    val array=arrayOf('G', 'B', 'R', 'R', 'B', 'R', 'G')
    reSortRGB(array)
    array.forEach { print("$it  ") }

}
/**
 * This problem was asked by Google.
 * Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the array so that all the Rs come first,
 * the Gs come second, and the Bs come last. You can only swap elements of the array.
 * Do this in linear time and in-place.
 * For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].
 */
fun reSortRGB(array: Array<Char>) {
    val map = HashMap<Char, Int>()
    //find the recurrence of each char
    array.forEach {
        if (map.containsKey(it))
            map[it] = map[it]!! + 1
        else map[it] = 1
    }
    //looping through the array elements
    for (i in array.indices) {
        when {
            map['R']!! > 0 -> {
                array[i] = 'R'
                map['R'] = map['R']!! - 1
            }
            map['G']!! > 0 -> {
                array[i] = 'G'
                map['G'] = map['G']!! - 1
            }
            else -> {
                array[i] = 'B'
                map['B'] = map['B']!! - 1
            }
        }
    }
}