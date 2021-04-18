package com.company

import kotlin.collections.HashMap

fun main() {
    val x = "abxaba"
    print(findIndices("ab", x))


}
//given a word and a string s,find all indices in s which are starting location of anagrams of w
//for example given w is ab and s is abxaba return [0,3,4]

//naive solution would be creating a window with size of word and loop through the string ,during each pass we check if the size of window is equal to size of word,
// basically all what we are doing is creating a map of char ocurrance and looping through the string if the map has chars larger than what in the word we remove char from beginner add another at the end
//if the two map are equal then add the index to list
//O(S) time and space
fun findIndices(w: String, s: String): List<Int> {
    val indexArray = arrayListOf<Int>()
    val wordMap = w.mapOccurrence()
    val stringMap = HashMap<Char, Int>()
    //refer to coming index of the element to be deleted from map
    var elementToDelete = 0
    var windowSize = 0
    stringMap.addOrIncrement(s[0])
    for (i in 1 until s.length) {
        stringMap.addOrIncrement(s[i])
        windowSize++
        if (windowSize % w.length == 0) {
            stringMap.deleteOrDecrement(s[elementToDelete])
            elementToDelete++
            windowSize--
        }
        if (stringMap == wordMap) {
            indexArray.add(elementToDelete)
        }
    }


    return indexArray

}

fun String.mapOccurrence(): Map<Char, Int> {
    val map = HashMap<Char, Int>()
    for (i in this)
        map.addOrIncrement(i)
    return map
}

fun HashMap<Char, Int>.addOrIncrement(char: Char) {
    if (this.containsKey(char)) {
        this[char] = this[char]!! + 1
    } else
        this[char] = 1


}

fun HashMap<Char, Int>.deleteOrDecrement(char: Char) {
    if (this.containsKey(char)) {
        this[char]?.let {
            if (it > 1) this[char] = this[char]!! - 1
            else this.remove(char)
        }
    }

}

