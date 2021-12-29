package backtrack;
/*
37.解数独
https://leetcode-cn.com/problems/sudoku-solver/
 */

public class LC_37_Sudoku {
    // 记录数字是否用过
    private boolean[][] rows;
    private boolean[][] columns;
    private boolean[][] grids;

    public void solveSudoku(char[][] board) {
        rows = new boolean[9][9];
        columns = new boolean[9][9];
        grids = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j]-'0';
                    rows[num-1][i] = true;
                    columns[num-1][j] = true;
                    grids[num-1][i/3*3+j/3] = true;
                }
            }
        }
        backtrack(0, 0, board);
    }

    public boolean backtrack(int row, int col, char[][] board) {
        if (row >= 9)
            return true;
        // 某一行遍历完，遍历下一行
        if (col >= 9)
            return backtrack(row+1, 0, board);
        if (board[row][col] != '.')
            return backtrack(row, col+1, board);
        for (int i = 0; i < 9; i++) {
            //当前数字在行，列，宫格已出现过
            if (rows[i][row] || columns[i][col] || grids[i][row/3*3+col/3])
                continue;
            board[row][col] = (char)('0'+i+1);
            rows[i][row] = true;
            columns[i][col] = true;
            grids[i][row/3*3+col/3] = true;
            // 找到一个可行解，提前结束
            if (backtrack(row, col+1, board)) {
                return true;
            }
            else {
                // 回溯
                board[row][col] = '.';
                rows[i][row] = false;
                columns[i][col] = false;
                grids[i][row/3*3+col/3] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC_37_Sudoku test = new LC_37_Sudoku();
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        test.printBoard(board);
        test.solveSudoku(board);
        System.out.println();
        test.printBoard(board);
    }
    private void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
