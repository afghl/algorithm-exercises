package leetcode.pending;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/different-ways-to-add-parentheses/
 *
 * medium
 */
public class 为运算表达式设计优先级_241 {

    // 注意只会有三个运算符 - + *
    public List<Integer> diffWaysToCompute(String input) {
        String[] split = input.split("/+-*/");
        System.out.println(Arrays.toString(split));

        return null;
    }


    public static void main(String[] args) {
        System.out.println(new 为运算表达式设计优先级_241().diffWaysToCompute("2*3-4*5+7"));
    }
}
