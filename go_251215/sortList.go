package main

import "fmt"

func sortList(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}
	return sortListPartition(head)
}

func sortListPartition(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	// find middle
	var firstPartTail *ListNode
	slow, fast := head, head
	for fast != nil {
		if fast.Next != nil {
			fast = fast.Next.Next
		} else {
			fast = fast.Next
		}
		if firstPartTail == nil {
			firstPartTail = slow
		} else {
			firstPartTail = firstPartTail.Next
		}

		slow = slow.Next
	}
	firstPartTail.Next = nil

	l := sortListPartition(head)
	r := sortListPartition(slow)
	fmt.Printf("l: %v, r: %v\n", l, r)
	res := &ListNode{}
	prev := res
	for l != nil || r != nil {
		if l == nil {
			prev.Next = r
			r = r.Next
		} else if r == nil {
			prev.Next = l
			l = l.Next
		} else if l.Val < r.Val {
			prev.Next = l
			l = l.Next
		} else {
			prev.Next = r
			r = r.Next
		}
		prev = prev.Next
	}
	return res.Next
}
