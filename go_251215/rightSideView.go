package main

func rightSideView(root *TreeNode) []int {
	ans := make([]int, 0)
	var dfs func(n *TreeNode, level int)

	dfs = func(n *TreeNode, level int) {
		if n == nil {
			return
		}
		if len(ans) < level {
			ans = append(ans, n.Val)
		} else {
			ans[level-1] = n.Val
		}
		dfs(n.Left, level+1)
		dfs(n.Right, level+1)
	}
	dfs(root, 1)
	return ans
}
