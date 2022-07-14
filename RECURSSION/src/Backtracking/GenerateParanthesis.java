package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class GenerateParanthesis {
    public static void main(String[] args) {
        // List<String> a = generateParenthesis(3);
        // System.out.println(a);

        // List<T> list = new ArrayList<>();  
        List<Integer> list = new ArrayList<>();   
            // ans.add(list);  
        int[] nums = {1};
        Arrays.stream(nums).boxed().collect(Collectors.toList());
        System.out.println(list);
    }
    public static List<String> generateParenthesis(int n) {
        solve("", n, n);
        return ans;
    }
    
    static List<String> ans = new ArrayList<>();
    
    public static void solve(String s, int openLeft, int closeLeft){
        if (openLeft == 0 && closeLeft == 0){
            ans.add(s);
            return;
        }
        
        if (openLeft > 0)
            solve(s + "(", openLeft - 1, closeLeft);
        
        if (closeLeft > 0 && openLeft != closeLeft){
            solve(s + ")", openLeft, closeLeft - 1);
        }
    }
}

