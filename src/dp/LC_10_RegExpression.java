package dp;

/*
10. 正则表达式匹配
https://leetcode-cn.com/problems/regular-expression-matching/
 */

public class LC_10_RegExpression {
    // 递归
    public boolean isMatchA(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        if (p.length() > 1 && p.charAt(1) == '*') {
            // 如果首字母后面是'*'， 1.匹配0个字母，跳过
            // 2.s长度不为0，且第一项相等或者p第一项是'.'，并和s[1:]继续匹配
            return isMatchA(s, p.substring(2)) || (s.length() > 0 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) && isMatchA(s.substring(1), p));
        } else {
            // 不是'*' 或 p长度为1，正常匹配完并继续匹配后面的部分
            return s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') && isMatchA(s.substring(1), p.substring(1));
        }
    }

    // dp
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        // dp[i][j]表示s的前i个字符和p的前j个字符是否匹配
        boolean[][] dp = new boolean[m+1][n+1];
        // 对应于递归中长度都为0的情况
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // i,j对应s的i号位字符和p的j号位字符（下标从0开始），故要-1
                if (p.charAt(j - 1) == '*') {
                    // 1.跳过[字母+'*']  2.匹配：相等或等于'.'
                    // j-1位为'*'，所以比较前一位的字母是否匹配
                    dp[i][j] = dp[i][j-2] || (i > 0 && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') && dp[i-1][j]);
                } else {
                    dp[i][j] = i > 0 && (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-2) == '.') && dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
