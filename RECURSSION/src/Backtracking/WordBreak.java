package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("apple");
        arr.add("pen");
        boolean ans = solve("applepenapple", 0, arr);
        System.out.println(ans);
    }

    public static boolean solve(String s, int index, List<String> wordDict){
        if (index == s.length()){
            return true;
        }
        
        for (int i = index; i <= s.length(); i++){
            if (wordDict.contains(s.substring(index, i))){
                return solve(s, i, wordDict);
            }
        }
        return false;
    }
}
