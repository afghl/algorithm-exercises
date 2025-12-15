package main

func isAnagram(s string, t string) bool {
	m := make(map[byte]int, 0)
	for i := 0; i < len(s); i++ {
		c := s[i]
		if cnt, ok := m[c]; ok {
			m[c] = cnt + 1
		} else {
			m[c] = 1
		}
	}
	for i := 0; i < len(t); i++ {
		c := t[i]
		if cnt, ok := m[c]; ok {
			m[c] = cnt - 1
		} else {
			return false
		}
		if m[c] == 0 {
			delete(m, c)
		}
	}
	return len(m) == 0
}

func isAnagram2(s, t string) bool {
	var c1, c2 [26]int
	for _, ch := range s {
		c1[ch-'a']++
	}
	for _, ch := range t {
		c2[ch-'a']++
	}
	return c1 == c2
}
