package main

func isSubsequence(s string, t string) bool {
	last := -1
	for i := 0; i < len(s); i++ {
		cS := s[i]
		found := false
		for j := last + 1; j < len(t); j++ {
			cT := t[j]
			if cT == cS {
				last = j
				found = true
				break
			}
		}
		if !found {
			return false
		}
	}
	return true
}
