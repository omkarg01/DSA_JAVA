package ArraysPrac.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicates {
    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        List<Integer> dups = findDuplicates(nums);
        System.out.println(dups.toString());
    }

    public static List<Integer> findDuplicates(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != arr[arr[i] - 1]) {
                swap(arr, i, arr[i] - 1);
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
        List<Integer> missing = new ArrayList<>();
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                missing.add(arr[j]);
            }
        }
        return missing;
    }

    private static boolean swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return true;
    }
}
