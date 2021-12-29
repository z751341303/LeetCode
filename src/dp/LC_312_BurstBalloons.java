package dp;

import java.util.*;
import java.util.stream.Collectors;
/*
312.戳气球
https://leetcode-cn.com/problems/burst-balloons/solution/san-chong-jie-fa-xiang-xi-tu-jie-312-chu-me4w/
 */

public class LC_312_BurstBalloons {
    // dfs 超时
    public int maxCoins_A(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return backtrack(list);
    }

    private int backtrack(List<Integer> list) {
        int res = 0;
        if (list.size() == 0) {
            return 0;
        }
        for (int i = 0; i < list.size(); i++) {
            int cur_coins = list.get(i) * (i - 1 < 0 ? 1 : list.get(i-1)) * (i + 1 > list.size() - 1 ? 1 : list.get(i+1));
            int temp = list.remove(i);
            cur_coins += backtrack(list);
            res = Math.max(cur_coins, res);
            list.add(i, temp);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,5,8};
        System.out.println(new LC_312_BurstBalloons().maxCoins_A(nums));
    }

    // dp
    // dp[i][j]表示nums[i…j]范围内获得的最多硬币，k表示选择的气球
    public int maxCoins_B(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        //创建一个n+2的数组，开头和末尾都填1
        int[] arr = new int[n + 2];
        for (int i = 1; i <= n; ++i) {
            arr[i] = nums[i - 1];
        }
        arr[0] = 1;
        arr[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        //从下往上遍历，i控制左边界，j控制右边界
        for(int i = n - 1; i >= 0; --i) {
            for(int j = i + 2; j <= n + 1; ++j) {
                //k在(i,j)范围内遍历气球，计算每选择一个气球的积分
                //一轮遍历完后，就能确定(i,j)的最大积分
                for(int k = i + 1; k < j; ++k) {
                    int total = arr[i] * arr[k] * arr[j];
                    total += dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], total);
                }
            }
        }
        return dp[0][n + 1];
    }
}
