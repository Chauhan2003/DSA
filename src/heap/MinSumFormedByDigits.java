package heap;

import java.util.PriorityQueue;

public class MinSumFormedByDigits {
    public static void main(String[] args) {
        int[] arr = {6, 8, 4, 5, 2, 3};

        long num1 = 0;
        long num2 = 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int ele : arr) {
            minHeap.offer(ele);
        }

        while(!minHeap.isEmpty()) {
            if (num1 <= num2) {
                num1 = addNumberAtEnd(num1, minHeap.poll());
            } else {
                num2 = addNumberAtEnd(num2, minHeap.poll());
            }
        }

        long res = num1 + num2;
        System.out.println("Min sum: " + res);
    }

    public static long addNumberAtEnd(long num, long val) {
        return num * 10 + val;
    }
}
