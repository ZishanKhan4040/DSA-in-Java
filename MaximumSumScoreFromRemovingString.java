
import java.util.*;

class Solution {
    public int maximumGain(String s, int x, int y) {

        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        int score = 0;

        // First pass: Remove higher priority substring
        if (x >= y) {

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (ch == 'b' && !stack.isEmpty() && stack.peek() == 'a') {
                    stack.pop();
                    score += x;
                } else {
                    stack.push(ch);
                }
            }

            // Second pass: Remove remaining "ba"
            for (int i = 0; i < stack.size(); i++) {
                char ch = stack.get(i);

                if (ch == 'a' && !stack2.isEmpty() && stack2.peek() == 'b') {
                    stack2.pop();
                    score += y;
                } else {
                    stack2.push(ch);
                }
            }

        } else {

            // First pass: Remove higher priority "ba"
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (ch == 'a' && !stack.isEmpty() && stack.peek() == 'b') {
                    stack.pop();
                    score += y;
                } else {
                    stack.push(ch);
                }
            }

            // Second pass: Remove remaining "ab"
            for (int i = 0; i < stack.size(); i++) {
                char ch = stack.get(i);

                if (ch == 'b' && !stack2.isEmpty() && stack2.peek() == 'a') {
                    stack2.pop();
                    score += x;
                } else {
                    stack2.push(ch);
                }
            }
        }

        return score;
    }
}
