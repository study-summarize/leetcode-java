package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jwang55
 */
public class Test_323_countComponents {

    public int countComponents(int n, int[][] edges) {
        // 做了几次DFS
        int count = 0;

        // 构建邻接表
        Map<Integer, List<Integer>> adj = new HashMap<>();
        // note：防止有一些孤立的节点
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // DFS
        boolean[] marked = new boolean[n];
        for (int i = 0; i < n ; i++) {
            if (!marked[i]) {
                dfs(adj, i, marked);
                count++;
            }
        }

        return count;
    }

    private void dfs(Map<Integer, List<Integer>> adj, int nodeNum, boolean[] marked) {
        marked[nodeNum] = true;
        for (Integer adjNode : adj.get(nodeNum)) {
            if (!marked[adjNode]) {
                dfs(adj, adjNode, marked);
            }
        }
    }
}