package leetcode.str;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/isomorphic-strings/
 *
 * easy
 */
public class 同构字符串_205 {

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> characterMapping = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char schar = s.charAt(i);
            char tchar = t.charAt(i);

            Character c = characterMapping.get(schar);
            if (c != null) {
                if (c != tchar) return false;
            } else if (characterMapping.containsValue(tchar)) {
                return false;
            } else {
                characterMapping.put(schar, tchar);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new 同构字符串_205().isIsomorphic("ab", "aa"));
        System.out.println(new 同构字符串_205().isIsomorphic("foo", "bar"));
        System.out.println(new 同构字符串_205().isIsomorphic("paper", "title"));
    }
}
