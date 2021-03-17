package com.company

fun main() {
    println(makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"))

}

//get the minimum deleteion to make the two string the same
fun makeAnagram(s1: String, s2: String): Int {
    val set1 = HashMap<Char, Int>()
    val set2 = HashMap<Char, Int>()
    var counter = 0
    //insert the String as Chars into Hash map with recurrence of each char
    set1.addCharsWithRecurrence(s1)
    set2.addCharsWithRecurrence(s2)

    counter += set1.getCountOfDeletedChars(set2)
    counter += set2.getCountOfDeletedChars(set1)
    return counter
}

fun HashMap<Char, Int>.addCharsWithRecurrence(s1: String) {
    s1.forEach {
        if (this.containsKey(it)) {
            this[it] = this[it]!! + 1
        } else {
            this[it] = 1
        }
    }
}

fun HashMap<Char, Int>.getCountOfDeletedChars(set2: HashMap<Char, Int>): Int {
    var counter = 0
    this.forEach {
        //if the current char is existed in the second set of chars then continue
        if (set2.containsKey(it.key) && set2[it.key]!! > 0) {
            //we get recurrence of the current item in the current set and the another set then find the bigger and minus it from the lower
            //and the result is our remaining chars that need to be deleted
            //otherwise means that the current char is not exist in the another array so the recurrence of this char is the number of char to be deleted
            if (it.value >= set2[it.key]!!) {
                this[it.key] = it.value - set2[it.key]!!
                set2[it.key] = 0
                counter += this[it.key]!!
                this[it.key] = 0

            } else {
                set2[it.key] = set2[it.key]!! - it.value
                this[it.key] = 0
                counter += set2[it.key]!!
                set2[it.key] = 0
            }
        } else {
            counter += it.value
            this[it.key] = 0
        }
    }
    return counter
}
