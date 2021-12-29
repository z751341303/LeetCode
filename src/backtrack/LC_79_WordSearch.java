package backtrack;


/*
79. 单词搜索
https://leetcode-cn.com/problems/word-search/
 */
public class LC_79_WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    // k表示当前判断的单词位置
    boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int k) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(k)) {
            return false;
        }
        if(k == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        if(dfs(board, word, visited, i-1, j, k+1)
                || dfs(board, word, visited, i+1, j, k+1)
                || dfs(board, word, visited, i, j-1, k+1)
                || dfs(board, word, visited, i, j+1, k+1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
