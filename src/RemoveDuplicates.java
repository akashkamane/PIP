import java.util.Stack;

public class RemoveDuplicates {



        /**
         * Removes adjacent duplicates in a string using a stack
         * @param s the input string
         * @return the string with adjacent duplicates removed
         */
        public static String removeDuplicates(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (!stack.isEmpty() && c == stack.peek()) {
                    stack.pop(); // Remove the previous character from the stack if it's the same as the current character
                } else {
                    stack.push(c); // Add the current character to the stack
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop()); // Append characters from the stack to the string builder
            }
            return sb.reverse().toString(); // Reverse the string builder and convert it to a string
        }

        /**
         * Removes adjacent duplicates in a string using two pointers
         * @param s the input string
         * @return the string with adjacent duplicates removed
         */
        public static String removeAdjacentDuplicates(String s) {
            int i = 0;
            char[] stack = s.toCharArray();
            for (int j = 1; j < stack.length; j++) {
                if (i >= 0 && stack[i] == stack[j]) {
                    i--; // Decrement i if the previous character is the same as the current character
                } else {
                    stack[++i] = stack[j]; // Increment i and add the current character to the stack
                }
            }
            return new String(stack, 0, i + 1); // Convert the character array to a string
        }


    public static void main(String[] args) {
        String s = "abbaca";
        String s2 = "azxxzy";
        System.out.println("---------------- Using Stack -----------------------------------");

        long startTime = System.nanoTime();

        System.out.println(removeDuplicates(s)); // Output: "ca"
        System.out.println(removeDuplicates(s2)); // Output: "ay"

        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime) / 1000; // convert nanoseconds to microseconds

        System.out.println("Time taken: " + elapsedTime + " µs");

        System.out.println("---------------- Two Pointers Algorithm -----------------------------------");

        long startTime2 = System.nanoTime();

        System.out.println(removeAdjacentDuplicates(s)); // Output: "ca"
        System.out.println(removeAdjacentDuplicates(s2)); // Output: "ay"

        long endTime2 = System.nanoTime();
        long elapsedTime2 = (endTime2 - startTime2) / 1000; // convert nanoseconds to microseconds

        System.out.println("Time taken: " + elapsedTime2 + " µs");

    }

}
