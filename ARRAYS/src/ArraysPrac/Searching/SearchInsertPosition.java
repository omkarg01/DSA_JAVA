package ArraysPrac.Searching;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 6, 9, 10, 12, 15 };
        int target = 11;
        int ans = searchInsert(arr, target);
        System.out.println(ans);
    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if (target > nums[end]) {
            return end + 1;
        }
        if (target < nums[start]) {
            return start;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
           
        }
        return end + 1;
    }
}
