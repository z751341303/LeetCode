package array;
import java.util.HashSet;
import java.util.Set;

/*
128. 最长连续序列
https://leetcode-cn.com/problems/longest-consecutive-sequence/
 */

public class LC_128_LCS {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashset = new HashSet<>();
        for(int num : nums) {
            hashset.add(num);
        }
        int res = 0;
        for(int start : hashset){
            if(!hashset.contains(start - 1)) {
                // 如果哈希表没有当前数的前一个数，则以当前数向后枚举
                int end = start;
                while(hashset.contains(end + 1)) {
                    end++;
                }
                res = Math.max(end - start + 1, res);
            }
        }
        return res;
    }
}
