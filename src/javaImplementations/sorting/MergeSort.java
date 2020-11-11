package javaImplementations.sorting;import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {7, 1, 2, 3, 4, 3, 5, 2, 1, 2, 1};

        System.out.print("array to mergeSort: ");
        System.out.println(Arrays.toString(arr));
        System.out.println();
        System.out.println();

        mergeSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr) {
        int l = arr.length;
        int m = l / 2;

        if (l > 1) {
            int[] arrL = Arrays.copyOfRange(arr, 0, m);
            int[] arrR = Arrays.copyOfRange(arr, m, l);

            mergeSort(arrL);
            mergeSort(arrR);

            System.out.printf("merging %s and %s", Arrays.toString(arrL), Arrays.toString(arrR));
            System.out.println();
            merge(arr, arrL, arrR);

            System.out.printf("result after merging: %s", Arrays.toString(arr));
            System.out.println();
            System.out.println();
        }
    }

    private static void merge(int[] arr, int[] arrL, int[] arrR) {
        int j = 0, k = 0, i = 0;

        for (; (i < arr.length) && (k < arrR.length) && (j < arrL.length); i++)
            if (arrL[j] < arrR[k])
                arr[i] = arrL[j++];
            else
                arr[i] = arrR[k++];

        while (j < arrL.length)
            arr[i++] = arrL[j++];

        while (k < arrR.length)
            arr[i++] = arrR[k++];
    }
}
