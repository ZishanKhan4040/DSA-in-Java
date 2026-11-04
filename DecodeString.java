import java.util.*;

class Solution {
    public String decodeString(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch != ']') {
                st.push(ch);
            }

            else {

                // Extract substring
                StringBuilder part = new StringBuilder();

                while (!st.isEmpty() && st.peek() != '[') {
                    part.append(st.pop());
                }

                st.pop(); // Remove '['

                part.reverse();

                // Extract number
                StringBuilder number = new StringBuilder();

                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    number.append(st.pop());
                }

                number.reverse();

                int num = Integer.parseInt(number.toString());

                // Repeat substring and push back
                StringBuilder repeated = new StringBuilder();

                for (int j = 0; j < num; j++) {
                    repeated.append(part);
                }

                // Push decoded characters back
                for (int j = 0; j < repeated.length(); j++) {
                    st.push(repeated.charAt(j));
                }
            }
        }

        // Construct final answer
        StringBuilder result = new StringBuilder();

        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        return result.reverse().toString();
    }
}
