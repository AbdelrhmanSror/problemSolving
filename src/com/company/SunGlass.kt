package com.company


fun main() {
    sunGlass(arrayOf(
            arrayOf(-1, -1, 0, -9, -2, -2),
            arrayOf(-2, -1, -6, -8, -2, -5),
            arrayOf(-1, -1, -1, -2, -3, -4),
            arrayOf(-1, -9, -2, -4, -4, -5),
            arrayOf(-7, -3, -3, -2, -9, -9),
            arrayOf(-1, -3, -1, -2, -4, -5)))
}

data class Max(var value: Int, var row: Int, var column: Int)

fun sunGlass(arr: Array<Array<Int>>) {

    var max=Int.MIN_VALUE
    var startRowIndex = 0
    var currentRowIndex = 0
    val array = Array<Array<Int>>(4) { Array(4) { 0 } }
    //represent each row in the array
    while (currentRowIndex < arr.size) {
        var startColumnIndex = 0
        var currentColumnIndex = 0
        var currentRowValue = 0
        if (currentRowIndex - startRowIndex == 3) {
            startRowIndex++
            currentRowIndex = startRowIndex

        }
        //columns
        while (currentColumnIndex < 6) {
            //we finished the first portion of the  sun glass
            if (currentColumnIndex - startColumnIndex == 3) {
                startColumnIndex++
                currentColumnIndex = startColumnIndex
                array[startRowIndex][startColumnIndex - 1] += currentRowValue
                currentRowValue = 0


            }
            //take the middle number from the portion
            if (currentRowIndex == startRowIndex + 1) {
                if (currentColumnIndex > 0 && currentColumnIndex < arr.size - 1) {
                    currentRowValue = arr[currentRowIndex][startColumnIndex + 1]

                }
            } else {
                currentRowValue += arr[currentRowIndex][currentColumnIndex]
            }

            currentColumnIndex++
        }
        array[startRowIndex][startColumnIndex] += currentRowValue
        currentRowIndex++


    }
    array.forEach { first ->
        first.forEach {
            if(it>max)max=it
            print("$it ")
        }
        print("\n")
    }
    print(" $max \n")

}