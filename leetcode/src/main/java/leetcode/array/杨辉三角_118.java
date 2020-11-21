package leetcode.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle/
 *
 * easy
 */
public class 杨辉三角_118 {

    public static void main(String[] args) {
        List<List<Integer>> generate = new 杨辉三角_118().generate(5);
        System.out.println(generate);
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> preRow = null;
        int rowCount = 1;
        while (rowCount <= numRows) {
            List<Integer> row = getRow(rowCount, preRow);
            result.add(row);

            rowCount++;
            preRow = row;
        }

        return result;
    }

    private List<Integer> getRow(int rowCount, List<Integer> preRow) {
        if (rowCount == 1) {
            return Collections.singletonList(1);
        } else if (rowCount == 2) {
            return Arrays.asList(1, 1);
        }

        List<Integer> result = new ArrayList<>();

        result.add(1);
        for (int i = 0; i < preRow.size() - 1; i++) {
            result.add(preRow.get(i) + preRow.get(i + 1));
        }
        result.add(1);

        return result;
    }
}
