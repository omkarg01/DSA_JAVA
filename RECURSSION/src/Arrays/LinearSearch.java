package Arrays;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = { 2, 8, 3, 3, 10, 21 };
        int target = 3;
        // System.out.println(find(arr, 0, target));
        // System.out.println(findIndex(arr, 0, target));
        System.out.println(findAllIndex(arr, 0, target));

    }

    private static ArrayList<Integer> findAllIndex(int[] arr, int index, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        if (index == arr.length) {
            return list;
        }

        if (arr[index] == target) {
            list.add(index);
        }

        ArrayList<Integer> ansFromBelowCalls = findAllIndex(arr, index + 1, target);

        list.addAll(ansFromBelowCalls);
        // System.out.println(ansFromBelowCalls);

        return list;
    }

    private static boolean find(int[] arr, int index, int target) {
        if (index == arr.length) {
            return false;
        }

        // if does not exist check in the next part of the array
        // if exist return true
        return arr[index] == target || find(arr, index + 1, target);
    }

    private static int findIndex(int[] arr, int index, int target) {
        if (index == arr.length) {
            return -1;
        }

        if (arr[index] == target) {
            return index;
        } else {
            return findIndex(arr, index + 1, target);
        }

    }
}
