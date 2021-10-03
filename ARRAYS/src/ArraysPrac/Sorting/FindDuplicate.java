package ArraysPrac.Sorting;

import java.util.Arrays;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        findDuplicate(nums);
        System.out.println(Arrays.toString(nums));   
    }

    public static int findDuplicate(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != arr[arr[i] - 1]) {
                swap(arr, i, arr[i] - 1);
            } else {
                i++;
            }
        }
        
        return arr[arr.length - 1];
    }

    private static boolean swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return true;
    }
}
