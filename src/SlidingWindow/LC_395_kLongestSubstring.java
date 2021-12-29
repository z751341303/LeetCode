package SlidingWindow;

/*
395. 至少有 K 个重复字符的最长子串
https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 */

import java.util.HashMap;

public class LC_395_kLongestSubstring {
    public int longestSubstring(String s, int k) {
        // 统计各个字符出现的次数
        HashMap<Character, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashmap.put(s.charAt(i), hashmap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (char c : hashmap.keySet()) {
            if (hashmap.get(c) < k) {
                int res = 0;
                // 若c数量小于k，将s按c进行分割
                for (String t : s.split(String.valueOf(c))) {
                    res = Math.max(res, longestSubstring(t, k));
                }
                return res;
            }
        }
        return s.length();
    }

    public static void main(String[] args) {
        System.out.println(new LC_395_kLongestSubstring().longestSubstring("aaabb",3));
    }
}
