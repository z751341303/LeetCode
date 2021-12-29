package SlidingWindow;

/*
3. 无重复字符的最长子串
https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC_3_LongestSubstring {
    public int lengthOfLongestSubstring1(String s) {
        Set<Character> win = new HashSet<>();
        int res = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            while (start <= end && win.contains(s.charAt(end))) {
                win.remove(s.charAt(start));
                start++;
            }
            win.add(s.charAt(end));
            res = Math.max(res, end - start + 1);
        }
        return res;
    }


    // 用哈希表记录字符最新的位置，如果重复直接跳转，节省一步一步右移左边界浪费的时间
    public int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> hashmap = new HashMap<>();
        int n = s.length();
        int res = 0, start = 0;
        for(int end = 0; end < n; end++){
            char c = s.charAt(end);
            // 如果这个字符出现过，则直接把窗口起始点右移
            if (hashmap.containsKey(c)) {
                start = Math.max(hashmap.get(c) + 1, start);
            }
            res = Math.max(res, end - start + 1);
            hashmap.put(c, end);
        }
        return res;
    }
}
