package BinarySeach;

public class LC_4_medianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        // 在最短的数组上查找分割线
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        // 分割线左边的元素总和, 向上取整
        int totalLeft = (m + n + 1) / 2;

        // 在nums1中的[0, m]区间内寻找分割线, i,j即为分割线右边的第一个元素下标
        // 使得nums1[i-1] <= nums2[j] && nums2[j-1] <= nums1[i]
        // 因为要考虑所有元素都在分割线左边的情况，所以右边界下标要设置到m而不是m-1
        int left = 0, right = m;
        while (left < right) {
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                left = i;
            }
        }
        int i = left, j = totalLeft - i;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];
        if (((m + n) % 2) == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            // 如果两个数组的长度之和为偶数，返回的是两个数组在左边的最大值和两个数组在右边的最小值的和的二分之一
            // 此处不能被向下取整，所以要强制转换为double类型
            return (double) ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
        }
    }
}
