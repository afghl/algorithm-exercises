package main

func isValid(s string) bool {
	pairs := map[rune]rune{
		')': '(',
		']': '[',
		'}': '{',
	}
	stack := []rune{}
	for _, c := range s {
		if right, ok := pairs[c]; ok {
			if len(stack) == 0 || stack[len(stack)-1] != right {
				return false
			}
			stack = stack[:len(stack)-1]
		} else {
			stack = append(stack, c)
		}

	}
	return len(stack) == 0
}
