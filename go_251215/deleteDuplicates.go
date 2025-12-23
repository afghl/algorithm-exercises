package main

func deleteDuplicates(head *ListNode) *ListNode {
	res := &ListNode{Next: head}
	prev, curr := res, head
	// 这里的意思是， 不是简单去重，而是把出现重复的元素也删除掉
	for curr != nil {
		currIsDup := false
		lastDup := curr.Next
		for lastDup != nil {
			if curr.Val == lastDup.Val {
				currIsDup = true
				lastDup = lastDup.Next
			} else {
				break
			}
		}
		if currIsDup {
			curr = lastDup
			prev.Next = curr
		} else {
			prev = curr
			curr = curr.Next
		}
	}
	return res.Next
}
