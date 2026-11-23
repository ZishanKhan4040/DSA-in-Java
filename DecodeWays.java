
class Solution {
    public int numDecodings(String s) {

        long mod = 1000000007;

        long prev2 = 1;
        long prev1 = single(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {

            char first = s.charAt(i - 1);
            char second = s.charAt(i);

            long ways = 0;

            // Single character decoding
            ways = (ways + prev1 * single(second)) % mod;

            // Two character decoding
            ways = (ways + prev2 * pair(first, second)) % mod;

            prev2 = prev1;
            prev1 = ways;
        }

        return (int) prev1;
    }

    private int single(char ch) {

        if (ch == '*') return 9;
        if (ch == '0') return 0;

        return 1;
    }

    private int pair(char first, char second) {

        if (first == '*' && second == '*') {
            return 15;
        }

        if (first == '*') {
            if (second >= '0' && second <= '6') {
                return 2;
            }
            return 1;
        }

        if (second == '*') {
            if (first == '1') return 9;
            if (first == '2') return 6;
            return 0;
        }

        int num = (first - '0') * 10 + (second - '0');

        return (num >= 10 && num <= 26) ? 1 : 0;
    }
}
