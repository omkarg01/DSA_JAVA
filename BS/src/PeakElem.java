public class PeakElem {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int target = 9;
        int ans = findPeakElement(arr);
        System.out.println(ans);
    }

    public static int findPeakElement(int[] nums) {
        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (mid > 0 && mid < nums.length - 1) {
                if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                    return mid;
                } else if (nums[mid] < nums[mid + 1]) {
                    s = mid + 1;
                } else if (nums[mid] < nums[mid - 1]) {
                    e = mid - 1;
                }
            } else if (mid == 0) {
                if (nums[0] > nums[mid + 1]) {
                    return 0;
                } else {
                    return 1;
                }
            } else if (mid == nums.length - 1) {
                if (nums[nums.length - 1] > nums[nums.length - 2]) {
                    return nums.length - 1;
                } else {
                    return nums.length - 2;
                }
            }
        }
        return -1;
    }
}
