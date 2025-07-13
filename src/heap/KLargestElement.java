package heap;

import java.util.PriorityQueue;

public class KLargestElement {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int ele : arr) {
            minHeap.offer(ele);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        if (!minHeap.isEmpty()) {
            System.out.println(k + "the largest element is: " + minHeap.peek());
        } else {
            System.out.println("Array is empty or k is invalid");
        }
    }
}
