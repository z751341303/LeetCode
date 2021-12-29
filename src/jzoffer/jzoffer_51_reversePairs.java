package jzoffer;

public class jzoffer_51_reversePairs {
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) return 0;
        //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp = new int[len];
        return sort(nums, 0, len - 1, temp);
    }
    private int sort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) return 0;
        int mid = left + (right - left) / 2;
        int leftPairs = sort(nums, left, mid, temp);
        int rightPairs = sort(nums, mid + 1, right, temp);
        int currentPairs = merge(nums, left, mid, right, temp);
        return leftPairs + rightPairs + currentPairs;
    }
    private int merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1, k = left;
        int count = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                count += mid - i + 1;
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        for(int x = left; x <= right; x++){
            nums[x] = temp[x];
        }
        return count;
    }
}
