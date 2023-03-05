public class RepeatedSubstringPattern {
    /**
     * Main method to test the repeatedSubstringPattern method
     */



    /**
     * Check if a string can be constructed by taking a substring of it and appending
     * multiple copies of the substring together
     *
     * @param s the input string to check
     * @return true if s can be constructed by repeating a substring, false otherwise
     */
    public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        // Iterate over all possible substring lengths
        for (int i = 1; i <= n / 2; i++) {
            // Check if the length is a divisor of the total length
            if (n % i == 0) {
                // Get the substring of length i
                String substr = s.substring(0, i);
                // Concatenate the substring multiple times
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n / i; j++) {
                    sb.append(substr);
                }
                // If the result equals the original string, return true
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }

        // If no substring pattern is found, return false
        return false;
    }


    public static String repeatedSubstringPattern2(String s) {
        int n = s.length();

        if (n < 2) {
            return "not same String";
        }

        for (int len = 1; len <= n / 2; len++) {
            if (n % len == 0) {
                String substr = s.substring(0, len);
                boolean isRepeated = true;
                int flag =0;
                for (int i = len; i < n; i += len) {

                    if (!s.startsWith(substr, i)) {
                        isRepeated = false;
                        break;
                    }
                    flag++;
                }

                if (isRepeated) {
                    return "same String repeat "+flag+" times";
                }
            }
        }

        return "not same String";
    }

    public static void main(String[] args) {
//        String s1 = "pqr";
//        String s2 = "pqqr";
        String s3 = "apqrqapqrapqrs";

        long startTime = System.nanoTime();

//        // Test the method with the given inputs
//        System.out.println(repeatedSubstringPattern(s1)); // Output: true
//        System.out.println(repeatedSubstringPattern(s2)); // Output: false
//        System.out.println(repeatedSubstringPattern(s3)); // Output: true
//
//        long endTime = System.nanoTime();
//        long elapsedTime = (endTime - startTime) / 1000; // convert nanoseconds to microseconds
//        System.out.println("Time taken: " + elapsedTime + " µs");
//
//        System.out.println("----------------------------------------------");
//
//        long startTime2 = System.nanoTime();

        // Test the method with the given inputs
//        System.out.println(repeatedSubstringPattern2(s1)); // Output: true
//        System.out.println(repeatedSubstringPattern2(s2)); // Output: false
        System.out.println(repeatedSubstringPattern2(s3)); // Output: true

//        long endTime2 = System.nanoTime();
//        long elapsedTime2 = (endTime2 - startTime2) / 1000; // convert nanoseconds to microseconds
//        System.out.println("Time taken: " + elapsedTime2 + " µs");




    }


}
