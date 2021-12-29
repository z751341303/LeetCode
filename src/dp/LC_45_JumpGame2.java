package dp;

/*
45.跳跃游戏2   贪心算法
https://leetcode-cn.com/problems/jump-game-ii/
 */

import java.util.Arrays;

public class LC_45_JumpGame2 {

    // 贪心算法
    public int jumpA(int[] nums) {
        if(nums.length <= 1) {
            return 0;
        }
        //记录上一步能到达的最远位置，即新的起跳点
        int end = 0;
        //记录当前点能到达的最远位置
        int farthest = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            //更新当前点能到达的最远位置
            farthest = Math.max(farthest, i + nums[i]);
            //如果对于当前位置能到达的最远距离超过终点，那最终所需步数即为count+1
            if(farthest >= nums.length - 1) {
                return count + 1;
            }
            //如果还没跳到终点，则更新起跳点，步数+1
            if(end == i) {
                end = farthest;
                count++;
            }
        }
        return count;
    }

    // dp
    public int jumpB(int[] nums) {
        // dp[i] 表示到位置i的最小跳跃数
        int[] dp = new int[nums.length];
        // basecase
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[nums.length - 1];
    }


    public static void main(String[] args) {
        LC_45_JumpGame2 test = new LC_45_JumpGame2();
        int[] nums = {2,3,1,1,4};
        System.out.println(test.jumpA(nums));
    }
}
