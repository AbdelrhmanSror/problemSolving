package com.company


//implementing the auto complete search in words using trie data structure

fun main() {


    val autoCompleteSearch = AutoCompleteSearch()

    autoCompleteSearch.add("abcdf")
    autoCompleteSearch.add("abcdfg")
    print(autoCompleteSearch.isExist("abcdfg"))


}


data class Node2(val charArray: Array<Node2?> = arrayOfNulls<Node2>(26)) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Node2

        if (!charArray.contentEquals(other.charArray)) return false

        return true
    }

    override fun hashCode(): Int {
        return charArray.contentHashCode()
    }
}


class AutoCompleteSearch() {
    private val node = Node2()
    private fun getCharIndex(char: Char) = char - 'a'
    private fun getChar(index: Int) = (index + 97).toChar()
    private fun getNode(root: Node2, char: Char): Node2 {
        val index = getCharIndex(char)
        if (root.charArray[index] == null) {
            root.charArray[index] = Node2()
        }
        return root.charArray[index]!!
    }

    fun add(word: String) {
        var currentNode: Node2 = node
        for (char in word) {
            currentNode = getNode(currentNode, char)
        }
    }

    fun isExist(word: String): Boolean {
        return isExist(word, node)

    }

    private fun isExist(word: String, node2: Node2?): Boolean {
        if (node2 == null) return false
        var currentNode: Node2 = node2
        for (i in word.indices) {
            //if we have found the place of char in array is not null this means that the char is exist
            if (currentNode.charArray[getCharIndex(word[i])] != null) {
                //here we update the current node to the node at the index of which current char implies.
                //for example if the char was a so we can find it at index of 0 at the current node
                //if we have found the current char at 'a' we update the current node with the node in 'a' index
                //so when going for the next char we user the node at 'a' as our root

                currentNode = currentNode.charArray[getCharIndex(word[i])]!!
            } else
                return false
        }
        return true
    }

}
