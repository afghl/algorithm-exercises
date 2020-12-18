package leetcode.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 * easy
 */
public class 有效的字母异位词_242 {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        return countChars(s).equals(countChars(t));
    }

    private HashMap<Character, Integer> countChars(String s) {
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;
    }
}
