package Assignments;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word1 = "ABC";
        String word2 = "SEE";
        List<String> arr = new ArrayList<>();
        arr.add(word1);
        arr.add(word2);
        System.out.println(exist(board, word1, 0, 0));
        List<String> res = new ArrayList<>();
        for (String string : arr) {
            if (exist(board, string, 0, 0)){
                res.add(string);
            }
        }
        System.out.println(res);
    }

        public static boolean exist(char[][] board, String word, int r, int c) {
            for (int row = r; row < board.length; row++) {
                for (int col = c; col < board[row].length; col++) {
                    if (board[row][col] == word.charAt(0)) {
                        if (recursiveBacktrack(board, word, row, col, 0)) {
                            return true;
                        }
                    }   
                }
            }
            return false;   
        }

        private static boolean recursiveBacktrack(char[][] board, String word, int row, int col, int index) {
            if (index == word.length()) {
                return true;
            }

            if (row == -1 || row == board.length || col == -1 || col == board[0].length
                    || board[row][col] != word.charAt(index)) {
                return false;
            }

            char temp = board[row][col];
            board[row][col] = '*';
            boolean found = recursiveBacktrack(board, word, row + 1, col, index + 1)
                    || recursiveBacktrack(board, word, row - 1, col, index + 1)
                    || recursiveBacktrack(board, word, row, col + 1, index + 1)
                    || recursiveBacktrack(board, word, row, col - 1, index + 1);
            board[row][col] = temp;

            return found;
        }
}


