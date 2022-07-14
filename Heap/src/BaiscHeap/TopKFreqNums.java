package BaiscHeap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFreqNums {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 2, 2, 3 };
        int k = 3;
        int[] ans = freqNums(nums, k);
        for (int i : ans) {
            System.out.println(i);
        }
    }

    private static class Pair {
        int key, value;

        Pair(int freq, int num) {
            this.key = freq;
            this.value = num;
        }

        @Override
        public String toString() {
            return "{" + key + " : " + value +
                    "}";
        }

    }

    private static int[] freqNums(int[] nums, int k) {
        PriorityQueue<Pair> heap = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                System.out.println("pair comparator " + a.key + " " + b.key);
                return a.key - b.key;
            }
        });

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        System.out.println(map);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Pair pair = new Pair(entry.getValue(), entry.getKey());
            heap.add(pair);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] arr = new int[k];
        int i = 0;

        while (heap.size() > 0) {
            System.out.println(heap.peek().toString());
            arr[i++] = heap.poll().key;
        }

        return arr;
    }

}
