package jzoffer;

import java.util.ArrayList;
import java.util.List;

public class jzoffer_57_findSequence {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int sum = 0;
        for (int l = 1, r = 1; r <= (int)Math.ceil(target/2.0); r++) {
            sum += r;
            while (sum > target) {
                sum -= l;
                l++;
            }
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                for (int i = l; i <= r; i++) {
                    list.add(i);
                }
                res.add(list.stream().mapToInt(Integer::valueOf).toArray());
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
