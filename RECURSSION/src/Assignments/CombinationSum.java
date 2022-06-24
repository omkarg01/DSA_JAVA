package Assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * CombinationSum
 */
public class CombinationSum {
    public static void main(String[] args) {
        // List<List<Integer>> list = combinationSum(new int[] { 1, 2, 3 }, 5);
        // System.out.println(list);

        System.out.println(combinationSum(new int[]{7, 2, 6, 5}, 16));
    }

    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        // add your code here
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        recursion(A, B, 0, new ArrayList<>(), ans);
        
        return ans;
    }

    static void recursion(ArrayList<Integer> arr, int target, int index, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans){
        if (index == arr.size()){
            if (target == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        
        if(target >= arr.get(index)){
            list.add(arr.get(index));
            recursion(arr, target - arr.get(index), index, list, ans);
            list.remove(arr.size() - 1);
        }
        recursion(arr, target, index + 1, list, ans);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] cand, int start, int target, List<Integer> list, List<List<Integer>> result) {
        if (target < 0)
            return;
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < cand.length; i++) {
            list.add(cand[i]);
            backtrack(cand, i, target - cand[i], list, result);
            list.remove(list.size() - 1);
        }
    }   

}