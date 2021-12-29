package BinarySeach;

/*
33.旋转排序数组
https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */

public class LC_33_RotatedArray {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 中间的数小于右边界数，则右半段升序
            else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;;
                }
            }
        }
        return -1;
    }
}
