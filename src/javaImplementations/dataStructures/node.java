package javaImplementations.dataStructures;

public class node {
    node next;
    int info;

    public static void main(String[] args) {
        node first = null;
        node last = null;
        int x = 0;


        node node = first;

        while (node != null && node.info != x && node.next.info != x) {
            node = node.next;
        }

        if (node != null) {
            if (first == last) {
                first = last = null;
            } else {
                node temp = node.next;
                node.next = node.next.next;
                temp.next = null;
            }
        } else {
            System.out.println("Element not found!");
        }

    }
}
