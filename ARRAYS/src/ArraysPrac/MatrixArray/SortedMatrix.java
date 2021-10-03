package ArraysPrac.MatrixArray;

import java.util.Arrays;

public class SortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        // int[][] matrix = { { 1, 2, 3, 4 } };
        for (int i = 1; i < 17; i++) {
            System.out.println(i + "->" + Arrays.toString(search(matrix, i)));
        }
    }

    // search in the row provided between the cols provided
    private static int[] binarySearch(int[][] matrix, int mRow, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 1;
            if (matrix[mRow][mid] == target) {
                return new int[] { mRow, mid };
            }
            if (matrix[mRow][mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return new int[] { -1, -1 };
    }

    private static int[] search(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length; // be cautious, matrix may be empty
        if (cols == 0) {
            return new int[] { -1, -1 };
        }

        if (rows == 1) {
            return binarySearch(matrix, 0, 0, cols - 1, target);
        }

        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = (cols / 2) - 1;

        // run the loop till 2 rows are remaining
        while (rStart < (rEnd - 1)) {// while this is true it will have more than 2 rows
            int mid = rStart + (rEnd - rStart) / 2;
            if (matrix[mid][cMid] == target) {
                return new int[] { mid, cMid };
            }
            if (matrix[mid][cMid] < target) {
                rStart = mid;
            } else {
                rEnd = mid;
            }
        }

        // now we have two rows
        // check whether the target is in the col of 2 rows
        if (matrix[rStart][cMid] == target) {
            return new int[] { rStart, cMid };
        }
        if (matrix[rStart + 1][cMid] == target) {
            return new int[] { rStart, cMid };
        }

        // search in 1st half
        if (matrix[rStart][cMid] > target) {
            return binarySearch(matrix, rStart, 0, cMid - 1, target);
        }

        // search in 2nd half
        if (matrix[rStart][cMid] < target && target <= matrix[rStart][cols - 1]) {
            return binarySearch(matrix, rStart, cMid + 1, cols - 1, target);
        }

        // search in 3rd half
        if (matrix[rStart + 1][cMid] > target) {
            return binarySearch(matrix, rStart + 1, 0, cMid - 1, target);

        } else {
            // search in 4th half
            return binarySearch(matrix, rStart + 1, cMid + 1, cols - 1, target);
        }

    }
}
