package main

import "fmt"

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func sumNumbers(root *TreeNode) int {
	if root == nil {
		return 0
	}
	ans := 0
	var sumNumbersRecursive func(*TreeNode, int)
	sumNumbersRecursive = func(n *TreeNode, pathSum int) {
		if n == nil {
			return
		}
		if n.Left == nil && n.Right == nil {
			ans += pathSum*10 + n.Val
		}
		fmt.Printf("n.va:%v, ans: %v,\n", n.Val, ans)

		sumNumbersRecursive(n.Left, pathSum*10+n.Val)
		sumNumbersRecursive(n.Right, pathSum*10+n.Val)
	}
	sumNumbersRecursive(root, 0)

	return ans
}
