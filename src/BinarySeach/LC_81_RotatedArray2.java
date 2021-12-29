package BinarySeach;

/*
33.旋转排序数组
https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */

public class LC_81_RotatedArray2 {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // 对于数组中有重复元素的情况，二分查找时可能会有 a[left]=a[mid]=a[right]，此时无法判断两边区间哪个是有序的，所以将比较的边界缩小一格
            if (nums[mid] == nums[right]) {
                --right;
            } else if (nums[mid] < nums[right]) {  // 中间的数小于等于右边界数，则右半段非降序
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
