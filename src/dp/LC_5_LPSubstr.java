package dp;

/*
5.最长回文子串
https://leetcode-cn.com/problems/longest-palindromic-substring/
 */

public class LC_5_LPSubstr {

    //a.双指针中心扩散法
    int start= 0, end = 0;
    public String longestPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1) {
            return s;
        }
        //以每个字符为中心进行扩散
        for(int i = 0; i < s.length(); i++) {
            Palindrome(s, i);
        }
        return s.substring(start, end + 1);
    }
    private void Palindrome(String s, int left){
        int right = left;
        while(right+1 < s.length() && s.charAt(left) == s.charAt(right+1)) {
            right++;
        }
        while(left > 0 && right < s.length()-1 && s.charAt(left-1) == s.charAt(right+1)) {
            right++;
            left--;
        }
        //如果找到更长的，更新起止位置
        if(end - start < right - left) {
            end = right;
            start = left;
        }
    }


    // b.dp法
    // 状态转移方程 dp[i][j] = (s[i]==s[j]) and (j-i<3 or dp[i+1][j-1])
    public String longestPalindrome2(String s) {
        int n = s.length();
        //表示s[i...j]是否为回文串
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int start = 0, end = 0;
        //每个dp[i][j]的值，都取决于其左下方的值，所以按列遍历
        for(int j = 1; j < n; j++) {
            for(int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = j - i < 3 || dp[i+1][j-1];
                }
                if(dp[i][j] && j - i > end - start) {
                    end = j;
                    start = i;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        LC_5_LPSubstr test = new LC_5_LPSubstr();
        System.out.println(test.longestPalindrome("babbad"));
        System.out.println(test.longestPalindrome2("babbad"));
    }
}
