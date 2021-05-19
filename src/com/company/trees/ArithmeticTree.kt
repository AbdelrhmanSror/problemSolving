package com.company.trees

fun main() {
    val plus = TreeNode<Any>('+', TreeNode(3, null, null), TreeNode(2, null, null))
    val plus2 = TreeNode<Any>('+', TreeNode(4, null, null), TreeNode(5, null, null))
    val mul = TreeNode('*', plus, plus2)
    print(getResult(mul))
}

//return the result of Arithmetic Operation inorder Evaluation
/*
         *
    +           +
  3  2        4   5
 */
fun getResult(node: TreeNode<Any>?): Int? {
    if (node == null)
        return null
    if (node.left == null && node.right == null)
        return node.value.toString().toInt()
    val left = getResult(node.left)
    val right = getResult(node.right)
    return left?.operate(right, node.value.toString()[0])


}

fun Int?.operate(number: Int?, arithmeticOp: Char): Int? {
    if (this == null || number == null) return null
    return when (arithmeticOp) {
        '*' -> this * number
        '-' -> this - number
        '+' -> this + number
        '/' -> this / number
        else -> null
    }
}