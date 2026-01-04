package main

import "strings"

func reverseWords(s string) string {
	start := -1
	end := -1
	recording := false
	arr := []byte(s)
	ans := make([]string, 0)
	for i := 0; i < len(s); i++ {
		c := arr[i]
		if !recording {
			if c == ' ' {
				continue
			} else {
				recording = true
				start = i
				end = i
				continue
			}
		} else {
			if c == ' ' {
				ans = append(ans, collect(arr, start, end))
				recording = false
			} else {
				end = i
			}
		}
	}
	if recording {
		ans = append(ans, collect(arr, start, end))
	}
	reverseStringArr(ans)
	return strings.Join(ans, " ")
}

func reverseStringArr(arr []string) {
	if len(arr) == 0 {
		return
	}
	for i, j := 0, len(arr)-1; i < j; {
		arr[i], arr[j] = arr[j], arr[i]
		i++
		j--
	}
}

func collect(s []byte, l, r int) string {
	ans := []byte{}
	for i := l; i <= r; i++ {
		ans = append(ans, s[i])
	}
	return string(ans)
}
