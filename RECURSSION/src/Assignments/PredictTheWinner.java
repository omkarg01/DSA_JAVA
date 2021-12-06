package Assignments;

import java.util.ArrayList;

public class PredictTheWinner {
    public static void main(String[] args) {
        predictTheWinner(new int[]{1, 5, 2, 3 ,7});
        System.out.println(flag);
    }

    static boolean flag = false;

    public static boolean predictTheWinner(int[] nums) {
        ArrayList<Integer> list = func1(nums);
        recursive(list, 0, 0);
        return flag;
    }

    private static void recursive(ArrayList<Integer> list, int p1, int p2) {
        if (list.isEmpty()) {
            if (p1 > p2) {
                flag = true;
            }
            return;
        }

        // start
        p1 = p1 + list.get(0);
        list.remove(0);
        p2 = p2 + (list.get(0) < list.get(list.size() - 1) ? list.get(0) : list.get(list.size() - 1));
        if (list.get(0) < list.get(list.size() - 1)) {
            list.remove(0);
        } else {
            list.remove(list.size() - 1);
        }
        recursive(list, p1, p2);
        // end

        // return false;
    }

    public static ArrayList<Integer> func1(int arr[]) {
        ArrayList<Integer> array_list = new ArrayList<Integer>();

        // Using add() method to add elements in array_list
        for (int i = 0; i < arr.length; i++)
            array_list.add(arr[i]);

        return array_list;
    }
}
