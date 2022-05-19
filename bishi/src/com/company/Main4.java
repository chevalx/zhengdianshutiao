package com.company;

import java.util.*;

public class Main4 {
    public static boolean check(int[][] goods, boolean[] visited, int k) {
        boolean flag = false;
        for (int i = 0; i < goods.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (goods[i][1] <= 0) {
                continue;
            }

            if (k > goods[i][0]) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] benqianArray = in.nextLine().trim().split(",");
        String[] jiageArray = in.nextLine().trim().split(",");
        int k = in.nextInt();
        int[][] goods = new int[benqianArray.length][2];
        for (int i = 0; i < benqianArray.length; i++) {
            goods[i][0] = Integer.parseInt(benqianArray[i]);
            goods[i][1] = Integer.parseInt(jiageArray[i]) - goods[i][0];
            if (goods[i][1] <= 0) {
                continue;
            }
        }
        Arrays.sort(goods, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int f = k;
        boolean[] visited = new boolean[goods.length];
        while (check(goods, visited, f)) {
            for (int i = 0; i < goods.length; i++) {
                if (f < goods[i][0]) {
                    continue;
                }
                if (goods[i][1] <= 0) {
                    continue;
                }
                f = f + goods[i][1];
                visited[i] = true;
            }
        }
        System.out.println(f);
    }
}
