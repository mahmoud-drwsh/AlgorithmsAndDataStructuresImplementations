package javaImplementations.searching;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BinarySearch {
    public static void main(String[] args) {
        // generate a random unsorted array
        int[] arr = generateRandomArray(16, 5);

        // this variable determines the order of sorting
        // and also determines how binary search will be performed
        // it'll be assigned a boolean value randomly
        boolean ascendingOrder = Math.random() * 100 > 50;

        // sort the array using QuickSort
        quickSort(arr, 0, arr.length - 1, ascendingOrder);


        // print information about the sorting and searching algorithms
        System.out.printf("the array will be sorted in %s order %n", (ascendingOrder ? "an ascending" : "a descending"));

        // print the generated array to the user
        System.out.println("The generated array:");
        System.out.println(Arrays.toString(arr) + "\n\n");

        // used for storing the number the user wants to search for
        int numberToLookFor = askUserForNumberToLookFor();

        // do the binary search
        int index;

        while (numberToLookFor != -9) {
            // do the binary search
            index = binarySearch(arr, ascendingOrder, numberToLookFor, 0, arr.length - 1);

            // check the result of the search
            checkSearchResult(arr, numberToLookFor, index);

            // ask the user to enter a number to look for
            numberToLookFor = askUserForNumberToLookFor();
        }
    }

    private static int askUserForNumberToLookFor() {
        int numberToLookFor;
        // ask the user to enter a number to look for
        System.out.println("(input -9 to finish the program)");
        System.out.println("enter the number you want to search for:");
        numberToLookFor = new Scanner(System.in).nextInt();
        return numberToLookFor;
    }

    private static void quickSort(int[] arr, int l, int r, boolean ascendingOrder) {
        // if left is greater than right it means we don't have an array to sort
        if (l >= r) return;

        // will be equal to the index of the pivot after the partitioning
        int j = l;

        /*
         * moving all of the elements that are less than or greater the last element
         * depending on the value of the parameter ascendingOrder
         */
        for (int i = j; i < r; i++) {
            if (ascendingOrder ? arr[i] < arr[r] : arr[i] > arr[r]) swap(arr, j++, i);
        }

        // put the pivot in its right place
        swap(arr, j, r);

        // sort the right half
        quickSort(arr, l, j - 1, ascendingOrder);
        // sort the left half
        quickSort(arr, j + 1, r, ascendingOrder);
    }

    private static void checkSearchResult(int[] arr, int numberToLookFor, int index) {
        if (index > -1) {
            int countOfOccurrences = countOccurrences(arr, numberToLookFor, index);

            System.out.printf("%d is found once at index %d in the array %n", numberToLookFor, index);

            System.out.printf("%d is found %d times in the array %n", numberToLookFor, countOfOccurrences);
        } else {
            System.out.printf("%d is not found %n", numberToLookFor);
        }
        System.out.println("\n");
    }

    private static int countOccurrences(int[] arr, int number, int index) {
        int count = 0;

        // count the number of elements to the left of the index
        for (int i = index; i >= 0; i--)
            if (arr[i] == number) count++;

        // count the number of elements to the right of the index
        for (int i = index + 1; i < arr.length; i++)
            if (arr[i] == number) count++;

        return count;
    }

    static int binarySearch(int[] arr, boolean ascendingOrder, int element, int bottom, int top) {
        // if this condition is met we conclude that the element we're looking for isn't in the array
        if (top < bottom) return -1;

        // calculating the middle index
        int middleIndex = bottom + ((top - bottom) / 2);

        // if the element at middleIndex is the number we're looking for we just return middleIndex
        if (arr[middleIndex] == element)
            return middleIndex;
        else if (arr[middleIndex] < element && ascendingOrder)
            // perform a binary search on the right half
            return binarySearch(arr, ascendingOrder, element, middleIndex + 1, top);
        else
            // perform a binary search on the left half
            return binarySearch(arr, ascendingOrder, element, bottom, middleIndex - 1);
    }

    private static int[] generateRandomArray(int length, int maxValue) {
        return IntStream
                .generate(() -> (int) (Math.random() * maxValue))
                .limit(length)
                .toArray();
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
