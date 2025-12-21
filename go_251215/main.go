package main

import "fmt"

func main() {
	arr := []int{0, 1, 2, 2, 3, 0, 4, 2}
	ans := removeElement(arr, 2)
	fmt.Printf("arr: %+v, ans: %v \n", arr, ans)
}
