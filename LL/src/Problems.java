import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problems {
    public static void main(String[] args) {
        // int[] arr = { 4, 3, 2, 7, 8, 2, 3, 1 };
        // List<Integer> l = findDisappearedNumbers(arr);
        // System.out.println(l);

        ll();
    }

    public static void ll() {
        LinkedList<ArrayList<Integer>> ll = new LinkedList<>();
        ArrayList<Integer> arrli1 = new ArrayList<Integer>(2);
        arrli1.add(0, 1);
        arrli1.add(1, 5);

        ArrayList<Integer> arrli2 = new ArrayList<Integer>(2);
        arrli2.add(0, 2);
        arrli2.add(1, 6);

        ll.add(arrli1);
        ll.add(arrli2);

        System.out.println(ll);

    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List li = new ArrayList<Integer>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }
        for (i = 0; i < nums.length; i++) // to check numbers are at correct index or not
        {
            if (nums[i] != i + 1)
                li.add(i + 1);
        }
        return li;
    }

    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }
}
