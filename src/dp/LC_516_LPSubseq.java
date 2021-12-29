/*
516.最长回文子序列
https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 */

package dp;

public class LC_516_LPSubseq {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        //base case
        if(n == 0) {
            return 0;
        }
        //dp[i][j]表示i到j子串的最长回文子串长度
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                // 状态转移方程
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        // 整个 s 的最长回文子串长度
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        LC_516_LPSubseq test = new LC_516_LPSubseq();
        System.out.println(test.longestPalindromeSubseq("bbbab"));
    }
}

