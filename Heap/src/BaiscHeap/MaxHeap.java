package BaiscHeap;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap {
    public static void main(String[] args) {


        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(3, Collections.reverseOrder());
        int[] arr = {7, 10, 4, 3, 20, 15};

        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
            if (maxHeap.size() > 3){
                maxHeap.poll();
            }
        }
        System.out.println(maxHeap.peek());
        
    }
}
