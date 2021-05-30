package com.company.heaps

typealias webUserMap = List<Pair<String, HashSet<Int>>>

fun main() {
    val map = constructWebsiteUser(
            "google" to 1, "google" to 3, "google" to 5,
            "pets" to 1, "pets" to 2, "pets" to 6,
            "yahoo" to 2, "yahoo" to 3, "yahoo" to 4, "yahoo" to 5,
            "wiki" to 4, "wiki" to 5, "wiki" to 6, "wiki" to 7,
            "bing" to 1, "bing" to 3, "bing" to 5, "bing" to 6)
    println(map)
    println(topPairs(map).peek())


}

//giving  a list of (website,user) pairs that represent users visiting websites,
// come up with a program that identifies top k pairs of websites with the greatest similarity.
//time (o(n^2 *m))     space o(n^2)
fun topPairs(map: webUserMap):MaxHeap<Double> {
    val heap=MaxHeap<Double>()
    for (i in map.indices) {
        for (j in i + 1 until map.size) {
            val similarity = computeSimilarity(map[i].second, map[j].second)
            println("${map[i].first}  ${map[j].first}  $similarity")
            heap.add(similarity)

        }
    }
    return heap


}
//o(m) time represents the length of smallest set
fun computeSimilarity(set1: HashSet<Int>, set2: HashSet<Int>): Double {
    //choosing to iterate over the least size set
    //first represents the least size set
    //second represents the bigger size set
    val setToIterate = if (set1.size < set2.size) set1 to set2 else set2 to set1
    var counter = 0.0
    setToIterate.first.forEach {
        if (setToIterate.second.contains(it))
            counter++
    }
    return (counter) / setToIterate.second.size


}

fun constructWebsiteUser(vararg websiteUser: Pair<String, Int>): List<Pair<String, HashSet<Int>>> {
    val websiteUserMap = HashMap<String, HashSet<Int>>()
    websiteUser.forEach {
        if (!websiteUserMap.containsKey(it.first))
            websiteUserMap[it.first] = HashSet<Int>()
        websiteUserMap[it.first]!!.add(it.second)

    }
    return websiteUserMap.toList()
}

