package leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/backspace-string-compare/
 *
 * easy
 */
public class 比较含退格的字符串_844 {

    /**
     * 普通做法：拿到转化后的str，用栈
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare1(String S, String T) {
        String realSForS = getRealStr(S);
        String realSForT = getRealStr(T);
        return realSForS.equals(realSForT);
    }

    private String getRealStr(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        Stack<Character> ans = new Stack();
        for (char c: s.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }

        return String.valueOf(ans);
    }
}
