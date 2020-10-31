package javaImplementations;

import java.util.Arrays;
import java.util.stream.IntStream;

public class QuickSort {
    public static void main(String[] args) {
        // generating an array with random elements to sort
        int[] arr = IntStream
                .generate(() -> (int) (Math.random() * 12))
                .limit(10)
                .toArray();

        // the array to sort
        System.out.printf("the array to sort: %s %n", Arrays.toString(arr));

        //sorting the array with QuickSort algorithm
        quickSort(arr, 0, arr.length - 1);

        //printing the sorted array
        System.out.printf("the sorted array : %s %n", Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int l, int r) {
        // base case #1: if the start and end indices are the same or have illegal values
        if (l >= r) return;

        // find the index where to split the array in half
        int pivot = partition(arr, l, r);

        // sort the left side
        quickSort(arr, l, pivot - 1);
        // sort the right side
        quickSort(arr, pivot + 1, r);
    }

    static int partition(int[] arr, int l, int r) {
        /*
         * in this implementation of the algorithm the last element is always the pivot
         * so, pivot = r
         */

        // the beginning index of where the insert an element less than the pivot
        int insertionIndex = l;

        // shifting all the elements that are less than the pivot to the left side of the array
        for (int i = l; i < r; i++)
            if (arr[r] > arr[i])
                SortingUtils.swap(arr, i, insertionIndex++);

        // inserting the pivot in its right position by swapping it with the element there
        SortingUtils.swap(arr, insertionIndex, r);

        // returning the new index of the pivot
        return insertionIndex;
    }
}
