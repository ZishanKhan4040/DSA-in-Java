class Solution {
    public String minRemoveToMakeValid(String s) {

        StringBuilder sb = new StringBuilder();

        int open = 0;

        // First pass: Left to Right
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            }

            else if (ch == ')') {

                if (open == 0) {
                    continue;
                }

                open--;
            }

            sb.append(ch);
        }

        // Second pass: Right to Left
        StringBuilder result = new StringBuilder();

        int close = 0;

        for (int i = sb.length() - 1; i >= 0; i--) {

            char ch = sb.charAt(i);

            if (ch == ')') {
                close++;
            }

            else if (ch == '(') {

                if (close == 0) {
                    continue;
                }

                close--;
            }

            result.append(ch);
        }

        return result.reverse().toString();
    }
}
