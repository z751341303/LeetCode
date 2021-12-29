package jzoffer;

import java.util.*;

public class jzoffer_03_findRepeatNumber {
    // 时间优先，用Set O(n) O(n)
    public int findRepeatNumber_A(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
        }
        return -1;
    }

    // 可以修改原数组,原地交换 O(n) O(1)
    public int findRepeatNumber_B(int[] nums) {
        for(int i = 0 ; i < nums.length;i++) {
            // 如果该数字没有不和他的索引相等
            // while是为了使得交换完之后还能继续判断，用if就无法继续判断
            while (nums[i] != i) {
                // 重复返回
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                // 不重复交换
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    // 排序 O(nlogn) O(1)
    public int findRepeatNumber_C(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if (nums[i-1] == nums[i])
                return nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,4,2,0,0,1};
        System.out.println(new jzoffer_03_findRepeatNumber().findRepeatNumber_B(nums));
    }
}
