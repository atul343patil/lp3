
import java.util.Scanner;

public class A3_Knapsack {

    // Function to solve 0-1 Knapsack using Dynamic Programming
    public static int knapsack(int[] weights, int[] values, int n, int capacity) {
        int[][] dp = new int[n + 1][capacity + 1];

        // Build table dp[][] bottom up
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (weights[i - 1] <= w)
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }

        // Print the DP table (optional, for understanding)
        System.out.println("\nDP Table:");
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                System.out.print(dp[i][w] + "\t");
            }
            System.out.println();
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] values = new int[n];
        int[] weights = new int[n];

        System.out.println("Enter the values of the items:");
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        System.out.println("Enter the weights of the items:");
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }

        System.out.print("Enter maximum capacity of knapsack: ");
        int capacity = sc.nextInt();

        int maxValue = knapsack(weights, values, n, capacity);

        System.out.println("\nMaximum value that can be put in knapsack = " + maxValue);

        sc.close();
    }
}


// Branch and bound 

/*
 



import java.util.*;

class Item {
    int value, weight;
    double ratio;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
        this.ratio = (double) value / weight;
    }
}

class Node {
    int level, profit, weight;
    double bound;

    Node(int level, int profit, int weight, double bound) {
        this.level = level;
        this.profit = profit;
        this.weight = weight;
        this.bound = bound;
    }
}

public class A3_Knapsack {

    static int capacity;

    // Function to calculate upper bound of maximum profit possible from this node
    static double bound(Node u, int n, Item[] arr) {
        if (u.weight >= capacity)
            return 0;

        double profitBound = u.profit;
        int j = u.level + 1;
        int totalWeight = u.weight;

        // Take items while possible
        while (j < n && totalWeight + arr[j].weight <= capacity) {
            totalWeight += arr[j].weight;
            profitBound += arr[j].value;
            j++;
        }

        // Take fraction of next item if possible
        if (j < n)
            profitBound += (capacity - totalWeight) * arr[j].ratio;

        return profitBound;
    }

    // Function to solve Knapsack using Branch and Bound
    static int knapsack(int n, Item[] arr) {
        // Sort items by decreasing value/weight ratio
        Arrays.sort(arr, (a, b) -> Double.compare(b.ratio, a.ratio));

        Queue<Node> queue = new LinkedList<>();
        Node u, v;

        // Start with dummy node at level -1
        v = new Node(-1, 0, 0, 0);
        v.bound = bound(v, n, arr);
        queue.add(v);

        int maxProfit = 0;

        while (!queue.isEmpty()) {
            v = queue.poll();

            // If node is promising
            if (v.level == n - 1)
                continue;

            // Next item
            u = new Node(v.level + 1, v.profit, v.weight, 0);

            // Include next item
            u.weight = v.weight + arr[u.level].weight;
            u.profit = v.profit + arr[u.level].value;

            if (u.weight <= capacity && u.profit > maxProfit)
                maxProfit = u.profit;

            u.bound = bound(u, n, arr);
            if (u.bound > maxProfit)
                queue.add(u);

            // Exclude next item
            u = new Node(v.level + 1, v.profit, v.weight, 0);
            u.bound = bound(u, n, arr);
            if (u.bound > maxProfit)
                queue.add(u);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] arr = new Item[n];

        System.out.println("Enter values of items:");
        int[] values = new int[n];
        for (int i = 0; i < n; i++)
            values[i] = sc.nextInt();

        System.out.println("Enter weights of items:");
        int[] weights = new int[n];
        for (int i = 0; i < n; i++)
            weights[i] = sc.nextInt();

        System.out.print("Enter maximum capacity of knapsack: ");
        capacity = sc.nextInt();

        for (int i = 0; i < n; i++)
            arr[i] = new Item(values[i], weights[i]);

        int result = knapsack(n, arr);
        System.out.println("\nMaximum possible profit = " + result);

        sc.close();
    }
}

















 */

