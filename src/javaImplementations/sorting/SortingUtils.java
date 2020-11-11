package javaImplementations.sorting;

import java.util.stream.IntStream;

public class SortingUtils {
    public static int[] generateArray(int upTo, int count) {
        return IntStream
                .generate(() -> (int) (Math.random() * upTo))
                .limit(count)
                .toArray();
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
