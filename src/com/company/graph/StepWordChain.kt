package com.company.graph

/*
given a start word ,an end word and a dictionary of valid words,find the shortest transformation sequence from start to end
such that only one letter is changed at a time and each transformed word is existing in the dictionary.
if no such a transformation return null
e.g.  start= dog   end= cat    dictionary={dot,dop,dat,cat}
 should return {dog,dop,dat,cat}
e.g. start= dog   end= cat    dictionary={dot,tod,dat,dar}
 should return null as there is no possible transformation from dog to cat
  */


fun main() {
    val start = "dog"
    val end = "cat"
    val dictionary = hashSetOf("dot", "dop", "dct", "cat")
    print(getStepWordChain(start, end, dictionary))
}

// o(n^2) time and o(n) space
fun getStepWordChain(start: String, end: String, dictionary: HashSet<String>): List<String>? {
    //first we make sure that end word is exited in the dictionary ,if not no need to go on anymore.
    val wordChain = arrayListOf<String>()
    if (dictionary.contains(end)) {
        val currentWord = StringBuilder(start)
        //getting the difference between the start and end word to to know how many char is needed to be changed.
        val listOfDifferentIndexes = start.getDiff(end)
        for (i in listOfDifferentIndexes.indices) {
            val size = listOfDifferentIndexes.size
            for (index in listOfDifferentIndexes) {
                // in case of not finding the new replaced string in dictionary we use the char to reverse back to the old string
                val char = currentWord[index]
                currentWord.replace(index, index + 1, "${end[index]}")
                val currentWordString = currentWord.toString()
                //if the dict contains the new replaced string then add it to the work chain and remove the index from the set,
                //so in the next iteration we do not have to passing the same index again resulting in the same string already existed in word chain
                if (dictionary.contains(currentWordString)) {
                    wordChain.add(currentWordString)
                    listOfDifferentIndexes.remove(index)
                    break
                } else {
                    //reverse back to the old string ,we did not find the current new one the dict
                    currentWord.replace(index, index + 1, "$char")

                }
            }
            //because with the end of the loop ,we have to add string to the word chain and removing the visited index,
            //this results in decreasing in the size of listOfDifferentIndex,if the size did not decrease ,
            //this mean we did not add any element to the word chain,as we can not construct the word chain without this element we return null
            if (size == listOfDifferentIndexes.size) return null
        }
    }
    return wordChain

}

fun String.getDiff(word: String): HashSet<Int> {
    val listOfDiffIndex = HashSet<Int>()
    for (i in this.indices) {
        //adding the index of both different char to list
        if (this[i] != word[i]) listOfDiffIndex.add(i)
    }
    //in case of there is string is bigger than the other
    if (this.length > word.length) {
        for (i in word.length until this.length)
            listOfDiffIndex.add(i)
    } else if (this.length < word.length) {
        for (i in this.length until word.length)
            listOfDiffIndex.add(i)
    }
    return listOfDiffIndex
}
