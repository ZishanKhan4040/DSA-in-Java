class Solution {
    public int compareVersion(String version1, String version2) {

        int i = 0;
        int j = 0;

        int n = version1.length();
        int m = version2.length();

        while (i < n || j < m) {

            // Get value of current revision from version1
            int num1 = 0;

            while (i < n && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (version1.charAt(i) - '0');
                i++;
            }

            // Get value of current revision from version2
            int num2 = 0;

            while (j < m && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (version2.charAt(j) - '0');
                j++;
            }

            // Compare current revisions
            if (num1 < num2) {
                return -1;
            }

            if (num1 > num2) {
                return 1;
            }

            // Skip '.'
            if (i < n && version1.charAt(i) == '.') {
                i++;
            }

            if (j < m && version2.charAt(j) == '.') {
                j++;
            }
        }

        return 0;
    }
}
