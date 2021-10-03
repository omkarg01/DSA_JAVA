package ArraysPrac.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAll {
    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        List<Integer> missingNumber = findDisappearedNumbers(nums);
        // List<Integer> missingNumber = solution2(nums);
        System.err.println(missingNumber.toString());
        print();
    }

    public static List<Integer> solution2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] map = new int[nums.length];
        for (int i : nums) {
            map[i - 1]++;
            System.out.println(map[i - 1]);
        }
        System.out.println(Arrays.toString(map));
        for (int i = 0; i < nums.length; i++) {
            if (map[i] == 0) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static List<Integer> findDisappearedNumbers(int[] arr) {
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
                missing.add(j + 1);
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

    private static void print() {
        int[] arr = { 3, 5, 1, 2, 4, 3 };
        for (int i : arr) {
            System.out.println(arr[i-1 ]++);
        }
    }
}
