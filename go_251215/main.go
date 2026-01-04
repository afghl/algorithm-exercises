package main

import "fmt"

func main() {
	// l := 4,2,1,3

	// sortList(getList([]int{4, 2, 1, 3}))
	// jump([]int{1, 2})
	// combine(4, 2)
	// hIndex([]int{0, 1, 3, 5, 6})
	fmt.Printf("ans: %v\n", reverseWords("the sky is blue"))
}
func getList(arr []int) *ListNode {
	head := &ListNode{}
	prev := head

	for _, v := range arr {
		prev.Next = &ListNode{Val: v}
		prev = prev.Next
	}
	return head.Next
}
