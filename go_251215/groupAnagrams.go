package main

func groupAnagrams(strs []string) [][]string {
	res := make(map[[26]int][]string, 0)
	// 字母异位词分组
	key := func(str string) [26]int {
		k := [26]int{}
		for _, b := range str {
			k[b-'a']++
		}
		return k
	}
	// 遍历下所有的str
	for _, str := range strs {
		k := key(str)
		if res[k] != nil {
			res[k] = append(res[k], str)
		} else {
			res[k] = []string{str}
		}
	}
	ans := make([][]string, 0)
	for _, v := range res {
		ans = append(ans, v)
	}
	return ans
}
