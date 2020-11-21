package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 *
 * easy
 */
public class 子集_78 {

    public static void main(String[] args) {
        new 子集_78().subsets(new int[] { 1, 2, 3 });
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            addNewElement(result, nums[i]);
        }

        return result;
    }

    private void addNewElement(List<List<Integer>> result, int num) {
        List<List<Integer>> newSubSets = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {
            List<Integer> subSet = result.get(i);

            ArrayList<Integer> newSubSet = new ArrayList<>(subSet);
            newSubSet.add(num);
            newSubSets.add(newSubSet);
        }

        result.addAll(newSubSets);
    }
}
