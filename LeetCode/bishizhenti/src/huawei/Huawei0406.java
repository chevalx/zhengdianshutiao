package huawei;

import java.util.*;

public class Huawei0406 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int serviceNum = scanner.nextInt();
        int serviceToStart = scanner.nextInt();
        ArrayList<int[]> pres = new ArrayList<>();
        for (int i = 0; i < serviceNum; i++) {
            String[] line = scanner.next().split(",");
            int input = Integer.parseInt(line[0]);
            for (int j = 1; j < line.length; j++) {
                pres.add(new int[]{i, Integer.parseInt(line[j])});
            }
        }
        int[][] prerequisites = new int[pres.size()][2];
        for (int i = 0; i < pres.size(); i++) {
            prerequisites[i] = pres.get(i);
        }
        int[] result = findOrder(serviceNum, prerequisites);
        if (result.length == 0) {
            System.out.println(-1);
        } else {
            int[] copy;
            for (int i = 0; i < result.length; i++) {
                if (result[i] == serviceToStart) {
                    copy = Arrays.copyOfRange(result, 0, i);
                    Arrays.sort(copy);
                    for (int j = 0; j < copy.length; j++) {
                        if (j != copy.length - 1) {
                            System.out.print(copy[j] + ",");
                        } else {
                            System.out.print(copy[j]);
                        }
                    }
                    break;
                }
            }
        }
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }

        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }

        // [1,0] 0 -> 1
        int[] inDegree = new int[numCourses];
        for (int[] p : prerequisites) {
            adj[p[1]].add(p[0]);
            inDegree[p[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] res = new int[numCourses];
        // ??????????????????????????????????????????????????????????????????
        int count = 0;

        while (!queue.isEmpty()) {
            // ??????????????? 0 ?????????
            Integer head = queue.poll();
            res[count] = head;
            count++;

            Set<Integer> successors = adj[head];
            for (Integer nextCourse : successors) {
                inDegree[nextCourse]--;
                // ??????????????????????????????????????? 0???????????? 0?????????????????????
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // ?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
        if (count == numCourses) {
            return res;
        }
        return new int[0];
    }
}
