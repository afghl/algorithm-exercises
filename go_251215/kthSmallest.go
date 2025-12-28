package main

import "fmt"

func kthSmallest(root *TreeNode, k int) int {
	// 注意这里是一棵bst
	var inorder func(*TreeNode)
	cnt := 0
	res := -1
	inorder = func(n *TreeNode) {
		if n == nil {
			return
		}
		if cnt > k {
			return
		}
		inorder(n.Left)
		cnt = cnt + 1
		if cnt == k {
			res = n.Val
		}
		fmt.Printf("n.val: %v, k: %v, cnt: %v\n", n.Val, k, cnt)
		inorder(n.Right)
	}
	return res
}
