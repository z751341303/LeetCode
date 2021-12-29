package array;

import java.util.ArrayList;
import java.util.List;

/*
448.找到数组中消失的数字
https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 */

public class LC_448_disappearedNum {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        // 不使用额外空间，则需要考虑在原来的数组上进行操作
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
