package heap.striver;

import java.util.Arrays;

public class MinHeapToMaxHeap {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int n = arr.length;

        for (int i = (n - 2) / 2; i >= 0; i--) {
            heapify(n, arr, i);
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void heapify(int n, int[] arr, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(n, arr, largest);
        }
    }
}
