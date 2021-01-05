package leetcode.dp;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * medium
 */
public class 回文子串_5 {

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 示例 1：
     *
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     *
     * 输入: "cbbd"
     * 输出: "bb"
     *
     */

    // 暴力求解
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int n = s.length();
        String ans = "";
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isPalindrome(s, i, j) && j - i + 1 > ans.length()) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        new 回文子串_5().longestPalindrome("babad");
//        System.out.println(new 回文子串_5().isPalindrome("babad", 0, 0));;
//        System.out.println(new 回文子串_5().isPalindrome("babad", 0, 1));
//        System.out.println(new 回文子串_5().isPalindrome("babad", 0, 2));
//        System.out.println(new 回文子串_5().isPalindrome("babad", 0, 3));
//        System.out.println(new 回文子串_5().isPalindrome("baasdfbad", 0, 4));
    }
}
