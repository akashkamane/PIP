import java.util.HashMap;
import java.util.Map;

public class RansomNote {

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


        public static boolean canConstructUsingHashMap(String ransomNote, String magazine) {

            // Check if input strings are null or empty
            if (ransomNote == null || magazine == null || ransomNote.isEmpty() || magazine.isEmpty()) {
                return false;
            }
            // Create a hashmap to store the frequency of each character in magazine
            Map<Character, Integer> freq = new HashMap<>();
            for (char c : magazine.toLowerCase().toCharArray()) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }

            // Iterate through each character in the ransomNote
            for (char c : ransomNote.toLowerCase().toCharArray()) {
                // If the character is not present in the magazine or its frequency is 0, return false
                if (!freq.containsKey(c) || freq.get(c) == 0) {
                    return false;
                }
                // Otherwise, decrement the frequency of the character in the magazine
                freq.put(c, freq.get(c) - 1);
            }

            // If all characters in ransomNote are present in magazine, return true
            return true;
        }


    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "Aba";

        System.out.println("---------------- Arrays -----------------------------------");


        long startTime = System.nanoTime();

        boolean canConstructUsingArrays = canConstructUsingArrays(ransomNote, magazine);
        System.out.println(canConstructUsingArrays); // output: true


        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime) / 1000; // convert nanoseconds to microseconds

        System.out.println("Time taken: " + elapsedTime + " µs");

        System.out.println("---------------- Hash Map ---------------------------------");

        long startTime2 = System.nanoTime();

        boolean canConstructUsingHashMap = canConstructUsingHashMap(ransomNote, magazine);
        System.out.println(canConstructUsingHashMap); // output: true


        long endTime2 = System.nanoTime();
        long elapsedTime2 = (endTime2 - startTime2) / 1000; // convert nanoseconds to microseconds

        System.out.println("Time taken: " + elapsedTime2 + " µs");

    }

}
