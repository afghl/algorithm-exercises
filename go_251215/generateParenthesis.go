package main

func generateParenthesis(n int) []string {
	ans := make([]string, 0)
	path := make([]byte, 0)
	var dfs func(l, r int)
	dfs = func(l, r int) {
		if len(path) == 2*n {
			ans = append(ans, string(path))
			return
		}
		// l: 已用 '(' 数量，r: 已用 ')' 数量
		if l < n {
			path = append(path, '(')
			dfs(l+1, r)
			path = path[:len(path)-1]
		}
		if r < l {
			path = append(path, ')')
			dfs(l, r+1)
			path = path[:len(path)-1]
		}
	}

	dfs(0, 0)
	return ans
}
