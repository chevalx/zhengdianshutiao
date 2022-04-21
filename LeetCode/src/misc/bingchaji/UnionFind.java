package misc.bingchaji;

public class UnionFind {
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

    // 找到某个节点x的根节点
    private int find(int x) {
        while (x != parent[x]) {
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
