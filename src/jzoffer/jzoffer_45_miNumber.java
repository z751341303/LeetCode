package jzoffer;

import java.util.Arrays;
import java.util.Comparator;

public class jzoffer_45_miNumber {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (a + b).compareTo(b + a);
            }
        });
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s);
        }
        return new String(res);
    }
}
