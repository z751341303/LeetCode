package dfs;

/*
200.岛屿数量
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。
 */

public class LC_200_Islands {
    public int numIslands(char[][] grid) {
        int n = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                // 如果找到陆地则进行深搜把整块陆地标记
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    n++;
                }
            }
        }
        return n;
    }
    // 深搜把与(i,j)相连的陆地全部标记，避免重复计算
    void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1')
            return;
        // 上下左右搜索
        grid[i][j] = '2';
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
    }
}
