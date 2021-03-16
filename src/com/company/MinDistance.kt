package com.company


/**
 * 1 2
2 3
3 4
4 5
5 6
6 7
7 8
8 9
9 10
 */
fun main(){
    print(findMinDistance(1 to 2,2 to 3,3 to 4,4 to 5, 5 to 6,6 to 7, 7 to 8, 8 to 9, 9 to 10))
}
fun findMinDistance(vararg edges: Pair<Int, Int>) :Int{
    val edgeMap = HashMap<Int, Int?>()
    var last: Int = 0
    var min=Int.MAX_VALUE
    edges.forEach {
        edgeMap[it.first] = it.second
        last = it.second
    }
    edgeMap[last] = null
    edges.forEach {
        val distance=findDistance(edgeMap,it.first)
        println("${it.first}  $distance")
        min= minOf(min, distance)
    }
    return min


}

fun findDistance(edges:HashMap<Int,Int?>,number: Int?):Int {
    if(number==null||edges[number]==number){
        return 0
    }
    return findDistance(edges,edges[number])+1


}