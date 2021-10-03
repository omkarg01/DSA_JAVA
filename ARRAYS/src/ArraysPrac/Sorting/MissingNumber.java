package ArraysPrac.Sorting;


public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = { 3 , 0 ,1 };
        int ans = missingNumber(arr);
        System.out.println(ans);
    }

    public static int missingNumber(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != i && arr[i] < arr.length) {
                swap(arr, i, arr[i]);
            } else {
                i++;
            }
        }
        // System.out.println(Arrays.toString(arr));

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j) {
                return j;
            }
        }

        return arr.length;
    }

    private static boolean swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return true;
    }
}
