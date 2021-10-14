package Arrays;

public class RBS {
    public static void main(String[] args) {
        int[] arr = { 5, 6, 7, 8, 9, 1, 2, 3 };
        int target = 9;
        System.out.println(search(arr, target, 0, arr.length - 1));
    }

    private static int search(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            return mid;
        }

        if (arr[start] <= arr[mid]) {

            if (arr[mid] >= target && target >= arr[start]) {
                return search(arr, target, start, mid - 1);
            } else {
                return search(arr, target, mid + 1, end);
            }

        }

        if (target >= arr[mid] && target <= arr[end]) {
            return search(arr, target, mid + 1, end);
        }

        return search(arr, target, start, mid - 1);

    }

    // static int search(int[] arr, int target, int s, int e) {
    // if (s > e) {
    // return -1;
    // }

    // int m = s + (e - s) / 2;
    // if (arr[m] == target) {
    // return m;
    // }

    // if (arr[s] <= arr[m]) {
    // if (target >= arr[s] && target <= arr[m]) {
    // return search(arr, target, s, m - 1);
    // } else {
    // return search(arr, target, m + 1, e);
    // }
    // }

    // if (target >= arr[m] && target <= arr[e]) {
    // return search(arr, target, m + 1, e);
    // }

    // return search(arr, target, s, m - 1);
    // }
}
