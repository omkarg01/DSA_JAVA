package Backtracking;

import java.util.ArrayList;
import java.util.List;

class Combination3 {
    public static void main(String[] args) {
        List<List<Integer>> ans = combinationSum3(3, 9);
        System.out.println(ans);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {

        return solve(k, n, new ArrayList<>(), new ArrayList<>(), 1);
    }
    
    public static List<List<Integer>> solve(int k, int n, List<Integer> li, List<List<Integer>> ans, int index){
        if (k == 0 && n == 0){
            List<Integer> l = new ArrayList<>();
            l.addAll(li);
            ans.add(l);
            return ans;
        }
        
        
        for (int i = index; i < 10; i++){
            if (i <= n){
                li.add(i);
                solve(k -1, n - i, li, ans, i + 1);
                li.remove(li.size() - 1);
            }
        }
        
        return ans;
    }
}
