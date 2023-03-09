public class RepeatedSubstringPatternDetector {

    /**
     * Check if a string can be constructed by taking a substring of it
     */



    /**
     * @param input the input string to check
     * @return true if input can be constructed by repeating a substring, false otherwise
     */
    public static boolean repeatedSubstringPattern(String input) {
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
     *
     * @param input the input string
     * @return true if input can be constructed by repeating a substring, false otherwise
     */
    public static boolean repeatedSubstringPatternwithKMP(String input) {
        int n = input.length();

        // Construct the prefix table for the input string input.
        int[] prefixTable = new int[n];
        prefixTable[0] = 0; // The first character cannot be a proper prefix.
        for (int i = 1, j = 0; i < n; i++) {
            // Check if the previous character matches input.charAt(i).
            while (j > 0 && input.charAt(i) != input.charAt(j)) {
                // Backtrack to the previous position in the prefix table.
                j = prefixTable[j-1];
            }
            if (input.charAt(i) == input.charAt(j)) {
                // If the characters match, increment j.
                j++;
            }
            prefixTable[i] = j; // Store the length of the proper prefix.
        }

        // Check if input can be constructed by repeating a substring.
        int len = prefixTable[n-1]; // Length of the longest proper prefix of input.
        return (len > 0 && n % (n-len) == 0); // Check if input is repeating substring.
    }



        public static void main(String[] args) {
        String input1 = "abab";
        String input2 = "ababqwjhab";
        String input3 = "abcabcabc";


        System.out.println("------------------ Brute Force Algorithm ----------------------------");
        long startTime = System.nanoTime();

        // Test the method with the given inputs
        System.out.println(repeatedSubstringPattern(input1)); // Output: true
        System.out.println(repeatedSubstringPattern(input2)); // Output: false
        System.out.println(repeatedSubstringPattern(input3)); // Output: true

        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime) / 1000; // convert nanoseconds to microseconds
        System.out.println("Time taken: " + elapsedTime + " µs");

        System.out.println("------------------ KMP Algorithm ----------------------------");

        long startTime2 = System.nanoTime();

//        System.out.println(repeatedSubstringPatternwithKMP(input1)); // Output: true
        System.out.println(repeatedSubstringPatternwithKMP(input2)); // Output: false
        System.out.println(repeatedSubstringPatternwithKMP(input3)); // Output: true

        long endTime2 = System.nanoTime();
        long elapsedTime2 = (endTime2 - startTime2) / 1000; // convert nanoseconds to microseconds
        System.out.println("Time taken: " + elapsedTime2 + " µs");

    }

}
