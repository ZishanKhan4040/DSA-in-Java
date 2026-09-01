class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        int[] freq = new int[128];

        // Store required frequency of characters in t
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0;
        int right = 0;

        int required = t.length();
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {

            char c = s.charAt(right);

            // If this character is still required
            if (freq[c] > 0) {
                required--;
            }

            freq[c]--;
            right++;

            // Window is valid
            while (required == 0) {

                // Update minimum window
                if (right - left < minLength) {
                    minLength = right - left;
                    start = left;
                }

                char leftChar = s.charAt(left);

                freq[leftChar]++;

                // Removing this character makes window invalid
                if (freq[leftChar] > 0) {
                    required++;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);
    }
}
