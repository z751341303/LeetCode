package string;

import java.util.Stack;

/*
32. 最长有效括号
https://leetcode-cn.com/problems/longest-valid-parentheses/
 */

public class LC_32_LVP {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int res = 0;
        st.push(-1);
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                st.push(i);
            } else {
                st.pop();
                if(!st.isEmpty()) {
                    res = Math.max(res, i - st.peek());
                } else {
                    st.push(i);
                }
            }
        }
        return res;
    }
}
