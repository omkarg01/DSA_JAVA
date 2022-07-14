public class MInDIffInSortArr {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 8, 10, 15 };
        int target = 11;

        int minDiff = bs(arr, target, arr.length);
        System.out.println(minDiff);

    }

    private static int bs(int[] arr, int target, int length) {
        int s = 0;
        int e = length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (target > arr[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        // System.out.println(s + " " + e);
        int left = Math.abs(arr[e] - target);
        int right = Math.abs(arr[s] - target);
        System.out.println(left + " " + right);
        int min = Math.min(left, right);
        
        return min == left ? e : s;
    }
}
