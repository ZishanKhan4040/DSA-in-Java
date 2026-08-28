class Solution {
    public boolean isNumber(String s) {

        boolean digitSeen = false;
        boolean dotSeen = false;
        boolean exponentSeen = false;
        boolean digitAfterExponent = true;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // If character is a digit
            if (ch >= '0' && ch <= '9') {
                digitSeen = true;

                // If we are after e/E, we need a digit there
                if (exponentSeen) {
                    digitAfterExponent = true;
                }
            }

            // Decimal point
            else if (ch == '.') {

                // Dot cannot appear after e/E
                // and there can only be one dot
                if (dotSeen || exponentSeen) {
                    return false;
                }

                dotSeen = true;
            }

            // Exponent
            else if (ch == 'e' || ch == 'E') {

                // e/E cannot appear twice
                // and there must be a number before it
                if (exponentSeen || !digitSeen) {
                    return false;
                }

                exponentSeen = true;
                digitAfterExponent = false;
            }

            // Sign
            else if (ch == '+' || ch == '-') {

                // Sign is valid only at the beginning
                // or immediately after e/E
                if (i != 0 && s.charAt(i - 1) != 'e'
                        && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }

            // Anything else is invalid
            else {
                return false;
            }
        }

        return digitSeen && digitAfterExponent;
    }
}
