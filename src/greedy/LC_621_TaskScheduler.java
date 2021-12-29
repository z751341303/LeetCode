package greedy;

import java.util.Arrays;
/*
621.任务调度器
https://leetcode-cn.com/problems/task-scheduler/
 */

/*
n+1 >= 种类数：
           n+1
          A B 冷
maxTimes  A B 冷
          A B             <---- count

(maxTimes - 1) * (n + 1) + (count + 1)

n+1 < 种类数：
tasks.length
 */
public class LC_621_TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        // 存储26个字母对应的出现次数，hashmap对value排序比较复杂， 所以采用数组
        int[] cnt = new int[26];
        for (char ch : tasks) {
            cnt[ch - 'A']++;
        }
        Arrays.sort(cnt);
        // 需要执行次数最多的任务
        int maxTimes = cnt[25];
        // 统计其他任务次数和最多次数一样的数量
        int count = 0;
        for (int i = 24; i >= 0; i--) {
            if (cnt[i] == cnt[25]) {
                count++;
            } else {
                break;
            }
        }
        int res = (maxTimes - 1) * (n + 1) + (count + 1);
        // 如果n + 1 < 任务类型数量，那最少值则为tasks.length
        return Math.max(res, tasks.length);
    }
}
