package backtrack;

import java.util.HashSet;
import java.util.Set;

/*
剑指offer38.字符串的排列
https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 */

class LC_jzoffer38_LCOF {
    public String[] permutation(String s) {
        char[] str = s.toCharArray();
        Set<String> list = new HashSet<>();
        int[] visited = new int[str.length];
        backtrack(str, list, "", visited);
//        return list.toArray(new String[0]);
        String[] res = new String[list.size()];
        int i = 0;
        for(String e : list) {
            res[i++] = e;
        }
        return res;

    }
    void backtrack(char[] str, Set<String> list, String temp, int[] visited) {
        if(temp.length() == str.length) {
            list.add(temp);
            return;
        }
        for(int i = 0; i < str.length; i++) {
            if(visited[i] == 1) continue;
            visited[i] = 1;
            temp += str[i];
            backtrack(str, list, temp+str[i], visited);
            visited[i] = 0;
        }
    }
}