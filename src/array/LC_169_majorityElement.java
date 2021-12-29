package array;

/*
169.多数元素
https://leetcode-cn.com/problems/majority-element/
 */

// 摩尔投票法：从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，减到0就重新换个数开始计数，总能找到最多的那个

public class LC_169_majorityElement {
    public int majorityElement(int[] nums) {
        int cnt = 1, candidate = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (candidate == nums[i]) {
                cnt++;
            } else {
                cnt--;
                if (cnt == 0) {
                    candidate = nums[i];
                    cnt = 1;
                }
            }
        }
        return candidate;
    }
}
