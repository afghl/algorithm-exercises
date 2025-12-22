package main

func romanToInt(s string) int {
	special := map[string]int{"IV": 4, "IX": 9, "XL": 40, "XC": 90, "CD": 400, "CM": 900}
	normal := map[string]int{"I": 1,
		"V": 5,
		"X": 10,
		"L": 50,
		"C": 100,
		"D": 500,
		"M": 1000}
	ans := 0
	i := 0
	if len(s) < 2 {
		return normal[s]
	}
	for i < len(s)-1 {
		if val, ok := special[s[i:i+2]]; ok {
			ans += val
			i += 2
		} else {
			ans += normal[s[i:i+1]]
			i += 1
		}
	}
	if i < len(s) {
		ans += normal[s[len(s)-1:]]
	}
	return ans
}
