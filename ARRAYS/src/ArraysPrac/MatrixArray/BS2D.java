package ArraysPrac.MatrixArray;

import java.util.Arrays;

public class BS2D {

    public static void main(String[] args) {
        int[][] arr = { { 5, 8, 10, 25 }, { 7, 15, 25, 40 }, { 10, 16, 32, 48 }, { 16, 21, 36, 50 } };
        int[] res = search(arr, 40);
        System.out.println(Arrays.toString(res));
    }

    private static int[] search(int[][] matrix, int target) {
        int r = 0;
        int c = matrix.length - 1;
        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) {
                return new int[] { r, c };
            }
            if (matrix[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }
        return new int[] { -1, -1 };
    }
}