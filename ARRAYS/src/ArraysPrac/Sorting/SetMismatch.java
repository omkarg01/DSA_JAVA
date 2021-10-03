package ArraysPrac.Sorting;

import java.util.Arrays;

public class SetMismatch {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 2};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    public static int[] findErrorNums(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != arr[arr[i] - 1]) {
                swap(arr, i, arr[i] - 1);
            } else {
                i++;
            }
        }
        int[] ans = new int[2];
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                ans[1] = j + 1;
                ans[0] = arr[j];
            }
        }
        return ans;
    }
    private static boolean swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return true;
    }
}
