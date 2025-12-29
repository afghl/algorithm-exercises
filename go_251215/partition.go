package main

func partition(head *ListNode, x int) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	head = &ListNode{Next: head}
	ans := &ListNode{}
	ansPrev := ans
	prev, curr := head, head.Next
	for curr != nil {
		if curr.Val < x {
			prev.Next = curr.Next
			ansPrev.Next = curr
			curr = curr.Next
		} else {
			curr = curr.Next
			prev = prev.Next
		}
	}
	// 遍历完后
	ansPrev.Next = head.Next
	return ans.Next
}
