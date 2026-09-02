class Solution {
    public String shortestPalindrome(String s) {

        String rev = new StringBuilder(s).reverse().toString();

        String combined = s + "#" + rev;

        int[] lps = new int[combined.length()];

        int i = 1;
        int len = 0;

        while (i < combined.length()) {

            if (combined.charAt(i) == combined.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else if (len > 0) {
                len = lps[len - 1];
            }
            else {
                lps[i] = 0;
                i++;
            }
        }

        int longestPalPrefix = lps[combined.length() - 1];

        String remaining = s.substring(longestPalPrefix);

        return new StringBuilder(remaining)
                .reverse()
                .toString() + s;
    }
}
