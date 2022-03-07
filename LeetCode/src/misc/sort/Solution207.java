package misc.sort;

import java.util.*;

public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 建立邻接表
        // k -> v
        // 课程 -> 该课程的预置课程个数
        int[] table = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            table[i] = 0;
        }
        for (int i = 0; i < prerequisites.length; i++) {
            table[prerequisites[i][0]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (table[i] == 0) {
                queue.offer(i);
            }
        }
        if (queue.isEmpty()) {
            return false;
        }

        while(!queue.isEmpty()) {
            Integer curr = queue.poll();
            // remove the pre = curr
            for(int[] pre : prerequisites) {
                if(pre[1] == curr) {
                    table[pre[0]] --;
                    if(table[pre[0]] == 0) {
                        queue.offer(pre[0]);
                    }
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (table[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
