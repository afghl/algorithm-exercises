package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/different-ways-to-add-parentheses/
 *
 * medium
 */
public class 为运算表达式设计优先级_241 {

    List<Character> signs = Arrays.asList('+', '-', '*');

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();

        if (input == null || input.isEmpty()) {
            return result;
        }

            if (signs.stream().noneMatch(c -> input.contains(c.toString()))) {
            result.add(Integer.valueOf(input));
            return result;
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (signs.contains(c)) {
                List<Integer> result1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> result2 = diffWaysToCompute(input.substring(i + 1));

                result.addAll(calc(result1, result2, c));
            }
        }

        return result;
    }

    private List<Integer> calc(List<Integer> result1, List<Integer> result2, char c) {
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < result1.size(); j++) {
            for (int k = 0; k < result2.size(); k++) {
                result.add(caculate(result1.get(j), c, result2.get(k)));
            }
        }
        return result;
    }

    private int caculate(int num1, char c, int num2) {
        switch (c) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> integers = new 为运算表达式设计优先级_241().diffWaysToCompute("2-1-1");
        System.out.println(integers);
    }
}
