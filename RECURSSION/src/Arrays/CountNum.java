package Arrays;

import java.util.ArrayList;

public class CountNum {
    public static void main(String[] args) {
        int[] nums = { 5, 8, 4, 4, 7 };

        int target = 4;
        ArrayList<Integer> indexeArrayList = new ArrayList<Integer>();
        
        // System.out.println(recursion(nums, target, 0, new ArrayList<Integer>(), indexeArrayList));
        // System.out.println(indexeArrayList);

        System.out.println(recursion2(nums, target, 0));
        
    }

    private static ArrayList<Integer> recursion(int[] nums, int target, int i, ArrayList<Integer> arrayList, ArrayList<Integer> indexeArrayList) {
        if (i == nums.length){
            return arrayList;
        }

        if (nums[i] == target) {
            arrayList.add(i);
        }
        ArrayList<Integer> ans = recursion(nums, target, i + 1, arrayList, indexeArrayList);

        indexeArrayList.add(i);

        return ans;
    }

    private static ArrayList<Integer> recursion2(int[] nums, int target, int i) {
        ArrayList<Integer> list = new ArrayList<>();

        if (i == nums.length){
            return list;
        }

        if (nums[i] == target){
            list.add(i);
        }

        ArrayList<Integer> listFromBelowCalls = recursion2(nums, target, i + 1);

        list.addAll(listFromBelowCalls);

        return list;
    }

    
}
