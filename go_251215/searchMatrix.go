package main

// searchMatrix
func searchMatrix(matrix [][]int, target int) bool {
	// 一次二分查找
	if len(matrix) == 0 {
		return false
	}
	n, m := len(matrix), len(matrix[0])
	l, r := 0, n*m-1
	for l <= r {
		mid := (l + r) / 2

		row, col := mid/m, mid%m
		if v := matrix[row][col]; v == target {
			return true
		} else if v > target {
			r = mid - 1
		} else {
			l = mid + 1
		}
	}
	return false
}

func searchMatrixDummy(matrix [][]int, target int) bool {
	// 这个好像挺简单吖..先定位行，再定位列.
	for i := 0; i < len(matrix); i++ {
		row := matrix[i]
		if row[len(row)-1] < target {
			continue
		}
		for j := 0; j < len(row); j++ {
			if row[j] == target {
				return true
			}
		}
	}
	return false
}
