a) Repeated Substring Pattern

Given a string s, 

check if it can be constructed by taking a substring of it and
appending multiple copies of the substring together.


Example 1:
Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.
Example 2:
Input: s = "aba"
Output: false
Example 3:
Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" four times or the substring "abcabc"
twice.

startsWith algorithm

The startsWith method is a built-in method in Java that determines if a string starts with a specified prefix. It works by simply comparing the characters of the prefix with the characters at the beginning of the string. If the characters match, the method returns true. If not, it returns false. This algorithm is very simple and efficient for small prefixes, but it becomes less efficient for longer prefixes or longer strings.

Rolling hash algorithm

Rolling hash is a hash-based algorithm that is used to find patterns in a string. It works by calculating a hash value for each possible substring in the string, and then comparing the hash values of the target pattern with the hash values of the substrings. The algorithm is very efficient for finding patterns in long strings, but it can sometimes produce false matches due to collisions in the hash values.

KMP algorithm

KMP algorithm, on the other hand, is a pattern matching algorithm that works by comparing a pattern with a text string, character by character. It uses a preprocessed table to skip over unnecessary comparisons, which makes it very efficient for finding patterns in short or medium-length strings. However, the algorithm requires preprocessing, which can be time-consuming for very long strings.

In general, rolling hash is faster than KMP algorithm for long strings, but it can produce false matches. KMP algorithm is more reliable and accurate, but it requires preprocessing and is slower for very long strings. Therefore, the choice of which algorithm to use depends on the specific situation and the trade-off between speed and accuracy.

Time complexity

startsWith Algorithm:
Time Complexity: O(m), where m is the length of the prefix string.
Rolling Hash Algorithm:
Time Complexity: O(n), where n is the length of the input string.
KMP Algorithm:
Preprocessing Time Complexity: O(m), where m is the length of the pattern.
Matching Time Complexity: O(n), where n is the length of the input string.
Note that the time complexities for the Rolling Hash and KMP algorithms are for matching the pattern against a single input string. If you need to match the same pattern against multiple input strings, the Rolling Hash algorithm can be faster because it doesn't require preprocessing. However, if you only need to match the pattern once or a few times, the KMP algorithm may be faster because it can skip over unnecessary comparisons.














b) Repeated String Match

Given two strings a and b, return the minimum number of times you should
repeat string a so that string b is a
substring of it. If it is impossible for b to be a substring of a after repeating it,
return -1.

Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and
repeated 2 times is "abcabc".
Example 1:
Input: a = "abcd", b = "cdabcdab"
Output: 3
Explanation: We return 3 because by repeating a three times "abcdabcdabcd",
b is a substring of
it.
Example 2:
Input: a = "a", b = "aa"
Output: 2




Brute force approach: A brute force approach would be to try all possible combinations of repeated strings until we find a match for b. This approach has a time complexity of O(n^2m), where n is the length of a and m is the length of b, which is not efficient for large inputs. Here's the code for this approach:
Rolling hash approach: We can use a rolling hash to check if a substring of a matches b. A rolling hash is a hash function that can update the hash value of a string efficiently as we move from one position to the next. This approach has a time complexity of O(n+m), where n is the length of a and m is the length of b. Here's the code for this approach:
Binary search approach: We can use binary search to find the minimum number of times a needs to be repeated to obtain b as a substring. The search space is between 1 and ceil(m/n) since we need to repeat a at least once and at most ceil(m/n) times to obtain a string of length at least m. This approach has a time complexity of O(n log n), where n is the length of a. Here's the code for this approach:
The rolling hash approach has a time complexity of O(n+m), where n is the length of a and m is the length of b. The approach uses a hash function that can update the hash value of a string efficiently as we move from one position to the next. We first compute the hash value of b using the same hash function. Then, we compute the hash value of all substrings of a of length m. If a substring of a has the same hash value as b, we check if the two substrings are actually equal. If they are, we return the number of times a needs to be repeated to obtain a string of length at least m.
The rolling hash approach has a better time complexity than the brute force approach, which has a time complexity of O(n^2m). The binary search approach also has a time complexity of O(n log n), where n is the length of a. However, the binary search approach involves more complex logic and is not as easy to implement as the rolling hash approach.




























