package main

import (
	"strings"
)

func wordPattern(pattern string, s string) bool {
	words := strings.Split(s, " ")
	if len(words) != len(pattern) {
		return false
	}
	c2w := make(map[rune]string)
	w2c := make(map[string]rune)
	for i, c := range pattern {
		if targetWord, ok := c2w[c]; ok {
			if targetWord != words[i] {
				return false
			}
		} else {
			c2w[c] = words[i]
		}
		word := words[i]
		if targetC, ok := w2c[word]; ok {
			if c != targetC {
				return false
			}
		} else {
			w2c[word] = c
		}
	}
	return true
}
