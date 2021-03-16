package com.company

fun main() {
    val univalTree = UnivalTree(0
            , UnivalTree(1, null, null)
            , UnivalTree(0, UnivalTree(1, UnivalTree(1, null, null), UnivalTree(1, null, null)), UnivalTree(0, null, null)))
    print(countUnivalTress(univalTree))
}

data class UnivalTree(val value: Int, val left: UnivalTree? = null, val right: UnivalTree? = null)

/*
   0
  / \
 1   0
    / \
   1   0
  / \
 1   1

 */
fun countUnivalTress(tree: UnivalTree?): Int {
    var counter = 0
    if (tree == null) {
        return 0
    } else if (tree.left == tree.right || (tree.left?.value == tree.right?.value)) {
        counter += 1
    }
    counter += countUnivalTress(tree.left) + countUnivalTress(tree.right)
    return counter
}