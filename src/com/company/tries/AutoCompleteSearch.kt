package com.company.tries


//implementing the auto complete search in words using trie data structure
typealias Trie = AutoCompleteSearch

fun main() {


    val trie = Trie()

    trie.add("dog")
    trie.add("coat")
    trie.add("cat")
    trie.add("bear")
    trie.add("deal")
    trie.add("deer")
    trie.add("abdelrhman")


    trie.printAllWords()


}


class TrieNode {
    private val nextCharArray = HashMap<Char, TrieNode>()
    var wordEndingHere = false

    fun isCharExist(char: Char): Boolean {
        if (!this.nextCharArray.containsKey(char)) {
            return false
        }
        return true

    }

    fun addChar(char: Char) {
        val node = TrieNode()
        nextCharArray[char] = node
    }

    fun getNextNodeAt(char: Char): TrieNode {
        return nextCharArray[char]!!
    }

    fun createIterator(): MutableIterator<MutableMap.MutableEntry<Char, TrieNode>> {
        return nextCharArray.entries.iterator()
    }

}


class AutoCompleteSearch() {
    private val node = TrieNode()

    /* //get the index of the char at the array
     private fun getCharIndex(char: Char) = char - 'a'

     //using index get the char at specific index
     fun getChar(index: Int) = (index + 97).toChar()*/
    private fun getNode(root: TrieNode, char: Char): TrieNode {
        if (!root.isCharExist(char)) {
            root.addChar(char)
        }
        return root.getNextNodeAt(char)
    }

    fun add(word: String) {
        var currentTrieNode: TrieNode = node
        for (char in word) {
            currentTrieNode = getNode(currentTrieNode, char)
        }
        currentTrieNode.wordEndingHere = true
    }

    fun isExist(word: String): TrieNode? {
        return isExist(word, node)

    }

    private fun isExist(word: String, trieNode: TrieNode?): TrieNode? {
        if (trieNode == null) return null
        var currentTrieNode: TrieNode = trieNode
        for (i in word.indices) {
            //if we have found the place of char in array is not null this means that the char is exist
            if (currentTrieNode.isCharExist(word[i])) {
                //here we update the current node to the node at the index of which current char implies.
                //for example if the char was a so we can find it at index of 0 at the current node
                //if we have found the current char at 'a' we update the current node with the node in 'a' index
                //so when going for the next char we user the node at 'a' as our root

                currentTrieNode = currentTrieNode.getNextNodeAt(word[i])
            } else
                return null
        }
        return currentTrieNode
    }

    //print all words in the trie
    fun printAllWords() {
        print(node).map {
            println(it)
        }

    }

    //print all words that have word as a prefix
    fun wordsStartWith(word: String) {
        val node = isExist(word)
        if (node != null) {
            print(node).map {
                println(word + it)
            }

        }


    }


    private fun print(currentNode: TrieNode): List<String> {
        if (currentNode.wordEndingHere) return arrayListOf("")
        //list that contains all string constructed until now
        val wordList = arrayListOf<String>()
        //iterating over all chars in trie ,see if the char exist ,get to next connected chars and so on until reached word ending here.
        val iterator = currentNode.createIterator()
        while (iterator.hasNext()) {
            val current = iterator.next()
            val list = print(current.value)
            //join the current char with list of subsequent strings
            wordList.addAll((current.key).joinList(list))
        }
        return wordList
    }


}

//concatenate char with each string in the list
fun Char.joinList(list: List<String>): List<String> {
    return list.map {
        this + it
    }

}
