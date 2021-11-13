package Strings;

import java.util.ArrayList;

public class PhonePad {
    public static void main(String[] args) {
        // ArrayList<String> ans = pad("", "12");
        // System.out.println(ans);

    }

    private static ArrayList<String> pad(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0';
        ArrayList<String> li = new ArrayList<>();

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char c = (char) ('a' + i);
            ArrayList<String> perm = pad(p + c, up.substring(1));
            li.addAll(perm);
        }

        return li;
    }
}
