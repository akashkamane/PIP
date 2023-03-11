import java.util.Scanner;
import java.util.Stack;

public class PIPAllInOne {

    /**
     * @param input the input string to check
     * @return true if input can be constructed by repeating a substring, false otherwise
     */
    public static boolean repeatedSubstringPattern(String input) {

        if (input == null || input.isEmpty()) {
            return false;
        }

        int n = input.length();

        // Iterate over all possible substring lengths
        for (int i = 1; i <= n / 2; i++) {
            // Check if the length is a divisor of the total length
            if (n % i == 0) {
                // Get the substring of length i
                String substr = input.substring(0, i);
                // Concatenate the substring multiple times
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n / i; j++) {
                    sb.append(substr);
                }
                // If the result equals the original string, return true
                if (sb.toString().equals(input)) {
                    return true;
                }
            }
        }
        // If no substring pattern is found, return false
        return false;
    }


    /**
     * @param firstValue  The string to be repeated
     * @param secondValue The string to be checked if it's a substring of the repeated firstValue
     * @return The minimum number of times the firstValue needs to be repeated or -1 if not possible
     */
    public static int repeatedStringMatch(String firstValue, String secondValue) {

        if (firstValue == null || secondValue == null || firstValue.isEmpty() || secondValue.isEmpty()) {
            return -1;
        }

        // Create a StringBuilder object to hold the repeated string.
        StringBuilder repeatedA = new StringBuilder(firstValue);

        int numRepeats = 1;

        // Repeat the firstValue until the length of the repeatedA is at least the length of secondValue.
        while (repeatedA.length() < secondValue.length()) {
            repeatedA.append(firstValue);
            numRepeats++;
        }

        // Check if secondValue is a substring of the repeatedA.
        if (repeatedA.indexOf(secondValue) >= 0) {
            return numRepeats;
        }

        // If not, append the firstValue one more time and increment the numRepeats.
        repeatedA.append(firstValue);
        numRepeats++;

        // Check if secondValue is a substring of the repeatedA after the second append.
        if (repeatedA.indexOf(secondValue) >= 0) {
            return numRepeats;
        }

        // If not possible to make secondValue a substring of the repeatedA, return -1.
        return -1;
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

    /**
     * Removes adjacent duplicates in a string using a stack
     *
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


    public static boolean canConstructUsingArrays(String ransomNote, String magazine) {

        // Check if input strings are null or empty
        if (ransomNote == null || magazine == null || ransomNote.isEmpty() || magazine.isEmpty()) {
            return false;
        }

        // Create a character array to count the frequency of characters in magazine
        int[] charCount = new int[26];

        // Convert magazine to lowercase and count the frequency of each character
        for (char c : magazine.toLowerCase().toCharArray()) {
            charCount[c - 'a']++;
        }

        // Convert ransomNote to lowercase and check if the characters can be constructed from magazine
        for (char c : ransomNote.toLowerCase().toCharArray()) {
            if (charCount[c - 'a'] <= 0) {
                // The character is not present in magazine or has already been used
                return false;
            }
            charCount[c - 'a']--;
        }
        // All characters in ransomNote can be constructed from magazine
        return true;
    }


    public static void main(String[] args) {

        System.out.println(" Available Task/Solution ");
        System.out.println("1. find substring in given string");
        System.out.println("2. find repeated String");
        System.out.println("3. remove adjacent duplicate");
        System.out.println("4. remove adjacent duplicate with K value");
        System.out.println("5. Ransome Note");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        String second = null;
        int k = 0;
        System.out.print("Enter First/Ransome Value: ");
        String first = scanner.nextLine();


        if (choice == 2 || choice == 5 ) {

            System.out.print("Enter Second/Magzine Value: ");
            second = scanner.nextLine();

        }
        if(choice == 4){
            System.out.print("Enter k Value: ");
            k = scanner.nextInt();
        }


        switch (choice) {
            case 1:
                System.out.println("You chose option 1");
                System.out.println(repeatedSubstringPattern(first));
                break;
            case 2:
                System.out.println("You chose option 2");
                System.out.println(repeatedStringMatch(first, second));
                break;
            case 3:
                System.out.println("You chose option 3");
                System.out.println(removeDuplicates(first));
                break;
            case 4:
                System.out.println("You chose option 4");
                System.out.println(removeDuplicatesWithSB(first, k));
                break;
            case 5:
                System.out.println("You chose option 5");
                boolean canConstructUsingArrays = canConstructUsingArrays(first, second);
                System.out.println(canConstructUsingArrays);
                break;
            default:
                System.out.println("Invalid choice");
        }

    }

}
