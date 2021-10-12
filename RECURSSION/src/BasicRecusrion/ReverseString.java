package BasicRecusrion;
import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] arr = { 'h', 'e', 'l', 'l', 'o' };
        reverseString(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(char[] s) {
        reverseString(s, 0, s.length - 1);
    }

    public static void reverseString(char[] arr, int s, int e) {
        if (s > e) {
            return;
        }
        char temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;

        reverseString(arr, s + 1, e - 1);
    }

    public static void reverseArray(int[] arr, int s, int e) {
        if (s > e) {
            return;
        }
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;

        reverseArray(arr, s + 1, e - 1);
    }
}
