class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        int n = s1.length();
        int m = s2.length();

        // Length must be equal
        if (n + m != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[n + 1][m + 1];

        // Empty s1 and empty s2 form empty s3
        dp[0][0] = true;

        // Using only s1
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0]
                    && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        // Using only s2
        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j - 1]
                    && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                int k = i + j - 1;

                // Take character from s1
                boolean fromS1 = dp[i - 1][j]
                        && s1.charAt(i - 1) == s3.charAt(k);

                // Take character from s2
                boolean fromS2 = dp[i][j - 1]
                        && s2.charAt(j - 1) == s3.charAt(k);

                dp[i][j] = fromS1 || fromS2;
            }
        }

        return dp[n][m];
    }
}
