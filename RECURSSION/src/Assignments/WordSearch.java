package Assignments;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "SEE";
        System.out.println(exist(board, word, 0, 0));
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
