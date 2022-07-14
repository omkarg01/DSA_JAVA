public class FloorInSorted {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 8, 10, 10, 19 };
        int target = 9;
        int ans = bs(arr, target, arr.length);
        System.out.println(ans);
    }

    private static int bs(int[] arr, int target, int n) {
        if (target >= arr[n - 1]){
            return n - 1;
        }
        int s = 0;
        int e = n - 1;

        while (s < e) {
            int mid = s + (e - s) / 2;
            if (mid + 1 < arr.length && arr[mid] <= target && target < arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > target) {
                e = mid;
            } else {
                s = mid + 1;

            }
        }

        return -1;
    }
}
