package leetcode.str;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * medium
 */
public class 无重复字符的最长子串_3 {

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int max = 0;
        int left = 0;
        int right = 0;

        Map<Character, Integer> characterIndex = new HashMap<>();
        while (right < s.length()) {
            // 如果left到right的区间内，包含重复字符串
            if (characterIndex.containsKey(s.charAt(right))) {
                left = Math.max(left, characterIndex.get(s.charAt(right)) + 1);
            }
            characterIndex.put(s.charAt(right), right);
            right = right + 1;
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new 无重复字符的最长子串_3().lengthOfLongestSubstring("dvdf"));
    }
}
