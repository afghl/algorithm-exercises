package main

// 哈希表解法
func hasCycleHashMap(head *ListNode) bool {
	m := make(map[*ListNode]bool)
	curr := head
	for curr != nil {
		if m[curr] {
			return true
		} else {
			m[curr] = true
			curr = curr.Next
		}
	}
	return false
}

func hasCycle(head *ListNode) bool {
	if head == nil || head.Next == nil {
		return false
	}
	fast, slow := head.Next, head
	for fast != nil {
		if fast == slow {
			return true
		}
		slow = slow.Next
		if fast.Next != nil {
			fast = fast.Next.Next
		} else {
			fast = nil
		}
	}
	return false
}
