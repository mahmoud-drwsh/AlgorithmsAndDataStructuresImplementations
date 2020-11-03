package javaImplementations;import java.util.Arrays;

public class HeapSort {


    public static void main(String[] args) {
        int[] arr = new int[7];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        System.out.println("array to sort using HeapSort");
        System.out.println(Arrays.toString(arr) + "\n");

        System.out.println("converting array to a Max-Heap...");
        printCurrentState(arr);

        convertToAMaxHeap(arr);

        System.out.println("done converting array to a Max-Heap");
        printCurrentState(arr);


        for (int i = arr.length - 1; i > 0; i--) {
            System.out.printf("extracting %d to its correct position in the array", arr[0]);
            System.out.println();
            printCurrentState(arr);
            swap(arr, i, 0);
            bubbleDown(arr, 0, i);
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void printCurrentState(int[] arr) {
        System.out.print("current state: ");
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    private static void convertToAMaxHeap(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            bubbleDown(arr, i, arr.length);
        }
    }

    private static void bubbleDown(int[] arr, int root, int n) {
        int greatest = root;

        if (hasLeft(root, n)) {
            if (arr[greatest] < arr[getLeft(root)])
                greatest = getLeft(root);
            if (hasRight(root, n) && (arr[greatest] < arr[getRight(root)]))
                greatest = getRight(root);
        }

        if (greatest != root) {
            System.out.printf("bubbling down %d", arr[root]);
            System.out.println();
            swap(arr, greatest, root);
            bubbleDown(arr, greatest, n);
        }
    }

    private static boolean hasRight(int root, int size) {
        return getRight(root) < size;
    }

    private static boolean hasLeft(int root, int size) {
        return getLeft(root) < size;
    }

    private static int getLeft(int p) {
        return p * 2 + 1;
    }

    private static int getRight(int p) {
        return getLeft(p) + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
