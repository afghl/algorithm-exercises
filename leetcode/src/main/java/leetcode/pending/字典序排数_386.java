package leetcode.pending;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/lexicographical-numbers/
 * <p>
 * medium
 */
public class 字典序排数_386 {

    /**
     * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
     * <p>
     * 例如，
     * <p>
     * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
     * <p>
     * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
     *
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(n, i, list);
        }
        return list;
    }

    private void dfs(int n, int i, List<Integer> list) {
        if (i > n) {
            return;
        }
        list.add(i);
        for (int j = 0; j <= 9; j++) {
            dfs(n, i * 10 + j, list);
        }
    }
}
