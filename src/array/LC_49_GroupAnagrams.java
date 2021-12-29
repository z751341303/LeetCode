package array;

import java.util.*;

/*
49. 字母异位词分组
https://leetcode-cn.com/problems/group-anagrams/
 */

public class LC_49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ana = new HashMap<>();
        for(String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String str = String.valueOf(ch);
            if(!ana.containsKey(str)) {
                ana.put(str, new ArrayList<>());
            }
            ana.get(str).add(s);
        }
        return new ArrayList<>(ana.values());
    }
}
