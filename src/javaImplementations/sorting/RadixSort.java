package javaImplementations.sorting;

import java.util.Arrays;
import java.util.HashSet;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr;

        for (int i = 1; i <= 3; i++) {
            arr = SortingUtils.generateArray(i, 10);

            radixSort(arr);

            System.out.println(Arrays.toString(arr));
        }
    }

    static void radixSort(int[] arr) {
        int largestPosition = calcLargestPosition(arr);

        for (int l = 0, k = 0; l < largestPosition; l++, k = 0) {

            int[] clone = arr.clone();

            HashSet<Integer> checked = new HashSet<>();

            for (int i = 0; i <= 9; i++) {

                for (int j = 0; j < arr.length; j++) {

                    if (!checked.contains(j)) {
                        int e = (clone[j] / (int) Math.pow(10, l)) % 10;

                        if (e == i && checked.add(j)) arr[k++] = clone[j];
                    }
                }
            }
        }
    }

    private static int calcLargestPosition(int[] arr) {
        int max = 0;
        for (int i : arr) max = Math.max(i, max);

        int count = 1;
        while ((max /= 10) > 0) count++;

        return count;
    }
}
