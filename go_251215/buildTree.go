package main

// 中序和后序，还原树
func buildTree(inorder []int, postorder []int) *TreeNode {
	if len(postorder) == 0 {
		return nil
	}
	head := &TreeNode{Val: postorder[len(postorder)-1]}
	if len(postorder) == 1 {
		return head
	}
	i := 0
	for ; i < len(inorder); i++ {
		if inorder[i] == head.Val {
			break
		}
	}
	head.Left = buildTree(inorder[0:i], postorder[0:i])
	head.Right = buildTree(inorder[i+1:], postorder[i:len(inorder)-1])
	return head
}

// 前序和中序，还原树
func buildTree2(preorder []int, inorder []int) *TreeNode {
	if len(preorder) == 0 {
		return nil
	}
	n := &TreeNode{Val: preorder[0]}
	if len(preorder) == 1 {
		return n
	}
	i := 0
	for ; i < len(inorder); i++ {
		if inorder[i] == preorder[0] {
			break
		}
	}
	// 如果找到左子树在inorder是0..i，那么说明有i-1个左子树节点
	n.Left = buildTree2(preorder[1:i+1], inorder[0:i])
	n.Right = buildTree2(preorder[i+1:], inorder[i+1:])
	return n
}
