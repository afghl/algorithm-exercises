package main

func isIsomorphic(s, t string) bool {
	if len(s) != len(t) {
		return false
	}
	st := make(map[byte]byte)
	ts := make(map[byte]byte)

	for i := 0; i < len(s); i++ {
		a, b := s[i], t[i]

		if v, ok := st[a]; ok && v != b {
			return false
		}
		if v, ok := ts[b]; ok && v != a {
			return false
		}

		st[a] = b
		ts[b] = a
	}
	return true
}
