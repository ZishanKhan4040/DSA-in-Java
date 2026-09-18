class Solution {
    public boolean isMatch(String s, String p) {

        int i = 0;              // pointer for s
        int j = 0;              // pointer for p

        int star = -1;          // position of last '*'
        int match = 0;          // position in s matched by that '*'

        while (i < s.length()) {

            // Case 1: Characters match OR pattern has '?'
            if (j < p.length() &&
                (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')) {

                i++;
                j++;
            }

            // Case 2: Pattern has '*'
            else if (j < p.length() && p.charAt(j) == '*') {

                star = j;
                match = i;

                j++;
            }

            // Case 3: Mismatch, but we have seen a '*'
            else if (star != -1) {

                j = star + 1;
                match++;
                i = match;
            }

            // Case 4: Mismatch and no '*' available
            else {
                return false;
            }
        }

        // Remaining pattern characters must all be '*'
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        return j == p.length();
    }
}
