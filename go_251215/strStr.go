package main

func strStr(haystack string, needle string) int {
	for i := 0; i < len(haystack); i++ {
		contain := true
		k, j := i, 0
		for k < len(haystack) && j < len(needle) {
			if haystack[k] != needle[j] {
				contain = false
				break
			}
			k++
			j++
		}
		if contain && j == len(needle) {
			return i
		}
	}
	return -1
}
