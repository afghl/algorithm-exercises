package main

func sortedArrayToBST(nums []int) *TreeNode {
	return recursiveSorted(nums, 0, len(nums))
}

func recursiveSorted(nums []int, l, r int) *TreeNode {
	if l >= r {
		return nil
	}
	m := (l + r) / 2
	n := &TreeNode{
		Val:   nums[m],
		Left:  recursiveSorted(nums, l, m),
		Right: recursiveSorted(nums, m+1, r),
	}
	return n
}
