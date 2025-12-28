package main

// type levelTreeNode struct {
// 	n     *TreeNode
// 	level int
// }

func levelOrder(root *TreeNode) [][]int {
	if root == nil {
		return nil
	}
	res := make([][]int, 0)
	res = append(res, []int{})
	queue := []*levelTreeNode{{n: root, level: 0}}
	for len(queue) > 0 {
		n := queue[0]
		i := n.level
		// 先不用分层，就直接的层序遍历
		if len(res) < i+1 {
			res = append(res, []int{})
		}
		res[i] = append(res[i], n.n.Val)
		if n.n.Left != nil {
			queue = append(queue, &levelTreeNode{n: n.n.Left, level: n.level + 1})
		}
		if n.n.Right != nil {
			queue = append(queue, &levelTreeNode{n: n.n.Right, level: n.level + 1})
		}
		queue = queue[1:]
	}
	return res
}
