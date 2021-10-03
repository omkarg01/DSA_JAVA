package ArraysPrac.Sorting;

import java.util.Arrays;

public class SortingTechniques {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 3, 7, 8, 6, 5, 9, 4 };
        // bubbleSort(arr);
        // selectionSort(arr);
        // insertionSort(arr);
        cyclicSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != i + 1) {
                swap(arr, i, arr[i] - 1);
            } else {
                i++;
            }
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapped = swap(arr, j, j + 1);
                }
            }
            if (!swapped) { // !false = true
                break;
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            swap(arr, arr.length - 1 - i, max);
            max = 0;
        }
    }

    private static boolean swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return true;
    }
}
