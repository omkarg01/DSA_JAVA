package Backtracking;

import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = new int[][] { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 }, { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        int[][] board2 = new int[][]{
            {1, 0, 3, 0},
            {0, 4, 1, 2},
            {2, 0, 4, 0},
            {0, 1, 0, 3}
        };
        // {1, 2, 3, 4},
        // {3, 4, 1, 2},
        // {2, 3, 4, 1},
        // {4, 1, 2, 3}
        display(board);
        sudokuSolver(board, 0, 0, 1);
    }

    private static void sudokuSolver(int[][] board, int row, int col, int countNum) {
        if (countNum == board.length * board.length) {
            display(board);
            System.out.println();
            return;
        }

        if (row == board.length - 1 && col == board.length) {
            return;
        }

        if (col == board.length) {
            sudokuSolver(board, row + 1, 0, countNum);
            return;
        }

        if (board[row][col] == 0) {
            for (int num = 1; num <= board.length; num++) {
                if (isSafe(board, row, col, num)) {
                    board[row][col] = num;
                    sudokuSolver(board, row, col + 1, countNum + 1);
                    board[row][col] = 0;
                    // display(board);
                }
            }
        }

        sudokuSolver(board, row, col + 1, countNum + 1);
    }

    private static boolean isSafe(int[][] board, int row, int col, int num) {
        // check the row
        for (int i = 0; i < board.length; i++) {
            // check if the number is in the row
            if (board[row][i] == num) {
                return false;
            }
        }

         // check the col
         for (int[] nums : board) {
            // check if the number is in the col
            if (nums[col] == num) {
                return false;
            }
        }

        int sqrt = (int)(Math.sqrt(board.length));
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for (int r = rowStart; r < rowStart + sqrt; r++) {
            for (int c = colStart; c < colStart + sqrt; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void display(int[][] board) {
        for (int[] row : board) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    
}
