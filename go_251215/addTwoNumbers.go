package main

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	res := &ListNode{}
	curr := res
	carry := 0
	for l1 != nil || l2 != nil || carry > 0 {
		digit := carry
		if l1 != nil {
			digit += l1.Val
		}
		if l2 != nil {
			digit += l2.Val
		}
		if digit >= 10 {
			digit = digit % 10
			carry = 1
		} else {
			carry = 0
		}
		curr.Next = &ListNode{Val: digit}
		curr = curr.Next
		if l1 != nil {
			l1 = l1.Next
		}
		if l2 != nil {
			l2 = l2.Next
		}
	}
	return res.Next
}
