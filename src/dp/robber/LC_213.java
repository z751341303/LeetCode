package dp.robber;

/*
这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋
装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 */

public class LC_213 {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        //不抢最后一个
        int[] dp1 = new int[nums.length+1];
        dp1[0] = 0;
        dp1[1] = nums[0];
        for(int i = 2 ; i < nums.length; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + nums[i-1]);
        }
        //不抢第一个
        int[] dp2 = new int[nums.length+1];
        dp2[0] = 0;
        dp2[1] = 0;
        dp2[2] = nums[1];
        for(int i = 3 ; i < nums.length + 1; i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + nums[i-1]);
        }
        return Math.max(dp1[nums.length-1],dp2[nums.length]);
    }
}
