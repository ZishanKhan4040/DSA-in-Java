class Solution {
    public int strongPasswordChecker(String password) {

        int n = password.length();

        // Check missing character types
        int missing = 3;

        boolean lower = false;
        boolean upper = false;
        boolean digit = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c))
                lower = true;

            if (Character.isUpperCase(c))
                upper = true;

            if (Character.isDigit(c))
                digit = true;
        }

        if (lower) missing--;
        if (upper) missing--;
        if (digit) missing--;

        // Count replacements needed for repeating characters
        int replace = 0;

        // Number of repeating groups based on length % 3
        int mod0 = 0;
        int mod1 = 0;

        for (int i = 0; i < n; ) {

            int j = i;

            while (j < n && password.charAt(j) == password.charAt(i)) {
                j++;
            }

            int len = j - i;

            if (len >= 3) {
                replace += len / 3;

                if (len % 3 == 0)
                    mod0++;

                if (len % 3 == 1)
                    mod1++;
            }

            i = j;
        }

        // Case 1: password is too short
        if (n < 6) {
            return Math.max(missing, 6 - n);
        }

        // Case 2: password length is already valid
        if (n <= 20) {
            return Math.max(missing, replace);
        }

        // Case 3: password is too long
        int delete = n - 20;

        // First use deletions on groups where 1 deletion
        // saves 1 replacement
        int use = Math.min(delete, mod0);
        replace -= use;
        delete -= use;

        // Next, 2 deletions save 1 replacement
        use = Math.min(delete, mod1 * 2);
        replace -= use / 2;
        delete -= use;

        // Finally, 3 deletions save 1 replacement
        use = Math.min(delete, replace * 3);
        replace -= use / 3;
        delete -= use;

        return (n - 20) + Math.max(missing, replace);
    }
}
