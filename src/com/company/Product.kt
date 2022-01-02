package com.company
//given an array of element output array such that each element is ,
// product of all the other element in the array except the current one.
//for example  [1,2,3,4,5] would be [120,60,40,30,24]
//for example  [1,2,3] would be [2,3,6]
//you can not use division


fun main() {
    product2(arrayOf(1, 2, 3, 4, 5)).forEach { println(it) }


}




//another solution not using division o(n)time o(n)space
fun product2(array: Array<Int>): Array<Int> {
    val prefix = IntArray(array.size) { 1 }
    val postfix = IntArray(array.size) { 1 }

    //looping through each element in array and find the prefix product of each element
    for (i in 1 until array.size)
        prefix[i] = array[i - 1] * prefix[i - 1]

    //looping through each element in array and find the postfix product of each element and,
    // multiply it with prefix of current element to find the product of the current element
    for (i in array.size - 2 downTo 0) {
        postfix[i] = array[i + 1] * postfix[i + 1]

    }
    for (i in array.indices) {
        array[i] = postfix[i] * prefix[i]
    }

    return array
}

//division solution
fun product(array: Array<Int>): List<Int> {
    val product = array.mul()
    return array.map { product / it }

}

fun Array<Int>.mul(): Int {
    var product = 1
    this.forEach {
        product *= it
    }
    return product
}
