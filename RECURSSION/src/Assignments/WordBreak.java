package Assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String[] wordDict = { "apple", "pen", "applepen", "pine", "pineapple" };
        List<String> ans = wordBreak("pineapplepenapple", Arrays.asList(wordDict));
        // System.out.println(ans);

        int min = Integer.MIN_VALUE;

    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        return recursiveList(wordDict, "", s);
    }

    private static List<String> recursiveList(List<String> wordDict, String p, String up) {
        if (up.isEmpty()) {
            List<String> ans = new ArrayList<>();
            ans.add(p.stripTrailing());
            return ans;
        }

        List<String> ansList = new ArrayList<>();

        int l = up.length();

        for (int i = 1; i <= l; i++) {
            String left = up.substring(0, i);
            if (wordDict.contains(left)) {
                List<String> list = recursiveList(wordDict, p + left + " ", up.substring(i));
                ansList.addAll(list);
            }
        }

        return ansList;
    }

    // private static List<String> recursiveList(List<String> wordDict, String up, String p) {
    //     if (p.isEmpty()) {
    //         List<String> ans = new ArrayList<>();
    //         ans.add(up.stripTrailing());
    //         // System.out.println(up);
    //         return ans;
    //     }

    //     List<String> ansList = new ArrayList<>();

    //     for (int i = 0; i < p.length(); i++) {
    //         String left = p.substring(0, i + 1);
    //         if (wordDict.contains(left)) {
    //             List<String> list = recursiveList(wordDict, up + left + " ", p.substring(i +
    //                     1));
    //             ansList.addAll(list);
    //         }
    //     }
    //     return ansList;
    // }

    private static void recursiveStr(List<String> wordDict, String up, String p) {
        if (p.isEmpty()) {
            System.out.println(up);
            return;
        }

        for (int i = 0; i < p.length(); i++) {
            String left = p.substring(0, i + 1);
            if (wordDict.contains(left)) {
                recursiveStr(wordDict, up + " " + left, p.substring(i + 1));
            }
        }
    }
}
