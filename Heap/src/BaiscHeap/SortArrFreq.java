package BaiscHeap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class SortArrFreq {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3, 3 };
        int[] ans = sortArr(nums);
        System.out.println(ans);
    }

    private static int[] sortArr(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == o2) {
                    // int a = map.get(o1);
                    // int b = map.get(o2);
                    return o2 - o1;
                }
                return o1 - o2;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        System.out.println(map);
        return null;
    }

}
