package com.company

//A unival tree is a tree where all nodes under it have the same value.
//given the root to binary tree,count the number of unival subtrees.


fun main() {
    val node1 = TreeNode('a')
    val node2 = TreeNode('b')
    val root = TreeNode('a', node1, TreeNode('a', node1, TreeNode('a', null, node1)))
    print(countUnivalTree(root))

}

data class TreeNode(val value: Any, var left: TreeNode? = null, var right: TreeNode? = null)

//o(n) time
fun countUnivalTree(root: TreeNode?): Pair<Int, Boolean> {
    if (root == null)
        return 0 to true
    //counter of unival tree
    //left count represents the count of left unival tree
    //right count represents the count of right unival tree
    //left represents if the left tree is unival or not
    //right represents if the right tree is unival or not
    var counter = 0
    val (leftCount, left) = countUnivalTree(root.left)
    val (rightCount, rigth) = countUnivalTree(root.right)
    counter = leftCount + rightCount
    if (left and rigth) {
        if (root.left != null && root.value != root.left!!.value || root.right != null && root.value != root.right!!.value)
            return counter to false
        return counter + 1 to true
    }
    return counter to false


}