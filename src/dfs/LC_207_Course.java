package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
207.课程表
https://leetcode-cn.com/problems/course-schedule/
 */

public class LC_207_Course {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        // 统计所有顶点的入度, 顶点数 = 课程数
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites) {
            // 出现一次，入度加1
            indeg[pre[0]]++;
            // 邻接表中添加数据, 每个结点存放后继结点集合
            adj.get(pre[1]).add(pre[0]);
        }
        // 把所有入度为的结点加入队列
        for(int i = 0; i < numCourses; i++) {
            if(indeg[i] == 0)
                queue.add(i);
        }
        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            numCourses--;
            // 将入度为0的结点的所有邻接结点入度减1
            for(int temp : adj.get(vertex)) {
                indeg[temp]--;
                if(indeg[temp] == 0) {
                    queue.add(temp);
                }
            }
        }
        return numCourses == 0;
    }
}
