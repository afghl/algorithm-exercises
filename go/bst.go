package main

import "fmt"

type Node struct {
	Val   int
	Left  *Node
	Right *Node
}

type visit func(n *Node)

type TravelTree interface {
	Inorder(f visit)
	Preorder(f visit)
}

type BST struct {
	head *Node
}

func (t *BST) Inorder(f visit) {
	node := t.head

	visitNode(node, f)
}

func visitNode(node *Node, f visit) {
	if node == nil {
		return
	}
	visitNode(node.Left, f)
	f(node)
	visitNode(node.Right, f)
}

func (t *BST) Preorder(f visit) {
	panic("implement me")
}

func NewBST(val int) *BST {
	return &BST{head: &Node{Val: val}}
}

func (t *BST) Insert(val int) {
	t.head.insert(val)
}

func (n *Node) insert(val int) {
	if val <= n.Val {
		if n.Left == nil {
			n.Left = &Node{Val: val}
		} else {
			n.Left.insert(val)
		}
	} else {
		if n.Right == nil {
			n.Right = &Node{Val: val}
		} else {
			n.Right.insert(val)
		}
	}
}

func main() {
	bst := NewBST(10)
	fmt.Println(bst)
	bst.Insert(5)
	bst.Insert(6)
	bst.Insert(15)
	bst.Insert(16)
	bst.Insert(20)
	bst.Insert(3)
	bst.Inorder(func(n *Node) {
		fmt.Println(n.Val)
	})
}
