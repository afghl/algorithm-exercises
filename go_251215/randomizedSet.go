package main

import "math/rand"

type RandomizedSet struct {
	data map[int]int
	// 这里重点是 random怎么实现。
	arr []int
}

func Constructor() RandomizedSet {
	return RandomizedSet{data: make(map[int]int), arr: make([]int, 0)}
}

func (s *RandomizedSet) Insert(val int) bool {
	if _, ok := s.data[val]; ok {
		return false
	} else {
		s.arr = append(s.arr, val)
		s.data[val] = len(s.arr) - 1
		return true
	}
}

func (s *RandomizedSet) Remove(val int) bool {
	if i, ok := s.data[val]; ok {
		// 换下位置
		last := s.arr[len(s.arr)-1]
		s.data[last] = i
		s.arr[i] = last
		s.arr = s.arr[:len(s.arr)-1]
		delete(s.data, val)
		return true
	} else {
		return false
	}
}

func (s *RandomizedSet) GetRandom() int {
	return s.arr[rand.Intn(len(s.arr))]
}
