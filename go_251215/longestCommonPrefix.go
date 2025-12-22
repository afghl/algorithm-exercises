package main

func longestCommonPrefix(strs []string) string {
	if len(strs) == 0 {

		return ""
	}
	n := len(strs[0])
	ans := ""
	for i := 0; i < n; i++ {
		same := true
		for j := 1; j < len(strs); j++ {
			str := strs[j]
			if len(str) < i+1 || str[i] != strs[0][i] {
				same = false
				break
			}
		}
		if same {
			ans += string(strs[0][i])
		} else {
			break
		}
	}
	return ans
}
