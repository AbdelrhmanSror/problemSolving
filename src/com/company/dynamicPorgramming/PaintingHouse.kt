package com.company.dynamicPorgramming

/**
 * a builder is looking to build a row of n houses that can be of k different colors ,
 * she ahs a gal of minimizing cost while ensuring that no two neighbouring houses are of the same color
 * 1 2 3
 * 1 4 6
 * should return 2+1=3 minimum cost
 *
 * {14, 2, 11}
 * {11, 14, 5}
 * {14, 3, 10}
 * should return 2+5+3 =10 which is the minimum cost we could reach
 */

fun main() {
    print(getMinCost(arrayOf(arrayOf(14, 2, 11), arrayOf(11, 14, 5), arrayOf(14, 3, 10))))
}

//o(n*k^2) time and o(k) space
fun getMinCost(colorCost: Array<Array<Int>>):Int {
    val colorCosts = HashMap<Int, Int>()

    for (previousColorCostIndex in colorCost[0].indices) {
        colorCosts[previousColorCostIndex] = colorCost.currentCost(0, previousColorCostIndex)
        var previousMinColorCostIndex = 0
        for (houseNumber in 1 until colorCost.size) {
            var minCost = Int.MAX_VALUE
            for (currentColorCostIndex in colorCost[houseNumber].indices) {
                if (currentColorCostIndex.notTheSameColor(previousMinColorCostIndex) && colorCost.currentCost(houseNumber, currentColorCostIndex) < minCost) {
                    minCost = colorCost.currentCost(houseNumber, currentColorCostIndex)
                    previousMinColorCostIndex = currentColorCostIndex
                }
            }
            colorCosts[previousColorCostIndex] = colorCosts[previousColorCostIndex]!! + minCost

        }
    }
    var minCost=Int.MAX_VALUE
    colorCosts.forEach {
        if (it.value<minCost)minCost=it.value
    }
    return minCost
}

private fun Array<Array<Int>>.currentCost(row: Int, column: Int) =
        this[row][column]

private fun Int.notTheSameColor(previousColorIndex: Int) = this != previousColorIndex