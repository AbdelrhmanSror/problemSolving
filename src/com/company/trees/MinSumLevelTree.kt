package com.company.trees

/**
 * giving a binary tree return the level of the tree that has the minimum sum
 * for example
 *       1
 *    2      3
 *         4    5
 * should return 0 because level 0 has sum of 1
 *
 */
fun main(){
    val two = TreeNode(2, null,null)
    val three = TreeNode(3, TreeNode(4, null, null), TreeNode(5, null, null))
    val one = TreeNode(1, two, three)
    print(getMin(one))
}
fun getMin(node: TreeNode<Int>?): Int {
    val map = HashMap<Int, Int?>()
    getMinLevel(node, 0, map)
    var least: Pair<Int, Int?> = 0 to Int.MAX_VALUE
    map.forEach {
        if (it.value!! < least.second!!)
            least = it.key to it.value
    }
    return least.first
}

/**
 * @node representing the current root of tree
 * @currntLevel representing the current level we currently at
 * @leastLevel representing the map we would accumulate the the values at each level to get the sum of values at the current level
 * @return none
 */
fun getMinLevel(node: TreeNode<Int>?, currentLevel: Int = 0, leastLevel: HashMap<Int, Int?>) {
    if (node == null)
        return
    // level to value pair

    if (leastLevel.containsKey(currentLevel))
        leastLevel[currentLevel] = leastLevel[currentLevel]?.plus(node.value.toString().toInt())
    else
        leastLevel[currentLevel] = node.value.toString().toInt()

    if (node.left == null && node.right == null)
        return
    getMinLevel(node.left, currentLevel + 1, leastLevel)
    getMinLevel(node.right, currentLevel + 1, leastLevel)
    return


}