c) Remove All Adjacent Duplicates In String

You are given a string “s” consisting of lowercase English letters. A duplicate
removal consists of choosing two adjacent and equal letters and removing them. 

We repeatedly make duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made. 
It can be proven that the answer is unique.


Example 1:
Input: s = "abbaca"
Output: "ca"
Explanation:
For example,
 in "abbaca" we could remove "bb" since the letters are adjacent and equal,
 And this is the only possible move. 

The result of this move is that the string is "aaca", of which only "aa" is possible, 
so the final string is "ca".
Example 2:
Input: s = "azxxzy"
Output: "ay"

. Using a Stack
The time complexity of the stack approach is O(n), where n is the length of the input string. This is because we iterate through the input string once and perform constant-time operations on the stack (push, pop, and peek).
2. Using Two Pointers
The time complexity of the two-pointer approach is also O(n), where n is the length of the input string. This is because we iterate through the input string once and perform constant-time operations on the array (assignment and comparison).
3. Using StringBuilder
The time complexity of the StringBuilder approach is also O(n), where n is the length of the input string. This is because we iterate through the input string once and perform constant-time operations on the StringBuilder (append, deleteCharAt, and charAt).
In general, all three algorithms have the same time complexity of O(n) and are efficient for small and large input sizes. However, there may be slight performance differences between them due to differences in constant factors and memory usage. For example, the stack and StringBuilder approaches may use more memory than the two-pointer approach. Therefore, the choice of which algorithm to use ultimately depends on the specific requirements of the use case and personal preference.





































d) Remove All Adjacent Duplicates in String II

You are given a string s and an integer k, a k duplicate removal consists of
choosing k adjacent and equal letters from s and removing them, 

causing the left and the right side of the deleted substring to concatenate together.
We repeatedly make k duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made. 
It is guaranteed that the answer is unique.

Example 1:
Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:
Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation:
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:
Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"


Using a char array instead of a Pair stack: O(n)
In this approach, we iterate over the input string once and remove duplicates in constant time per character. The final step of creating a new string from the char array takes O(n) time, where n is the length of the input string.
Using a LinkedList instead of a Stack: O(n)
In this approach, we iterate over the input string once and remove duplicates in constant time per character. The final step of creating a new string using StringBuilder takes O(n) time, where n is the length of the input string.
Using recursion instead of a loop: O(n^2)
In this approach, we may need to recursively call the helper method multiple times to remove all adjacent duplicates. In the worst case, where all characters in the input string are the same, each recursive call reduces the length of the string by k. Therefore, the maximum depth of the recursion is n/k, and each call takes O(n) time to find the longest substring of adjacent duplicates. Thus, the overall time complexity of this approach is O(n^2/k).
Note that these time complexities are all linear or close to linear with respect to the length of the input string. Therefore, all of these approaches are efficient for most practical input sizes. However, the first two approaches are more efficient than the third approach for large values of k, since the recursive approach has a higher worst-case time complexity when k is large.































e) Ransom Note

Given two strings ransomNote and magazine, return true if ransomNote can
be constructed by using the letters from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.

Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false
Example 3:
Input: ransomNote = "aa", magazine = "Aba"
Output: true







Original Solution (Using Arrays):
In the original solution, we iterate over each character in magazine to count the occurrences of each character. Then, we iterate over each character in ransomNote to decrement the counts. Both of these loops have a time complexity of O(n), where n is the length of magazine or ransomNote. Therefore, the time complexity of this approach is O(n), where n is the length of the longer string (magazine or ransomNote).
Using HashMap:
In this approach, we use a HashMap to count the occurrences of each character in magazine, and then iterate over each character in ransomNote to decrement the counts. The time complexity of iterating over ransomNote is O(n), where n is the length of ransomNote. The time complexity of counting the occurrences in magazine is O(m), where m is the length of magazine. Therefore, the time complexity of this approach is O(m+n).


























6.Add Binary
Given two binary strings a and b, return their sum as a binary string.
Example 1:
Input: a = "11", b = "1"
Output: "100"
Example 2:
Input: a = "1010", b = "1011"
Output: "10101"












































