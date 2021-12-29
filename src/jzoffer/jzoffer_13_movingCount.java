package jzoffer;

public class jzoffer_13_movingCount {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(m, n, k, visited, 0, 0);
    }
    private int dfs(int m, int n, int k, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || (i/10 + i%10 + j/10 + j%10) > k || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        // 不需要撤销选择，因为每一次递归都把周围能到达的点全部计算进去了
        return dfs(m, n, k, visited, i + 1, j) + dfs(m, n, k, visited, i - 1, j) +
                dfs(m, n, k, visited, i, j + 1) + dfs(m, n, k, visited, i, j - 1) + 1;
    }
}
