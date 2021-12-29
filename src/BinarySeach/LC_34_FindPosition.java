package BinarySeach;

/*
34. 在排序数组中查找元素的第一个和最后一个位置
https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class LC_34_FindPosition {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0, right = nums.length - 1;
        // 找左边界，尽量取小，由左向右逼近
        while(left < right) {
            int mid = left + (right - left)/2;
            if(nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        if(nums[left] != target) {
            return new int[]{-1, -1};
        }
        int num = left;
        left = 0;
        right = nums.length - 1;
        // 找右边界，尽量取大，由由向左逼近
        while(left < right) {
            int mid = left + (right - left + 1)/2;
            if(nums[mid] > target) right = mid - 1;
            else left = mid;
        }
        return new int[]{num, left};
    }
}
