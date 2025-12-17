package main

func lengthOfLastWord(s string) int {
	if len(s) == 0 {
		return 0
	}
	start := false
	length := 0
	for i := len(s) - 1; i >= 0; i-- {
		c := s[i]
		if c != ' ' && start {
			length++
		} else if c != ' ' && !start {
			length++
			start = true
		} else if c == ' ' && start {
			break
		}
	}
	return length
}
