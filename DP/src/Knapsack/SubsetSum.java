package Knapsack;


public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};
        int sum = 22;

        boolean[][] t = new boolean[arr.length + 1][(sum/2) + 1];
        display(t);
        boolean ans = subset(arr, sum/2, t, arr.length);
        System.out.println(ans);
    }
    

    public static boolean subset(int[] arr, int sum, boolean[][] t, int n){
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
       
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i-1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i-1]] || t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        display(t);

        return t[n][sum];
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
