package com.company.tries


//implementing the auto complete search in words using trie data structure
typealias Trie = AutoCompleteSearch

fun main() {


    val trie = Trie()

    trie.add("dog")
    trie.add("coat")
    trie.add("cat")
    trie.add("bear")
    trie.add("ahmed")
    trie.add("mohamed")
    trie.add("abdelrhman")


    trie.printAllWords()


}


class TrieNode {
    private val nextCharArray: Array<TrieNode?> = arrayOfNulls(26)
    var word_ending_here = false
    var currentWord = ' '
        private set

    fun isCharExist(index: Int): Boolean {
        if (this.nextCharArray[index] == null) {
            return false
        }
        return true

    }

    fun addChar(index: Int, char: Char) {
        val node = TrieNode()
        node.currentWord = char
        nextCharArray[index] = node
    }

    fun getNextNodeAt(index: Int): TrieNode {
        return nextCharArray[index]!!
    }

}


class AutoCompleteSearch() {
    private val node = TrieNode()

    //get the index of the char at the array
    private fun getCharIndex(char: Char) = char - 'a'

    //using index get the char at specific index
    fun getChar(index: Int) = (index + 97).toChar()
    private fun getNode(root: TrieNode, char: Char): TrieNode {
        val index = getCharIndex(char)
        if (!root.isCharExist(index)) {
            root.addChar(index, char)
        }
        return root.getNextNodeAt(index)
    }

    fun add(word: String) {
        var currentTrieNode: TrieNode = node
        for (char in word) {
            currentTrieNode = getNode(currentTrieNode, char)
        }
        currentTrieNode.word_ending_here = true
    }

    fun isExist(word: String): Boolean {
        return isExist(word, node)

    }

    private fun isExist(word: String, trieNode: TrieNode?): Boolean {
        if (trieNode == null) return false
        var currentTrieNode: TrieNode = trieNode
        for (i in word.indices) {
            //if we have found the place of char in array is not null this means that the char is exist
            if (currentTrieNode.isCharExist(getCharIndex(word[i]))) {
                //here we update the current node to the node at the index of which current char implies.
                //for example if the char was a so we can find it at index of 0 at the current node
                //if we have found the current char at 'a' we update the current node with the node in 'a' index
                //so when going for the next char we user the node at 'a' as our root

                currentTrieNode = currentTrieNode.getNextNodeAt(getCharIndex(word[i]))
            } else
                return false
        }
        return true
    }

    //print all words in the trie
    fun printAllWords() {
        print(node).map {
            println(it)
        }

    }

    private fun print(currentNode: TrieNode): List<String> {
        if (currentNode.word_ending_here) return arrayListOf("")
        //list that contains all string constructed until now
        val wordList = arrayListOf<String>()
        //iterating over all chars in trie ,see if the char exist ,get to next connected chars and so on until reached word ending here.
        for (i in 0 until 26) {
            if (currentNode.isCharExist(i)) {
                val list = print(currentNode.getNextNodeAt(i))
                //join the current char with list of subsequent strings
                wordList.addAll(getChar(i).joinList(list))
            }

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
