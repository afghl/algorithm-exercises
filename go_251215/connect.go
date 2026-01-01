package main

type Node struct {
	Val   int
	Left  *Node
	Right *Node
	Next  *Node
}

func connect(root *Node) *Node {
	// 层序遍历
	if root == nil {
		return nil
	}
	queue := []*Node{root}
	for len(queue) > 0 {
		// 将这一层全部出队
		allNode := queue
		queue = []*Node{}
		for i, node := range allNode {
			if i > 0 {
				allNode[i-1].Next = node
			}
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}
	}
	return root
}
