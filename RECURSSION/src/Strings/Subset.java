package Strings;

import java.util.ArrayList;
import java.util.Arrays;

public class Subset {
    public static void main(String[] args) {
        // subseq("", "abc");
        // System.out.println(subSeqAscci("", "abc"));
        // ArrayList<ArrayList<Integer>> ans = subSeqItrDuplicate(new int[] { 2, 1, 2
        // });
        // for (ArrayList<Integer> arrayList : ans) {
        // System.out.println(arrayList);
        // }


    }

    private static void subseq(String p, String up) {
        if (up.isEmpty()) {
            System.err.println(p);
            return;
        }

        char ch = up.charAt(0);
        subseq(p + ch, up.substring(1));
        subseq(p, up.substring(1));
    }

    private static ArrayList<String> subseqList(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList();

        char ch = up.charAt(0);
        ArrayList<String> takeIt = subseqList(p + ch, up.substring(1));
        ArrayList<String> ignoreIt = subseqList(p, up.substring(1));

        list.addAll(takeIt);
        list.addAll(ignoreIt);

        return list;
    }

    private static ArrayList<String> subSeqAscci(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList();

        char ch = up.charAt(0);
        ArrayList<String> takeIt = subSeqAscci(p + ch, up.substring(1));
        ArrayList<String> ignoreIt = subSeqAscci(p, up.substring(1));
        ArrayList<String> takeItAscii = subSeqAscci(p + (int) ch, up.substring(1));

        list.addAll(takeIt);
        list.addAll(takeItAscii);
        list.addAll(ignoreIt);

        return list;
    }

    private static ArrayList<ArrayList<Integer>> subSeqItr(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> outerList = new ArrayList<>();
        ArrayList<Integer> empList = new ArrayList<>();
        outerList.add(empList);

        for (int each : arr) {
            int n = outerList.size();
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> insideList = new ArrayList<>(outerList.get(i));
                insideList.add(each);
                outerList.add(insideList);
            }
        }

        return outerList;
    }

    private static ArrayList<ArrayList<Integer>> subSeqItrDuplicate(int[] arr) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> outerList = new ArrayList<>();
        ArrayList<Integer> empList = new ArrayList<>();
        outerList.add(empList);

        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            start = 0;
            if (i > 0 && arr[i] == arr[i - 1]) {
                start = end + 1;
            }
            end = outerList.size() - 1;
            int n = outerList.size();
            for (int j = start; j < n; j++) {
                ArrayList<Integer> insideList = new ArrayList<>(outerList.get(j));
                insideList.add(arr[i]);
                outerList.add(insideList);
            }
        }

        return outerList;
    }

    // Permutations
   

}
