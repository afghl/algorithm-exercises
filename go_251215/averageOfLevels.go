package main

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func averageOfLevels(root *TreeNode) []float64 {
	averageOfLevelsDatas = make([]averageOfLevelsData, 0)
	recursiveAverageOfLevels(root, 0)
	return toAns(averageOfLevelsDatas)
}

func recursiveAverageOfLevels(node *TreeNode, level int) {
	if node == nil {
		return
	}

	if len(averageOfLevelsDatas) < level+1 {
		averageOfLevelsDatas = append(averageOfLevelsDatas, averageOfLevelsData{})
	}
	averageOfLevelsDatas[level].cnt += 1
	averageOfLevelsDatas[level].sum += node.Val
	recursiveAverageOfLevels(node.Left, level+1)
	recursiveAverageOfLevels(node.Right, level+1)
}

func toAns(datas []averageOfLevelsData) []float64 {
	ans := make([]float64, 0)
	for _, d := range datas {
		ans = append(ans, float64(d.sum)/float64(d.cnt))
	}
	return ans
}

type averageOfLevelsData struct {
	sum int
	cnt int
}

var averageOfLevelsDatas []averageOfLevelsData
