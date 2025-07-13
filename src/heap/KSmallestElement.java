package heap;

import java.util.PriorityQueue;
import java.util.Collections;

public class KSmallestElement {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        // Create a max-heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int num : arr) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        if (!maxHeap.isEmpty()) {
            System.out.println(k + "the smallest element is: " + maxHeap.peek());
        } else {
            System.out.println("Array is empty or k is invalid");
        }
    }
}
