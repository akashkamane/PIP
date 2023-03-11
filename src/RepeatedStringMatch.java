public class RepeatedStringMatch {

    /**
     * Returns the minimum number of times the firstValue needs to be repeated
     * such that the secondValue becomes a substring of the repeated string.
     * If this is not possible, then returns -1.
     *
     * /



     /**
     *
     * @param firstValue The string to be repeated
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
     *
     * This implementation uses the Knuth-Morris-Pratt algorithm to efficiently
     * compute the Longest Prefix Suffix (LPS) array for the secondValue.
     *
     * @param firstValue The string to be repeated
     * @param secondValue The string to be checked if it's a substring of the repeated firstValue
     * @return The minimum number of times the firstValue needs to be repeated or -1 if not possible
     */
    public static int repeatedStringMatchWithKPM(String firstValue, String secondValue) {

        if (firstValue == null || secondValue == null || firstValue.isEmpty() || secondValue.isEmpty()) {
            return -1;
        }

        // Compute the LPS array for the secondValue using the KMP algorithm.
        int[] lps = computeLPS(secondValue);

        // Initialize variables for the index i and j, and the length of the strings.
        int i = 0, j = 0, n = firstValue.length(), m = secondValue.length();

        // Iterate over the firstValue until we find a match or exhaust all possibilities.
        while (i < n) {
            // Keep incrementing j until we find a mismatch or j reaches the end of the secondValue.
            while (j < m && firstValue.charAt((i+j) % n) == secondValue.charAt(j)) {
                j++;
            }

            // If j has reached the end of the secondValue, then we have found a match.
            if (j == m) {
                return (i+j+n-1) / n;
            }

            // If j is still 0, then we haven't found a match yet, so increment i.
            if (j == 0) {
                i++;
            }
            // Otherwise, we can skip over some characters using the LPS array.
            else {
                i += j - lps[j-1];
                j = lps[j-1];
            }
        }

        // If we haven't found a match by the end of the loop, then it's not possible to make secondValue a substring of the repeatedA.
        return -1;
    }

    /**
     * Computes the Longest Prefix Suffix (LPS) array for string 's' using
     * the Knuth-Morris-Pratt (KMP) algorithm.
     *
     * @param s the input string
     * @return the LPS array
     */
    private static int[] computeLPS(String s) {
        int[] lps = new int[s.length()];
        int i = 1, j = 0;

        // Iterate over the string s to compute the LPS array.
        while (i < s.length()) {
            // If the characters match, then increment both i and j, and set lps[i] to j.
            if (s.charAt(i) == s.charAt(j)) {
                lps[i++] = ++j;
            }
            // If the characters don't match and j is 0, then set lps[i] to 0 and increment i.
            else if (j == 0) {
                lps[i++] = 0;
            }
            // Otherwise, skip over some characters using the LPS array.
            else {
                j = lps[j-1];
            }
        }
        return lps;
    }





    public static void main(String[] args) {

        System.out.println("------------------ Brute Force Algorithm ----------------------------");
        long startTime = System.nanoTime();

//        System.out.println(repeatedStringMatch("abc", "abcabc")); // 2
        System.out.println(repeatedStringMatch("abcd", "cdabcdab")); // 3

        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime) / 1000; // convert nanoseconds to microseconds

//        System.out.println("Time taken: " + elapsedTime + " µs");
//
//        System.out.println("----------------  KMP Algorithm -----------------------------------");
//
//        long startTime2 = System.nanoTime();
//
//        System.out.println(repeatedStringMatchWithKPM("abc", "abcabc")); // Output: false
//        System.out.println(repeatedStringMatchWithKPM("abcd", "cdabcdab")); // Output: true
//
//        long endTime2 = System.nanoTime();
//        long elapsedTime2 = (endTime2 - startTime2) / 1000; // convert nanoseconds to microseconds
//
//        System.out.println("Time taken: " + elapsedTime2 + " µs");
//


    }

}
