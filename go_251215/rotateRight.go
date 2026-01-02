package main

func rotateRight(head *ListNode, k int) *ListNode {
	if head == nil {
		return nil
	}
	// 先成环，再在合适的地方切断
	length := 1
	curr := head
	for curr.Next != nil {
		length += 1
		curr = curr.Next
	}
	curr.Next = head
	i := length - (k % length)
	curr, next := head, head.Next
	for i > 1 {
		i--
		curr = curr.Next
		next = next.Next
	}
	curr.Next = nil
	return next
}
