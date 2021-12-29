package bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
301. 删除无效的括号
https://leetcode-cn.com/problems/remove-invalid-parentheses/
 */

// 输入的字符串s中可能出现非左右括号的情况，所以裁剪的时候要做明确的判断
public class LC_301_removeParentheses {
    // bfs
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Set<String> cur = new HashSet<>();
        cur.add(s);
        while (true) {
            for (String str : cur) {
                if (isValid(str)) {
                    res.add(str);
                }
            }
            // 因为要满足删除最少，所以找到后就不需要再进行裁剪
            if (res.size() > 0) {
                return res;
            }
            // 存放下一层的字符串，避免重复
            Set<String> next = new HashSet<>();
            for (String str : cur) {
                for (int i = 0; i < str.length(); i++) {
                    // 如果连着一样的括号出现，则必定是重复的，所以就没必要添加到下一层的set中，增加此判断提高效率
                    if (i > 0 && str.charAt(i) == str.charAt(i - 1)) {
                        continue;
                    }
                    if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                        // substring(i)方法在i = str.length()的时候是不会越界的，所以不需要做额外判断
                        next.add(str.substring(0, i) + str.substring(i + 1));
                    }
                }
            }
            cur = next;
        }
    }
    private boolean isValid(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else if (s.charAt(i) == ')') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }
        return cnt == 0;
    }

    public static void main(String[] args) {
        System.out.println(new LC_301_removeParentheses().removeInvalidParentheses("(a)())()"));
    }
}
