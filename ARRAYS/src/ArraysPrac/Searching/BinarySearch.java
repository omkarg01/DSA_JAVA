package ArraysPrac.Searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { -4, -1, 0, 1, 2, 4, 9, 12, 15, 25, 36, 45 };
        int target = 0;
        int ans = binarySearch(arr, target);
        System.out.println(ans);

    }

    private static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
