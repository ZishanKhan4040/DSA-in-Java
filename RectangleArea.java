class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] stack = new int[n];
        int top = -1;
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? 0 : heights[i];

            while (top != -1 && heights[stack[top]] > curr) {
                int height = heights[stack[top--]];

                int width;
                if (top == -1) {
                    width = i;
                } else {
                    width = i - stack[top] - 1;
                }

                maxArea = Math.max(maxArea, height * width);
            }

            if (i < n) {
                stack[++top] = i;
            }
        }

        return maxArea;
    }
}
