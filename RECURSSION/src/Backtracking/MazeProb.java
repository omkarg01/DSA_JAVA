package Backtracking;

import java.util.ArrayList;

public class MazeProb {
    public static void main(String[] args) {
        // System.out.println(mazeCount(3, 3));
        // System.out.println(mazePathDiag("", 3, 3));

        boolean[][] board = {
            {true, true, true},
            {true, false, true},
            {true, true, true},
        };

        mazePathRestriction("", board, 0, 0);
    }

    private static int mazeCount(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }

        int left = mazeCount(r - 1, c);
        int right = mazeCount(r, c - 1);

        return left + right;
    }

    private static ArrayList<String> mazePath(String up, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(up);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();

        if (r > 1) {

            ArrayList<String> left = mazePath(up + "D", r - 1, c);
            list.addAll(left);
        }

        if (c > 1) {

            ArrayList<String> right = mazePath(up + "R", r, c - 1);
            list.addAll(right);
        }
        return list;
    }

    private static ArrayList<String> mazePathDiag(String up, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(up);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();

        if (c > 1 && r > 1) {
            ArrayList<String> diagonal = mazePathDiag(up + "C", r - 1, c - 1);
            list.addAll(diagonal);
        }

        if (r > 1) {

            ArrayList<String> left = mazePathDiag(up + "D", r - 1, c);
            list.addAll(left);
        }

        if (c > 1) {

            ArrayList<String> right = mazePathDiag(up + "R", r, c - 1);
            list.addAll(right);
        }

        return list;
    }

    private static void mazePathRestriction(String up, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(up);
            return;
        }


        if (maze[r][c] == false) {
            return;
        }

        if (r < maze.length - 1) {
            mazePathRestriction(up + "D", maze, r + 1, c);
        }

        if (c < maze[0].length - 1) {
            mazePathRestriction(up + "R", maze, r, c + 1);
        }

    }
}
