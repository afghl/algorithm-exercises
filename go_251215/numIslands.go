package main

func numIslands(grid [][]byte) int {
	if len(grid) == 0 {
		return 0
	}
	cnt := 0
	row, col := len(grid), len(grid[0])
	dirs := [][2]int{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}
	for i := range row {
		for j := range col {
			cell := grid[i][j]
			if cell != '1' {
				continue
			}
			cnt++

			q := [][2]int{{i, j}}
			for len(q) > 0 {
				cur := q[0]
				q = q[1:]
				i, j := cur[0], cur[1]
				grid[i][j] = '2'
				for _, d := range dirs {
					nx, ny := i+d[0], j+d[1]
					if nx >= 0 && nx < row && ny >= 0 && ny < col && grid[nx][ny] == '1' {
						grid[nx][ny] = '2'
						q = append(q, [2]int{nx, ny})
					}
				}
			}
		}
	}
	return cnt
}
