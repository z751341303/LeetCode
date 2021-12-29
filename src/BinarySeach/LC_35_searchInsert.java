package BinarySeach;

/*
35.搜索插入位置
https://leetcode-cn.com/problems/search-insert-position/
 */

public class LC_35_searchInsert {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if (nums[nums.length - 1] < target) return nums.length;
        if (nums[0] > target) return 0;
        while (left < right) {
            int mid = (left + right) / 2;
            // 若中间元素小于目标元素，解肯定在右边
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
