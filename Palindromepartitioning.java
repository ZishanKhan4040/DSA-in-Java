class Solution {

    public int minCut(String s) {

        int n = s.length();

        // palindrome[i][j] = true if s[i...j] is a palindrome
        boolean[][] palindrome = new boolean[n][n];

        // dp[i] = minimum cuts needed for substring s[0...i-1]
        int[] dp = new int[n + 1];

        // Initially, maximum possible cuts = i - 1
        for (int i = 0; i <= n; i++) {
            dp[i] = i - 1;
        }

        for (int end = 0; end < n; end++) {

            for (int start = end; start >= 0; start--) {

                // Check whether s[start...end] is palindrome
                if (s.charAt(start) == s.charAt(end) &&
                    (end - start <= 1 || palindrome[start + 1][end - 1])) {

                    palindrome[start][end] = true;

                    // Whole string from 0 to end is palindrome
                    if (start == 0) {
                        dp[end + 1] = 0;
                    } 
                    else {
                        dp[end + 1] = Math.min(
                            dp[end + 1],
                            dp[start] + 1
                        );
                    }
                }
            }
        }

        return dp[n];
    }
}
