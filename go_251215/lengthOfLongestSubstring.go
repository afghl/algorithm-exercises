package main

func lengthOfLongestSubstring(s string) int {
	if len(s) == 0 {
		return 0
	}

	max := func(a, b int) int {
		if a > b {
			return a
		}
		return b
	}
	index := map[byte]int{}

	ans := 0
	start := -1
	for end := 0; end < len(s); end++ {
		c := s[end]
		if i, ok := index[c]; ok {
			start = max(start, i)
		}
		index[c] = end
		ans = max(ans, end-start)
	}
	return ans
}
