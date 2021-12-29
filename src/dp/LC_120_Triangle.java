package dp;

import java.util.List;

/*
120.三角形最小路径和
给定一个三角形 triangle ，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者
等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
输出：11
解释：如下面简图所示：
   2
  3 4
 6 5 7
4 1 8 3
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */

public class LC_120_Triangle {
    /*
    dp[i][j]表示到第(i,j)位置的最小路径和
    */

    //自顶向下笨比写法 case太多
    public int minimumTotalA(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();

        if(m == 0) return 0;
        if(m == 1) return triangle.get(0).get(0);

        int[][] dp = new int[m][n];
        dp[0][0] = triangle.get(0).get(0);

        for(int i = 1; i < m; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0)
                    dp[i][j] = triangle.get(i).get(j) + dp[i-1][j];
                else if(j == i)
                    dp[i][j] = triangle.get(i).get(j) + dp[i-1][j-1];
                else
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j-1], dp[i-1][j]);
            }
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            res = Math.min(res, dp[m-1][i]);
        }
        return res;
    }

    // 自底向上聪明写法，避开了dp数组中多余的0
    public int minimumTotalB(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        // 加1省去初始化底层的步骤
        int[][] dp = new int[m+1][n+1];

        for(int i = m-1; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}
