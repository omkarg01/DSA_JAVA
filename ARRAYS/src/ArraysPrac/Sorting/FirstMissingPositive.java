package ArraysPrac.Sorting;

import java.util.Arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {

        int[] arr = {2, 1};
     
        int ans = firstMissingPositive(arr);
        System.out.println(ans);
    }

    public static int firstMissingPositive(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            if (nums[i] < nums.length) {

                if ((nums[i] > 0) && (nums[i] != nums[nums[i] - 1])) {
                    swap(nums, i, nums[i] - 1);
                } else {
                    i++;
                }
            }
            else {
                i++;
            }
        }

        System.out.println(Arrays.toString(nums));

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }

        return nums[nums.length - 1] + 1;
    }

    private static boolean swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return true;
    }

}
