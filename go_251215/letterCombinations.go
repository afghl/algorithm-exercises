package main

func letterCombinations(digits string) []string {
	var phoneMap = map[byte]string{
		'2': "abc",
		'3': "def",
		'4': "ghi",
		'5': "jkl",
		'6': "mno",
		'7': "pqrs",
		'8': "tuv",
		'9': "wxyz",
	}
	ans := make([]string, 0)
	var backtracing func(i int, prev []string)
	backtracing = func(i int, prev []string) {
		if i >= len(digits) {
			ans = append(ans, prev...)
			return
		}
		digit := digits[i]
		records := make([]string, 0, len(prev)*len(phoneMap[digit]))
		letters := phoneMap[digit]
		for _, l := range letters {
			for _, pre := range prev {
				records = append(records, pre+string(l))
			}
		}
		backtracing(i+1, records)
	}
	backtracing(0, []string{""})
	return ans
}
