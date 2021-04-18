package com.company

import org.w3c.dom.ranges.Range

//given list of word ,find all pairs of unique indices such that concatenation of two word is as palindrome.
//for example given list ["code","edoc","da","d"] return [(0,1),(1,0),(2,3)]


fun main() {
    findAllPairs("code", "edoc", "da", "a").forEach {
        println(it)
    }
}

/**
 * solution
 * the main point here to loop through each char in the word+previous words to see if its a palindrome or not
 * if its a palindrome we search for reversed suffix in map ,if it exists and its index is not the same with current word
 * so we are facing possible string that could be concatenated with current word to form a palindrome
 * at each iteration w do the check for the prefix and suffix .
 * complexity O(N*C^2) N is the list of word and C is the largest word size
 */

//lets create a map that maps the  word to its index
fun createMap(vararg listOfWord: String): HashMap<String, Int> {
    val map = HashMap<String, Int>()
    listOfWord.forEachIndexed { index, s ->
        map[s] = index
    }
    return map
}

//creating a fun that checks if the string is palindrome
fun isPalindrome(word: String): Boolean {
    if (word == word.reversed())
        return true
    return false

}

fun findAllPairs(vararg listOfWord: String): ArrayList<Pair<Int, Int>> {
    val map = createMap(*listOfWord)
    val list = arrayListOf<Pair<Int, Int>>()
    for (i in listOfWord.indices) {
        //looping through each char in word
        for (char_id in 0 until listOfWord[i].length) {
            val prefix = listOfWord[i].substring(0 until char_id)
            val suffix = listOfWord[i].substring(char_id until listOfWord[i].length)
            val reversedPrefix = prefix.reversed()
            val reversedSuffix = suffix.reversed()
            if (isPalindrome(prefix) && map.containsKey(reversedSuffix) && map[reversedSuffix] != i)
                list.add(Pair(i, map[reversedSuffix]!!))
            if (isPalindrome(suffix) && map.containsKey(reversedPrefix) && map[reversedPrefix] != i)
                list.add(Pair(i, map[reversedPrefix]!!))
        }
    }
    return list


}