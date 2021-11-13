package Backtracking;

import java.util.Arrays;

public class AllPAths {
    public static void main(String[] args) {
        boolean[][] board = { { true, true, true }, { true, true, true }, { true, true, true }, };

        int[][] path = new int[board.length][board[0].length];
        allPath("", board, 0, 0, path, 1);
    }

    private static void allPath(String up, boolean[][] maze, int r, int c, int[][] path, int step) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = step; 
            for (int[] is : path) {
                System.out.println(Arrays.toString(is));
            }
            System.out.println(up);
            System.out.println();
            return;
        }

        if (maze[r][c] == false) {
            return;
        }

        maze[r][c] = false;
        path[r][c] = step;

        if (r < maze.length - 1) {
            allPath(up + "D", maze, r + 1, c, path, step + 1);
        }

        if (c < maze[0].length - 1) {
            allPath(up + "R", maze, r, c + 1, path, step + 1);
        }

        if (r > 0) {
            allPath(up + "U", maze, r - 1, c, path, step + 1);
        }

        if (c > 0) {
            allPath(up + "L", maze, r, c - 1, path, step + 1);
        }
        maze[r][c] = true;
        path[r][c] = 0;

    }
}
