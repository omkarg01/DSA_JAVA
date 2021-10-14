package Arrays;

public class IsSorted {
    public static void main(String[] args) {
        int[] arr = { 2, 4, 3, 5, 8 };
        System.out.println(isSorted2(arr, 0));
    }

    private static boolean isSorted(int[] arr, int i) {
        if (i == arr.length - 1 || arr.length == 1) {
            return true;
        }
        if (arr[i] < arr[i + 1]) {
            return isSorted(arr, i + 1);
        } else {
            return false;
        }
    }

    private static boolean isSorted2(int[] arr, int i) {
        if (i == arr.length - 1 || arr.length == 1) {
            return true;
        }

        // if true find in the next part of the array, if false no need to find in the
        // next part of the array
        return arr[i] < arr[i + 1] && isSorted(arr, i + 1);
    }
}
