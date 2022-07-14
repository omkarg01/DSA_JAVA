package Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        // dict.add("aa");
        // dict.add("aaa");
        // boolean b = wordBreak("aaaaaaa", dict);
        // System.out.println(b);
        // System.out.println(map);

        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");

        wordBreakII(dict, "", "catsanddog", 0);
        System.out.println(l);

        // List<String> ans = new ArrayList<>();
        // Set<String> set = new HashSet<>();
        // for (String word : dict) {
        //     set.add(word);
        // }
        
        // solve("catsanddog", 0, set, ans, new StringBuilder());
        // System.out.println(ans);

    }

    private static void wordBreakII(List<String> dict, String p, String up, int index) {
        if (index == up.length()) {
            l.add(p.strip());
            // System.out.println(p);
            return;
        }

        for (int i = index + 1; i <= up.length(); i++) {
            String left = up.substring(index, i);
            // System.out.println(left);
            if (dict.contains(left)) {
                // System.out.println(p);
                wordBreakII(dict, p + left + " ", up, i);
            }
        }
    }

    private static void solve(String s, int index, Set<String> set, List<String> ans, StringBuilder sb) {
        if (index == s.length()) {
            ans.add(sb.toString().trim());
            return;  
        }
        
        int sbStart = sb.length();        
        for (int i=index+1; i<=s.length(); i++) {
            String substring = s.substring(index,i);
            if (set.contains(substring)) {
                
                sb.append(substring);
                sb.append(" ");
                
                solve(s, i, set, ans, sb);
                
                sb.delete(sbStart, sb.length());
                
            }
        }
        
    }

    static List<String> l = new ArrayList<>();

    // private static void wordBreakII(List<String> dict, StringBuilder p, String up) {
    //     if (up.isEmpty()) {
    //         l.add(p.toString().trim());
    //         return;
    //     }

    //     int sbStart = p.length();        

    //     for (int i = 1; i <= up.length(); i++) {
    //         String left = up.substring(0, i);
    //         if (dict.contains(left)) {
    //             p.append(left);
    //             p.append(" ");
    //             wordBreakII(dict, p, up.substring(i));
    //             p.delete(sbStart, p.length());
    //         }
    //     }

    // }

    

   

    // private static List<String> wordBreakII(List<String> dict, String p, String
    // up) {
    // if (up.isEmpty()) {
    // List<String> list = new ArrayList<>();
    // list.add(p.stripLeading());
    // return list;
    // }

    // List<String> list = new ArrayList<>();
    // for (int i = 1; i <= up.length(); i++) {
    // String left = up.substring(0, i);
    // if (dict.contains(left)) {
    // List<String> comb = wordBreakII(dict, p + " " + left, up.substring(i,
    // up.length()));
    // list.addAll(comb);
    // }

    // }
    // return list;
    // }

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

    static Map<String, Boolean> map = new HashMap<>();

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.contains(s)) {
            return true;
        }

        if (map.containsKey(s)) {
            return map.get(s);
        }

        for (int i = 1; i <= s.length(); i++) {
            String left = s.substring(0, i);
            if (wordDict.contains(left) && wordBreak(s.substring(i), wordDict)) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }

}
