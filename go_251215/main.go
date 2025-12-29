package main

func main() {
	// l := 4,2,1,3

	sortList(getList([]int{4, 2, 1, 3}))
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
