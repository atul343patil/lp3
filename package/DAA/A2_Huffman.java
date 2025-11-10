import java.util.*;

// Node class for Huffman Tree
class HuffmanNode {
    char data;
    int frequency;
    HuffmanNode left, right;

    HuffmanNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }
}

// Comparator for the PriorityQueue (min-heap)
class Compare implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode a, HuffmanNode b) {
        return a.frequency - b.frequency;
    }
}

public class A2_Huffman {

    // Function to generate Huffman Codes
    static void generateCodes(HuffmanNode root, String code, Map<Character, String> huffmanCodes) {
        if (root == null) return;

        // If it's a leaf node, store its code
        if (root.left == null && root.right == null) {
            huffmanCodes.put(root.data, code);
            System.out.println(root.data + " : " + code);
        }

        generateCodes(root.left, code + "0", huffmanCodes);
        generateCodes(root.right, code + "1", huffmanCodes);
    }

    // Function to build Huffman Tree (Greedy Approach)
    static void buildHuffmanTree(String text) {
        // Step 1: Count frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : text.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Create a priority queue (min-heap)
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(new Compare());

        // Step 3: Create leaf node for each character and add to queue
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        // Step 4: Greedy approach — combine two smallest nodes until one remains
        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();   // least frequency
            HuffmanNode right = pq.poll();  // second least frequency

            HuffmanNode newNode = new HuffmanNode('\0', left.frequency + right.frequency);
            newNode.left = left;
            newNode.right = right;

            pq.add(newNode); // add back to queue
        }

        // Step 5: Root node contains the complete Huffman Tree
        HuffmanNode root = pq.peek();

        // Step 6: Generate Huffman codes
        System.out.println("\nHuffman Codes:");
        Map<Character, String> huffmanCodes = new HashMap<>();
        generateCodes(root, "", huffmanCodes);

        // Step 7: Print Encoded String
        System.out.print("\nEncoded String: ");
        StringBuilder encoded = new StringBuilder();
        for (char ch : text.toCharArray()) {
            encoded.append(huffmanCodes.get(ch));
        }
        System.out.println(encoded);
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to encode using Huffman Encoding: ");
        String text = sc.nextLine();

        buildHuffmanTree(text);
        sc.close();
    }
}
