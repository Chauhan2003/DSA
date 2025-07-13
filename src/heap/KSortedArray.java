package heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KSortedArray {
    public static void main(String[] args) {
        int[] arr = {7, 5, 3, 2, 8, 10,9};
        int k = 3;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i=0;i<=k;i++) {
            minHeap.offer(arr[i]);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int j=k+1;j<arr.length;j++) {
            minHeap.offer(arr[j]);
            if (minHeap.size() > k+1) {
                res.add(minHeap.poll());
            }
        }

        while(!minHeap.isEmpty()) {
            res.add(minHeap.poll());
        }

        System.out.println(res);
    }
}