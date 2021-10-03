package ArraysPrac.Searching;

public class FindSmallestLetter {
    public static void main(String[] args) {
        char[] arr = { 'a', 'b', 'c', 'd', 'e' };
        char target = 'b';
        System.out.println(findSmallest(arr, target));
    }


    public static char findSmallest(char[] arr, char target) {
        int ans = binarySearch(arr, target) + 1;
        if (target > arr[arr.length - 1]) {
            return arr[0];
        }
        return arr[ans];
    }

    private static int binarySearch(char[] arr, char target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
