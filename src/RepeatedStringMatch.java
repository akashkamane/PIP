public class RepeatedStringMatch {

    /**
     * Returns the minimum number of times string 'a' needs to be repeated
     * so that string 'b' is a substring of it. If it is impossible for 'b' to be
     * a substring of 'a' after repeating it, returns -1.
     *
     * @param a the input string to be repeated
     * @param b the target substring to be found
     * @return the minimum number of times 'a' needs to be repeated to obtain 'b', or -1 if not possible
     */
    public static int repeatedStringMatch(String a, String b) {
        StringBuilder repeatedA = new StringBuilder(a);
        int numRepeats = 1;
        while (repeatedA.length() < b.length()) {
            repeatedA.append(a);
            numRepeats++;
        }
        if (repeatedA.indexOf(b) >= 0) {
            return numRepeats;
        }
        repeatedA.append(a);
        numRepeats++;
        if (repeatedA.indexOf(b) >= 0) {
            return numRepeats;
        }
        return -1;
    }

    public static int repeatedStringMatch3(String a, String b) {
        int count = 1;
        StringBuilder sb = new StringBuilder(a);
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }
        if (sb.indexOf(b) != -1) {
            return count;
        }
        sb.append(a);
        return (sb.indexOf(b) != -1) ? count + 1 : -1;
    }

//    ---------------------
    /**
     * Returns the minimum number of times string 'a' needs to be repeated
     * so that string 'b' is a substring of it. If it is impossible for 'b' to be
     * a substring of 'a' after repeating it, returns -1.
     *
     *
     * @param a the input string to be repeated
     * @param b the target substring to be found
     * @return the minimum number of times 'a' needs to be repeated to obtain 'b', or -1 if not possible
     */
    public static int repeatedStringMatch2(String a, String b) {
        int[] lps = computeLPS(b);
        int i = 0, j = 0, n = a.length(), m = b.length();
        while (i < n) {
            while (j < m && a.charAt((i+j) % n) == b.charAt(j)) {
                j++;
            }
            if (j == m) {
                return (i+j+n-1) / n;
            }
            if (j == 0) {
                i++;
            } else {
                i += j - lps[j-1];
                j = lps[j-1];
            }
        }
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
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                lps[i++] = ++j;
            } else if (j == 0) {
                lps[i++] = 0;
            } else {
                j = lps[j-1];
            }
        }
        return lps;
    }



//--------------------------------------

    public static void main(String[] args) {

        long startTime = System.nanoTime();

        System.out.println(repeatedStringMatch("abcd", "cdabcdab")); // 3
        System.out.println(repeatedStringMatch("a", "aaaaa")); // 2
//        long endTime = System.nanoTime();
//        long elapsedTime = (endTime - startTime) / 1000; // convert nanoseconds to microseconds
//
//        System.out.println("Time taken: " + elapsedTime + " µs");
//
//        System.out.println("---------------------------------------------------");
//
//        long startTime2 = System.nanoTime();
//
//        System.out.println(repeatedStringMatch2("abcd", "cdabcdab")); // 3
//        System.out.println(repeatedStringMatch2("a", "aa")); // 2
//        long endTime2 = System.nanoTime();
//        long elapsedTime2 = (endTime2 - startTime2) / 1000; // convert nanoseconds to microseconds
//
//        System.out.println("Time taken: " + elapsedTime2 + " µs");









    }

}
