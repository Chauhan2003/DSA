package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestElement {
    static class Pair {
        int diff;
        int element;

        public Pair(int diff, int element) {
            this.diff = diff;
            this.element = element;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 11};
        int k = 3;
        int x = 7;

        List<Integer> res = new ArrayList<>();

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> {
            if (b.diff != a.diff) return b.diff - a.diff;
            return b.element - a.element;
        });
        for (int ele : arr) {
            if (ele == x) {
                continue;
            }
            maxHeap.offer(new Pair(Math.abs(ele - x), ele));
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        while(!maxHeap.isEmpty()) {
            res.add(maxHeap.poll().element);
        }

        System.out.println("K closest element to x: " + res);
    }
}

// minHeap:
// PriorityQueue<Integer> minHeap = new PriorityQueue<>();

// maxHeap:
// PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

// Pair::::::::::::::Important
// Pair {
// int var1; -> This one
// int var2;
// }

// minHeap:
// PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a.var1 - b.var1);

// maxHeap:
// PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b.var1 - a.var1);
























