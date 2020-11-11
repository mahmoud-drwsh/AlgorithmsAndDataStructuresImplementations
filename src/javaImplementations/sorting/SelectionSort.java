package javaImplementations.sorting;import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 2, 1};

        System.out.println(Arrays.toString(arr) + "\n");

        sort(arr);
    }

    private static void sort(int[] arr) {
        int step = 1;

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                System.out.println("Step #:" + step++);
                System.out.printf("Swapping elements arr[%d]=%d and arr[%d]=%d %n", i, arr[i], minIndex, arr[minIndex]);
                swap(arr, i, minIndex);
                System.out.println("result: " + Arrays.toString(arr));
                System.out.println("\n");
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
