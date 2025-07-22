package heap.striver;

public class ArrayRepresentHeap {
    public static void main(String[] args) {
        int[] arr = {90, 15, 10, 7, 12, 2};
        int n = arr.length;
        boolean flag = true;

        for (int i=0;i<=(n-2)/2;i++) {
            int left = 2*i+1;
            int right = 2*i+2;

            if (left < n && arr[i] < arr[left]) {
                flag = false;
                break;
            }
            if(right < n && arr[i] < arr[right]) {
                flag = false;
                break;
            }
        }

        if (flag) System.out.println("Array is max heap");
        else System.out.println("Array is not max heap");
    }
}
