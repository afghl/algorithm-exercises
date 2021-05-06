package main

import (
	"fmt"
)
func fibonacci(c, quit, r chan int) {
	x, y := 0, 1
	for {

		// wait on multiple channel
		select {
		// 这里的意思是这fib的方法是从c这个chan里取数，只要被feed了，就计算x,y，并保存在这个方法的栈里。
		case c <- x:
			x, y = y, x+y
			r <- y
		case <-quit:
			fmt.Println("quit")
			return
		}
	}
}

func main() {
	c := make(chan int)
	quit := make(chan int)
	receive := make(chan int)
	go func() {
		// 这里是不停的（10次）从c这个chan里取数据
		for i := 0; i < 20; i++ {
			<-c
		}
		// 搞定了，这个quit的chan相当于一个锁，用来做goroutine的同步的
		quit <- 0
	}()

	go func() {
		r := 0
		for {
			select {
			case r = <-receive:
				fmt.Println(r)
			}
		}
	}()
	fibonacci(c, quit, receive)
}
