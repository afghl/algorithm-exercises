package leetcode.str;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * easy
 */
public class 最长公共前缀_14 {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();

        int index = 0;

        while (index < strs[0].length()) {
            boolean isSame = true;
            char c = strs[0].charAt(index);
            for (String str : strs) {
                if (str.length() < index || str.charAt(index) != c) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) {
                result.append(c);
                index++;
            } else {
                break;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        System.out.println(true);
        System.out.println(a.getClass());
    }
}
