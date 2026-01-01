package main

func gameOfLife(board [][]int) {

	copyBoard := make([][]int, len(board))
	for i := range copyBoard {
		copyBoard[i] = make([]int, len(board[i]))
		copy(copyBoard[i], board[i])
	}
	neighbors := func(i, j int) int {
		liveNeighbors := 0
		for _, neighbor := range [][]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}} {
			ni, nj := i+neighbor[0], j+neighbor[1]
			if ni >= 0 && ni < len(board) && nj >= 0 && nj < len(board[0]) {
				liveNeighbors += copyBoard[ni][nj]
			}
		}
		return liveNeighbors
	}

	for i := range copyBoard {
		for j := range copyBoard[i] {
			cell := copyBoard[i][j]
			liveNeighbors := neighbors(i, j)
			if cell == 1 {
				if liveNeighbors < 2 || liveNeighbors > 3 {
					board[i][j] = 0
				}
			} else {
				if liveNeighbors == 3 {
					board[i][j] = 1
				}
			}
		}
	}
}
