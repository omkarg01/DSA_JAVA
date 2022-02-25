package Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Poblems {
    public static void main(String[] args) {
        // List<String> l = permutationStrings("", "abc");
        // System.out.println(l);

        // System.out.println();
        // List<String> l = phoneDial("", "23");
        // System.out.println(l);

        // String str = countAndSay(4);
        // System.out.println(str);



        // List<String> dict = new ArrayList<>();
        // dict.add("aaaa");
        // dict.add("aaa");
        // boolean b = wordBreak("aaaaaaa", dict, new HashMap<>() );

        // System.out.println(b);



        // List<String> dict = new ArrayList<>();
        // dict.add("cat");
        // dict.add("cats");
        // dict.add("and");
        // dict.add("sand");
        // dict.add("dog");

        // List<String> l = wordBreakII(dict, "", "catsanddog");
        // System.out.println(l);


        
        


    }

    private static List<String> wordBreakII(List<String> dict, String p, String up) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p.stripLeading());
            return list;
        }

        List<String> list = new ArrayList<>();
        for (int i = 1; i <= up.length(); i++) {
            String left = up.substring(0, i);
            if (dict.contains(left)) {
                List<String> comb = wordBreakII(dict, p + " " + left, up.substring(i, up.length()));
                list.addAll(comb);
            }
        

        // return list;
    }

    public static List<String> permutationStrings(String p, String up) {
        if (up.isEmpty()) {

            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char c = up.charAt(0);
        int n = p.length();

        List<String> list = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            List<String> perms = permutationStrings(p.substring(0, i) + c + p.substring(i, n), up.substring(1));
            list.addAll(perms);
        }

        return list;
    }

    public static List<String> phoneDial(String p, String up) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> list = new ArrayList<>();

        int digit = up.charAt(0) - '0';
        up = up.substring(1);

        for (int i = 1; i <= 3; i++) {
            char c = (char) ((3 * (digit - 2)) + i + 96);
            List<String> dials = phoneDial(p + c, up);
            list.addAll(dials);
        }

        return list;
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        if (n == 2) {
            return "11";
        }

        String res = countAndSay(n - 1);
        int count = 1;
        String newRes = "";

        for (int i = 1; i < res.length(); i++) {
            if (res.charAt(i) != res.charAt(i - 1)) {
                newRes += count;
                newRes += res.charAt(i - 1);
                count = 1;
            } else {
                count++;
            }

            if (i == res.length() - 1) {
                newRes += count;
                newRes += res.charAt(i);
            }
        }

        return newRes;
    }

    public static boolean wordBreak(String s, List<String> wordDict, Map<String, Boolean> map) {
        if (wordDict.contains(s)) {
            return true;
        }

        if (map.containsKey(s)) {
            return map.get(s);
        }

        for (int i = 1; i < s.length(); i++) {
            if (wordDict.contains(s.substring(0, i)) && wordBreak(s.substring(i, s.length()), wordDict, map)) {
                map.put(s.substring(0, i), true);
                return true;
            }
        }

        return false;
    }

}
