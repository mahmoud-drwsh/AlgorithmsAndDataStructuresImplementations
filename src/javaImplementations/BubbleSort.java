package javaImplementations;import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

        System.out.println("array to sort using bubble sort: ");
        System.out.println(Arrays.toString(arr));
        System.out.println();

        sort(arr);

        System.out.println();
        System.out.println("final result: " + Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int step = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int a = arr[j];
                int b = arr[j + 1];

                if (a > b) {
                    swap(arr, j, j + 1);
                    System.out.printf("step #%d: %s", step++, Arrays.toString(arr));
                    System.out.println();
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        System.out.printf("swapping arr[%d]=%d with arr[%d]=%d", i, arr[i], j, arr[j]);
        System.out.println();
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
