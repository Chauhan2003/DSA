package heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class IncreasingFrequencySort {
    static class Pair {
        int ele;
        int freq;

        Pair(int ele, int freq) {
            this.ele = ele;
            this.freq = freq;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3};

        Map<Integer, Integer> map = new HashMap<>();
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.freq != b.freq) return a.freq - b.freq;
            return b.ele - a.ele;
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        int i = 0;
        while(!minHeap.isEmpty()) {
            Pair newPair = minHeap.poll();
            int element = newPair.ele;
            int frequency = newPair.freq;

            while(frequency > 0) {
                nums[i++] = element;
                frequency--;
            }
        }

        System.out.println("Sorted in increasing frequency: " + Arrays.toString(nums));
    }
}
