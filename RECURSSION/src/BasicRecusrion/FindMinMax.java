package BasicRecusrion;
public class FindMinMax {
    public static void main(String[] args) {
        int[] arr = { 4, 7, 2, 5, 1 };
        int min = min(arr, 0, arr.length);
        int max = max(arr, 0, arr.length);
        System.out.println(min);
        System.out.println(max);
    }

    public static int min(int arr[], int i, int n) {
        return (n == 1) ? arr[i] : Math.min(arr[i], min(arr, i + 1, n - 1));
    }
    public static int max(int arr[], int i, int n) {
        return (n == 1) ? arr[i] : Math.max(arr[i], max(arr, i + 1, n - 1));
    }
}
