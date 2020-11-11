package javaImplementations.sorting;

import java.util.ArrayDeque;

public class TreeSort {
    public static class Node {
        int data;
        Node right;
        Node left;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node treeSort(int[] arr) {
        Node rootNode = null;

        for (int j = 0, arrLength = arr.length; j < arrLength; j++) {
            int i = arr[j];

            if (j == 0)
                rootNode = new Node(i);
            else {
                System.out.println("--------------------");
                System.out.printf("Step %d: inserting %d into the following in-order traversed tree: %n", j, i);
                displayProgress(rootNode);
                insert(rootNode, i);
            }
        }

        return rootNode;
    }

    static void insert(Node rootNode, int i) {
        if (rootNode.data > i) {
            if (rootNode.left != null)
                insert(rootNode.left, i);
            else
                rootNode.left = new Node(i);
        } else {
            if (rootNode.right != null)
                insert(rootNode.right, i);
            else
                rootNode.right = new Node(i);
        }
    }

    public static void treeToQueueInOrder(Node rootNode, ArrayDeque<Integer> integers) {
        if (rootNode == null) return;
        treeToQueueInOrder(rootNode.left, integers);
        integers.offer(rootNode.data);
        treeToQueueInOrder(rootNode.right, integers);
    }

    public static void treeToQueueInOrderReversed(Node rootNode, ArrayDeque<Integer> integers) {
        if (rootNode == null) return;
        treeToQueueInOrderReversed(rootNode.right, integers);
        integers.offer(rootNode.data);
        treeToQueueInOrderReversed(rootNode.left, integers);
    }

    private static void displayProgress(Node rootNode) {
        ArrayDeque<Integer> treeInOrderTraversal = new ArrayDeque<>();
        treeToQueueInOrder(rootNode, treeInOrderTraversal);
        System.out.println(treeInOrderTraversal);
    }
}
