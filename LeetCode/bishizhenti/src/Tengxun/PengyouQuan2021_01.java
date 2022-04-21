package Tengxun;

import java.util.*;
import java.lang.Math;


/** 测试用例
 * 2
 * 4
 * 1 2
 * 3 4
 * 5 6
 * 1 6
 * 4
 * 1 2
 * 3 4
 * 5 6
 * 7 8
 */


public class PengyouQuan2021_01 {
    static long quanId = 1;
    static Scanner scanner;
    static ArrayList<Integer> resList = new ArrayList<>();
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testNum = scanner.nextInt();
        for (int i = 0; i < testNum; i++) {
            solution();
        }
        for (int i = 0; i < resList.size(); i++) {
            System.out.println(resList.get(i));
        }
    }

    private static void solution() {
        int relationNum = scanner.nextInt();
        UnionFind uf = new UnionFind(relationNum * 2 + 1);
        for (int i = 0; i < relationNum; i++) {
            int user1 = scanner.nextInt();
            int user2 = scanner.nextInt();
            uf.union(user1, user2);
        }
        resList.add(uf.getMost());
    }
}

class UnionFind {
    // 记录连通分量
    private int count;
    // 节点x的父节点是parent[x]
    private int[] parent;

    public UnionFind(int n) {
        // 一开始互不连通
        this.count = n;
        parent = new int[n];
        // 初始，每个节点的父节点指向自己
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int getMost() {
        HashMap<Integer, Integer> summary = new HashMap<>(); // 根节点：联通个数
        for (int i = 0; i < parent.length; i++) {
            int iRoot = find(i);
            summary.put(iRoot, summary.getOrDefault(iRoot, 0) + 1);
        }
        int most = 0;
        for (Integer value : summary.values()) {
            most = Math.max(most, value);
        }
        return most;
    }

    // 找到某个节点x的根节点
    private int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    // 连接p和q两个节点，p和q是某个索引
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        parent[rootP] = rootQ;
        count--;
    }

    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    public int count() {
        return count;
    }
}

