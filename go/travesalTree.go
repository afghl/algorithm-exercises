package main

import (
	"fmt"
	"golang.org/x/tour/tree"
)


// Walk walks the tree t sending all values
// from the tree to the channel ch.
func Walk(t *tree.Tree, ch chan int) {
	walkRecur(t, ch)
	close(ch)
}

func walkRecur(t *tree.Tree, ch chan int) {
	if t == nil {
		return
	}
	walkRecur(t.Left, ch)
	ch <- t.Value
	walkRecur(t.Right, ch)
}

// Same determines whether the trees
// t1 and t2 contain the same values.
func Same(t1, t2 *tree.Tree) bool {
	ch1, ch2 := make(chan int), make(chan int)
	go Walk(t1, ch1)
	go Walk(t2, ch2)

	for i := range ch1 {
		i2 := <- ch2
		if i != i2 {
			return false
		}
	}
	return true
}

func main() {
	ch := make(chan int)
	go Walk(tree.New(1), ch)


	//for i := range ch {
	//	fmt.Println(i)
	//}

	//fmt.Println("Should return true:", Same(tree.New(1), tree.New(1)))
	//fmt.Println("Should return false:", Same(tree.New(1), tree.New(2)))
	//var i int64
	//i = 1123123
	fmt.Println(1123123 % 10000)
	fmt.Println(1124123 % 10000)
	fmt.Println(0 % 10000)
	fmt.Println(1 % 10000)
}
