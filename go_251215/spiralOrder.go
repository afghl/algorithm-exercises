package main

func spiralOrder(matrix [][]int) []int {
	// bounds
	u, d, l, r := 0, len(matrix), 0, len(matrix[0])
	res := []int{}
	direction := "right"
	for u < d && l < r {
		switch direction {
		case "right":
			for i := l; i < r; i++ {
				res = append(res, matrix[u][i])
			}
			u++
			direction = "down"
		case "down":
			for i := u; i < d; i++ {
				res = append(res, matrix[i][r-1])
			}
			r--
			direction = "left"
		case "left":
			for i := r - 1; i >= l; i-- {
				res = append(res, matrix[d-1][i])
			}
			d--
			direction = "up"
		case "up":
			for i := d - 1; i >= u; i-- {
				res = append(res, matrix[i][l])
			}
			l++
			direction = "right"
		}
	}
	return res
}
