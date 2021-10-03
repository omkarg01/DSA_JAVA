import java.util.Arrays;

public class SumTriangle {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        sumTriangle(arr, arr.length);
    }

    private static void sumTriangle(int[] arr, int n) {
        if (arr.length == 1){
            return;
        }
        // System.out.println(Arrays.toString(arr));
        // int sum = 0;
        int[] temp = new int[arr.length - 1];
        for (int index = 0; index < arr.length - 1; index++) {
            int x = arr[index] + arr[index + 1];
            temp[index] = x;
        }
        sumTriangle(temp, n);
        System.out.println(Arrays.toString(temp));
        if (arr.length == n){
            System.out.println(Arrays.toString(arr));
        }
    }
}
