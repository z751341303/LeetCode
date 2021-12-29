package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_438_Anagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] cnt_s = new int[26];
        int[] cnt_p = new int[26];
        if (s.length() < p.length()) {
            return res;
        }
        for (int i = 0; i < p.length(); i++) {
            cnt_s[s.charAt(i) - 'a']++;
            cnt_p[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cnt_s, cnt_p)) {
            res.add(0);
        }
        for (int i = 1; i <= s.length() - p.length(); i++) {
            cnt_s[s.charAt(i - 1) - 'a']--;
            cnt_s[s.charAt(i + p.length() - 1) - 'a']++;
            if(Arrays.equals(cnt_s, cnt_p)){
                res.add(i);
            }
        }
        return res;
    }
}
