package com.company;

import java.util.*;

public class Main3 {
    public static class GoodInfo {
        int benqian;
        int lirun;
        boolean visited;
    }

    public static boolean check(List<GoodInfo> goods, int k) {
        boolean flag = false;
        for (int i = 0; i < goods.size(); i++) {
            if (goods.get(i).visited) {
                continue;
            }
            if (goods.get(i).lirun <= 0) {
                continue;
            }

            if (k > goods.get(i).benqian) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<GoodInfo> goods = new ArrayList<>();
        String[] benqianArray = in.nextLine().trim().split(",");
        String[] jiageArray = in.nextLine().trim().split(",");
        int k = in.nextInt();
        for (int i = 0; i < benqianArray.length; i++) {
            GoodInfo goodInfo = new GoodInfo();
            goodInfo.benqian = Integer.parseInt(benqianArray[i]);
            goodInfo.lirun = Integer.parseInt(jiageArray[i]) - goodInfo.benqian;
            if (goodInfo.lirun <= 0) {
                continue;
            }
            goodInfo.visited = false;
            goods.add(goodInfo);
        }
        goods.sort(new Comparator<GoodInfo>() {
            @Override
            public int compare(GoodInfo o1, GoodInfo o2) {
                return o2.lirun - o1.lirun;
            }
        });
        int f = k;
        while (check(goods, f)) {
            for (int i = 0; i < goods.size(); i++) {
                if (f < goods.get(i).benqian) {
                    continue;
                }
                if (goods.get(i).lirun <= 0) {
                    continue;
                }
                f = f + goods.get(i).lirun;
                goods.get(i).visited = true;
            }
        }
        System.out.println(f);
    }
}
