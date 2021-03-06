package com.company.trees


fun main() {
    val binarySearchTree = BinarySearchTree()
    /* binarySearchTree.insert(8)
     binarySearchTree.insert(12)
     binarySearchTree.insert(4)
     binarySearchTree.insert(10)
     binarySearchTree.insert(14)
     binarySearchTree.insert(2)
     binarySearchTree.insert(6)

     print(binarySearchTree.ceil(6))*/
    val array = arrayOf(1, 2, 3)
    binarySearchTree.constructAllPossibilities(array).forEach {
        println(it)
    }


}
//floor means highest element which is less than or equal to an integer

//ceil means lowes element which is grater than or equal to an integer

class BinarySearchTree() {
    private var root: TreeNode<Int>? = null

    fun insert(value: Int) {
        if (root == null)
            root = TreeNode(value)
        else
            insert(value, root!!)

    }

    fun find(value: Int): Int? {
        return if (root == null)
            null
        else
            find(value, root!!)
    }

    private fun insert(value: Int, root: TreeNode<Int>) {
        if (value > root.value && root.right == null) {
            root.right = TreeNode(value)
            return
        } else if (value < root.value && root.left == null) {
            root.left = TreeNode(value)
            return
        } else {
            if (value > root.value)
                insert(value, root.right!!)
            else {
                insert(value, root.left!!)

            }
        }
    }

    private fun find(value: Int, root: TreeNode<Int>): Int? {
        if (value == root.value)
            return value
        if (value > root.value && root.right == null || value < root.value && root.left == null) {
            return null
        }
        return if (value > root.value)
            find(value, root.right!!)
        else {
            find(value, root.left!!)

        }

    }

    fun floor(value: Int): Int? {
        return if (root == null) null
        else {
            floor(value, null, root!!)
        }
    }

    fun ceil(value: Int): Int? {
        return if (root == null) null
        else {
            ceil(value, null, root!!)
        }
    }

    //find the greatest element in the tree which is lower or equal than current element.
    private fun floor(value: Int, currentMinValue: Int?, root: TreeNode<Int>): Int? {
        return when {
            //if the current value is less than the desired value and there is no way to get value greater than the current value return the current value else go for the next greater value
            //if the current value is greater than the desired value and there is no way to get value less than the current value return the currentMinvalue else go for the next smaller value
            root.value < value -> {
                if (root.right == null)
                    root.value
                else
                    floor(value, root.value, root.right!!)
            }
            root.value > value -> {
                if (root.left == null)
                    currentMinValue
                else
                    floor(value, currentMinValue, root.left!!)
            }
            else -> value
        }


    }

    //find the lowest element in tree which is greater than the desired element
    private fun ceil(value: Int, currentMaxValue: Int?, root: TreeNode<Int>): Int? {
        return when {
            root.value < value -> {
                if (root.right == null)
                    currentMaxValue
                else
                    ceil(value, currentMaxValue, root.right!!)
            }
            root.value > value -> {
                if (root.left == null)
                    root.value
                else
                    ceil(value, root.value, root.left!!)
            }
            else -> value
        }


    }

    //construction of all possible binary search tree with n nodes where all values from [1..n] are used .
    // O(N*2^N) TIME AS WELL AS SPACE
    fun constructAllPossibilities(data: Array<Int>): ArrayList<TreeNode<Int>> {
        return construct(low = 0, high = data.size - 1, data = data)
    }

    private fun construct(low: Int, high: Int, data: Array<Int>): ArrayList<TreeNode<Int>> {
        //tree than contain list of all possible tree
        val trees = ArrayList<TreeNode<Int>>()
        if (low > high) {
            //an equivalent to none node
            trees.add(TreeNode(-1, null, null))
            return trees
        }
        //looping over all values in array and each time making new root to start from and construct our tree
        for (i in low..high) {
            val left = construct(low, i - 1, data)
            val right = construct(i + 1, high, data)

            //looping over all left tree nodes and assigning it with each node existing in the right
            for (l in left) {
                for (r in right) {
                    val node = TreeNode<Int>(data[i], l, r)
                    trees.add(node)
                }
            }

        }
        //return the result
        return trees

    }
}