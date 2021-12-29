package greedy;

import java.util.*;

public class LC_406_reconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        // 按h降序，k升序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        // 将身高低[hi,ki]的插入到ki的位置时，前面一定有ki个比他高的
        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[list.size()][]);
    }
}
