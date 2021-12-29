package backtrack;

import java.util.ArrayList;
import java.util.List;

public class LC_51_NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        // 初始化棋盘
        List<StringBuilder> board = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            for(int j = 0; j < n; j++) {
                s.append('.');
            }
            board.add(s);
        }

        backtrack(board, n, 0, res);
        return res;
    }

    void backtrack(List<StringBuilder> board, int n, int row, List<List<String>> res) {
        if(row == n) {
            List<String> temp = new ArrayList<>();
            for(StringBuilder str : board) {
                temp.add(str.toString());
            }
            res.add(temp);
            return;
        }
        for(int col = 0; col < n; col++) {
            if(!isValid(board, row, col)) {
                continue;
            }
            // 放皇后
            board.get(row).replace(col, col+1, "Q");
            // 进入下一行
            backtrack(board, n, row + 1, res);
            // 撤销选择
            board.get(row).replace(col, col+1, ".");
        }
    }

    Boolean isValid(List<StringBuilder> board, int row, int col) {
        // 对于即将新放置的位置，只需要判断上面的位置就行

        // 判断正上方
        for(int i = row; i >= 0; i--) {
            if(board.get(i).charAt(col) == 'Q'){
                return false;
            }
        }

        // 判断左上方
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(board.get(i).charAt(j) == 'Q'){
                return false;
            }
        }

        // 判断右上方
        for(int i = row, j = col; i >= 0 && j < board.size(); i--, j++) {
            if(board.get(i).charAt(j) == 'Q'){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
