package Assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String[] wordDict = { "cat", "cats", "and", "sand", "dog" };
        List<String> ans = wordBreak("catsanddog", Arrays.asList(wordDict));
        System.out.println(ans);
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        return recursiveList(wordDict, "", s);
    }

    private static List<String> recursiveList(List<String> wordDict, String up, String p) {
        if (p.isEmpty()) {
            List<String> ans = new ArrayList<>();
            ans.add(up.stripTrailing());
            // System.out.println(up);
            return ans;
        }

        List<String> ansList = new ArrayList<>();

        for (int i = 0; i < p.length(); i++) {
            String left = p.substring(0, i + 1);
            if (wordDict.contains(left)) {
                List<String> list = recursiveList(wordDict, up + left + " ", p.substring(i + 1));
                ansList.addAll(list);
            }
        }
        return ansList;
    }

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
