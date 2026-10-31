
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {

        int[][] matrix = new int[m][n];

        // Initialize matrix with -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (head != null) {

            // Left to Right
            for (int j = left; j <= right && head != null; j++) {
                matrix[top][j] = head.val;
                head = head.next;
            }
            top++;

            // Top to Bottom
            for (int i = top; i <= bottom && head != null; i++) {
                matrix[i][right] = head.val;
                head = head.next;
            }
            right--;

            // Right to Left
            for (int j = right; j >= left && head != null; j--) {
                matrix[bottom][j] = head.val;
                head = head.next;
            }
            bottom--;

            // Bottom to Top
            for (int i = bottom; i >= top && head != null; i--) {
                matrix[i][left] = head.val;
                head = head.next;
            }
            left++;
        }

        return matrix;
    }
}
