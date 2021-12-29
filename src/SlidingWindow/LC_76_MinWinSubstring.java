package SlidingWindow;

import java.util.HashMap;
import java.util.Map;


/*
76. 最小覆盖子串
https://leetcode-cn.com/problems/minimum-window-substring/
 */

public class LC_76_MinWinSubstring {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }
        // 分别记录滑动窗口和t中各个字符以及出现的次数
        Map<Character, Integer> win = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for(char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0)+1);
        }
        int l = 0, r = 0, start = 0, len = Integer.MAX_VALUE, valid = 0;
        while(r < s.length()) {
            char nxt = s.charAt(r);
            win.put(nxt, win.getOrDefault(nxt, 0)+1);
            if(need.containsKey(nxt) && win.get(nxt).equals(need.get(nxt))) {
                valid++;
            }
            r++;
            while(valid == need.size()) {
                // 判断当前最小覆盖子串是否比之前的短，如果最短则记录起始位置
                if(r - l < len) {
                    len = r - l;
                    start = l;
                }
                char delchar = s.charAt(l);
                // 开始缩减窗口，left右移，如果要从窗口删除的字符正好是need中需要的且数目也等于need中需要的数目，
                // 则删减后，该该字符要求的数量显然不满足need要求的数量，所以valid要-1；
                if(need.containsKey(delchar) && win.get(delchar).equals(need.get(delchar))){
                    valid--;
                }
                win.put(delchar, win.get(delchar)-1);
                l++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }
}
