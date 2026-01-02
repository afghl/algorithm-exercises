package main

import (
	"fmt"
	"sort"
)

func hIndex(citations []int) int {
	// sort之后 ->0,1,3,5,6, 如果0,1,4,5,6呢？  h还是3
	sort.Ints(citations)
	reverse(citations)
	fmt.Printf("ci: %v\n", citations)
	h := -1
	for i, citation := range citations {
		if citation >= i+1 {
			h = i + 1
		} else {
			break
		}
	}
	return h
}

func reverse(arr []int) {
	if len(arr) == 0 {
		return
	}
	for i, j := 0, len(arr)-1; i < j; {
		arr[i], arr[j] = arr[j], arr[i]
		i++
		j--
	}
}
