package Assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] arr = { 10, 1, 2, 7, 6, 1, 5 };
        List<List<Integer>> list = combinationSum2(arr, 8);

        for (List<Integer> list2 : list) {
            System.out.println(list2);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        recursive(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void recursive(int[] candidates, int target, int index, ArrayList<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        
        for (int i = index; i < candidates.length; i++) {
            if ((i == index || candidates[i] != candidates[i - 1]) && candidates[i] <= target) {
                current.add(candidates[i]);
                recursive(candidates, target - candidates[i], i + 1, current, result);
                // System.out.println(current);
                current.remove(current.size() - 1);
            }
        }
    }
}
