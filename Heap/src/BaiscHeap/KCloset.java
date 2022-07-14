package BaiscHeap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class KCloset {
  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5 };
    int x = 3;
    int k = 4;

    // List<Integer> ansList = usingListInHeap(arr, x, k);
    // System.out.println(ansList);

    List<Integer> ansList = usingListInHeap(arr, x, k);
    System.out.println(ansList);

  }

  private static class Pair {
    int key, value;

    Pair(int diff, int num) {
      this.key = diff;
      this.value = num;
    }
  }

  public static List<Integer> usingPairInHeap(int[] arr, int k, int x) {
    PriorityQueue<Pair> heap = new PriorityQueue<Pair>(new Comparator<Pair>() {
        public int compare(Pair a, Pair b) {
            if (b.key == a.key) return b.value - a.value;
            return b.key - a.key;
        }
    });
    for (int i : arr) {
        heap.add(new Pair(Math.abs(i - x), i));
        if (heap.size() > k) 
            heap.remove();
    }
    List<Integer> res = new ArrayList<Integer>();
    for (int i = 0; i < k; i++) res.add(heap.remove().value);
    Collections.sort(res);
    return res;
}

  private static List<Integer> usingListInHeap(int[] arr, int x, int k) {
    PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>(new Comparator<List<Integer>>() {
      @Override
      public int compare(List<Integer> o1, List<Integer> o2) {
        if (o1.get(0) < o2.get(0)) {
          return 1;
        } else {
          return -1;
        }
      }
    });

    for (int i = 0; i < arr.length; i++) {
      List<Integer> arr2 = new ArrayList<>();
      arr2.add(Math.abs(arr[i] - x));
      arr2.add(arr[i]);
      maxHeap.add(arr2);
      if (maxHeap.size() > k) {
        maxHeap.poll();
      }
    }

    // while (maxHeap.size() > 0) {
    // System.out.println(maxHeap.poll());
    // }

    List<Integer> ansList = new ArrayList<>();
    while (maxHeap.size() > 0) {
      ansList.add(maxHeap.poll().get(1));
    }
    Collections.sort(ansList);
    return ansList;
  }

}
