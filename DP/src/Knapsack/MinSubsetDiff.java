package Knapsack;

import java.util.ArrayList;
import java.util.List;

public class MinSubsetDiff {
    public static void main(String[] args) {
        int[] arr = { -2, 10};

        int sum = 0;
        for (int i : arr) {
            
            sum += i;
        }

        // System.out.println(sum);
        boolean[][] t = new boolean[arr.length + 1][Math.abs(sum) + 1];
        // System.out.println(t.length);
        // display(t);
    
        int minDiff = minSubsetDiff(arr, arr.length, sum, t);
        System.out.println(minDiff);
    }

    private static int minSubsetDiff(int[] arr, int n, int sum, boolean[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                if (i == 0) {
                    t[i][j] = false;
                }
                if (j == 0) {
                    t[i][j] = true;
                }
            }
        }
        // display(t);
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                // System.out.print("");
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][Math.abs(j - Math.abs(arr[i - 1]))] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }

                // System.out.println();
            }
        }

        // display(t);

        List<Integer> lastArr = new ArrayList<>();

        for (int j = 0; j < t[0].length / 2; j++) {
            if (t[n][j]) {
                lastArr.add(j);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lastArr.size(); i++) {
            min = Math.min(min, sum - 2 * lastArr.get(i));
        }

        return min;
    }

    private static void display(boolean[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
    }
}
