package main

import (
	"fmt"
)

func main() {
	c1, c2 := make(chan int, 1), make(chan int, 1)
	fin := make(chan bool)
	c1 <- 1

	go func() {
		for i := 1; i <= 100; i = i + 2 {
			<-c1 // wait c1
			fmt.Println("a", i)
			c2 <- 1 // notify c2
		}
	}()

	go func() {
		for i := 2; i <= 100; i = i + 2 {
			<-c2 // wait c2
			fmt.Println("b", i)
			c1 <- 1 // notify c1
		}
		fin <- true
	}()

	<- fin
}
