package main

func flatten(root *TreeNode) {
	nodes := preorderTree(root)
	for i, n := range nodes {
		if i == len(nodes)-1 {
			break
		}
		// 移除left指针，然后将right指针指向下一个
		n.Left = nil
		n.Right = nodes[i+1]
	}

}

func preorderTree(root *TreeNode) []*TreeNode {
	list := []*TreeNode{}
	if root != nil {
		list = append(list, root)
		list = append(list, preorderTree(root.Left)...)
		list = append(list, preorderTree(root.Right)...)
	}
	return list
}
