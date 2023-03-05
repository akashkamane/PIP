import javafx.util.Pair;

import java.util.Stack;

public class RemoveDuplicateII {



    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek().getKey() != c) {
                stack.push(new Pair<>(c, 1));
            } else {
                Pair<Character, Integer> top = stack.peek();
                if (top.getValue() == k - 1) {
                    stack.pop();
                } else {
                    stack.pop();
                    stack.push(new Pair<>(c, top.getValue() + 1));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair<Character, Integer> pair = stack.pop();
            for (int i = 0; i < pair.getValue(); i++) {
                sb.insert(0, pair.getKey());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;
        RemoveDuplicateII solution = new RemoveDuplicateII();
        String result = solution.removeDuplicates(s, k);
        System.out.println(result);

    }
}
