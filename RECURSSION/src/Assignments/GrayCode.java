package Assignments;

import java.util.ArrayList;

public class GrayCode {
    public static void main(String[] args) {
        System.out.println(graycode(3));
    }

    public static ArrayList<String> graycode(int n) {
        if (n == 1) {
            ArrayList<String> bres = new ArrayList<>();    
            bres.add("0");
            bres.add("1");
            return bres;
        }

        ArrayList<String> rres = graycode(n - 1);
        ArrayList<String> mres = new ArrayList<>();

        for (int i = 0; i < rres.size(); i++) {
            String ci = rres.get(i);
            mres.add("0" + ci);
        }

        for (int i = rres.size() - 1; i >= 0; i--) {
            String ci = rres.get(i);
            mres.add("1" + ci);
        }

        return mres;
    }
}
