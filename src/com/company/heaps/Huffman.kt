package com.company.heaps

import com.company.isNumber
import com.company.trees.TreeNode
import java.util.*
import kotlin.collections.HashMap

//giving a dictionaries of char frequencies ,build a huffman tree ,
// and use it to determine a mapping between character and their encoded binary strings.


fun main() {
    val charFreq = HashMap<String, Int>()
    charFreq["a"] = 3
    charFreq["c"] = 6
    charFreq["e"] = 8
    charFreq["f"] = 2
    print(encodeInHuffman(charFreq))


}

fun encodeInHuffman(freq: HashMap<String, Int>): HashMap<String, String> {
    //constructing min heap using priority queue
    //provide comparator to priority queue to tell it how to sort the the nodes
    val minHeap = PriorityQueue<TreeNode<String>> { n1, n2 ->
        when {
            freq[n1.value]!! < freq[n2.value]!! -> -1
            freq[n1.value]!! > freq[n2.value]!! -> 1
            else -> 0

        }

    }
    accumulateMinHeap(freq, minHeap)
    val parent = constructHuffmanTree(minHeap, freq)
    val encodedChars = HashMap<String, String>()
    encodedCharInBinary(parent, map = encodedChars)
    return encodedChars

}

//accumulating the min heap will take O(nlog(n)) time, because we iterate over the whole set of char frequencies
//which take o(n) where n is the number of char in map
//and then operation of heapfiy down or up takes at most o(log(n))

private fun accumulateMinHeap(freq: HashMap<String, Int>, minHeap: PriorityQueue<TreeNode<String>>) {
    //looping through frequencies of char and put it in min heap
    val iterator = freq.iterator()
    while (iterator.hasNext()) {
        minHeap.add(TreeNode(iterator.next().key))
    }
}

//it takes o(nlog(n)) time for constructing the huffman tree
private fun constructHuffmanTree(minHeap: PriorityQueue<TreeNode<String>>, freq: HashMap<String, Int>): TreeNode<String> {
    var parent: TreeNode<String> = TreeNode("0")
    //if the size of min heap is bigger than 1 then poll the two least values,
    //create a new node with a new value equal to summation of the nodes value
    //add the first node as left node and second node a right
    if (minHeap.size > 1) {
        val node1 = minHeap.poll()
        val node2 = minHeap.poll()
        parent = TreeNode((freq[node2.value]!! + freq[node1.value]!!).toString(), node1, node2)

    }
    //if the min heap is not empty then continue polling from the min heap
    //while doing this continue updating the value of the parent
    //adding the old parent as left node for the new parent whereas the polled node as right
    while (minHeap.isNotEmpty()) {
        val node = minHeap.poll()
        parent = TreeNode((parent.value.toInt() + freq[node.value]!!).toString(), parent, node)
    }
    return parent
}

/**
 * @encodedCharInBinary resposible for accumulating the value of encoded char into a map
 * @node parent node of the huffman tree
 * @binaryString represent the binary code that has been constructed yet for the char
 * @map to accumulate the binary encoding of the char
 * it take log(h) to traverse path to each char in the tree where n is considered the height of current char
 * for string with length m it will take overall m(log n) time
 */
private fun encodedCharInBinary(node: TreeNode<String>?, binaryString: String = "", map: HashMap<String, String>) {
    if (node == null)
        return
    //if the value of the node is char then add the binary code to the map and return
    if (!node.value.isNumber()) {
        map[node.value] = binaryString
        return
    }
    //encode the left subtree with 0 and right with 1
    encodedCharInBinary(node.left, binaryString + "0", map)
    encodedCharInBinary(node.right, binaryString + "1", map)
}