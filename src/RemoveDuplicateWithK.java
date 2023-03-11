import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Stack;

public class RemoveDuplicateWithK {


    /**
     * Removes all adjacent characters that appear k or more times in a row from the given string.
     *
     * @param s the input string
     * @param k the number of adjacent characters that must appear for them to be removed
     * @return the modified string with adjacent characters removed
     */
    public static String removeDuplicatesWithLinkedList(String s, int k) {
        // Check for edge cases
        if (s == null || s.length() == 0 || k <= 1) {
            return s;
        }

        // Create a linked list to keep track of characters and their counts
        LinkedList<Node> list = new LinkedList<>();

        // Iterate through the input string
        for (char c : s.toCharArray()) {
            // If the current character is the same as the last character in the list,
            // increment the count of that character; otherwise, add a new node to the list
            if (!list.isEmpty() && list.getLast().c == c) {
                list.getLast().count++;

                // If the count of the last character in the list is k, remove it
                if (list.getLast().count == k) {
                    list.removeLast();
                }
            } else {
                list.addLast(new Node(c, 1));
            }
        }

        // Build the modified string using the characters and their counts in the list
        StringBuilder sb = new StringBuilder();
        for (Node node : list) {
            for (int i = 0; i < node.count; i++) {
                sb.append(node.c);
            }
        }

        return sb.toString();
    }

    /**
     * A node in the linked list used to keep track of characters and their counts.
     */
    private static class Node {
        char c;
        int count;

        Node(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }





    /**
     * Removes all adjacent characters in the string that occur k or more times.
     *
     * @param s the input string
     * @param k the minimum number of adjacent characters to remove
     * @return the string with adjacent duplicates removed
     */
    public static String removeDuplicatesWithSB(String s, int k) {
        // Check for edge cases
        if (s == null || s.length() < k) {
            return s;
        }

        // Use StringBuilder to modify string in-place
        StringBuilder sb = new StringBuilder(s);
        int[] counts = new int[sb.length()]; // keep track of count of adjacent characters
        int i = 0, n = sb.length();
        for (int j = 0; j < n; j++) {
            sb.setCharAt(i, sb.charAt(j)); // move non-duplicates to the front of the string
            if (i > 0 && sb.charAt(i - 1) == sb.charAt(i)) {
                counts[i] = counts[i - 1] + 1; // increment count if current character is a duplicate
            } else {
                counts[i] = 1; // reset count if current character is not a duplicate
            }
            if (counts[i] == k) {
                i -= k; // remove k adjacent characters by moving the index back
            }
            i++;
        }
        return sb.substring(0, i).toString(); // return the modified string
    }


    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;



        System.out.println("---------------- Linked List ---------------------------------");

        long startTime2 = System.nanoTime();

        System.out.println(removeDuplicatesWithLinkedList(s, k));

        long endTime2 = System.nanoTime();
        long elapsedTime2 = (endTime2 - startTime2) / 1000; // convert nanoseconds to microseconds
        System.out.println("Time taken: " + elapsedTime2 + " µs");

        System.out.println("----------------  Stack using StringBuilder ---------------------------------");

        long startTime3 = System.nanoTime();

        System.out.println(removeDuplicatesWithSB(s, k));

        long endTime3 = System.nanoTime();
        long elapsedTime3 = (endTime3 - startTime3) / 1000; // convert nanoseconds to microseconds
        System.out.println("Time taken: " + elapsedTime3 + " µs");


    }
}
