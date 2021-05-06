package main

import (
	"fmt"
	"time"
)

func main() {
	c := make(chan int)

	go func() {
		c <-1
		fmt.Println("c <-1")
	}()

	time.Sleep(1 * time.Second)
}
