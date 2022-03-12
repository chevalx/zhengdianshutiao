package misc.huisu;

import java.util.LinkedList;
import java.util.List;

public class SolutionJZOfferZXTJ110 {
    public static void main(String[] args) {
        new SolutionJZOfferZXTJ110().allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}});
    }

    private LinkedList<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int[] startIndices = graph[0];
        LinkedList<Integer> path = new LinkedList<>();
        int n = graph.length-1;
        path.add(0);
        backtrack(graph, startIndices, path, n);
        return res;
    }

    public void backtrack(int[][] graph, int[] nextNodes, LinkedList<Integer> path, int n) {
        if (path.getLast() == n) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nextNodes.length; i++) {
            path.add(nextNodes[i]);
            backtrack(graph, graph[nextNodes[i]], path, n);
            path.removeLast();
        }
    }
}
