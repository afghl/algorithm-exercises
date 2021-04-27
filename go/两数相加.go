package main

//给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
//请你将两个数相加，并以相同形式返回一个表示和的链表。
//
//你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	// 进位
	add := 0

	res := &ListNode{Val: -1}
	r := res

	for l1 != nil || l2 != nil || add > 0 {
		sum := getSum(l1, l2, add)

		if sum >= 20 {
			add = 2
			sum = sum - 20
		} else if sum >= 10 {
			add = 1
			sum = sum - 10
		} else {
			add = 0
		}

		r.Next = &ListNode{Val: sum}
		r = r.Next

		if l1 != nil { l1 = l1.Next }
		if l2 != nil { l2 = l2.Next }
	}

	return res.Next
}

func getSum(l1 *ListNode, l2 *ListNode, add int) int {
	if l1 != nil && l2 != nil {
		return l1.Val + l2.Val + add
	} else if l1 != nil {
		return l1.Val + add
	} else if l2 != nil {
		return l2.Val + add
	} else {
		return add
	}
}
