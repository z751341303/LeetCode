package dp;

/*
221.最大正方形
在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 */

public class LC_221_MaxSquare {
    /*
    dp[i][j] 表示以(i,j)为右下角所构成的最大正方形的边长
    若matrix[i][j]==1，dp[i][j] = 1 + min(左, 上, 左上)
    */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int res = 0;

        for(int i = 1; i < m+1; i++) {
            for(int j = 1; j < n+1; j++) {
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res * res;
    }
}
