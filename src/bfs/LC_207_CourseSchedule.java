package bfs;

/*
207.课程表
https://leetcode-cn.com/problems/course-schedule/
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        // 计算各个顶点的入度
        int[] in = new int[numCourses];
        for (int[] edge : prerequisites) {
            edges.get(edge[1]).add(edge[0]);
            in[edge[0]]++;
        }
        // 入度为0时，加入到待学习的队列
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (in[i] == 0) {
                queue.offer(i);
            }
        }
        // 已学习的课程数
        int visited = 0;
        while (!queue.isEmpty()) {
            visited++;
            int course = queue.poll();
            // 将学习完的课程的后继课程入度减1;
            for (int v : edges.get(course)) {
                in[v]--;
                if (in[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return visited == numCourses;
    }
}
