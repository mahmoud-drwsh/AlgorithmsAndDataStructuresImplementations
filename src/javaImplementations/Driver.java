package javaImplementations;

import javaImplementations.sorting.TreeSort;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class Driver {

    public static void main(String[] args) {
        int arraySize = 10;
        int maxNumber = 123;


        // generating a random array to sort
        int[] arr = IntStream
                .generate(() -> (int) (Math.random() * maxNumber))
                .limit(arraySize)
                .toArray();

        System.out.println("array to sort using TreeSort:");
        System.out.println(Arrays.toString(arr) + "\n");


        TreeSort.Node rootNode = TreeSort.treeSort(arr);

        System.out.println("============================");
        System.out.println("finished sorting the array");
        System.out.println("============================");

        ArrayDeque<Integer> treeTraversal = new ArrayDeque<>();

        TreeSort.treeToQueueInOrder(rootNode, treeTraversal);
        System.out.println("\nThe final in-oder traversed tree (sorted Array)");
        System.out.println(treeTraversal);

        treeTraversal.clear();


        TreeSort.treeToQueueInOrderReversed(rootNode, treeTraversal);
        System.out.println("\nThe final in-oder reversed traversed tree (sorted Array in reverse)");
        System.out.println(treeTraversal);
    }
}
