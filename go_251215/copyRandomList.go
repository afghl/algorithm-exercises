package main

type Node struct {
	Val    int
	Next   *Node
	Random *Node
}

func copyRandomList(head *Node) *Node {
	// 这里最直接的方法应该是用一个map，构造完新的list之后，再匹配random指针
	res := &Node{}
	m := make(map[*Node]*Node, 0)
	prev := res
	for curr := head; curr != nil; {
		newNode := &Node{Val: curr.Val}
		m[curr] = newNode
		prev.Next = newNode
		curr = curr.Next
		prev = prev.Next
	}
	// 复制random指针
	curr1, curr2 := head, res.Next
	for curr1 != nil && curr2 != nil {
		rand := curr1.Random
		curr2.Random = m[rand]
		curr1 = curr1.Next
		curr2 = curr2.Next
	}
	return res.Next
}
