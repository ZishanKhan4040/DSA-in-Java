class Solution {

    public List<String> restoreIpAddresses(String s) {

        List<String> ans = new ArrayList<>();

        // Minimum 4 digits and maximum 12 digits
        if (s.length() < 4 || s.length() > 12) {
            return ans;
        }

        backtrack(s, 0, 0, "", ans);

        return ans;
    }

    private void backtrack(String s, int index, int parts,
                            String current, List<String> ans) {

        // All digits are used
        if (index == s.length()) {

            // IP must contain exactly 4 parts
            if (parts == 4) {
                ans.add(current.substring(0, current.length() - 1));
            }

            return;
        }

        // Cannot create more than 4 parts
        if (parts == 4) {
            return;
        }

        // Try taking 1, 2 or 3 digits
        for (int len = 1; len <= 3; len++) {

            if (index + len > s.length()) {
                break;
            }

            String part = s.substring(index, index + len);

            // Leading zero is not allowed
            if (part.length() > 1 && part.charAt(0) == '0') {
                break;
            }

            // Value must be <= 255
            int value = Integer.parseInt(part);

            if (value > 255) {
                break;
            }

            backtrack(
                s,
                index + len,
                parts + 1,
                current + part + ".",
                ans
            );
        }
    }
}
