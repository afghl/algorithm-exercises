package main

// 这个算法简单点，每次迭代就是返回包含p或q的子树的root节点
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	if root == nil || p == nil || q == nil {
		return nil
	}
	if root == q || root == p { // 如果递归的找到了p或q本身，那就返回这个节点
		return root
	}
	// 在左子树里寻找p和q的公共祖先
	left := lowestCommonAncestor(root.Left, p, q)
	right := lowestCommonAncestor(root.Right, p, q)
	if left != nil && right != nil {
		return root
	} else if left == nil {
		return right
	} else {
		return left
	}
}

func lowestCommonAncestorComplex(root, p, q *TreeNode) *TreeNode {
	var ans *TreeNode
	setAns := func(n *TreeNode) {
		if ans != nil {
			ans = n
		}
	}
	var recursive func(root, p, q *TreeNode) (bool, bool)
	recursive = func(n, p, q *TreeNode) (bool, bool) {
		if n == nil {
			return false, false
		}
		leftContainP, leftContainQ := recursive(n.Left, p, q)
		rightContainP, rightContainQ := recursive(n.Right, p, q)
		if (leftContainP && rightContainQ) || (leftContainQ && rightContainP) {
			setAns(n)
		}
		if n == p {
			if leftContainQ || rightContainQ {
				setAns(n)
			}
		}
		if n == q {
			if leftContainP || rightContainP {
				setAns(n)
			}
		}
		return n == p || leftContainP || rightContainP, n == q || leftContainQ || rightContainQ
	}
	recursive(root, p, q)
	return ans
}
