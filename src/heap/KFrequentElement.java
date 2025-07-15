package heap;

import java.util.*;

public class KFrequentElement {
    static class Pair {
        int ele;
        int freq;

        Pair(int ele, int freq) {
            this.ele = ele;
            this.freq = freq;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 4, 5, 2, 6, 1};
        int k = 2;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.freq != b.freq) return a.freq - b.freq;
            return b.ele - a.ele;
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.offer(new Pair(entry.getKey(), entry.getValue()));
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!minHeap.isEmpty()) {
            res.add(minHeap.poll().ele);
        }

        System.out.println("K frequent element: " + res);
    }
}
