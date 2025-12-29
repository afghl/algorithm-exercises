package main

func setZeroes(matrix [][]int) {
	if len(matrix) == 0 || len(matrix[0]) == 0 {
		return
	}
	row, col := len(matrix), len(matrix[0])
	// 先找0所在的行列..
	zerosIndex := make([][]int, 0)
	for i := 0; i < row; i++ {
		for j := 0; j < col; j++ {
			if matrix[i][j] == 0 {
				zerosIndex = append(zerosIndex, []int{i, j})
			}
		}
	}
	zeroRows := make([]bool, row)
	zeroCols := make([]bool, col)
	// 清空...
	for _, idx := range zerosIndex {
		// pending
		i, j := idx[0], idx[1]
		zeroRows[i] = true
		zeroCols[j] = true
	}

	// 就可以清空了
	for i := 0; i < row; i++ {
		for j := 0; j < col; j++ {
			if zeroRows[i] || zeroCols[j] {
				matrix[i][j] = 0
			}
		}
	}
}
