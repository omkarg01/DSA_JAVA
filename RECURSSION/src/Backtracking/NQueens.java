package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        boolean[][] board = new boolean[4][4];
        // System.out.println(queens(board));
        List<List<String>> result = new ArrayList<>();
        queens(board, 0, result);
        // display(board);
        System.out.println(result);
    }
    private static int queens(boolean[][] board, int row, List<List<String>> ans){
        if (row == board.length) {
            ans.add(display(board));
            // System.out.println();
            return 1;
        }

        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += queens(board, row + 1, ans);
                board[row][col] = false;
            }
        }

        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        
        // check vertical
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }
        
        // left diagonal
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        // right diagonal
        int maxRight = Math.min(row, board.length - col - 1 );
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }
        return true;
    }

    private static List<String> display(boolean[][] board) {
        List<String> list = new ArrayList<>();
        for (boolean[] row : board) {
            String r = "";
            for (boolean elem : row) {
                if (elem) {
                    r += "Q";
                } else {
                    r += ".";
                }
            }
            list.add(r);
            // System.out.println();
        }

        return list;
    }


    

}
