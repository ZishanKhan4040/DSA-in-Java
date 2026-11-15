import java.util.*;

class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));

            if (stack.size() >= 2) {
                char first = stack.get(stack.size() - 1);
                char second = stack.get(stack.size() - 2);

                if ((second == 'A' && first == 'B') ||
                    (second == 'C' && first == 'D')) {

                    stack.pop();
                    stack.pop();
                }
            }
        }

        return stack.size();
    }
}
