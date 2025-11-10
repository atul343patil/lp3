import java.util.*;

public class A5_QuickSort {

    // Function to swap two elements
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Deterministic partition: last element as pivot
    static int partitionDeterministic(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    // Randomized partition: random pivot selection
    static int partitionRandomized(int[] arr, int low, int high) {
        Random rand = new Random();
        int randomPivot = rand.nextInt(high - low + 1) + low;
        swap(arr, randomPivot, high);
        return partitionDeterministic(arr, low, high);
    }

    // Deterministic QuickSort
    static void quickSortDeterministic(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionDeterministic(arr, low, high);
            quickSortDeterministic(arr, low, pi - 1);
            quickSortDeterministic(arr, pi + 1, high);
        }
    }

    // Randomized QuickSort
    static void quickSortRandomized(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionRandomized(arr, low, high);
            quickSortRandomized(arr, low, pi - 1);
            quickSortRandomized(arr, pi + 1, high);
        }
    }

    // Print array elements
    static void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr1 = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        // Copy array for randomized version
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);

        System.out.println("\nOriginal Array:");
        printArray(arr1);

        // Deterministic QuickSort
        long start1 = System.nanoTime();
        quickSortDeterministic(arr1, 0, n - 1);
        long end1 = System.nanoTime();
        System.out.println("\nSorted Array (Deterministic QuickSort):");
        printArray(arr1);
        System.out.println("Time taken (Deterministic): " + (end1 - start1) + " ns");

        // Randomized QuickSort
        long start2 = System.nanoTime();
        quickSortRandomized(arr2, 0, n - 1);
        long end2 = System.nanoTime();
        System.out.println("\nSorted Array (Randomized QuickSort):");
        printArray(arr2);
        System.out.println("Time taken (Randomized): " + (end2 - start2) + " ns");
    }
}
