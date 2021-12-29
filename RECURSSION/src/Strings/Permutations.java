package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Permutations
 */
public class Permutations {
    public static void main(String[] args) {

        ArrayList<String> ans = permutation("", "abc");
        System.out.println(ans);

        // int n = permutationCount("", "abc");
        // System.out.println(n);

      
        // ArrayList<String> ans = dice("", 4);
        // System.out.println(ans);

    }

    private static ArrayList<String> dice(String p, int target) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        for (int i = 1; i <= 6 && i <= target; i++) {

            list.addAll(dice(p + i, target - i ));
        }

        return list;
    }

    private static ArrayList<String> permutation(String up, String p) {
        if (p.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(up);
            return list;
        }

        int n = up.length();
        char c = p.charAt(0);
        p = p.substring(1);

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            ArrayList<String> firstList = permutation(up.substring(0, i) + c + up.substring(i, n), p);
            list.addAll(firstList);
        }

        return list;
    }

    private static int permutationCount(String up, String p) {
        if (p.isEmpty()) {
            return 1;
        }

        int count = 0;
        int n = up.length();
        char c = p.charAt(0);
        p = p.substring(1);

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            count = count + permutationCount(up.substring(0, i) + c + up.substring(i, n), p);
        }

        return count;
    }

    
}