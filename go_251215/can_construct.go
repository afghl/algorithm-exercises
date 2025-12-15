package main

func canConstruct(ransomNote string, magazine string) bool {
	m := make(map[rune]int)
	for _, c := range magazine {
		m[c] = m[c] + 1
	}
	for _, r := range ransomNote {
		m[r] = m[r] - 1
		if m[r] < 0 {
			return false
		}
	}
	return true
}
