package com.company.trees

//construction of tree using inorder and preorder traversal

fun main() {
    val root = construct(arrayOf('a', 'b', 'd', 'e', 'c', 'f', 'g'), arrayOf('d', 'b', 'e', 'a', 'f', 'c', 'g'))
    print(root)

}

fun construct(preorder: Array<Char>?, inorder: Array<Char>?): TreeNode<Char>? {
    if (preorder == null || inorder == null)
        return null
    //if the two array are with size of 1 return the element of the array
    if (inorder.size == 1 && preorder.size == 1)
        return TreeNode(preorder[0], null, null)
    //in the preorder the first element is the first element
    val root = TreeNode(preorder[0], null, null)
    //getting the index of root in inorder array ,will  use it as indication of ending point for new range of preorder and inorder in the left side,
    //and indication as start point of the right side to the end
    val root_index = inorder.indexOf(root.value)
    root.left = construct(preorder.copyOfRange(1, root_index + 1), inorder.copyOfRange(0, root_index))
    root.right = construct(preorder.copyOfRange(root_index + 1, preorder.size), inorder.copyOfRange(root_index + 1, inorder.size))
    return root


}