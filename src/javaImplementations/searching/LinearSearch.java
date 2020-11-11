package javaImplementations.searching;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = generateRandomElementsArray(10, 10);

        System.out.println(Arrays.toString(arr) + "\n");


        System.out.println("please input the value that you want to search for: ");
        int numberToLookFor = new Scanner(System.in).nextInt();

        // searching the array
        int index = searchForElement(arr, numberToLookFor);

        // display the proper output to the user
        checkSearchResult(arr, numberToLookFor, index);
    }

    private static int[] generateRandomElementsArray(int size, int maxNumber) {
        return IntStream
                .generate(() -> (int) (Math.random() * maxNumber)) // the element generation lambda
                .limit(size) // the size of the array to be generated
                .toArray(); // converting the stream to an array
    }


    private static void checkSearchResult(int[] arr, int numberToLookFor, int index) {
        if (index > -1) { // means the element is found in the array
            int countOfOccurrences = countOccurrences(arr, numberToLookFor, index);

            System.out.printf("%d is found once at index %d in the array %n", numberToLookFor, index);

            System.out.printf("%d is found %d times in the array %n", numberToLookFor, countOfOccurrences);
        } else  // means the element isn't found in the array
            System.out.println("\n");
    }

    private static int countOccurrences(int[] arr, int number, int index) {
        int count = 0;

        // count the number of elements equal to @number
        for (int j : arr) if (j == number) count++;

        return count;
    }

    private static int searchForElement(int[] arr, int n) {
        for (int j = 0, arrLength = arr.length; j < arrLength; j++)
            if (arr[j] == n)
                return j;

        return -1;
    }
}
