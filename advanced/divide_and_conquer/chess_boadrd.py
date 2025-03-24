# 在一个2^k×2^k 个方格组成的棋盘中，恰有一个方格与其它方格不同，称该方格为一特殊方格，且称该棋盘为一特殊棋盘。在棋盘覆盖问题中，要用图示的4种不同形态的L型骨牌覆盖给定的特殊棋盘上除特殊方格以外的所有方格，且任何2个L型骨牌不得重叠覆盖。
from typing import List


class Solution:
    tile: int = 0
    board: List[List[int]] = []

    def chess_board(self, tr: int, tc: int, dr: int, dc: int, size: int):
        """
        tr: 棋盘的左上角行
        tc: 棋盘的左上角列
        dr: 特殊方格的行
        dc: 特殊方格的列
        size: 棋盘的大小
        """
        if size == 1:
            return
        s = size // 2
        t = self.tile
        self.tile += 1
        # 如果特殊方块在左上角
        if dr < tr + s and dc < tc + s:
            self.chess_board(tr, tc, dr, dc, s)
        else:
            # 覆盖右下角
            self.board[tr + s - 1][tc + s - 1] = t
            self.chess_board(tr, tc, tr + s - 1, tc + s - 1, s)

        # 如果特殊方块在右上角
        if dr < tr + s and dc >= tc + s:
            self.chess_board(tr, tc + s, dr, dc, s)
        else:
            # 覆盖左下角
            self.board[tr + s - 1][tc + s] = t
            self.chess_board(tr, tc + s, tr + s - 1, tc + s, s)

        # 如果特殊方块在左下角
        if dr >= tr + s and dc < tc + s:
            self.chess_board(tr + s, tc, dr, dc, s)
        else:
            # 覆盖右上角
            self.board[tr + s][tc + s - 1] = t
            self.chess_board(tr + s, tc, tr + s, tc + s - 1, s)

        # 如果特殊方块在右下角
        if dr >= tr + s and dc >= tc + s:
            self.chess_board(tr + s, tc + s, dr, dc, s)
        else:
            # 覆盖左上角
            self.board[tr + s][tc + s] = t
            self.chess_board(tr + s, tc + s, tr + s, tc + s, s)


if __name__ == "__main__":
    n = 8
    board = [[0] * n for _ in range(n)]
    tile = 1
    dr, dc = 2, 2  # 特殊方格的坐标
    solution = Solution()
    solution.tile = tile
    solution.board = board
    solution.chess_board(0, 0, dr, dc, n)
    for row in board:
        print(",".join([f" {x}" if x < 10 else f"{x}" for x in row]))
