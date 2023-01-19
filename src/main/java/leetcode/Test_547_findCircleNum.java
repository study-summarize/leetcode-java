package leetcode;

/**
 * @author jwang55
 */
public class Test_547_findCircleNum {

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }
        // 图的连通分量
        int count = 0;

        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length ; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int cityNum) {
        visited[cityNum] = true;
        int[] values = isConnected[cityNum];
        for (int i = 0; i < values.length; i++) {
            if (values[i] == 1 && !visited[i]) {
                dfs(isConnected, visited, i);
            }
        }
    }
}
