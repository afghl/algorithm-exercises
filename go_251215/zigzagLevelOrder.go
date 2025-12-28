package main

type levelTreeNode struct {
	n     *TreeNode
	level int
}

func zigzagLevelOrder(root *TreeNode) [][]int {
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
	for i, arr := range res {
		if i%2 == 1 {
			r(arr)
		}
	}

	return res
}

func r(arr []int) {
	n := len(arr)
	for i := 0; i < n/2; i++ {
		arr[i], arr[n-1-i] = arr[n-1-i], arr[i]
	}
}
