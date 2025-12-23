package main

// removeNthFromEnd
func removeNthFromEnd(head *ListNode, n int) *ListNode {
	res := &ListNode{Next: head}
	curr, nthNode, nthNodePrev := head, head, res
	k := 0
	for curr != nil {
		if k < n {
			k++
		} else {
			nthNode = nthNode.Next
			nthNodePrev = nthNodePrev.Next
		}
		curr = curr.Next
	}
	nthNodePrev.Next = nthNode.Next
	return res.Next
}
