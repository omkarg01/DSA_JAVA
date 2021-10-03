package ArraysPrac.Searching;

public class SplitArray {
    public static void main(String[] args) {

    }

    public static int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            start = Math.max(nums[i], start);
            end += nums[i];
        }
        while (start < end) {
            int mid = start + (end - start) / 2;

            int pieces = 0;
            int sum = 0;

            for (int elem : nums) {
                sum += elem;
                if (sum > mid) {
                    pieces++;
                    sum = elem;
                }
            }

            if (pieces < m) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}
